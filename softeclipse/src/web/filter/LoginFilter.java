package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(
		urlPatterns = { 
				"/cartlist.jsp", 
				"/cartlist2", 
				"/orderlist.jsp", 
				"/updateuser.jsp",
		}, 
		servletNames = { 
				"CartItemServlet", 
				"OrderServlet"
				
		})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Object user = req.getSession().getAttribute("sessionUser");
		if(user == null) {
			req.setAttribute("code", "error");//为了显示X图片
			req.setAttribute("msg", "您还没有登录，不能访问");
			req.getRequestDispatcher("msg.jsp").forward(req, response);
		} else {
			chain.doFilter(request, response);//放行
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
