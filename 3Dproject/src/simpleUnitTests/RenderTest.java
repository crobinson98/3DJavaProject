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

public class RenderTest{

	
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
	public void recursiveTest4(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		Sphere sphere = new Sphere(new Color(0, 0, 100), 300, new Point3D(-550, -500, -1000));
		Material material = new Material();
		material.set_nShininess(20); 
		material.set_kt(0.5);
		sphere.set_material(new Material(material));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(new Color(100, 20, 20), 150, new Point3D(-550, -500, -1000));
		Material material2 = new Material();
		material2.set_nShininess(20);
		material2.set_kt(0);		
		sphere2.set_material(new Material(material2));
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Color(20, 20, 20), new Point3D(  1500, -1500, -1500),
				 new Point3D( -1500,  1500, -1500),
				 new Point3D(  200,  200, -375));

		Triangle triangle2 = new Triangle(new Color(20, 20, 20), new Point3D(  1500, -1500, -1500),
				  new Point3D( -1500,  1500, -1500),
				  new Point3D( -1500, -1500, -1500));

		
	
		Material material3 = new Material();		
		material3.set_kr(1);		
		triangle.set_material(new Material(material3));
		
		Material material4 = new Material();		
		material4.set_kr(0.5);		
		triangle2.set_material(new Material(material4));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);


		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   0.1, 0.00001, 0.000005,  new Vector(-2, -2, -3)));
	
		ImageWriter imageWriter = new ImageWriter("Recursive Test3", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
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
	  
	    
	    ImageWriter imageWriter = new ImageWriter("shadownnnn test", 500, 500, 500, 500);
	    
	    Render render = new Render(scene, imageWriter);
	    
	    render.renderImage();
	    render.get_imW().writeToimage();
	    
	  }
	
	
	 @Test
	 public void finalTest(){

	 Scene scene = new Scene();
	 
	 Sphere sphere = new Sphere(new Point3D(170.0, 20.0, -400), 200);
	 sphere.get_material().set_nShininess(20);
	 sphere.setEmissoion(Color.red);
	 sphere.get_material().set_kt(0.5);
	 
	 Sphere sphereEye1 = new Sphere(new Point3D(-170.0, -20.0, -400), 200);
	 sphereEye1.get_material().set_nShininess(20);
	 sphereEye1.setEmissoion(Color.red);
	 sphereEye1.get_material().set_kt(0.5);
	 
	 Sphere sphereEye2 = new Sphere(new Point3D(20.0, 170.0, -400), 200);
	 sphereEye2.get_material().set_nShininess(20);
	 sphereEye2.setEmissoion(Color.red);
	 sphereEye2.get_material().set_kt(0.5);
	 
	 Sphere sphereEye3 = new Sphere(new Point3D(-20.0, -170.0, -400), 200);
	 sphereEye3.setEmissoion(Color.red);
	 sphereEye3.get_material().set_nShininess(20);
	 sphereEye3.get_material().set_kt(0.5);
	 
	 scene.addGeometry(sphere);
	 scene.addGeometry(sphereEye1);
	 scene.addGeometry(sphereEye2);
	 scene.addGeometry(sphereEye3);
	 
	 scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150)
	 ,   1, 0.00001, 0.000005, new Vector(2, 2, -3)));

	 Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
	 new Point3D( -3500, -3500, -1000),
	 new Point3D(  3500, -3500, -2000));

	 Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
	  	 new Point3D( -3500,  3500, -1000),
	  	 new Point3D( -3500, -3500, -1000));

	 scene.addGeometry(triangle);
	 scene.addGeometry(triangle2);


	 scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
	   0, 0, 0, new Vector(-2, -2, -3)));

	 ImageWriter imageWriter = new ImageWriter("final test1", 500, 500, 500, 500);

	 Render render = new Render(scene, imageWriter);

	 render.renderImage2();
	 //render.printGrid(50);
	 render.get_imW().writeToimage();

	 }
	 
}
	  

