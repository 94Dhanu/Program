package com.bridgelab.cab.car;

import org.springframework.stereotype.Component;

import com.bridgelab.cab.engine.Engine;
import com.sun.org.apache.bcel.internal.ExceptionConst.EXCS;

@Component
public class Car 
{
@Autowired
private Engine engine;
public void printdata()
{
	System.out.println("Engine:"+EXCS.getName());
}
}
