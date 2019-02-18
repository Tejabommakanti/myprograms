package teja;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Test3 
{
	public static void main(String[] args) throws Exception  //availability of given color
	{
		Color ec=Color.BLUE;
		File f=new File("E:\\teja\\nagsir\\teja1.png");
		BufferedImage bif=ImageIO.read(f);
		int w=bif.getWidth();
		int h=bif.getHeight();
		int count=0;
		for(int i=0;i<w;i++)
		{
			for(int j=0;j<h;j++)
			{
				Color ac=new Color(bif.getRGB(i, j));
				if(ac.getRed()==ec.getRed() && ac.getBlue()==ec.getBlue() && ac.getGreen()==ec.getGreen())
				{
					count=count+1;
				}
			}
		}
		System.out.println("total pixels are:"+(w*h));
		System.out.println("pixels with expected color:"+count);
		double percentage=count*100.0/(w*h);
		System.out.println(percentage);
	}
}
