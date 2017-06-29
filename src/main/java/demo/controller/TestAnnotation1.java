package demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.service.ITestService1;
import demo.service.bo.User;
import demo.service.impl.TestService1;
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

	/**
	 * <p>功能描述：普通测试。</p>
	 * <p>Jial </p>	
	 * @param response
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月29日 下午3:16:00。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	@RequestMapping("/hello")
	public void test(HttpServletResponse response) {
		try {
			String str = testService.testService();
			response.getWriter().write(str);		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>功能描述：get方法测试，包括json串的转换。</p>
	 * <p>Jial </p>	
	 * @param request
	 * @param response
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月29日 下午3:16:19。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
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
	
	/**
	 * <p>功能描述：post方法测试，包括json串的转换和数据的映射接收。</p>
	 * <p>Jial </p>	
	 * @param user
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月29日 下午3:16:52。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	@ResponseBody
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public Object postMethod(@RequestBody User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("username", user.getUsername());
		result.put("password", user.getPassword());
		return result;
		
	}
	
	/**
	 * <p>功能描述：测试数据库链接。</p>
	 * <p>Jial </p>	
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月29日 下午3:17:24。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	@ResponseBody
	@RequestMapping(value = "/testJdbc", method = RequestMethod.GET)
	public List testJdbc() {
		return testService.testJdbc();
	}
	
	/**
	 * <p>功能描述：测试事物。</p>
	 * <p>Jial </p>	
	 * @return
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月29日 下午3:20:42。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	@ResponseBody
	@RequestMapping(value = "testTransaction")
	public Object testTransaction() {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			testService.testTransaction();
			result.put("success", 1);
			result.put("msg", "测试事物成功");
		} catch (Exception e) {
			result.put("success", -1);
			result.put("msg", "测试事物成功");
		}
		return result;
	}

}
