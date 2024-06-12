//package com.example.demo.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.model.Account;
//
////ログイン状態チェック
//@Aspect
//@Component
//public class CheckLoginAspect {
//
//	@Autowired
//	Account account;
//
//	@Before("execution(* com.example.demo.controller.*Controller.*(..))")
//	public void writeLog(JoinPoint jp) {
//		if (account == null || account.getId() == null) {
//			System.out.print("ゲスト : ");
//		} else {
//			String mode = "";
//			switch(account.getUserStatus()) {
//			case 1:
//				mode = "管理者";
//				break;
//			case 2:
//				mode = "会員";
//				break;
//			}
//			System.out.print(account.getId() + " : ");
//			System.out.print(mode + " : ");
//		}
//		System.out.println(jp.getSignature());
//	}
//
//	//未ログインの場合ログインページにリダイレクト
//	@Around("execution(* com.example.demo.controller.ItemController.*(..))"
//			+ " || execution(* com.example.demo.controller.BBSController.*(..))"
//			+ " || execution(* com.example.demo.controller.MessageController.*(..))"
//			+ " || execution(* com.example.demo.controller.AccountController.view())"
//			+ " || execution(* com.example.demo.controller.AccountController.resetPassword())"
//			+ " || execution(* com.example.demo.controller.AccountController.setPassword())"
//			+ " || execution(* com.example.demo.controller.AccountController.view())"
//			+ " || execution(* com.example.demo.controller.AccountController.resetIntroduce())"
//			+ " || execution(* com.example.demo.controller.AccountController.setIntroduce())")
//	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable {
//		if (account.getId() == null) {
//			System.err.println("ログインしていません!");
//			return "redirect:/";
//		}
//		//Controller内のメソッドの実行
//		return jp.proceed();
//	}
//
//	//管理者アカウントが不正の場合はitemsに返す
//	@Around("execution(* com.example.demo.controller.AdminController.*(..))")
//	public Object checkAdmin(ProceedingJoinPoint jp) throws Throwable {
//		System.out.print(account.getId() + " : ");
//		if (account.getId() == null || account.getUserStatus() != 1) {
//			System.err.println("管理者画面に不正なアクセスです!");
//			return "redirect:/home";
//		}
//
//		return jp.proceed();
//	}
//}
