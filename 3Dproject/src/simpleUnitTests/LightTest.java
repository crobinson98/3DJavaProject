package simpleUnitTests;

import java.awt.Color;

import org.junit.Test;

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

public class LightTest {

	@Test
	public void pointLightTest1(){

		Scene scene = new Scene();
		scene.setScreenDistance(100);
		Sphere sphere = new Sphere (new Material(),new Color(0,0,100),800, new Point3D(0,0,-1000));
		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200,-100),//-200, -200, -100), 
				0, 0.00001, 0.000005));

		ImageWriter imageWriter = new ImageWriter("Point Test1", 500, 500, 500, 500);

		Render render = new Render(scene, imageWriter);

		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();

	}


	@Test
	public void pointLightTest2(){
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		Sphere sphere = new Sphere (new Material(),new Color(0,0,100),800, new Point3D(0,0, -1000));
		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);


		Triangle triangle = new Triangle(new Material(),new Color(0,0,0), new Point3D(  3500, 3500, -2000),
				new Point3D( -3500, -3500, -1000),  new Point3D(3500, -3500, -2000) );
		Triangle triangle2 = new Triangle(new Material(),new Color(0,0,0), new Point3D(   3500, 3500, -2000),
				new Point3D(   -3500, 3500, -1000), new Point3D( -3500, -3500, -1000));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200,200, -100),
				0, 0.000001, 0.0000005));


		ImageWriter imageWriter = new ImageWriter("Point Test2", 500, 500, 500, 500);
		Render render = new Render(scene, imageWriter);

		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();
	}



	@Test
	public void spotLightTest1(){

		Scene scene = new Scene();
		scene.setScreenDistance(100);
		Sphere sphere = new Sphere (new Material(),new Color(0,0,100),800, new Point3D(0,0, -1000));


		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
				0, 0.00001, 0.000005,   new Vector(2, 2, -3)));

		ImageWriter imageWriter = new ImageWriter("Spot Test1", 500, 500, 500, 500);

		Render render = new Render(scene, imageWriter);

		render.renderImage();
		//	render.printGrid(50);
		imageWriter.writeToimage();
	}

	@Test
	public void spotLightTest2(){

		Scene scene = new Scene();
		scene.setScreenDistance(200);

		Sphere sphere = new Sphere (new Material(),new Color(0,0,100),500, new Point3D(0,0,-1000));

		Material m=new Material();
		m.set_nShininess(20);
		sphere.set_material(m);
		scene.addGeometry(sphere);

		Triangle triangle = new Triangle(new Material(),new Color (0, 0, 100),
				new Point3D(-125, -225, -260),
				new Point3D(-225, -125, -260),
				new Point3D(-225, -225, -270)
				);

		Material m1=new Material();
		m1.set_nShininess(4);
		triangle.set_material(m);
		scene.addGeometry(triangle);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
				0.1, 0.00001, 0.000005,   new Vector(2, 2, -3)));

		ImageWriter imageWriter = new ImageWriter("Spot Test2", 500, 500, 500, 500);

		Render render = new Render(scene, imageWriter);

		render.renderImage();
		//	render.printGrid(50);
		imageWriter.writeToimage();
	}

	@Test
	public void spotLightTest3(){


		Scene scene = new Scene();
		scene.setScreenDistance(100);

		Triangle triangle = new Triangle(new Material(),new Color(0,0,0),
				new Point3D(  3500,  3500, -2000),
				new Point3D( -3500, -3500, -1000),
				new Point3D(  3500, -3500, -2000)
				);



		Triangle triangle2 = new Triangle(new Material(),new Color(0,0,0),
				new Point3D(  3500,  3500, -2000),
				new Point3D( -3500,  3500, -1000),
				new Point3D( -3500, -3500, -1000)
				);

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
				0, 0.000001, 0.0000005, new Vector(-2, -2, -3)));

		
		ImageWriter imageWriter = new ImageWriter("Spot Test3", 500, 500, 500, 500);

		Render render = new Render(scene, imageWriter);

		render.renderImage();
		//	render.printGrid(50);
		imageWriter.writeToimage();

	}

}
