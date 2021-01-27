package springcore_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static ApplicationContext context;	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		context = new ClassPathXmlApplicationContext("beans.xml");
		
		HelloBean helloBean = (HelloBean)context.getBean("HelloBean");
		helloBean.sayHello();
	}

}
