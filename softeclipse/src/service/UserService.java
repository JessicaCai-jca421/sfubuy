package service;

import java.sql.SQLException;

import dao.UserDao;
import domain.User;

public class UserService
{
	private UserDao userDao=new UserDao();
	public boolean ajaxValidateLoginname(String loginname)
	{
		try
		{
			return userDao.ajaxValidateLoginname(loginname);
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
	}
	
	public boolean ajaxValidateEmail(String email)
	{
		try
		{
			return userDao.ajaxValidateEmail(email);
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
	}
	
	public boolean ajaxValidatePhone(String phone)
	{
		try
		{
			return userDao.ajaxValidatePhone(phone);
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
	}
	
	public boolean ajaxValidateEmail2(String email,String loginname)
	{
		try
		{
			return userDao.ajaxValidateEmail2(email,loginname);
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
	}
	
	public boolean ajaxValidatePhone2(String phone,String loginname)
	{
		try
		{
			return userDao.ajaxValidatePhone2(phone,loginname);
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
	}
	//注册添加用户
	public void regist(User user)
	{
		try
		{
			userDao.add(user);
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
	}
	//更新用户
	public void update(User user)
	{
		try
		{
			userDao.update(user);
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
	}
	public User login(User user) {
		try {
			return userDao.findByLoginnameAndLoginpass(user.getLoginname(), user.getLoginpass());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void date(String loginname)
	{
		try
		{
			userDao.userDate(loginname);
		} catch (SQLException e)
		{
			// TODO 自动生成的 catch 块
			throw new RuntimeException(e);
		}
	}
	public void updatePassword(String loginname, String newPass, String oldPass) throws Exception {

		try {
			/*
			 * 1. 校验老密码
			 */
			boolean bool = userDao.findByLoginnameAndPassword(loginname, oldPass);
			if(!bool) {//如果老密码错误
				throw new Exception("老密码错误！");
			}
			
			/*
			 * 2. 修改密码
			 */
			userDao.updatePassword(loginname, newPass);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
