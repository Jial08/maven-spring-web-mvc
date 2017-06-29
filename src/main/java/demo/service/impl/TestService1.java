package demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.domain.ITestDao;
import demo.service.ITestService1;
import demo.service.ITestService2;
@Service
@Transactional
public class TestService1 implements ITestService1 {
	
	@Resource
	private ITestDao testDao;

	public String testService() {
		return "注解方法测试一";
	}
	
	public List testJdbc() {
		return testDao.test();
	}

	@Override
	public void testTransaction() {
		testDao.testTransaction();
	}

}
