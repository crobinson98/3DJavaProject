package primitives;

public class Ray {
	
	protected Point3D _POO; //point
	protected Vector _direction; //direction
	

	// ***************** Constructors ********************** //
	
	/**
	 * default constructor
	 */
	public Ray() 
	{
        this._direction=new Vector();
        this._POO=new Point3D(0,0,0);
	}
	
	
	/**
	 *  constructor with a parameter
	 * @param r obj to copy
	 */
	public Ray(Ray r)
	{
		super();
		  this._POO = new Point3D(r.getPOO());
		  this._direction = new Vector(r.getDirection());
		  this._direction.normalize();
	}
	
	
	/**
	 *  constructor with  parameters
	 * @param poo
	 * @param v
	 */
	public Ray(Point3D poo, Vector v) 
	{
		  this._POO = new Point3D(poo);
		  this._direction = new Vector(v);
		  this._direction.normalize();
	}
	
	//***************** Getters/Setters ********************** //
	
	/**
	 * 
	 * @return point of ray
	 */
	public Point3D getPOO() {
		return new Point3D(_POO);
	}
	
	/**
	 * set value
	 * @param POO
	 */
	public void setPOO(Point3D POO) {
		this._POO = new Point3D(POO);
	}
	
	/**
	 * 
	 * @return direction
	 */
	public Vector getDirection() {
		return new Vector(_direction);
	}
	
	/**
	 * set value
	 * @param direction
	 */
	public void setDirection(Vector direction) {
		this._direction = new Vector(direction);
		this._direction.normalize();
	}

	//***************** Administration  ******************** //
	
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
		Ray other = (Ray) obj;
		if (_POO == null) {
			if (other._POO != null)
				return false;
		} else if (!_POO.equals(other._POO))
			return false;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}
	
	
	/**
	 * built-in method which (converts)return itself a string
	 */
	@Override
	public String toString() 
	{
		return "Ray POO=" + _POO + ", _direction=" + _direction + ", getPOO()=" + getPOO() + ", getDirection()="
				+ getDirection();
	}
	
	

// ***************** Operations ******************** //
	/**
	 * 
	 * @param n
	 * @param p
	 * @param ray
	 * @return
	 */
	public Ray constructRefractedRay(Vector n, Point3D p, Ray ray)
	{
		n.normalize();
		return new Ray(p,n);
	}

}
