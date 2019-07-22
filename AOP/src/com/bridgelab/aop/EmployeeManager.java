package com.bridgelab.aop;

public class EmployeeManager
{
	@Component
	public class EmployeeManager
	{
	    public EmployeeDTO getEmployeeById(Integer employeeId) {
	        System.out.println("Method getEmployeeById() called");
	        return new EmployeeDTO();
	    }
	}
}
