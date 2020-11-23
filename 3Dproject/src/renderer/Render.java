package renderer;

import java.util.Map.Entry;

import primitives.Point3D;
import primitives.Ray;
import elements.Light;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.*;
import scene.Scene;

public class Render {

	protected Scene _scene;
	protected ImageWriter _imW;
	int RECURSION_LEVEL=3;

	//***************** Getters/Setters ********************** //

	/**
	 * 
	 * @return the  picture
	 */
	public Scene get_scene() 
	{
		return new Scene(_scene);
	}

	/**
	 * set picture
	 * @param _scene
	 */
	public void set_scene(Scene _scene)
	{
		this._scene = new Scene(_scene);
	}

	/**
	 * 
	 * @return image writer
	 */
	public ImageWriter get_imW()
	{
		return _imW;
	}

	/**
	 * set value
	 * @param imW
	 */
	public void set_imW(ImageWriter imW)
	{
		this._imW = imW;
	}


	//***************** Constructors ********************** //

	/**
	 * constructor with parameters
	 * @param _scene
	 * @param imW
	 */
	public Render(Scene _scene, ImageWriter imW) 
	{
		this._scene =new Scene( _scene);
		this._imW = imW;
	}

	/**
	 * copy constructor
	 * @param r
	 */
	public Render(Render r) 
	{
		this._scene = new Scene(r.get_scene());
		this._imW = r.get_imW();
	}



