package demo.service.impl;

import org.springframework.stereotype.Service;

import demo.service.ITestService1;
import demo.service.ITestService2;
@Service
public class TestService1 implements ITestService1 {

	public String testService() {
		return "注解方法测试一";
	}

}
