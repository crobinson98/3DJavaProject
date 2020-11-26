package geometries;
import primitives.*;

import java.awt.Color;


import java.util.ArrayList;
//import java.util.List;

public abstract class Geometry //abstract class
{
	protected Color _emission;
	protected Material _material;
    
	
    
// ***************** Constructors ********************** //
	/**
	 * constructor with parameters
	 * @param m material
	 * @param _color
	 */
	public Geometry(Material m, Color _color) 
	{
		this._emission = new Color(_color.getRGB());
		this._material=new Material(m);
	}
	
	/**
	 * constructor with parameters
	 * @param _color
	 */
	public Geometry( Color _color) 
	{
		this._emission = new Color(_color.getRGB());
	}
	
	/**
	 * default constructor
	 */
	public Geometry()
	{
		this._emission= new Color(255);
		this._material=new Material();
	}
	
	/**
	 * constructor with parameters
	 * @param m material
	 * @param c color
	 */
	public Geometry(Material m, int c) 
	{
		this._emission = new Color(c);
		this._material=new Material(m);
	}
	
	/**
	 * copy constructor
	 * @param other object to copy
	 */
	public Geometry(Geometry other) 
	{
		this._emission = new Color(other._emission.getRed(),other._emission.getGreen(),other._emission.getBlue());
		this._material=new Material(other._material.get_kd(),other._material.get_ks(),other._material.get_nShininess(),other._material.get_kr(),other._material.get_kt());
	}

	
// ***************** Getters/Setters ********************** // 
	
	/**
	 * 
	 * @return color
	 */
	public Color getEmission() {
		if (_emission!= null) return new Color(_emission.getRGB());
		else return new Color(255,255,255);
	}
	
	/**
	 * set color
	 * @param _color
	 */
	public void setEmissoion(Color _color) {
		this._emission = new Color(_color.getRGB());
	}

	/**
	 * 
	 * @return material
	 */
	public Material get_material() {
		return new Material(_material);
	}

	/**
	 * set val
	 * @param _material
	 */
	public void set_material(Material _material) {
		this._material = new Material(_material);
	}
	
	
// ***************** Administration  ******************** // 
	
	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Geometry [material = " +_material+" color = " + _emission + "]";
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
		Geometry other = (Geometry) obj;
		if (_emission == null ||_material==null) {
			if (other._emission != null || other._material!=null)
				return false;
		} else if (!_emission.equals(other._emission)||!_material.equals(other._material))
			return false;
		return true;
	}
	
// ***************** Operations ***************************** //
	
	/**
	 * abstract function
	 * @param p
	 * @return normal
	 */
	public abstract Vector getNormal(Point3D p);
	
	/**
	 * abstract function
	 * @param r ray
	 * @return list of intersections
	 */
    public abstract ArrayList<Point3D> findInterSections(Ray r) ; 
    
}
