package in.ineuron.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionalManagement {

	@Pointcut(value = "execution(public * in.ineuron.service.UserServiceImpl.registerUser(*))")
	public void p1() {
	}

	@Before(value = "p1()")
	public void beforeTransaction(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();

		Object[] args = joinPoint.getArgs();

		System.out.println("Calling method ::" + methodName);
		for (Object arg : args) {
			System.out.println(arg);
		}

	}

	@AfterReturning(value = "p1()", returning = "result")
	public void commitedTrasaction(JoinPoint joinPoint, Object result) {

		String methodName = joinPoint.getSignature().getName();

		System.out.println("Method ::" + methodName + " executed succesfully");

		if((int) result==0) {
			System.out.println("Output Parameter ::User name is not available");
		}else {
			System.out.println("Output parameter :: User created with id no ::"+result);
		}
	}

}
