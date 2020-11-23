package geometries;
import java.awt.Color;
import java.util.ArrayList;

import primitives.*;

public class Triangle extends Geometry implements FlatGeometry
{
	
	private Point3D _p1,_p2,_p3;

// ***************** Constructors ********************** // 
	
	/**
	 * Constructor with parameters
	 * @param _p1 vertex 1
	 * @param _p2 ""2
	 * @param _p3 ""3
	 */
	public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) 
	{
		super(new Material(), new Color(0,0,0));
		this._p1 = new Point3D(_p1);
		this._p2 =new Point3D( _p2);
		this._p3 =new Point3D( _p3);
	}
	
	/**
	 * Constructor with parameters
	 * @param m material
	 * @param c color
	 * @param _p1
	 * @param _p2
	 * @param _p3
	 */
	public Triangle(Material m,Color c,Point3D _p1, Point3D _p2, Point3D _p3) 
	{
		super(m,c);
		this._p1 = new Point3D(_p1);
		this._p2 =new Point3D( _p2);
		this._p3 =new Point3D( _p3);
	}
	
	/**
	 * Constructor with parameters
	 * @param c color
	 * @param _p1
	 * @param _p2
	 * @param _p3
	 */
	public Triangle(Color c,Point3D _p1, Point3D _p2, Point3D _p3)
	{
		super(c);
		this._p1 = new Point3D(_p1);
		this._p2 =new Point3D( _p2);
		this._p3 =new Point3D( _p3);
	}
	
	/**
	 * default constructor
	 */
	public Triangle()
	{
		super();
		this._p1 = new Point3D();
		this._p2 = new Point3D();
		this._p3 = new Point3D();
	}

	/**
	 * copy  Constructor
	 * @param t object to copy
	 */
	public Triangle(Triangle t) 
	{
		super(t._material,t._emission);
		this._p1 = new Point3D(t._p1);
		this._p2 =new Point3D( t._p2);
		this._p3 =new Point3D( t._p3);
	}
	
	
// ***************** Getters/Setters ********************** // 
	
	/**
	 * 
	 * @return first vertex
	 */
	public Point3D get_p1() {
		return new Point3D(_p1);
	}
	
	/**
	 * set value
	 * @param _p1
	 */
	public void set_p1(Point3D _p1) {
		this._p1 = new Point3D(_p1);
	}
	
	/**
	 * 
	 * @return second vertex
	 */
	public Point3D get_p2() {
		return new Point3D(_p2);
	}
	
	/**
	 * set value
	 * @param _p2
	 */
	public void set_p2(Point3D _p2) {
		this._p2 = new Point3D(_p2);
	}
	
	/**
	 * 
	 * @return vertex 3
	 */
	public Point3D get_p3() {
		return new Point3D(_p3);
	}
	
	/**
	 * set val
	 * @param _p3
	 */
	public void set_p3(Point3D _p3) {
		this._p3 = new Point3D(_p3);
	}
	
// ***************** Administration  ******************** // 
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() //built-in method which (converts)return itself a string
	{
		return "Triangle: p1 = "+_p1+"p2 = "+_p2+"p3 = "+_p3;
	}

	/**
	 * check if 2 variables are equals
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
		Triangle other = (Triangle) obj;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (_p2 == null) {
			if (other._p2 != null)
				return false;
		} else if (!_p2.equals(other._p2))
			return false;
		if (_p3 == null) {
			if (other._p3 != null)
				return false;
		} else if (!_p3.equals(other._p3))
			return false;
		return true;
	}
	
// ***************** Operations ******************** //
	
	
	/**
	 * return the triangles normal
	 * @param point p not used
	 * @return the normal
	 */
	public Vector getNormal(Point3D p) 
	{
		Vector v1 = new Vector(_p1, _p2);
		Vector v2 = new Vector(_p1, _p3);
		Vector v = v2.crossProduct(v1);
        v.normalize();
        v.scale(-1);		
		return v;
	}
	
	/**
	 * returns a list of all the intersection between the ray and the triangle
	 * @param ray
	 * @return a list of all the intersection, where the ray touched the triangle
	 */
	@Override
	  public ArrayList<Point3D> findInterSections (Ray ray)
	  {  

	    Vector v = this.getNormal(new Point3D(0, 0, 0));
	    ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
	    Plane p = new Plane(this.get_material(),this.getEmission(),this._p1,v);
	    intersectionPoints = p.findInterSections(ray);

	    if (intersectionPoints.isEmpty())
	    {
	      return intersectionPoints; 
	    }         
	    Triangle tr1 = new Triangle(this.get_material(), this.getEmission(), ray.getPOO(), _p1, _p2);
	    Vector N1 = new Vector(tr1.getNormal(new Point3D()));
	    Triangle tr2 = new Triangle(this.get_material(),this.getEmission(),ray.getPOO(), _p2, _p3);
	    Vector N2 = new Vector(tr2.getNormal(new Point3D()));
	    Triangle tr3 = new Triangle(this.get_material(),this.getEmission(), ray.getPOO(), _p3, _p1);
	    Vector N3 = new Vector(tr3.getNormal(new Point3D()));

	    Vector v1 = new Vector(intersectionPoints.get(0));
	    Vector v2=new Vector(ray.getPOO());
	    Vector sign=new Vector(v1.subVectorV(v2));
	    if (((sign.dotProduct(N1) >= 0) && (sign.dotProduct(N2) >= 0) 
	        && (sign.dotProduct(N3) >= 0)) || ((sign.dotProduct(N1) < 0) && 
	            (sign.dotProduct(N2) < 0) && (sign.dotProduct(N3) < 0))) 
	    {
	      return intersectionPoints;
	    }

	    intersectionPoints.clear();
	    return intersectionPoints;  
	  }

	
}


	