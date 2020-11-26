package SimpleUnitTests;

//import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;


import elements.PointLight;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primatives.Material;
import primatives.Point3D;
import primatives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class LightTest {

	@Test
	public void pointLightTest1(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		Sphere sphere = new Sphere(new Color(0,0,100) , 800, new Point3D(0,0,-1000));
		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200,-100), 
					   0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("new Point Test1", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
		
	}
	

	@Test
	public void pointLightTest2(){
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		//Sphere sphere = new Sphere (new Color(0,0,100),800, new Point3D(0,0, -1000));
		Material m=new Material();
		m.set_nShininess(20);
		//sphere.set_material(m);
		
	
		Triangle triangle = new Triangle(new Color(0,0,0), new Point3D(  3500, 3500, -2000),
					  new Point3D( -3500, -3500, -1000),  new Point3D(3500, -3500, -2000), new Material());
		Triangle triangle2 = new Triangle(new Color(0,0,0), new Point3D(   3500, 3500, -2000),
						new Point3D(   -3500, 3500, -1000), new Point3D( -3500, -3500, -1000), new Material());
	
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200,200, -100),
	                   0, 0.000001, 0.0000005));

		
		ImageWriter imageWriter = new ImageWriter("new Point Test2", 500, 500, 500, 500);
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
	}
	
	

	@Test
	public void spotLightTest1(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		Sphere sphere = new Sphere (new Color(0,0,100),800, new Point3D(0,0, -1000));
		
		
		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
				
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
					  0, 0.00001, 0.000005,   new Vector(2, 2, -3)));
	
		ImageWriter imageWriter = new ImageWriter("new Spot Test1", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
	}
	

	
	@Test
    public void spotLightTest2(){

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.set_color(new Color(0, 0, 100));
        Material m=new Material();
        m.set_nShininess(20);
        sphere.set_material(m);
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270));
        triangle.set_color(new Color (0, 0, 100));

        Material m1=new Material();
        m1.set_nShininess(4);
        triangle.set_material(m);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150)
        		, 0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("new Spot test 2", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        imageWriter.writeToimage();
    }
	

	@Test
	public void spotLightTest3(){
		
		
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		
		Triangle triangle = new Triangle(new Color(0,0,0),
										 new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000), new Material());

		
		
		Triangle triangle2 = new Triangle(new Color(0,0,0),
										  new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000), new Material());
	
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

	scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					    0, 0.000001, 0.0000005, new Vector(-2, -2, -3)));
	
		
		ImageWriter imageWriter = new ImageWriter("new Spot Test3", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
	//	render.printGrid(50);
		imageWriter.writeToimage();
		
	}
	
	@Test
	public void shadowTest(){

	Scene scene = new Scene();
	Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
	sphere.get_material().set_nShininess(20);
	sphere.set_color(new Color(0, 0, 100));

	scene.addGeometry(sphere);

	Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
	new Point3D( -3500, -3500, -1000),
	new Point3D(  3500, -3500, -2000));

	Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
	 	 new Point3D( -3500,  3500, -1000),
	 	 new Point3D( -3500, -3500, -1000));

	scene.addGeometry(triangle);
	scene.addGeometry(triangle2);

	scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
			0, 0.000001, 0.0000005,  new Vector(-2, -2, -3)));


	ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);

	Render render = new Render(scene, imageWriter);

	render.renderImage();
	imageWriter.writeToimage();

	}
	
	
	
}

































