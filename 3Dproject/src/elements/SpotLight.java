package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight{
	protected Vector direction;
	
	// ***************** Constructors ********************** // 
	/**
	 * constructor with parameters
	 * @param color
	 * @param position of light 
	 * @param kc attenuation factor
	 * @param kl attenuation factor
	 * @param kq attenuation factor
	 * @param direction of light
	 */
	public SpotLight(Color color, Point3D position, double kc, double kl, double kq, Vector direction) {
		super(color, position, kc, kl, kq);
		this.direction = new Vector(direction);
	}
	/**
	 * default constructor
	 */
	public SpotLight() {
		super();
		this.direction = new Vector();
	}
	/**
	 * copy constructor
	 * @param other object to copy 
	 */
	public SpotLight(SpotLight other) {
		super(other._color, other._position, other._kc, other._kl, other._kq);
		this.direction = new Vector(other.direction);
	}
	// ***************** Getters/Setters ********************** // 
	/**
	 * return value
	 * @return direction of light
	 */
	public Vector getDirection() {
		return new Vector(direction);
	}
	/**
	 * set value
	 * @param direction of light
	 */
	public void setDirection(Vector direction) {
		this.direction = new Vector (direction);
	}

	// ***************** Administration  ******************** // 
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
		SpotLight other = (SpotLight) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "SpotLight [direction=" + direction + "]";
	}
	
	// ***************** Operations ******************** //

		/**
		 * returns intensity
		 * IL=(I0(D*L))/(kc+kl*d+kq*d^2)
		 * @param point of light
		 * @return color amount of light
		 */
	
	@Override
public Color getIntensity(Point3D point)

{
	Vector L= new Vector(getPosition(),point);
	L.normalize();//L
	Vector D = new Vector(direction);
	D.normalize();
	double DL= D.dotProduct(L);
	double d = _position.distance(point);//d
	double mechane = _kc +(_kl*d)+(_kq*d*d);
	if(mechane<1)mechane=1;
	Color I0 = this._color;
	double ILred = Math.abs(I0.getRed()*DL/(mechane));
	if(ILred>255) ILred= 255;
	if(ILred<0) ILred = 0;
	double ILgreen = Math.abs(I0.getGreen()*DL/mechane);
	if(ILgreen>255) ILgreen= 255;
	if(ILgreen<0) ILgreen = 0;
	double ILblue = Math.abs(I0.getBlue()*DL/mechane);
	if(ILblue>255) ILblue= 255;
	if(ILblue<0) ILblue = 0;	
	Color IL = new Color((int)ILred, (int)ILgreen, (int)ILblue);
	return IL;
}

	
	/**
	 *  
	 * @param point 
	 * @return a vector from light point
	 */
	public Vector getL(Point3D point) 
	{		
		Vector vector= new Vector(getPosition(),point);
		vector.normalize();
		return vector;
	}
}
