package geometries;
//import java.awt.List;
//import java.util.ArrayList;

import java.util.ArrayList;

import primitives.*;

 public class Cylinder  extends RadialGeometry 
 {
	
	protected Point3D _axisPoint;
	protected Vector _axisDirection;
	
// ***************** Constructors ********************** // 
	/**
	 * default constructor
	 */
	public Cylinder()
	{
		super(0);
		_axisPoint=new Point3D(0,0,0);
		_axisDirection=new Vector();
	}
	
	/**
	 * constructor with parameters
	 * @param _axisPoint
	 * @param _axisDirection
	 */
	public Cylinder(Point3D _axisPoint, Vector _axisDirection) //constructor with parameters
	{
	
		super(0);
		this._axisPoint = new Point3D(_axisPoint);
		this._axisDirection = new Vector(_axisDirection);
		
	}
	
// ***************** Administration  ******************** //
	
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() //built-in method which (converts)return itself a string
	{
		return "Cylinder :"+ "axisPoint ="+_axisPoint+"axisDirection = "+_axisDirection;

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
		Cylinder other = (Cylinder) obj;
		if (_axisDirection == null) {
			if (other._axisDirection != null)
				return false;
		} else if (!_axisDirection.equals(other._axisDirection))
			return false;
		if (_axisPoint == null) {
			if (other._axisPoint != null)
				return false;
		} else if (!_axisPoint.equals(other._axisPoint))
			return false;
		return true;
	}
	
// ***************** Getters/Setters ********************** // 
	
	/**
	 * 
	 * @return axis point
	 */
	public Point3D get_axisPoint() {
		return new Point3D(_axisPoint);
	}
	
	/**
	 * set val
	 * @param _axisPoint
	 */
	public void set_axisPoint(Point3D _axisPoint) {
		this._axisPoint = new Point3D(_axisPoint);
	}
	
	/**
	 * 
	 * @return axis direction
	 */
	public Vector get_axisDirection() {
		return new Vector(_axisDirection);
	}
	
	/**
	 * set val 
	 * @param _axisDirection
	 */
	public void set_axisDirection(Vector _axisDirection) {
		this._axisDirection =new Vector( _axisDirection);
	}
	
	
	// ***************** Operations ******************** //
	
	/*/**
	 * returns normal
	 */
	/*public Vector getNormal(Point3D p)
	{
		return new Vector();
	}*/
	
	@Override
	public ArrayList<Point3D> findInterSections(Ray ray) {
		
		return null;
	}
	public Vector getNormal(Point3D point){
		
		return null;
	}
} 
