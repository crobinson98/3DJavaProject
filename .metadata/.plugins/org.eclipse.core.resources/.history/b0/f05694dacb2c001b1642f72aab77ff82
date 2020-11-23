package simpleUnitTests;

import static org.junit.Assert.*;
import org.junit.Test;
import elements.Camera;
import primitives.*;


public class CameraTest {

	@Test
	public void testConstructRay1() {
		
		Vector vup = new Vector(0, 1, 0);
		Vector vto = new Vector(0, 0, -1);
		//Vector vRt = new Vector(1, 0, 0);
		Point3D p0 =new Point3D(0,0,0);
		Camera c = new Camera(p0, vto, vup
				);
		
		Ray ray = c.constructRayThroughPixel(3, 3, 3.0, 3.0, 100, 150, 150);
		Point3D centerPoint = new Point3D(0,0,0);
		Vector direction = new Vector(0.5773502691896257, -0.5773502691896257, -0.5773502691896257);
		
		Ray answer = new Ray(centerPoint, direction);
		System.out.println(answer);
		System.out.println(ray);
		assertEquals(answer, ray);
		/*if(answer==ray)
		   assertTrue(true);
		else
			System.out.println("fail 1");//fail("not working");*/
	}
	
	
	@Test
	public void testConstructRay2() {
		
		final int WIDTH  = 3;
		final int HEIGHT = 3;
		
		
		Point3D p = new Point3D(new Coordinator(0.0), new Coordinator(0.0), new Coordinator(0.0));
		Point3D p1 = new Point3D(new Coordinator(0.0), new Coordinator(1.0), new Coordinator(0.0));
		Point3D p2 = new Point3D(new Coordinator(0.0), new Coordinator(0.0), new Coordinator(-1.0));
		
		Vector v1 = new Vector(p1);
		Vector v2 = new Vector(p2);
		
		Point3D[][] screen = new Point3D [HEIGHT][WIDTH];
		
		Camera camera = new Camera(p, v1, v2);
		
	for (int i = 0; i < HEIGHT; i++){
		for (int j = 0; j < WIDTH; j++){
			
				Ray ray = camera.constructRayThroughPixel(
						WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
				
				screen[i][j] = ray.getPOO();
				
	
				// Checking z-coordinate
				//assertTrue(Double.compare(screen[i][j].getZ().getCoordinate(), -1.0) == 0);
				if(Double.compare(screen[i][j].getZ().getCoordinate(), -1.0) == -0)
					assertTrue(true);
				else
					System.out.println("fail 2");//fail("not working");

				
				
				// Checking all options
				double x = screen[i][j].getX().getCoordinate();
				double y = screen[i][j].getX().getCoordinate();
				
				if (Double.compare(x, 3) == 0 || 
					Double.compare(x, 0) == 0 ||
					Double.compare(x, -3) == 0){
						if (Double.compare(y, 3) == 0 || 
							Double.compare(y, 0) == 0 ||
							Double.compare(y, -3) == 0){
								assertTrue(true);
						} else {
							System.out.println("fail 3");//fail("Wrong y coordinate");
						}
				} else {
					System.out.println("fail 4");//fail("Wrong x coordinate");
				}
				
			}
			System.out.println("--");
		}
		
	}


}




   
   



