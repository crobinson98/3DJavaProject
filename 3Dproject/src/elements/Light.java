package elements;

import java.awt.Color;
//import java.util.Vector;

import primitives.*;

public abstract class Light {
	
	protected Color _color;
	
// ***************** Constructors ********************** // 

	/**
	 * Constructor with parameters
	 * @param color
	 */
	public Light(Color color)
	{
		super();
		if(color!=null)
			this._color = color;
		else
		this._color = new Color(255);
	}
/**
 * default Constructor
 */
	public Light() 
	{
		super();
		this._color = new Color(0);
	}
	
	/**
	 * copy Constructor
	 * @param l object to copy
	 */
	public Light(Light l)
	{
		super();
		this._color = new Color(l._color.getRGB());
	}
	
	
//***************** Getters/Setters ********************** //
	/**
	 * 
	 * @return color
	 */
	public Color getColor() {
		if(_color!=null)
		return new Color(_color.getRGB());
		else
	    	return _color=new Color(255, 255, 255);

	}

	/**
	 * set color
	 * @param color
	 */
	public void setColor(Color color) {
		if(color!=null)
		    this._color =  new Color(color.getRGB());
		else
    	   _color=new Color(255, 255, 255);

	}

	
	//***************** Administration  ******************** // 
	
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Light [color=" + _color + "]";
	}

	/**
	 * check if 2 variabels are equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Light other = (Light) obj;
		if (_color == null) {
			if (other._color != null)
				return false;
		} else if (!_color.equals(other._color))
			return false;
		return true;
	}
	
//***************** Operations ******************** //
	
	/**
	 * calculates the color of light
	 * @param p the point of the light
	 * @return intensity of light 
	 */
	abstract public  Color getIntensity(Point3D p);
	
	/**
	 * 
	 * @param point
	 * @return vector from light point
	 */
	abstract public Vector getL(Point3D point);
}
