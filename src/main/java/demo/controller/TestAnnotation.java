package demo.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.service.ITestService;

@Controller
@RequestMapping("/annotation")
public class TestAnnotation {
	@Resource
	private ITestService testService;

	@RequestMapping("/hello")
	public void test(HttpServletResponse response) {
		try {
			String str = testService.testService();
			response.getWriter().write(str);//			response.getWriter().write("哈哈");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
