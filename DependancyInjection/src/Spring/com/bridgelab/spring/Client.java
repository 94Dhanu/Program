package Spring.com.bridgelab.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelab.beans.BeanTest;



public class Client 
{
@SuppressWarnings("resource")
public static void main(String arg[])
{
	ApplicationContext context=new ClassPathXmlApplicationContext("/DependancyInjection/src/com/bridgelab/resource/Spring.xml");
	BeanTest bean=(BeanTest)context.getBean("t");
	bean.hello("Dhanajay");
}
}
