package elements;
import java.awt.Color;

import primitives.Point3D;

//import primitives.Point3D;

public class AmbientLight 
{
	
  protected Color _color;
  protected double _Ka; //Restriction factor
  
//***************** Constructors ********************** //
  
/**
 * default constructor 
 */
public AmbientLight()  
{
	this._color= new Color(255,255,255);
	_Ka = 0.1;
}

/**
 * constructor with color parameter
 * @param color 
 * @param ka attenuation factor
 */
public AmbientLight(Color color, double ka) 
{
	this._color = new Color(color.getRGB());
	if(ka<0) _Ka= 0;
	else if(ka>1) _Ka =1;
	     else _Ka = ka;
}

/**
 * constructor with parameters
 * @param c1 color red
 * @param c2 color green
 * @param c3 color blue
 */
public AmbientLight(int c1,int c2,int c3) 
{
	if(c1>255)c1 = 255;
	if(c2>255) c2 = 255;
	if(c3 >255) c3 = 255;
	this._color = new Color(c1, c2, c3); 
	_Ka = 0.1;
}

/**
 * copy constructor
 * @param al the object we are copying
 */
public AmbientLight(AmbientLight al) 
{
	this._color = new Color(al._color.getRGB());
	_Ka = al.getKa();
}


//***************** Getters/Setters ********************** //

/**
 * 
 * @return color
 */
public Color get_color() {
	return new Color(_color.getRGB());
}

/**
 * set color
 * @param color
 */
public void set_color(Color color) {
	this._color= new Color(color.getRGB());
}

/**
 * 
 * @return attenuation factor
 */
public double getKa() {
	return _Ka;
}

/**
 * set attenuation factor
 * @param ka
 */
public void setKa(double ka) {
	_Ka = ka;
}

//***************** Administration  ******************** // 

/**
 * check if 2 variables are equals
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AmbientLight other = (AmbientLight) obj;
	if (Double.doubleToLongBits(_Ka) != Double.doubleToLongBits(other._Ka))
		return false;
	if (_color == null) {
		if (other._color != null)
			return false;
	} else if (!_color.equals(other._color))
		return false;
	return true;
}
  
/**
 * print string with name and value
 */
@Override
public String toString() {
	return "AmbientLight [_color=" + _color + ", Ka=" + _Ka + "]";
}
  
//***************** Operations ******************** //

/**
 * returns color multiplied by the Restriction factor
 * @param point not used
 * @return
 */
public Color getIntensityP(Point3D point)
{
	double red=_color.getRed()*_Ka;
	double green=_color.getGreen()*_Ka;
	double blue=_color.getBlue()*_Ka;
	if(red>255) red=255;
	if(green>255) green=255;
	if(blue>255) blue=255;
	return new Color((int)red,(int)green,(int)blue);
}
/**
 * returns color multiplied by the Restriction factor
 * @param point not used
 * @return 
 */
public Color  getIntensity(Color point)
{
	if(_Ka>1) _Ka=1;
    double red= _color.getRed()*_Ka;
    double blue= _color.getBlue()*_Ka;
    double green= _color.getGreen()*_Ka;
	return new Color((int)red,(int)green,(int)blue);

}


}
