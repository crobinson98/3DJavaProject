package primitives;

public class Coordinator {
 protected  double _coordinate;


//***************** Constructors ********************** // 
 /**
  * default constructor
  */
public Coordinator()
{
	this._coordinate=0;
}

/**
 *  constructor with parameter
 * @param coordinate
 */
public Coordinator(double coordinate) 
{
	this.setCoordinate (coordinate);
}


/**
 * copy constructor
 * @param coordinate to copy
 */
public Coordinator(Coordinator coordinate) 
{
	this._coordinate = coordinate.getCoordinate();
}

//***************** Getters/Setters ********************** // 

/**
 * 
 * @return  coordinate
 */
public double getCoordinate() 
{
	return this._coordinate;
}


/**
 * set val
 * @param coordinate
 */
public void setCoordinate(double coordinate) 
{
	this._coordinate = coordinate;
}  

//***************** Administration  ******************** // 

/**
 * //built-in method which (converts)return itself a string
 */
@Override 
public String toString() 
{
	return  " "+_coordinate;
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
	Coordinator other = (Coordinator) obj;
	if (Double.doubleToLongBits(_coordinate) != Double.doubleToLongBits(other._coordinate))
		return false;
	return true;
}

//***************** Operations ******************** //

/**
 * adds  given coordinates
 * @param p
 * @return
 */
public double add(Coordinator p) 
{
	this._coordinate+=p.getCoordinate();
	return this._coordinate;
}


/**
 * adds  given coordinates
 * @param p
 * @return
 */
public double add(double p) 
{
	this._coordinate+=p;
	return this._coordinate;
} 


/**
 * subtracts  2 given coordinates
 * @param p
 * @return
 */
public double subtract(Coordinator p)  
{
	this._coordinate-=p.getCoordinate();
	return this._coordinate;
}


/**
 * subtracts  2 given coordinates
 * @param p
 * @return
 */
public double subtract(double p) 
{
	this._coordinate-=p;
	return this._coordinate;
}


/**
 * multiplies the coordinate
 * @param p
 * @return
 */
public double scale(double p) 
{
	this._coordinate*=p;
	return this._coordinate;
}


/**
 * // multiplies the coordinate
 * @param p
 * @return
 */
public double scale(Coordinator p) 
{
	this._coordinate*=p.getCoordinate();
	return this._coordinate;
}
}

