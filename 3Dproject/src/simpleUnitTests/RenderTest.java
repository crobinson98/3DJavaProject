package simpleUnitTests;

import java.awt.Color;

import org.junit.Test;

import elements.AmbientLight;
import elements.DirectionalLight;
import elements.PointLight;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class RenderTest{
	
	@Test
	
	public void basicRendering(){
		
		Scene scene = new Scene();
		
		scene.addGeometry(new Sphere(new Material(), Color.red, 50, new Point3D(0.0, 0.0, -150)));
		
		Triangle triangle = new Triangle(new Material(), Color.blue,new Point3D( 100, 0, -149),
				 						 new Point3D(  0, 100, -149),
				 						 new Point3D( 100, 100, -149));
		
		Triangle triangle2 = new Triangle(new Material(), Color.green,new Point3D( 100, 0, -149),
				 			 			  new Point3D(  0, -100, -149),
				 			 			  new Point3D( 100,-100, -149));
		
		Triangle triangle3 = new Triangle(new Material(), Color.orange,new Point3D(-100, 0, -149),
				 						  new Point3D(  0, 100, -149),
				 						  new Point3D(-100, 100, -149));
		
		Triangle triangle4 = new Triangle(new Material(), Color.pink,new Point3D(-100, 0, -149),
				 			 			  new Point3D(  0,  -100, -149),
				 			 			  new Point3D(-100, -100, -149));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("Render test2", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		
		imageWriter.writeToimage();
	}

	
	@Test
	public void recursiveTest1(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere(new Color(0,0, 100), 500, new Point3D(0.0, 0.0, -1000));	
		Material material = new Material();		
		material.set_nShininess(20); 
		material.set_kt(0.5);
		sphere.set_material(new Material(material));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color (100, 20, 20), 250, new Point3D(0.0, 0.0, -1000));
		material.set_kt(0);	
		sphere2.set_material(new Material(material));
		scene.addGeometry(sphere2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
							   0.1, 0.00001, 0.000005,  new Vector(2, 2, -3))); // NOW
				
		ImageWriter imageWriter = new ImageWriter("Recursive Test1", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
		
	}
	
	
	
	@Test
	public void recursiveTest2(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere(Color.RED, 500, new Point3D(0.0, 0.0, -1000));
		Material material = new Material();
		material.set_nShininess(20);
		material.set_kt(0.5);
		sphere.set_material(new Material(material));	
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(Color.BLUE, 250, new Point3D(0.0, 0.0, -1000));
		material.set_kt(0);
		sphere2.set_material(new Material(material));
		scene.addGeometry(sphere2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					    0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));
			
		ImageWriter imageWriter = new ImageWriter("Recursive Test2", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
	}

	
	@Test
	  public void shadowTest(){
	    
	    Scene scene = new Scene();
	    Sphere sphere = new Sphere(new Point3D(0.0, 0.0, -1000), 500);
	    sphere.get_material().set_nShininess(20);
	    sphere.setEmissoion(new Color(0, 0, 100));
	    
	    scene.addGeometry(sphere);
	    
	    Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
	                      new Point3D( -3500, -3500, -1000),
	                      new Point3D(  3500, -3500, -2000));

	    Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
	                        new Point3D( -3500,  3500, -1000),
	                        new Point3D( -3500, -3500, -1000));
	    
	    scene.addGeometry(triangle);
	    scene.addGeometry(triangle2);
	    
	    scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005, new Vector(-2, -2, -3)));
	  
	    
	    ImageWriter imageWriter = new ImageWriter("shadow test1", 500, 500, 500, 500);
	    
	    Render render = new Render(scene, imageWriter);
	    
	    render.renderImage();
	    render.get_imW().writeToimage();
	    
	  }
	
	

	 
	 @Test
	  public void finalTest2(){
	    
	    Scene scene = new Scene();
	    Sphere sphere1 = new Sphere(new Point3D(280, 250, -990),300);
	    sphere1.get_material().set_nShininess(20);
	    sphere1.setEmissoion(new Color(231, 125, 163));
	    
	    scene.addGeometry(sphere1);
	    
	    Sphere sphere2 = new Sphere(new Point3D(-280, 250, -990), 300);
	    sphere2.get_material().set_nShininess(20);
	    sphere2.setEmissoion(new Color(165, 126, 86));
	    
	    scene.addGeometry(sphere2);

	    Sphere sphere3 = new Sphere(new Point3D(0, 570, -1000), 300);
	    sphere3.get_material().set_nShininess(20);
	    sphere3.setEmissoion(new Color(164, 240, 216));
	    
	    scene.addGeometry(sphere3);
	    
	    Triangle triangle3 = new Triangle(new Color (160,128, 96),
				 new Point3D(0, -1000, -700),
				 new Point3D(380, 50, -700),
				 new Point3D(-380, 50, -700));
	    Material m1=new Material();
		m1.set_nShininess(4);
		triangle3.set_material(m1);
	    scene.addGeometry(triangle3);
	    
	    
	   
	    Triangle triangle = new Triangle(new Point3D(  4000,  4000, -2000),
	                      new Point3D( -4000, -4000, -1000),
	                      new Point3D(  3500, -3500, -2000));
	   

	    Triangle triangle2 = new Triangle(new Point3D( 4000,  4000, -2000),
	                        new Point3D( -3500,  3500, -1000),
	                        new Point3D( -4000, -4000, -1000));
	    
	    scene.addGeometry(triangle);
	    scene.addGeometry(triangle2);
	    
	    scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200,-100),	0, 0.00001, 0.000005));
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				0.1, 0.00001, 0.000005,   new Vector(-4, -4, -5)));
	
		
	    ImageWriter imageWriter = new ImageWriter("final test2", 500, 500, 500, 500);
	    
	    Render render = new Render(scene, imageWriter);
	    
	    render.renderImage();
	    render.get_imW().writeToimage();
	    
	  }
}
	  

