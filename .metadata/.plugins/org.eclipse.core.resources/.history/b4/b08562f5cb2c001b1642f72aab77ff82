package simpleUnitTests;

import java.awt.Color;
import org.junit.Test;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class ShadowTest {
	
	@Test
	public void testShadow(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere (new Color(0,0,100),500, new Point3D(0,0,-1000));
		
		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color (0, 0, 100),
										 new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270));
		Material m1=new Material();
		m1.set_nShininess(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);
	
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					  0.1, 0.00001, 0.000005,   new Vector(2, 2, -3)));
	

		ImageWriter imageWriter = new ImageWriter("Shadow Test", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
	}
}
