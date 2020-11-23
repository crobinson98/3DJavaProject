package geometries;
import java.awt.Color;
import java.util.ArrayList;

import primitives.*;

public class Plane  extends Geometry implements FlatGeometry 
{
	
	private Point3D _p1;
	private Vector _normal;
	
// ***************** Constructors ********************** // 
	
	/**
	 * default constructor
	 */
	public Plane() 
	{
		this._p1=new Point3D(0,0,0);
		this._normal=new Vector(0,0,0);
	}
	
	/**
	 *  Constructor with parameters
	 * @param p
	 * @param v
	 */
	public Plane(Point3D p,Vector v)
	{
		this._p1=new Point3D(p);
		this._normal=new Vector(v);
		
	}
	
	/**
	 *  Constructor with parameters
	 * @param m material
	 * @param c color
	 * @param p point on plane
	 * @param v vector normal
	 */
	public Plane(Material m, Color c,Point3D p,Vector v)
	{
		super(m,c);
		this._p1=new Point3D(p);
		this._normal=new Vector(v);
	}
	
	/**
	 *  Constructor with parameters
	 * @param c color
	 * @param p point on plane
	 * @param v normal
	 */
	public Plane(Color c,Point3D p,Vector v)
	{
		super(c);
		this._p1=new Point3D(p);
		this._normal=new Vector(v);
	}
	
	/**
	 * copy constructor
	 * @param p other object to copy
	 */
	public Plane(Plane p) 
	{
		super(p._material,p.getEmission());
		this._p1=new Point3D(p._p1);
		this._normal=new Vector(p._normal);
	}
	
// ***************** Getters/Setters ********************** //
	
	/**
	 * 
	 * @return point on plane
	 */
	public Point3D getP1() {
		return new Point3D(_p1);
	}

	/**
	 * 
	 * @return normal
	 */
	public Vector getNormal() {
		return new Vector(_normal);
	}

	/**
	 * set value
	 * @param _normal
	 */
	public void setNormal(Vector _normal) {
		this._normal = new Vector(_normal);
	}

	/**
	 * set point 
	 * @param _p1
	 */
	public void setP1(Point3D _p1) {
		this._p1 = new Point3D(_p1);
	}

	
	
// ***************** Administration  ******************** // 
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() //built-in method which (converts)return itself a string
	{
		return "Plane _p1=" + _p1 + ", _normal="+ _normal;
	}
	public Point3D get_p1() {
		return _p1;
	}
	public void set_normal(Point3D _p1) {
		this._normal.setHead( _p1);
	}
	

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
		Plane other = (Plane) obj;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (_normal == null) {
			if (other._normal != null)
				return false;
		} else if (!_normal.equals(other._normal))
			return false;
		
		return true;
	}
	
// ***************** Operations ******************** //
	

	/**
	* return a list of intersection points between the plane and ray
	* @param ray - ray to get the intersection points
	* @return list of intersection point according to ray on plane
	*/
	@Override
	public ArrayList<Point3D> findInterSections(Ray ray) {
	 ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
	 Vector n = new Vector(_normal);
	 Point3D p0 = ray.getPOO();
	 Point3D q0 = new Point3D(_p1);
	 Vector pq1 = new Vector(p0);
	 Vector pq2 = new Vector(q0);
	 pq1.subVector(pq2);
	 Vector v = new Vector(ray.getDirection());
	 double mechane=n.dotProduct(v);
	 if(mechane!=0)
	 {
	   double t = (-1 * n.dotProduct(pq1))/mechane;
	   if(t>=0)
	   {
	   v.scale(t);
	   p0.add(v);
	   intersectionPoints.add(p0);
	   }
	 }
	 return intersectionPoints;
	}

	
	/**
	 * get normal
	 */
	public Vector getNormal(Point3D p) {
		
		return new Vector(this._normal);
	}
	

}

