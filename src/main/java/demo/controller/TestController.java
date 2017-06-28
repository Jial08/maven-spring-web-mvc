package demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView();
		// 为了解决jsp页面中文乱码问题，只需将jsp页面编码方式改为UTF-8，默认为ISO-8859-1
		view.addObject("message", "实现Controller处理器方法测试");
		view.setViewName("hello");
        return view;
	}

}
