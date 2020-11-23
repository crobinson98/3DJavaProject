package geometries;
import primitives.*;

import java.awt.Color;
import java.util.ArrayList;
//import java.util.List;

 public class Sphere extends RadialGeometry
 {
	
	private Point3D _center;

// ***************** Constructors ********************** // 
	/**
	 *  Constructor with parameters
	 * @param center
	 * @param radius
	 */
	public Sphere(Point3D center,double radius) 
	{
		super(radius);
		this._center = new Point3D(center);
	}

	/**
	 *  Constructor with parameters
	 * @param m material
	 * @param c color
	 * @param radius
	 * @param center
	 */
	public Sphere(Material m, Color c ,double radius,Point3D center)
	{
		super(m,c,radius);
		this._center =new Point3D( center);
	}
	
	/**
	 *  Constructor with parameters
	 * @param c color
	 * @param radius
	 * @param center
	 */
	public Sphere( Color c ,double radius,Point3D center)
	{
		super(c,radius);
		this._center =new Point3D( center);
	}
	
	/**
	 * default constructor
	 */
	public Sphere()
	{
		super(0);
		this._center = new Point3D();
	}
	
	/***
	 * copy constructor
	 * @param s object to copy
	 */
	public Sphere(Sphere s)
	{
		super(s._radius);
		this._center = new Point3D(s._center);
	}

// ***************** Getters/Setters ********************** // 

	/**
	 * @return radius
	 */
	public double get_radius() {
		return _radius;
	}

	/**
	 * set radius
	 */
	public void set_radius(double _radius) {
		this._radius = _radius;
	}
	
	/**
	 * 
	 * @return point of center
	 */
	public Point3D get_center() {
		return new Point3D(_center);
	}

	/**
	 * set value
	 * @param _center
	 */
	public void set_center(Point3D _center) {
		this._center =new Point3D(_center);
	}
	
// ***************** Administration  ******************** // 
	
	/**
	 * check if 2 variabels are equals
	 */
	@Override
	public boolean equals(Object obj) //method compares the two given strings based on the content of the string
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		return true;
	}
	
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() //built-in method which (converts)return itself a string
	{
		return "Sphere: "+" center = "+_center+"radius = "+_radius;

	}


// ***************** Operations ******************** //
	
/**
 * returns the normal of the triangle 
 */
	@Override
	public Vector getNormal(Point3D point) {
		Vector vector = new Vector(_center, point);
		vector.normalize();
		return vector;
		
	}
	
	/**
	 * calculating inersections using this formula:
	 * Ray:P=Po+t*v
	 * sphere:|P-O|^2-r^2=0
	 * L=O-P0
	 * tm=L dot product with v
	 * d=(|L|^2-tm^2)^0.5
	 * th=(r^2-d^2)^0.5
	 * t1=tm-th
	 * t2=tm+th
	 * P1=P0+t1*V
	 * P2=P0+t2*V
	 * 
	 */
	@Override
	public ArrayList<Point3D> findInterSections(Ray ray) {
	 
	 ArrayList <Point3D> intersectionPoints = new ArrayList<Point3D>();
	 
	 Point3D center = new Point3D(_center); // center is called O in slides
	 Point3D p0= ray.getPOO();
	 double length = center.distance(p0);
	 
	 
	 // fixing - remove these two lines
	 //Vector v = new Vector(ray.getDirection());
	 //v.scale(length);
	 
	 // fixing added this one next line
	 Vector v = new Vector(ray.getPOO(),_center);
	 // fixing remove next line
	 //double tm = v.length();
	 
	 // fixing - added this next line
	 double tm = v.dotProduct(ray.getDirection());
	 
	 double d = Math.sqrt(Math.pow(length, 2) - Math.pow(tm, 2));
	 
	 if (d<0)
	  return intersectionPoints;
	 
	 double th = Math.sqrt(Math.pow(_radius, 2) - Math.pow(d, 2));
	 double t1 = tm - th;
	 double t2 = tm + th;
	 
	 Point3D p1 = new Point3D(ray.getPOO());
	 Vector vector1 = new Vector(ray.getDirection());
	 
	 if(t1 > 0){
	  vector1.scale(t1);
	  p1.add(vector1);
	  intersectionPoints.add(p1);   
	 }
	 
	 Point3D p2 = new Point3D(ray.getPOO());
	 Vector vector2 = new Vector(ray.getDirection());
	 if(t2 > 0){
	  vector2.scale(t2);
	  p2.add(vector2);
	  intersectionPoints.add(p2); 
	 }
	 
	 return intersectionPoints;
	   
	}
	

   }
   	