	//***************** Administration  ******************** // 

	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Render scene=" + _scene + ", imageWriter=" + _imW;
	}

	/**
	 *  check if 2 variables are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Render other = (Render) obj;
		if (_imW == null)
		{
			if (other._imW != null)
				return false;
		} 
		else if (!_imW.equals(other._imW))
			return false;
		if (_scene == null)
		{
			if (other._scene != null)
				return false;
		} 
		else if (!_scene.equals(other._scene))
			return false;
		return true;
	}

	// ***************** Operations ******************** //

	/**
	 * prints a grid, black background and white lines
	 * @param interval the size of the squire
	 */
	public void printGrid(int interval) 
	{
		for(int i=0;i<this._imW.getHeight();i++)
		{
			for(int j=0;j<this._imW.getWidth();j++)
			{
				if(j%interval==0 || i%interval==0)
					this._imW.writePixel(i, j, 255,255,255);
			}
		}
		this._imW.writeToimage();
	}


	/**
	 * return a map, the key is the type of geometry and the value is a list of intersections
	 * @param ray the ray that is shot form the camera
	 * @return a map of geometry type and list of intersections
	 */
	private HashMap<Geometry, ArrayList<Point3D>> getSceneRayIntersections(Ray r)
	{
		Iterator<Geometry> geometries = _scene.getGeometriesIterator();
		HashMap<Geometry, ArrayList<Point3D>> intersectionPoints = new  HashMap<Geometry,  ArrayList<Point3D>>();
		while (geometries.hasNext())
		{
			Geometry geometry = geometries.next();
			ArrayList<Point3D> geometryIntersectionPoints =geometry.findInterSections(r);
			if(!geometryIntersectionPoints.isEmpty())
			{
				intersectionPoints.put(geometry, geometryIntersectionPoints);
			}
		}
		return intersectionPoints;
	}


	/**
	 * for each point on each geometry checks if its hidden
	 * @param light light source
	 * @param point the point we want to check
	 * @param geometry the geometry the point is on
	 * @return true if the point is hidden otherwise false 
	 */
	private boolean occluded(Light light, Point3D point, Geometry geometry) 
	{
		Vector lightDirection = new Vector(light.getL(point));
		lightDirection.scale(-1);

		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));
		epsVector.scale(2);

		geometryPoint.add(epsVector);
		Ray lightRay = new Ray(geometryPoint, lightDirection);
		Map<Geometry, ArrayList<Point3D>> intersectionPoints =
				getSceneRayIntersections(lightRay);

		// Flat geometry cannot self intersect
		if (geometry instanceof FlatGeometry){
			intersectionPoints.remove(geometry);
		}

		for (Entry <Geometry, ArrayList<Point3D>> entry:intersectionPoints.entrySet()) 
			if (entry.getKey().get_material().get_kt()==0) 
				return true; 
		return false;

	}

	/**
	 * calculates the diffuse of the light at the given point
	 * @param kd diffuse factor
	 * @param n the vector that is vertical to the light source
	 * @param l the vector of the light direction
	 * @param intensity the color of the geometry
	 * @return the color after taking into account the diffuse
	 */
	public Color caclDiffuseComp(double kd, Vector normal, Vector vecL, Color intensity)
	{
		Vector dotP = new Vector(normal);
		dotP.normalize();
		Vector tempL = new Vector(vecL);
		tempL.normalize();
		double res = dotP.dotProduct(tempL);
		res *=kd;
		if(res<0)
			res= -1*res;
		if(res>1) res=1;
		int red = (int)(res*intensity.getRed());
		int green = (int)(res*intensity.getGreen());
		int blue = (int)(res*intensity.getBlue());
		red=red>255?255:red;
		green =green>255?255:green;
		blue =blue>255?255:blue;
		return new Color (red,green,blue);
	}

	/**
	 * mixes two colors together to get a new color
	 * @param c1 first color
	 * @param c2 second color
	 * @return new mixed color
	 */
	public Color addColor(Color c1, Color c2)
	{
		int red=c1.getRed()+c2.getRed();
		if(red>255) red=255;
		int green=c1.getGreen()+c2.getGreen();
		if(green>255) green=255;
		int blue=c1.getBlue()+c2.getBlue();
		if(blue>255) blue=255;
		return new Color(red, green, blue);
	}

	/** 
	 * @param red
	 * @param green
	 * @param blue
	 * @param num
	 * @return color
	 */
	public Color avarage(int red, int green, int blue, int num)
	{
		red=red/num;
		if(red > 255)red = 255;

		green = green/num;
		if(green>255)green = 255;

		blue = blue/num;
		if(blue>255)blue = 255;

		return new Color(red, green, blue);
	}

	/**
	 * calculates the color of the geometry, call another function
	 * @param geometry the geometry we want the color of
	 * @param point point on geometry
	 * @param inRay ray from camera to geometry
	 * @return the color
	 */
	private Color calcColor(Geometry geometry, Point3D point,Ray inRay) 
	{
		return calcColor( geometry, point,inRay, 0);
	}

	/*private Ray constructRefractedRay(Vector D,Point3D point, Ray ray)
    {
      ray.getDirection().normalize();
      Vector temp = new Vector(ray.getDirection());
      Point3D point1 = new Point3D(point);
      point1.add(temp);
      return new Ray(point1, ray.getDirection());
    }*/

	/**
	 *  builds the ray the reflects from the given point
	 * @param g
	 * @param point
	 * @param inRay
	 * @return
	 */
	private Ray constructRefractedRay(Geometry g, Point3D point, Ray inRay) {

		Vector normal = g.getNormal(point);
		normal.normalize();
		normal.scale(-2);
		point.add(normal);

		Ray reflectedRay = new Ray(point,new Vector(inRay.getDirection()));

		return reflectedRay;
	}

	/**
	 * builds the ray the reflects from the given point
	 * @param N normal of point
	 * @param point point we want to check
	 * @param ray ray from camera to geometry
	 * @return the new reflected ray
	 */
	Ray constructReflectedRay(Vector N, Point3D point, Ray ray)
	{
		N.normalize();
		Vector D = new Vector(ray.getDirection());
		D.normalize();
		double A=D.dotProduct(N);
		Vector B=N.scale1(A*(-2));
		D.addVector(B);
		Point3D point1 = new Point3D(point);
		point1.add(D);
		return new Ray(point1 ,D);
	}

	/**
	 * returns a map, the key is the geometry type and the value is the closest point the ray hit
	 * @param intersectionPoints a map with geometrys and lists of intersection points
	 * @return the point that is closest to the camera where the ray hit the geometry
	 */
	private Map<Geometry, Point3D>getClosestPoint (Map<Geometry, ArrayList<Point3D>> intersectionPoints)
	{
		double distance = Double.MAX_VALUE;
		Point3D P0 = _scene.getCamera().getpO();
		Map<Geometry, Point3D> minDistancePoint  = new HashMap<Geometry, Point3D>();
		for (Entry<Geometry, ArrayList<Point3D>> entry : intersectionPoints.entrySet())  
		{
			for (Point3D point: entry.getValue())  
			{
				if (P0.distance(point) < distance)
				{
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(), new Point3D(point));
					distance = P0.distance(point);
				}
			}
		}
		return minDistancePoint;
	}

	/**
	 * return a map with geometry type and the closest intersection
	 * @param ray ray form camera to geometry
	 * @return a map with geometry type and the closest intersection
	 */
	private Map<Geometry, Point3D> findClosesntIntersection(Ray ray)
	{
		Map<Geometry, ArrayList<Point3D>> help = getSceneRayIntersections(ray);
		return getClosestPoint(help);
	}

	/**
	 * calculates the reflection of the light at the given point
	 * @param ks specular factor
	 * @param vector the direction of the light
	 * @param n vector vertical to light source
	 * @param l vector form camera to geometry
	 * @param shininess Refraction index
	 * @param intensity color
	 * @return the color after taking into account the specular
	 */
	private Color calcSpec(double ks, Vector v,Vector normal,Vector D, double shiny, Color in)
	{
		Vector r1 = new Vector (D);
		double scalar = D.dotProduct(normal);
		Vector n = new Vector(normal);
		n.scale(scalar);
		n.scale(-2);
		r1.addVector(n);
		r1.normalize();
		Vector tempV = new Vector(v);
		tempV.normalize();
		scalar = r1.dotProduct(tempV);
		if(scalar<0)
			scalar = 0;
		scalar = Math.pow(scalar, shiny);
		scalar*=ks;
		if(scalar>1) scalar = 1;
		int r = (int)(in.getRed()*scalar);
		int g = (int)(in.getGreen()*scalar);
		int b = (int)(in.getBlue()*scalar);
		r=r>255?255:r;
		g =g>255?255:g;
		b=b>255?255:b;
		return new Color(r,g,b);
	}

	/**
	 * renders the picture
	 */
	public void renderImage() 
	{
		for(int i=0; i < this._imW.getHeight(); i++)
		{
			for(int j=0;j<this._imW.getWidth();j++)
			{
				Ray ray = _scene.getCamera().constructRayThroughPixel
						(_imW.getNx(),_imW.getNy(),
								i, j, _scene.getScreenDistance(), _imW.getWidth(),
								_imW.getHeight());

				Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
				if (intersectionPoints.isEmpty()){
					_imW.writePixel(i, j, _scene.getBackground());
				}

				else
				{
					Map<Geometry, Point3D> closestPoint = getClosestPoint(intersectionPoints);
					_imW.writePixel(i, j, calcColor(closestPoint.entrySet().iterator().next().getKey() 
							,closestPoint.entrySet().iterator().next().getValue(), ray));
				}
			}

		}
	}




	/**
	 * calculates the color of the geometry
	 * @param geometry the geometry we want the color of
	 * @param point point on geometry
	 * @param inRay ray from camera to geometry
	 * @param level we take into account different aspects like shade but up to a certain degree, here its 3 times
	 * @return the color
	 */
	private Color calcColor(Geometry geometry, Point3D point ,Ray inRay, int level) 
	{
		if (level == RECURSION_LEVEL) return new Color(0, 0, 0);
		Color ambientLight = _scene.getAmbientLight().getIntensityP(point);
		Color emissionLight = geometry.getEmission();

		Iterator<Light> lights = _scene.getLightsIterator();
		Color ColorDiffuseLight= new Color(0,0,0);
		Color SpecularLight = new Color(0,0,0);
		Color reflectedLight = new Color(0,0,0);
		Color refractedLight = new Color(0,0,0);

		while (lights.hasNext()){
			Light light = lights.next();
			if (!occluded(light, point, geometry))
			{  
				ColorDiffuseLight = addColor(ColorDiffuseLight, caclDiffuseComp(geometry.get_material().get_kd(),
						geometry.getNormal(point),  light.getL(point),  light.getIntensity(point)));

				SpecularLight = addColor(SpecularLight, calcSpec(geometry.get_material().get_ks(),
						new Vector(point, _scene.getCamera().getpO()),
						geometry.getNormal(point),  light.getL(point), geometry.get_material().get_nShininess(),
						light.getIntensity(point)));
			}
		}

		// Recursive call for a reflected ray
		Ray reflectedRay = new Ray(constructReflectedRay(geometry.getNormal(point), point, inRay));
		Map<Geometry, Point3D> reflectedEntry = findClosesntIntersection(reflectedRay);
		if (!reflectedEntry.isEmpty()) 
		{
			Color reflectedColor = calcColor(reflectedEntry.entrySet().iterator().next().getKey(),
					reflectedEntry.entrySet().iterator().next().getValue(), reflectedRay, level + 1);  
			double kr = geometry.get_material().get_kr();
			int reflectR = (int) (kr * reflectedColor.getRed());
			int reflectG = (int) (kr * reflectedColor.getGreen());
			int reflectB = (int) (kr * reflectedColor.getBlue());
			reflectedLight = new Color(reflectR, reflectG, reflectB);
		}

		// Recursive call for a refracted ray
		Ray refractedRay = constructRefractedRay(geometry, point, inRay);
		Map<Geometry, Point3D> refractedEntry = findClosesntIntersection(refractedRay);
		if (!refractedEntry.isEmpty())
		{
			Color refractedColor = calcColor(refractedEntry.entrySet().iterator().next().getKey(), 
					refractedEntry.entrySet().iterator().next().getValue(), refractedRay, level + 1);
			double kt = geometry.get_material().get_kt();
			int refractR = (int) (kt * refractedColor.getRed());
			int refractG = (int) (kt * refractedColor.getGreen());
			int refractB = (int) (kt * refractedColor.getBlue());
			refractedLight = new Color(refractR, refractG, refractB);        
		}

		double totalRed = ambientLight.getRed() + emissionLight.getRed()
		+ ColorDiffuseLight.getRed() + SpecularLight.getRed() + reflectedLight.getRed() + refractedLight.getRed();
		double totalBlue = ambientLight.getBlue() + emissionLight.getBlue() 
		+ ColorDiffuseLight.getBlue() + SpecularLight.getBlue() + reflectedLight.getBlue() + refractedLight.getBlue();
		double totalGreen = ambientLight.getGreen() + emissionLight.getGreen() 
		+ ColorDiffuseLight.getGreen() + SpecularLight.getGreen()+reflectedLight.getGreen() + refractedLight.getGreen();
		if(totalRed>255) totalRed = 255;
		if(totalBlue>255) totalBlue = 255;
		if(totalGreen>255) totalGreen = 255;
		return new Color((int)totalRed, (int)totalGreen, (int)totalBlue);
	}


	/**
	 * Produces the actual image and builds with the imageWriter image file
	 * with superSumpling improvement
	 */
	public void renderImage2() 
	{
       // improves running time
		boolean [][] check= new boolean [this._imW.getHeight()][this._imW.getWidth()];
		for(int i=0;i<this._imW.getHeight();i++)
		{
			for(int j=0;j<this._imW.getWidth();j++)
			{
				Ray ray = this._scene.getCamera().constructRayThroughPixel
						(_imW.getNx(), _imW.getNy(),i,j,this._scene.getScreenDistance(), _imW.getWidth(),_imW.getHeight());
				Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
				if (intersectionPoints.isEmpty())
				{
					check[i][j]=false;
				}
				else
				{
					check[i][j]=true;
				}
			}
		}
		//For each point (i,j) in the view plane
		for(int i=0;i<this._imW.getHeight();i++)
		{
			for(int j=0;j<this._imW.getWidth();j++)
			{
				if(check[i][j]==false)
				{
					_imW.writePixel(i,j, this._scene.getBackground());
				}
				else
				{
					Ray ray = this._scene.getCamera().constructRayThroughPixel
							(_imW.getNx(), _imW.getNy(),i,j,this._scene.getScreenDistance(), _imW.getWidth(),_imW.getHeight());
					Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
					Color color=new Color(0,0,0);

					//super
					ArrayList<Ray> raysSuper = this._scene.getCamera().constructRayThroughPixelSuper
							(_imW.getNx(), _imW.getNy(),i,j,this._scene.getScreenDistance(), _imW.getWidth(),_imW.getHeight());
					for (Iterator<Ray> iterator = raysSuper.iterator(); iterator.hasNext();)
					{
						Ray help = iterator.next();
						Map<Geometry, ArrayList<Point3D>>intersectionPointsSuper=getSceneRayIntersections(help);
						if(intersectionPointsSuper.isEmpty())
						{
							color=addColor(color,_scene.getBackground());
						}
						else
						{
							Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPointsSuper);  
							color=addColor(color,calcColor(closestPoint.entrySet().iterator().next().getKey() ,closestPoint.entrySet().iterator().next().getValue(),help));
					
						}
					}

					int red=color.getRed()/4;
					int green=color.getGreen()/4;
					int blue=color.getBlue()/4;

					//middle

					Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
					Color middle=color=addColor(color,calcColor(closestPoint.entrySet().iterator().next().getKey() ,closestPoint.entrySet().iterator().next().getValue(),new Ray()));
					red+= middle.getRed();
					red=red/2;
					green+=middle.getGreen();
					green=green/2;
					blue+=middle.getBlue();
					blue=blue/2;
					Color superSampling=new Color(red, green, blue);
					_imW.writePixel(i, j, superSampling) ;
				}

			}	

		}
	}

}


