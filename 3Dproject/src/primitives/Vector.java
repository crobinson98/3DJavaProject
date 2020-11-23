package primitives;

public class Vector{
	
  protected Point3D _head;

//***************** Constructors ********************** //
  
  /**
   * default constructor
   */
  public Vector()
  {
	_head=new Point3D(0,0,1);
  }

  /**
   * constructor with head parameter
   * @param p1
   */
public Vector(Point3D p1) 
{
	Coordinator x= new Coordinator(p1.getX().getCoordinate());
	Coordinator y = new Coordinator(p1.getY().getCoordinate());
	Coordinator z = new Coordinator(p1.getZ().getCoordinate() );
	_head = new Point3D(x, y, z);
//	normalize();

}

/**
 * constructor witch creates  a vector between two points 
 * @param p1
 * @param p2
 */
public Vector(Point3D p1, Point3D p2)
{
	  Coordinator x=new Coordinator(p2.getX().getCoordinate()-p1.getX().getCoordinate());
	  Coordinator y=new Coordinator(p2.getY().getCoordinate()-p1.getY().getCoordinate());
	  Coordinator z=new Coordinator(p2.getZ().getCoordinate()-p1.getZ().getCoordinate());
	    this._head = new Point3D(x,y,z);
}

/**
 * constructor with parameters
 * @param x
 * @param y
 * @param z
 */
public Vector(double x,double y, double z) 
{
	this._head=new Point3D(x,y,z);
}


/**
 * copy constructor
 * @param v
 */
public Vector(Vector v) 
{
	this._head=new Point3D(v.getHead());
}

//***************** Getters/Setters ********************** //

/**
 * 
 * @return point of vector
 */
public Point3D getHead() {
	return new Point3D( _head);
}


/**
 * set value
 * @param head
 */
public void setHead(Point3D head) {
	this._head = new Point3D(head);
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
	Vector other = (Vector) obj;
	if (_head == null) {
		if (other._head != null)
			return false;
	} else if (!_head.equals(other._head))
		return false;
	return true;
}

/**
 * built-in method which (converts)return itself a string
 */
@Override
public String toString() 
{
	return "Vector:" + _head;
			
}


//***************** Operations ******************** //

/**
 * adds between two vectors 
 * @param v
 */
public void addVector(Vector v)  
{
	this._head.add(v);
}


/**
 * adds between two vectors 
 * @param v
 */
public Vector addV(Vector v)  
{
	return new Vector(this.getHead().add2(v));
}


/**
 * subtracts between two vectors 
 * @param v
 */
public void subVector(Vector v)  
{
	this._head.subtract(v);
}

/**
 * subtracts between two vectors 
 * @param v
 * @return
 */
public Vector subVectorV(Vector v)  
{
	Point3D head= new Point3D(this.getHead());
	head.subtract(v);
	return new Vector(head);
}


/**
 *  Multiplies the vector by a given number
 * @param sf
 */
public void scale(double sf) 
{
	this._head._x.scale(sf);
	this._head._y.scale(sf);
	this._head._z.scale(sf);
}

/**
 * returns the Multiplied  vector 
 * @param sf
 * @return
 */
public Vector scale1(double sf) 
{
	Vector v=new Vector();
	v.scale(sf);
	return v;
}

/**
 * cross product of 2 vectores
 * @param vector
 * @return
 */
public Vector crossProduct(Vector vector) 
{
	double x1,y1,z1,x2,y2,z2,x3,y3,z3;
	
	x1=this.getHead().getX().getCoordinate();
	y1=this.getHead().getY().getCoordinate();
	z1=this.getHead().getZ().getCoordinate();
	x2=vector.getHead().getX().getCoordinate();
	y2=vector.getHead().getY().getCoordinate();
	z2=vector.getHead().getZ().getCoordinate();
	// Determinants 2 vectors 
	x3=(y1*z2-z1*y2);//i
	y3=-(x1*z2-z1*x2);//j
	z3=(x1*y2-x2*y1);//k
	if(x3==-0)x3=0;
	if(y3==-0)y3=0;
	if(z3==-0)z3=0;
	Vector temp=new Vector(x3,y3,z3);
	return temp;
}

/**
 * returns the length of the vector
 * @return
 */
public double length() 
{
	double x,y,z;
	x=this.getHead().getX().getCoordinate();
	y=this.getHead().getY().getCoordinate();
	z=this.getHead().getZ().getCoordinate();
	return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
	
}


/**
 *  normalizes the vector
 */
public void normalize()
{
	double length=this.length();
	if(length!=0)
	{
	this._head._x._coordinate/=length;
	this._head._y._coordinate/=length;
	this._head._z._coordinate/=length;
	}
}


/**
 * dot product- multiplies vector with vector
 * @param vector
 * @return
 */
public double dotProduct(Vector vector) 
{
	double x1,y1,z1,x2,y2,z2;

	x1=this.getHead().getX().getCoordinate();
	y1=this.getHead().getY().getCoordinate();
	z1=this.getHead().getZ().getCoordinate();
	x2=vector.getHead().getX().getCoordinate();
	y2=vector.getHead().getY().getCoordinate();
	z2=vector.getHead().getZ().getCoordinate();
	return (x1*x2+y1*y2+z1*z2);
}


}
