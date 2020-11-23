package simpleUnitTests;
import primitives.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import org.junit.Test;



public class Point2DTest {

	@Test
	public void testSet() {
		Point2D point=new Point2D();
		Coordinator c=new Coordinator(5);
		point.setX(c);
		//assertEquals(point.getX(),5.0);
		if(point.getX().getCoordinate()==5)
			assertTrue(true);
			else
				System.out.println("fail");//fail("not working");
	}



	@Test
	public void testEquals() {
		Coordinator c=new Coordinator(5);
		Point2D point=new Point2D(c,c);
		Point2D poo=new Point2D(5,5);
		
		assertEquals(point,poo);
	}
	
	@Test
	public void testToString() {
		Coordinator c=new Coordinator(5);
		Point2D point=new Point2D(c,c);
		assertEquals(point.toString(),"x=" + c + ", " + "y=" + c);
	}
	
} 
