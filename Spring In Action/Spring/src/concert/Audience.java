package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	
	@Pointcut("execution(** concert.Performance.perform(..))")
	public void performance() {}
	
	@Before("performance()")
	public void silenceCellPhones() {
		System.out.println("Silencing cell phones");
	}
	
	@Before("performance()")
	public void takeSeats() {
		System.out.println("Taking seats");
	}
	
	@AfterReturning("execution(** concert.Performance.perform(..))")
	public void applause() {
		System.out.println("CLAP CLAP CLAP!!!");
	}
	
	@AfterThrowing("execution(** concert.Performance.perform(..))")
	public void demandRefund() {
		System.out.println("Demanding a refund");
	}
	
	@Around("performance()")	//功能非常强大，可以定义切点前后的通知
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			System.out.println("Silencing cell phones");
			System.out.println("Taking seats");
			jp.proceed();
			System.out.println("CLAP CLAP CLAP!!!");
		} catch (Throwable e) {
			System.out.println("Demanding a refund");
		}
	}
}
