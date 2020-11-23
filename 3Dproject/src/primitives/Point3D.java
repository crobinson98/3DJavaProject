package primitives;

public class Point3D extends Point2D{
	protected Coordinator _z;

// ***************** Constructors ********************** //
	
	/**
	 * constructor with coordinates
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(Coordinator x,Coordinator y,Coordinator z) 
	{
		super(x,y);
		this._z =  new Coordinator(z);
	}
	
	
	/**
	 * constructor with coordinates
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(double x,double y,double z) 
	{
		super(x,y);
		this._z = new Coordinator(z);
	}
	
	
	/**
	 *  copy constructor
	 * @param p object to copy
	 */
	public Point3D(Point3D p) 
	{
		super(p._x,p._y);
        this._z= new Coordinator(p._z);
	}

	
	/**
	 * default constructor
	 */
	public Point3D()
	{
		this._x=new Coordinator(0);
		this._y=new Coordinator(0);
		this._z=new Coordinator(0);

	}
	
	
	//***************** Getters/Setters ********************** //
	
	/**
	 * 
	 * @return coordinate z
	 */
	public Coordinator getZ() {
		return  new Coordinator(_z);
	}

	/**
	 * set value
	 * @param z
	 */
	public void setZ(Coordinator z) {
		this._z = new Coordinator(z);
	}  
	
	
	/**
	 * set val
	 * @param z
	 */
	public void setZ(double z) {
		this._z = new Coordinator(z);
	} 
	
	//***************** Administration  ******************** //
	
	/**
	 * built-in method which (converts)return itself a string
	 */
	@Override
	public String toString() 
	{
		return super.toString()+", z="+_z;
	}
	
	
	/**
	 * method compares the two given strings based on the content of the string
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (_z == null) {
			if (other._z != null)
				return false;
		} else if (!_z.equals(other._z))
			return false;
		return true;
	}

// ***************** Operations ******************** //

	/**
	 * 
	 * @param p
	 * @return  distance between two 3Dpoints
	 */
public double distance(Point3D p)   
{

    return Math.sqrt(Math.pow(p.getX().getCoordinate()-(this.getX().getCoordinate()),2)+
    		Math.pow(p.getY().getCoordinate()-(this.getY().getCoordinate()),2)+
    		Math.pow(p.getZ().getCoordinate()-(this.getZ().getCoordinate()),2));
}

/**
 * adds vector to point
 * @param vector
 */
public void add(Vector vector) 
{
	
	this._x.add(vector.getHead().getX());
	this._y.add(vector.getHead().getY());
	this._z.add(vector.getHead().getZ());

}

public Point3D add2(Vector vector) 
{
	return new Point3D(this.getX().add(vector.getHead().getX()),
	this.getY().add(vector.getHead().getY()),
	this.getZ().add(vector.getHead().getZ()));

}


/**
 * adds a 3Dpoint to another
 * @param p
 */
public void addp(Point3D p) 
{
	
	this._x.add(p.getX());
	this._y.add(p.getY());
	this._z.add(p.getZ());

}


/**
 * subtracts vector from point
 * @param v
 */
public void subtract(Vector v) 
{
	
	this._x.subtract(v.getHead().getX());
	this._y.subtract(v.getHead().getY());
	this._z.subtract(v.getHead().getZ());

}


/**
 * subtracts between two points
 * @param p
 */
public void subtract(Point3D p) 
{
	
	this._x.subtract(p.getX());
	this._y.subtract(p.getY());
	this._z.subtract(p.getZ());

}
}
