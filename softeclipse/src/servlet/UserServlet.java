package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.itcast.commons.CommonUtils;

import dao.UserDao;
import domain.User;
import service.UserService;

/**
 * 用户模块WEB层
 * 
 * @author qdmmy6
 *
 */
public class UserServlet extends BaseServlet
{
	private UserService userService = new UserService();
	public int count = 3;
	public long start = 0;
	public long end = 0;

	/**
	 * ajax用户名是否注册校验
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateLoginname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		/*
		 * 1. 获取用户名
		 */
		String loginname = req.getParameter("loginname");
		/*
		 * 2. 通过service得到校验结果
		 */
		boolean b = userService.ajaxValidateLoginname(loginname);
		/*
		 * 3. 发给客户端
		 */
		resp.getWriter().print(b);
		return null;
	}

	/**
	 * ajax Email是否注册校验
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateEmail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		/*
		 * 1. 获取Email
		 */
		String email = req.getParameter("email");
		/*
		 * 2. 通过service得到校验结果
		 */
		boolean b = userService.ajaxValidateEmail(email);
		/*
		 * 3. 发给客户端
		 */
		resp.getWriter().print(b);
		return null;
	}

	public String ajaxValidatePhone(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		/*
		 * 1. 获取Email
		 */
		String phone = req.getParameter("phone");
		/*
		 * 2. 通过service得到校验结果
		 */
		boolean b = userService.ajaxValidatePhone(phone);
		/*
		 * 3. 发给客户端
		 */
		resp.getWriter().print(b);
		return null;
	}
	
	public String ajaxValidateEmail2(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		/*
		 * 1. 获取Email
		 */
		String email = req.getParameter("email");
		String loginname=req.getParameter("loginname");
		/*
		 * 2. 通过service得到校验结果
		 */
		boolean b = userService.ajaxValidateEmail2(email,loginname);
		/*
		 * 3. 发给客户端
		 */
		resp.getWriter().print(b);
		return null;
	}

	public String ajaxValidatePhone2(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		/*
		 * 1. 获取Email
		 */
		String phone = req.getParameter("phone");
		String loginname=req.getParameter("loginname");
		/*
		 * 2. 通过service得到校验结果
		 */
		boolean b = userService.ajaxValidatePhone2(phone,loginname);
		/*
		 * 3. 发给客户端
		 */
		resp.getWriter().print(b);
		return null;
	}
	/**
	 * ajax验证码是否正确校验
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateVerifyCode(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String vcode = (String) req.getSession().getAttribute("vCode");
		System.out.println(vcode);
		/*
		 * 1. 获取输入框中的验证码
		 */
		String verifyCode = req.getParameter("verifyCode");
		System.out.println(verifyCode);
		/*
		 * 2. 获取图片上真实的校验码
		 */

		/*
		 * 3. 进行忽略大小写比较，得到结果
		 */
		boolean b = verifyCode.equalsIgnoreCase(vcode);
		/*
		 * 4. 发送给客户端
		 */
		resp.getWriter().print(b);
		return null;
	}

	/**
	 * 注册功能
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

		/*
		 * 1. 封装表单数据到User对象
		 */
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		/*
		 * 2. 校验之, 如果校验失败，保存错误信息，返回到regist.jsp显示
		 */

		Map<String, String> errors = validateRegist(formUser, req.getSession());
		if (errors.size() > 0)
		{
			req.setAttribute("form", formUser);
			req.setAttribute("errors", errors);
			return "regist.jsp";
		}
		/*
		 * 3. 使用service完成业务
		 */
		userService.regist(formUser);
		System.out.println("regist...");
		/*
		 * 4. 保存成功信息，转发到msg.jsp显示！
		 */
		req.setAttribute("code", "success");
		req.setAttribute("msg", "Signin Sucessfully");
		return "msg.jsp";
	}
	//更新用户信息
	public String update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException
	{
		/*
		 * 1. 封装表单数据到User对象
		 */
		
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		/*
		 * 2. 校验之, 如果校验失败，保存错误信息，返回到regist.jsp显示
		 */
		UserDao.getAllUserInfos(formUser);
		
		Map<String, String> errors = validateUpdate(formUser, req.getSession());
		if (errors.size() > 0)
		{
			req.setAttribute("form", formUser);
			req.setAttribute("errors", errors);
			return "updateuser.jsp";
		}
		
		
		/*
		 * 3. 使用service完成业务
		 */
		userService.update(formUser);
		System.out.println("update...");
	
		return "updateuser.jsp";
	}
	private Map<String, String> validateUpdate(User formUser, HttpSession session)
	{
		Map<String, String> errors = new HashMap<String, String>();
		/*
		 * 5. 验证码校验
		 */
		String Ic = formUser.getIc();
		if (Ic.length() != 18&&Ic.length()>0)
		{
			errors.put("ic", "18");
		} 
		return errors;
	}
	/*
	 * 注册校验 对表单的字段进行逐个校验，如果有错误，使用当前字段名称为key，错误信息为value，保存到map中 返回map
	 */
	private Map<String, String> validateRegist(User formUser, HttpSession session)
	{
		Map<String, String> errors = new HashMap<String, String>();
		/*
		 * 1. 校验登录名
		 */
		String loginname = formUser.getLoginname();
		if (loginname == null || loginname.trim().isEmpty())
		{
			errors.put("loginname", "The user name cannot be empty！");
		} else if (loginname.length() < 3 || loginname.length() > 20)
		{
			errors.put("loginname", "The length of user name must be between 3 and 20！");
		} else if (!userService.ajaxValidateLoginname(loginname))
		{
			errors.put("loginname", "The user name has been registered！");
		}

		/*
		 * 2. 校验登录密码
		 */
		String loginpass = formUser.getLoginpass();
		if (loginpass == null || loginpass.trim().isEmpty())
		{
			errors.put("loginpass", "Password cannot be empty！");
		} else if (loginpass.length() < 3 || loginpass.length() > 20)
		{
			errors.put("loginpass", "Password length must be between 3 and 20！");
		}

		/*
		 * 3. 确认密码校验
		 */
		String reloginpass = formUser.getReloginpass();
		if (reloginpass == null || reloginpass.trim().isEmpty())
		{
			errors.put("reloginpass", "Confirm password cannot be empty！");
		} else if (!reloginpass.equals(loginpass))
		{
			errors.put("reloginpass", "The passwords entered did not match！");
		}

		/*
		 * 4. 校验email
		 */
		String email = formUser.getEmail();
		if (email == null || email.trim().isEmpty())
		{
			errors.put("email", "Email cannot be empty！");
		} else if (!email.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$"))
		{
			errors.put("email", "Email format error！");
		} else if (!userService.ajaxValidateEmail(email))
		{
			errors.put("email", "Email registered！");
		}
		//校验手机号
		String phone = formUser.getPhone();
		if (phone == null || phone.trim().isEmpty())
		{
			errors.put("phone", "Mobile phone number cannot be empty！");
		} else if (phone.length()!=11)
		{
			errors.put("phone", "Mobile phone number must be 11 digits！");
		} else if (!userService.ajaxValidatePhone(phone))
		{
			errors.put("phone", "Mobile number has been registered!");
		}

		return errors;
	}

	// /**
	// * 激活功能
	// * @param req
	// * @param resp
	// * @return
	// * @throws ServletException
	// * @throws IOException
	// */
	// public String activation(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	// /*
	// * 1. 获取参数激活码
	// * 2. 用激活码调用service方法完成激活
	// * > service方法有可能抛出异常, 把异常信息拿来，保存到request中，转发到msg.jsp显示
	// * 3. 保存成功信息到request，转发到msg.jsp显示。
	// */
	// String code = req.getParameter("activationCode");
	// try {
	// userService.activatioin(code);
	// req.setAttribute("code", "success");//通知msg.jsp显示对号
	// req.setAttribute("msg", "恭喜，激活成功，请马上登录！");
	// } catch (UserException e) {
	// // 说明service抛出了异常
	// req.setAttribute("msg", e.getMessage());
	// req.setAttribute("code", "error");//通知msg.jsp显示X
	// }
	// return "f:/jsps/msg.jsp";
	// }
	//
	 /**
	 * 修改密码
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	 public String updatePassword(HttpServletRequest req, HttpServletResponse
	 resp)
	 throws ServletException, IOException {
	 /*
	 * 1. 封装表单数据到user中
	 * 2. 从session中获取uid
	 * 3. 使用uid和表单中的oldPass和newPass来调用service方法
	 * > 如果出现异常，保存异常信息到request中，转发到pwd.jsp
	 * 4. 保存成功信息到rquest中
	 * 5. 转发到msg.jsp
	 */
	 User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
	 User user = (User)req.getSession().getAttribute("sessionUser");
	 // 如果用户没有登录，返回到登录页面，显示错误信息
	 if(user == null) {
	 req.setAttribute("msg", "您还没有登录！");
	 return "login.jsp";
	 }
	
	 try {
	 userService.updatePassword(user.getLoginname(), formUser.getNewloginpass(),
	 formUser.getLoginpass());
	 req.setAttribute("msg", "修改密码成功");
	 req.setAttribute("code", "success");
	 return "msgpwd.jsp";
	 } catch (Exception e) {
	 req.setAttribute("msg", e.getMessage());//保存异常信息到request
	 req.setAttribute("user", formUser);//为了回显
	 return "pwd.jsp";
	 }
	 }

	/**
	 * 退出功能
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String quit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		start=0;
		end=0;
		count=3;
		UserDao.user2=new User();
		req.getSession().invalidate();
		return "login.jsp";
	}

	/**
	 * 登录功能
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException 
	 */
	public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException
	{
		/*
		 * 1. 封装表单数据到User 2. 校验表单数据 3. 使用service查询，得到User 4. 查看用户是否存在，如果不存在： *
		 * 保存错误信息：用户名或密码错误 * 保存用户数据：为了回显 * 转发到login.jsp 5. 如果存在，查看状态，如果状态为false： *
		 * 保存错误信息：您没有激活 * 保存表单数据：为了回显 * 转发到login.jsp 6. 登录成功： * 保存当前查询出的user到session中 *
		 * 保存当前用户的名称到cookie中，注意中文需要编码处理。
		 */
		/*
		 * 1. 封装表单数据到user
		 */
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);

		/*
		 * 2. 校验
		 */
		Map<String, String> errors = validateLogin(formUser, req.getSession());
		if (errors.size() > 0)
		{
			req.setAttribute("form", formUser);
			req.setAttribute("errors", errors);
			return "login.jsp";
		}

		/*
		 * 3. 调用userService#login()方法
		 */
		User user = userService.login(formUser);
		
		/*
		 * 4. 开始判断
		 */
		if (user == null)
		{
			count--;
			if (count <= 0)
			{
				if (start != 0)
				{
					end = System.currentTimeMillis();
					if (end - start > 10000)
					{
						count = 3;
						start = 0;
						end = 0;
						req.setAttribute("msg", "用户名或密码错误！还有" + count + "次机会");
					} else
						req.setAttribute("msg", "请" + (10 - (end - start) / 1000) + "秒后再试");
				} else
				{
					req.setAttribute("msg", "请10s后再试");
					start = System.currentTimeMillis();
				}

				System.out.println(count);

			}

			else
				req.setAttribute("msg", "用户名或密码错误！还有" + count + "次机会");
			req.setAttribute("user", formUser);
			return "login.jsp";
		} else
		{
			end = System.currentTimeMillis();
			if (count <= 0)
			{
				if (end - start > 10000)
				{
					// 保存用户到session
					req.getSession().setAttribute("sessionUser", user);
					// 获取用户名保存到cookie中
					String loginname = user.getLoginname();
					loginname = URLEncoder.encode(loginname, "utf-8");
					Cookie cookie = new Cookie("loginname", loginname);
					cookie.setMaxAge(60 * 60 * 24 * 10);// 保存10天
					resp.addCookie(cookie);
					userService.date(loginname);
					return "index.jsp";// 重定向到主页
				} else
					req.setAttribute("msg", "请" + (10 - (end - start) / 1000) + "秒后再试");
				return "login.jsp";
			} else
			{
				// 保存用户到session
				req.getSession().setAttribute("sessionUser", user);
				// 获取用户名保存到cookie中
				String loginname = user.getLoginname();
				loginname = URLEncoder.encode(loginname, "utf-8");
				Cookie cookie = new Cookie("loginname", loginname);
				cookie.setMaxAge(60 * 60 * 24 * 10);// 保存10天
				resp.addCookie(cookie);
				userService.date(loginname);
				return "index.jsp";// 重定向到主页
			}

		}
	}

	/*
	 * 登录校验方法
	 */
	private Map<String, String> validateLogin(User formUser, HttpSession session)
	{
		Map<String, String> errors = new HashMap<String, String>();
		/*
		 * 5. 验证码校验
		 */
		String verifyCode = formUser.getVerifyCode();
		String vcode = (String) session.getAttribute("vCode");
		if (verifyCode == null || verifyCode.trim().isEmpty())
		{
			errors.put("verifyCode", "验证码不能为空！");
		} else if (!verifyCode.equalsIgnoreCase(vcode))
		{
			errors.put("verifyCode", "验证码错误！");
		}
		return errors;
	}
	

}
