package Spring.com.bridgelab.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client 
{
public static void main(String arg[])
{
	ApplicationContext context=new ClassPathXmlApplicationContext("/com/bridgelab/resource/Spring.xml");
	System.out.println(context.getBean("t"));//object crea only once
	System.out.println(context.getBean("t"));//bcz by default scope is singaltone
	System.out.println(context.getBean("t"));//points to existing object
}
}
