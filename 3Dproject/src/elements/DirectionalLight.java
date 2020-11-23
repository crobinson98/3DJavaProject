package elements;

import java.awt.Color;
//import java.util.Vector;

import primitives.*;

public class DirectionalLight extends Light{
    
	protected Vector _direction;
	
// ***************** Constructors ********************** // 

	/**
	 * Constructor with parameters
	 * @param color
	 * @param direction of light
	 */
	public DirectionalLight(Color color, Vector direction) 
	{
		super(color);
		this._direction = new Vector (direction);
	}

	/**
	 * default Constructor
	 */
	public DirectionalLight()//empty Constructor
	{
		super();
		this._direction = new Vector();
	}
	
	/**
	 * copy Constructor
	 * @param d object to copy
	 */
	public DirectionalLight(DirectionalLight d) 
	{
		super(d.getColor());
		this._direction = new Vector(d.get_direction());
	}
	

	//***************** Getters/Setters ********************** //
	
	/**
	 * 
	 * @return direction of light
	 */
	public Vector get_direction() {
		return new Vector(_direction);
	}

	/**
	 * set direction of light
	 * @param direction
	 */
	public void set_direction(Vector direction) {
		this._direction = new Vector(direction);
	}
	
	//***************** Administration  ******************** // 
	
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "DirectionalLight [_direction=" + _direction + "]";
	}

	/**
	 * check if 2 variabels are equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectionalLight other = (DirectionalLight) obj;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}

//***************** Operations ******************** //
	
	/**
	 * returns intensity
	 * @param point p not used
	 * @return color the color of body
	 */
	@Override
	public Color getIntensity(Point3D p) 
	{
		return new Color(_color.getRed(),_color.getGreen(),_color.getBlue());
	}

	/**
	 * returns a vector from light to point
	 * @param point not used
	 * @return normalized direction
	 */
	@Override
	public Vector getL(Point3D point) 
	{
		//Vector vec = new Vector(point);
		//vec.subVector(new Vector(_direction));
	    //return vec;
		return new Vector(_direction);
	}

}
