package dao;

import java.sql.SQLException;

import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import cn.itcast.jdbc.TxQueryRunner;
import domain.User;


public class UserDao
{
	private QueryRunner qr=new TxQueryRunner();
	public static User user2=new User();
	public static void getAllUserInfos(User user) throws SQLException
	{
		user2=user;
		System.out.println(user2.getName());
	}
	public boolean ajaxValidateLoginname(String id) throws SQLException
	{
		String sql="select count(1) from 用户表 where loginname=?";
		Number number=(Number)qr.query(sql, new ScalarHandler(),id);
		return number.intValue()==0;
	}
	public boolean ajaxValidateEmail(String email) throws SQLException
	{
		String sql="select count(1) from 用户表 where email=?";
		Number number=(Number)qr.query(sql, new ScalarHandler(),email);
		return number.intValue()==0;
	}
	public boolean ajaxValidatePhone(String phone) throws SQLException
	{
		String sql="select count(1) from 用户表 where phone=?";
		Number number=(Number)qr.query(sql, new ScalarHandler(),phone);
		return number.intValue()==0;
	}
	public boolean ajaxValidateEmail2(String email,String loginname) throws SQLException
	{
		String sql="select count(1) from 用户表 where email=? and loginname!=?";
		Number number=(Number)qr.query(sql, new ScalarHandler(),email,loginname);
		return number.intValue()==0;
	}
	public boolean ajaxValidatePhone2(String phone,String loginname) throws SQLException
	{
		String sql="select count(1) from 用户表 where phone=? and loginname!=?";
		Number number=(Number)qr.query(sql, new ScalarHandler(),phone,loginname);
		return number.intValue()==0;
	}
	public void add(User user) throws SQLException
	{
		String sql="insert into 用户表(loginname,loginpass,email,phone) values(?,?,?,?)";
		Object[] params= {user.getLoginname(),user.getLoginpass(),user.getEmail(),user.getPhone()};
		qr.update(sql,params);
	}
	public void update(User user) throws SQLException
	{
		String sql="update 用户表 set name=?,sex=?,email=?,phone=?,ic=?,addr=? where loginname=?";
		Object[] params= {user.getName(),user.getSex(),user.getEmail(),user.getPhone(),user.getIc(),user.getAddr(),user.getLoginname()};
		qr.update(sql,params);
	}
	public User findByLoginnameAndLoginpass(String loginname, String loginpass) throws SQLException {
		String sql = "select * from 用户表 where loginname=? and loginpass=?";
		return qr.query(sql, new BeanHandler<User>(User.class), loginname, loginpass);
	}
	public boolean findByLoginnameAndPassword(String loginname, String password) throws SQLException {
		String sql = "select count(*) from 用户表 where loginname=? and loginpass=?";
		Number number = (Number)qr.query(sql, new ScalarHandler(), loginname, password);
		return number.intValue() > 0;
	}
	public void updatePassword(String loginname, String password) throws SQLException {
		String sql = "update 用户表 set loginpass=? where loginname=?";
		qr.update(sql, password, loginname);
	}
	public void userDate(String loginname) throws SQLException
	{
		String sql="insert into 登录时间表(loginname,logintime) values(?,?)";
		Object[] params= {loginname,new Date()};
		qr.update(sql,params);
	}
}
