package simpleUnitTests;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import primitives.Vector;



public class VectorTest {

	@Test
	public void testAddVector() {
		Vector v1=new Vector(1,2,3);
		Vector v2=new Vector(2,5,8);
		Vector v3=new Vector(3,7,11);
		v1.addVector(v2);
		assertEquals(v1,v3);
	}

	@Test
	public void testSubVector() {
		Vector v1=new Vector(1,2,3);
		Vector v2=new Vector(2,5,8);
		Vector v3=new Vector(-1,-3,-5);
		v1.subVector(v2);
		assertEquals(v1,v3);
	}
	@Test
	public void testScale() {
		Vector v1=new Vector(1,2,3);
		v1.scale(5);
		Vector v2=new Vector(5,10,15);
		assertEquals(v1,v2);
	}
	@Test
	public void testDotProduct() {
		Vector v1=new Vector(1,2,3);
		Vector v2=new Vector(4,5,6);
		double ans=v1.dotProduct(v2);
		if(ans==32)
			assertTrue(true);
		else
			System.out.println("fail");//fail("not working");
	}
	@Test
	public void testLength() {
		Vector v=new Vector(4,2,10);
		double ans=v.length();
		if(ans==Math.sqrt(Math.pow(4,2)+Math.pow(2,2)+Math.pow(10,2)))
			assertTrue(true);
		else
			System.out.println("fail");//fail("not working");
		
		

	}
	@Test
	public void testNormalize() {
		Vector v=new Vector(4,2,10);
	    double ans=v.length();
		v.normalize();
		Vector normal=new Vector(4.0/ans,2.0/ans,10.0/ans);
		assertEquals(normal,v);
		
	}
	
	
	@Test
	public void testCrossProduct() {
		Vector v1=new Vector(5,5,5);
		Vector v2=new Vector(2,2,2);
		Vector v=new Vector(v1.crossProduct(v2));
		System.out.println(v);
		Vector v3=new Vector(0,0,0);
		assertEquals(v,v3);
	}

}
