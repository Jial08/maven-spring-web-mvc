package demo.service.impl;

import org.springframework.stereotype.Service;

import demo.service.ITestService;
@Service
public class TestService implements ITestService {

	public String testService() {
		return "service层测试";
	}

}
