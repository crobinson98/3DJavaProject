package simpleUnitTests;

//import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.Test;

//import primitives.Coordinator;
import renderer.ImageWriter;

public class ImageWriterTest {

	@Test
	public void testWritePixel1() {
		
		ImageWriter c= new ImageWriter("test",500,500,50,50);
		for(int i=0;i<500;i++)
		{
			for(int j=0;j<500;j++)
			{
				if(j%50==0 || i%50==0)
					c.writePixel(i, j, 255,255,255);
				else
					c.writePixel(i, j, 0,0,0);
			}
		}
		c.writeToimage();
	}

	
	@Test
	public void testWritePixel2() {
		
		int[] rgb=new int[3];
		ImageWriter c= new ImageWriter("test2",500,500,50,50);
		for(int i=0;i<500;i++)
		{
			for(int j=0;j<500;j++)
			{
				if(j%50==0 || i%50==0)
				{
					rgb[0]=255;
					rgb[1]=255;
					rgb[2]=255;
					c.writePixel(i, j, rgb);
				}
				else
				{
					rgb[0]=0;
					rgb[1]=0;
					rgb[2]=0;
					c.writePixel(i, j, rgb);
				}
			}
		}
		c.writeToimage();
	}

	
	@Test
	public void testWritePixel3() {
		Color rgb= new Color(255,255,255);
		ImageWriter c= new ImageWriter("test3",500,500,50,50);
		for(int i=0;i<500;i++)
		{
			for(int j=0;j<500;j++)
			{
				if(j%50==0 || i%50==0)
					c.writePixel(i, j,rgb);
				else {
					Color rgb2= new Color(0,0,0);
					c.writePixel(i, j,rgb2);
				}
			}
		}
		c.writeToimage();
	}

}

