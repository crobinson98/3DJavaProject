package simpleUnitTests;
import primitives.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Point3DTest {

	@Test
	public void testAdd() {
		Point3D point3d=new Point3D(2,5,4.5);
		Point3D point=new Point3D(4,8,8.5);
		Vector sum=new Vector(2,3,4);
		point3d.add(sum);
		assertEquals(point3d,point);
	}
	
	@Test
	public void testSubtract() {
		Point3D point3d=new Point3D(2,5,4.5);
		Point3D point=new Point3D(0,2,0.5);
		Vector sum=new Vector(2,3,4);
		point3d.subtract(sum);
		assertEquals(point3d,point);
	}

}
