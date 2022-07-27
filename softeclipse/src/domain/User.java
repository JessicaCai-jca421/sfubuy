package domain;

public class User
{
	private String loginname;
	private String name;
	private String loginpass;
	private String sex;
	private String ic;
	private String addr;
	private String phone;
	private String email;
	
	//注册表单
	private String reloginpass;
	private String verifyCode;
	private String newloginpass;
	private int count=3;
	
	public int getCount()
	{
		count--;
		if(count<=0)
			System.currentTimeMillis();
		return count;
	}
	public String getLoginname()
	{
		return loginname;
	}
	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getLoginpass()
	{
		return loginpass;
	}
	public void setLoginpass(String loginpass)
	{
		this.loginpass = loginpass;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getIc()
	{
		return ic;
	}
	public void setIc(String ic)
	{
		this.ic = ic;
	}
	public String getAddr()
	{
		return addr;
	}
	public void setAddr(String addr)
	{
		this.addr = addr;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getReloginpass()
	{
		return reloginpass;
	}
	public void setReloginpass(String reloginpass)
	{
		this.reloginpass = reloginpass;
	}
	public String getVerifyCode()
	{
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode)
	{
		this.verifyCode = verifyCode;
	}
	public String getNewloginpass()
	{
		return newloginpass;
	}
	public void setNewloginpass(String newloginpass)
	{
		this.newloginpass = newloginpass;
	}
	
	
	
}
