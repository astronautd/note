package com.whc.noteserver.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.param.NoteBookParam;
import com.whc.noteserver.service.NoteBookService;
import com.whc.noteserver.service.UserService;

@Aspect
@Component 
public class NoteBookCountAOP {
	
	@Autowired
	private NoteBookService noteBookService;
	
	@Pointcut("execution(* com.whc.noteserver.service.NoteBookService.addNoteBook(..))")
	private void poinCut() {
		
	}
	
	@Before("poinCut()") 
	public void before(JoinPoint joinPoint) {
	    System.out.println("addNoteBook方法执行前"); 
	 }
	 
	@AfterReturning("poinCut()") 
	public void afterReturning(JoinPoint joinPoint){ 
		System.out.println("添加笔记本后执行方法"); 
	}
	 
	@Around("poinCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("环绕开始");
		Object[] args = proceedingJoinPoint.getArgs();
		NoteBookParam noteBookParam = new NoteBookParam();
		noteBookParam.setUserid(((NoteBook)args[0]).getUserid());
		int re = noteBookService.getCount(noteBookParam);
		Object obj = null;
		if (re<50) {
			//可以添加
			try {
				//执行目标方法
				obj = proceedingJoinPoint.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("环绕结束");
			return obj;
		}else {
			//不可以添加笔记本
			System.out.println("环绕开始");
			return -1;
		}
	}
	
	@AfterThrowing(value = "poinCut()",throwing="e")
	public void countThrow(JoinPoint joinPoint,Throwable e) {
		System.out.println("异常："+e.getMessage());
	}
	
	@After("poinCut()")
	public void retu(JoinPoint joinPoint) {
		System.out.println("最终执行方法");
	}
	
	

}
