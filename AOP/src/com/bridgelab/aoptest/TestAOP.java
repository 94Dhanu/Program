package com.bridgelab.aoptest;

public class TestAOP
{
    @SuppressWarnings("resource")
    public static void main(String[] args) {
  
        ApplicationContext context = new ClassPathXmlApplicationContext
                            ("com/howtodoinjava/demo/aop/applicationContext.xml");
 
        EmployeeManager manager = context.getBean(EmployeeManager.class);
  
        manager.getEmployeeById(1);
    }
}
