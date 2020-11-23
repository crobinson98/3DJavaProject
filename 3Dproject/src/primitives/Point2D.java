package primitives;

public class Point2D{
	
	protected Coordinator _x;
	protected Coordinator _y;
	
	
	// ***************** Constructors ********************** //
	
	/**
	 * constructor with parameters
	 * @param x
	 * @param y
	 */
	public Point2D(Coordinator x, Coordinator y) 
	{
	    this._x = new Coordinator(x);
	    this._y = new Coordinator(y);
	}
	
	
	/**
	 * constructor with parameters
	 * @param x
	 * @param y
	 */
	public Point2D(double x, double y) 
	{
	    this.setX(x);
	    this.setY(y);
	}
	
	
	/**
	 * copy constructor
	 * @param p
	 */
	public Point2D(Point2D p)  
	{	
		 this._x = new Coordinator(p.getX());
		 this._y = new Coordinator(p.getY());
	}
	
	
	/**
	 * default constructor
	 */
	public Point2D() 
	{
		this._x = new Coordinator();
		this._y = new Coordinator();
	}
	
	//***************** Getters/Setters ********************** //
	
	
	/**
	 * 
	 * @return x
	 */
	public Coordinator getX() {
		return new Coordinator(_x);
	}
	
	
	/**
	 * set x
	 * @param x
	 */
	public void setX(Coordinator x) {
		this._x =  new Coordinator(x);
	}
	
	
	/**
	 * 
	 * @return y
	 */
	public Coordinator getY() {
		return  new Coordinator(_y);
	
	}
	
	
	/**
	 * set val
	 * @param y
	 */
	public void setY(Coordinator y) {
		this._y =  new Coordinator(y);
	}
	
	
	/**
	 * set y
	 * @param y
	 */
	public void setY(double y) {
		this._y = new Coordinator(y);
	}
	
	
	/**
	 * set x
	 * @param x
	 */
	public void setX(double x) {
		this._x = new Coordinator(x);	
	}
	
	
	//***************** Administration  ******************** //
	
	
	/**
	 * //built-in method which (converts)return itself a string
	 */
	@Override
	public String toString() 
	{
		return "x=" + _x + ", "
				+ "y=" + _y;
	}


	/**
	 * //method compares the two given strings based on the content of the string
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
		Point2D other = (Point2D) obj;
		if (_x == null) {
			if (other._x != null)
				return false;
		} else if (!_x.equals(other._x))
			return false;
		if (_y == null) {
			if (other._y != null)
				return false;
		} else if (!_y.equals(other._y))
			return false;
		return true;
	}

}
