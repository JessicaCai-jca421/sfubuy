package image;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerifyCode
{
	private int w=70;
	private int h=35;
	private Random r=new Random();
	private String[] fontNames= {"宋体","华文楷体","黑体","微软雅黑"};
	//可选字符
	private String codes="23456789abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	//背景色
	private Color bgColor=new Color(255,255,255);
	//验证码上的文本
	private String text;
	
	//生产随机的颜色
	private Color randomColor()
	{
		int red=r.nextInt(150);
		int green=r.nextInt(150);
		int blue=r.nextInt(150);
		return new Color(red,green,blue);
	}
	
	//生成随机的字体
	private Font randomFont()
	{
		int index=r.nextInt(fontNames.length);
		String fontName=fontNames[index];
		int style=r.nextInt(4);//生成随机样式，0无样式，1粗体，2斜体，3粗体+斜体
		int size=r.nextInt(5)+24;//生成随机字号。24——28
		return new Font(fontName,style,size);
	}
	
	//画干扰线
	private void drawLine(BufferedImage image)
	{
		int num=3;//3条线
		Graphics2D g=(Graphics2D)image.getGraphics();
		for(int i=0;i<num;i++)
		{
			int x1=r.nextInt(w);
			int x2=r.nextInt(w);
			int y1=r.nextInt(h);
			int y2=r.nextInt(h);
			g.setStroke(new BasicStroke(1.5F));
			g.setColor(Color.BLUE);//干扰线颜色
			g.drawLine(x1, y1, x2, y2);//画线
		}
	}
	
	//生成随机字符
	private char randomChar()
	{
		int index=r.nextInt(codes.length());
		return codes.charAt(index);
	}
	
	//创建BufferedImage
	private BufferedImage createImage()
	{
		BufferedImage image=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2=(Graphics2D)image.getGraphics();
		g2.setColor(bgColor);
		g2.fillRect(0, 0, w, h);
		return image;
	}
	
	//调用这个方法得到验证码
	public BufferedImage getImage()
	{
		BufferedImage image=createImage();
		Graphics2D g=(Graphics2D)image.getGraphics();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<4;i++)
		{
			String s=randomChar()+"";
			sb.append(s);
			float x=i*1.0F*w/4;//设置当前字符的x轴坐标
			g.setFont(randomFont());
			g.setColor(randomColor());
			g.drawString(s, x, h-5);//画图
		}
		this.text=sb.toString();//把生成的字符串赋给text
		drawLine(image);//添加干扰线
		return image;
	}
	
	//保存图片到指定输出流
	public static void output(BufferedImage image,OutputStream out) throws IOException
	{
		ImageIO.write(image, "JPEG", out);
	}
	public String getText()
	{
		return text;
	}

}
