package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * <p>类描述：设置编码格式。</p>
 * @author Jial
 * @version v1.0.0.1。
 * @since JDK1.8。
 *<p>创建日期：2017年6月26日 下午7:34:58。</p>
 */
public class SetCharacterEncodingFilter implements Filter {
	private String encode;
	
	/**
	 * <p>功能描述：初始化获取配置文件中指明的编码格式。</p>
	 * <p>Jial </p>	
	 * @param config
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月26日 下午7:35:41。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public void init(FilterConfig config) throws ServletException {
		encode = config.getInitParameter("encode");
	}
	
	/**
	 * <p>功能描述：设置编码格式，如果未指定，则设为UTF-8。</p>
	 * <p>Jial </p>	
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException
	 * @since JDK1.8。
	 * <p>创建日期:2017年6月26日 下午7:36:44。</p>
	 * <p>更新日期:[日期YYYY-MM-DD][更改人姓名][变更描述]。</p>
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (encode != null && !"".equals(encode)) {
			request.setCharacterEncoding(encode);
			response.setCharacterEncoding(encode);
		} else {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		}
		
		// doFilter方法调用链中的下一个过滤器或目标资源
		chain.doFilter(request, response);
	}

}
