package elements;

import java.awt.Color;
//import java.util.Vector;

import primitives.*;
import primitives.Vector;

public class PointLight extends Light{
   

	protected Point3D _position;
	
	/**
	 * attenuation factors
	 */
	protected double _kc;
	protected double _kl;
	protected double _kq;
	
// ***************** Constructors ********************** // 
	/**
	 * default constructor
	 */
	public PointLight() 
	{
		super();
		this._position = new Point3D();
		this._kc = 0.1;
		this._kl = 0.1;
		this._kq = 0.1;
	}
	
	/**
	 * constructor with parameters
	 * @param color
	 * @param position of the light
	 * @param kc attenuation factor
	 * @param kl attenuation factor
	 * @param kq attenuation factor
	 */
	public PointLight(Color color, Point3D position, double kc, double kl, double kq)
	{
		super(color);
		this._position = position;
		if(kc<0)_kc=0;
		if(kc>1) _kc=1;
		else _kc=kc;
		
		 if(kl<0) _kl=0;
		 if(kl>1) _kl=1;
		 else _kl=kl;
		 
		 if(kq<0) _kq=0;
		 if(kq>1)_kq=1;
		 else _kq=kq;
	}
	
	/**
	 * copy constructor
	 * @param l object to copy
	 */
	public PointLight(PointLight l) 
	{
		super(l.getColor());
		this._position = l.getPosition();
		this._kc = l.getKc();
		this._kl = l.getKl();
		this._kq = l.getKq();
	}

	
	//***************** Getters/Setters ********************** //	
	
	/**
	 * 
	 * @return position of light
	 */
	public Point3D getPosition() {
		return new Point3D (this._position);
	}

	/**
	 * set position
	 * @param position
	 */
	public void setPosition(Point3D position) {
		this._position = new Point3D(position);
	}

	/**
	 * 
	 * @return attenuation factor
	 */
	public double getKc() {
		return _kc;
	}

	/**
	 * 
	 * @param kc attenuation factor
	 */
	public void setKc(double kc) {
		this._kc = kc;
	}

	/**
	 * 
	 * @return attenuation factor
	 */
	public double getKl() {
		return _kl;
	}

	/**
	 * 
	 * @param kl attenuation factor
	 */
	public void setKl(double kl) {
		this._kl = kl;
	}

	/**
	 * 
	 * @return attenuation factor
	 */
	public double getKq() {
		return _kq;
	}

	/**
	 * 
	 * @param kq attenuation factor
	 */
	public void setKq(double kq) {
		this._kq = kq;
	}

	//***************** Administration  ******************** // 
	
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
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(_kc) != Double.doubleToLongBits(other._kc))
			return false;
		if (Double.doubleToLongBits(_kl) != Double.doubleToLongBits(other._kl))
			return false;
		if (Double.doubleToLongBits(_kq) != Double.doubleToLongBits(other._kq))
			return false;
		if (_position == null) {
			if (other._position != null)
				return false;
		} else if (!_position.equals(other._position))
			return false;
		return true;
	}

	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "PointLight [_position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq + "]";
	}

//***************** Operations ******************** //
	/**
	 * returns intensity of point light: Il=IO/(Kc+ Kl*d +kw*d^2)
	 */
	public Color getIntensity(Point3D point)
	{
		double d = _position.distance(point);
		Color I0 = this._color;
		double mechane = _kc +(_kl*d)+(_kq*d*d);
		if(mechane<1)mechane=1;
		double ILred = I0.getRed()/(mechane);
		if(ILred>255) ILred= 255;
		if(ILred<0) ILred = 0;
		double ILgreen = I0.getGreen()/mechane;
		if(ILgreen>255) ILgreen= 255;
		if(ILgreen<0) ILgreen = 0;
		double ILblue = I0.getBlue()/mechane;
		if(ILblue>255) ILblue= 255;
		if(ILblue<0) ILblue = 0;
		Color IL = new Color((int)ILred, (int)ILgreen, (int)ILblue);
		return IL;
	}
	
	/**
	 * returns direction of the light
	 */
	
	@Override
	public Vector getL(Point3D p) {
		Vector v= new Vector(this.getPosition(),p);
		v.normalize();
		return v;

	}
	


}


