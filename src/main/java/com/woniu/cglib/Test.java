package com.woniu.cglib;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Test {
	
	@org.junit.Test
	public void test1() throws Exception {
		Enhancer eh =new Enhancer();
		//设置父类
		eh.setSuperclass(CalcImpl.class);
		//设置处理器
		eh.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				// TODO Auto-generated method stub
				
				System.out.println("开始....");
				Object o =proxy.invokeSuper(obj, args);
				System.out.println("结束...");
				return o;
			}
		});
		
		CalcImpl proxy =(CalcImpl) eh.create();
		System.out.println(proxy.add(1, 1));
		
	}
}
