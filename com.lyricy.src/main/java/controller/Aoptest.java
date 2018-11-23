package controller;


import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class Aoptest implements MethodInterceptor {
	private Logger logger = Logger.getLogger(Aoptest.class);

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	

}
