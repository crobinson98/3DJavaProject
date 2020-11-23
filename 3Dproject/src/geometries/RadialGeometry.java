package geometries;

import java.awt.Color;
import java.util.ArrayList;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class RadialGeometry extends Geometry
{
	/**
	 * all shapes with a radius will inherit from this class
	 */
	
	protected double _radius;
	
// ***************** Constructors ********************** // 
	
	/**
	 * Constructor with parameters
	 * @param _radius
	 */
    public RadialGeometry(double _radius) 
    {
		this._radius = _radius;
	}
    
    /**
     * Constructor with parameters
     * @param m material
     * @param c color
     * @param _radius
     */
    public RadialGeometry(Material m, Color c,double _radius) 
    {
    	super(m,c);
		this._radius = _radius;
	}
    
    /**
     * Constructor with parameters
     * @param c color
     * @param _radius
     */
    public RadialGeometry( Color c,double _radius) 
    {
    	super(c);
		this._radius = _radius;
	}
    
    /**
     * default constructor
     */
    public RadialGeometry()  
    {
		this._radius = 0;
	}
    
    /**
     * copy constructor
     * @param r object to copy
     */
    public RadialGeometry(RadialGeometry r) 
    {
    	super(r._material,r.getEmission());
		this._radius = r._radius;
	}

// ***************** Getters/Setters ********************** //
	
    /**
     * 
     * @return radius
     */
	public double get_radius() {
		return _radius;
	}

	/**
	 * set value
	 * @param _radius
	 */
	public void set_radius(double _radius) {
		this._radius = _radius;
	}

 
	
// ***************** Administration  ******************** // 
	
	/**
	 * built-in method which (converts)return itself a string
	 */
	@Override
	public String toString() 
	{
		return "RadialGeometry [_radius=" + _radius + "]";
	}

	/**
	 * method compares the two given strings based on the content of the string
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RadialGeometry other = (RadialGeometry) obj;
		if (Double.doubleToLongBits(_radius) != Double.doubleToLongBits(other._radius))
			return false;
		return true;
	}


// ***************** Operations ******************** //
	
	@Override
	public ArrayList<Point3D> findInterSections(Ray r) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Vector getNormal(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	} 
}
