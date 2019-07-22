package com.bridgelab.beans;

public class BeanTest 
{
private String gender;

public void setGender(String gender) 
{
	this.gender = gender;
}
public void hello(String name)
{
	System.out.println("Hello...."+gender+""+name);
}
}