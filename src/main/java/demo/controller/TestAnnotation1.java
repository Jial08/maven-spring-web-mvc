package demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.service.ITestService1;
import demo.service.bo.User;
/**
 * <p>类描述：注解测试方法一，service层有@Service注解。</p>
 * @author Jial
 * @version v1.0.0.1。
 * @since JDK1.8。
 *<p>创建日期：2017年6月28日 下午3:47:33。</p>
 */
@Controller
@RequestMapping("/annotation1")
public class TestAnnotation1 {
	@Resource
	private ITestService1 testService;

	@RequestMapping("/hello")
	public void test(HttpServletResponse response) {
		try {
			String str = testService.testService();
			response.getWriter().write(str);		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public Object getMethod(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		result.put("username", username);
		result.put("password", password);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public Object postMethod(@RequestBody User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("username", user.getUsername());
		result.put("password", user.getPassword());
		return result;
		
	}

}
