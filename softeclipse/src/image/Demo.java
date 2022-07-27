package image;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		VerifyCode vc=new VerifyCode();
		BufferedImage b=vc.getImage();
		VerifyCode.output(b, new FileOutputStream("E:/xxx.jpg"));
		System.out.print(vc.getText());
	}
	
}
