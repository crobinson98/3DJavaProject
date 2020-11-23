package simpleUnitTests;

import static org.junit.Assert.*;

//import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class TriangleTest {



@Test
public void testTriangleIntersections() {

	// creating the expected values
	
	List<Point3D> answerList = new ArrayList<Point3D>();		
	Point3D answerPoint = new Point3D(0, 0, -200);		
	answerList.add(answerPoint);
	
	// building the triangle
	
	Point3D p1 = new Point3D(0, 100, -200);
	Point3D p2 = new Point3D(100, -100, -200);
	Point3D p3 = new Point3D(-100, -100, -200);
	
	Triangle t1 = new Triangle(/*Color.white,*/ p1, p2, p3);
	Triangle t2 = new Triangle(t1);			
	
	// building the ray that will intersect the triangle
	
	Point3D centerPoint = new Point3D(0,0,0);		
	Vector vector = new Vector(0, 0, -5);
	Ray ray = new Ray(centerPoint, vector);

	// testing the findIntersection function
	
	List<Point3D> list = new ArrayList<Point3D>();
	list = t2.findInterSections(ray);
	assertEquals(answerList, list);			
}

}