package simpleUnitTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import geometries.Plane;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane1Test {

	@Test
	public void testGetNormal() {
		Plane p=new Plane();
		p.setNormal(new Vector(1,2,3));
		Vector v=new Vector();
		v=p.getNormal(new Point3D(0,0,0));
		Vector ans=new Vector(1,2,3);
		assertEquals(ans,v);
		/*if(ans==v)
		assertTrue(true);
		else
			System.out.println("fail");//fail("not working");*/
	}
	
	
	@Test
	public void testPlaneIntersections() {


		// creating the expected values
		
		ArrayList<Point3D> answerList = new ArrayList<Point3D>();		
		Point3D answerPoint = new Point3D(0, 0, -200);		
		answerList.add(answerPoint);
		
		// building the plane
		
		Point3D directionPoint = new Point3D(0, 0, -1);
		Point3D planePoint = new Point3D(0, 100, -200);
				
		Vector direction = new Vector(directionPoint);
		
		Plane plane = new Plane(Color.white, planePoint, direction);
			
		// building the ray that will intersect the plane
		
		Point3D centerPoint = new Point3D(0,0,0);
		Vector vector = new Vector(0, 0, -5);
		Ray ray = new Ray(centerPoint, vector);
	
		// testing the findIntersection function
		
		ArrayList<Point3D> list = new ArrayList<Point3D>();
		list = plane.findInterSections(ray);
		 System.out.println(answerList);
		 System.out.println(list);
		assertEquals(answerList, list);
	}

}
