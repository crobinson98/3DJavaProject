package elements;
import java.util.ArrayList;


import primitives.*;

public class Camera {
	/**
	 * middle point of the camera
	 */
	private Point3D _pO; 
	/**
	 * 3 vectors of the camera
	 */
	private Vector _vUp, _vR,_vTo; 
	
	// ***************** Constructors ********************** // 
	/**
	 * default constructor
	 */
	public Camera() 
	{
        this._pO=new Point3D(0,0,0);
		this._vUp = new Vector(0,1,0);
		this._vTo = new Vector(0,0,-1);
		this._vR =  new Vector(_vUp.crossProduct(_vTo));
	}
	
	/**
	 * constructor with parameters 1
	 * @param pO point of origin
	 * @param vUp vector facing upwards
	 * @param vR vector pointing right
	 * @param vTo vector pointing forwards
	 */
	
	public Camera(Point3D pO, Vector vUp, Vector vR, Vector vTo) 
	{
		this._pO = new Point3D(pO);
		this._vUp =new Vector( vUp);
		this._vTo = new Vector(vTo);
		this._vR = new Vector(_vUp.crossProduct(_vTo));
		
	}
	
	/**
	 * copy constructor
	 * @param c - object we are copying
	 */
	public Camera(Camera c) 
	{
		this._pO = new Point3D(c.getpO());
		this._vUp = new Vector(c.getvUp());
		this._vR = new Vector(c.getvR());
		this._vTo =new Vector( c.getvTo());
	}
	
	/**
	 * constructor with parameters 2
	 * @param p point of origin
	 * @param vTo vector pointing forwards
	 * @param vUp vector facing upwards
	 */
	public Camera(Point3D p,Vector vTo, Vector vUp)
	{
		this._pO =new Point3D(p);
		this._vUp = new Vector(vUp);
		this._vR = new Vector(vUp.crossProduct(vTo));
		this._vTo = new Vector(vTo);
	}

	// ***************** Administration  ******************** // 
	
	@Override
	
	/**
	 * method compares the two given strings based on the content of the string
	 */
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (_pO == null) {
			if (other._pO != null)
				return false;
		} else if (!_pO.equals(other._pO))
			return false;
		if (_vR == null) {
			if (other._vR != null)
				return false;
		} else if (!_vR.equals(other._vR))
			return false;
		if (_vTo == null) {
			if (other._vTo != null)
				return false;
		} else if (!_vTo.equals(other._vTo))
			return false;
		if (_vUp == null) {
			if (other._vUp != null)
				return false;
		} else if (!_vUp.equals(other._vUp))
			return false;
		return true;
	}
	
	@Override
	
	/**
	 * built-in method which (converts)return itself a string
	 */
	public String toString()// built-in method which (converts)return itself a string
	{
		return "Camera [pO=" + _pO + ", vUp=" + _vUp + ", vR=" + _vR + ", vTo=" + _vTo + "]";
	}
	
// ***************** Getters/Setters ********************** // 
	
	/**
	 * 
	 * @return point of origin
	 */
	public Point3D getpO() {
		return new Point3D(_pO);
	}
	
	/**
	 * set point of origin
	 * @param pO
	 */
	public void setpO(Point3D pO) {
		this._pO = new Point3D(pO);
	}
	
	/**
	 * 
	 * @return vector facing up
	 */
	public Vector getvUp() {
		return new Vector(_vUp);
	}
	
	/**
	 * set vector pointing upwards
	 * @param vUp
	 */
	public void setvUp(Vector vUp) {
		this._vUp = new Vector(vUp);
	}
	
	/**
	 * 
	 * @return vector pointing right
	 */
	public Vector getvR() {
		return new Vector(_vR);
	}
	
	/**
	 * set vec pointing right
	 * @param vR
	 */
	public void setvR(Vector vR) {
		this._vR = new Vector(vR);
	}
	
	/**
	 * 
	 * @return vector pointing forwards
	 */
	public Vector getvTo() {
		return new Vector(_vTo);
	}
	
	/**
	 * set vector pointing forwards
	 * @param vTo
	 */
	public void setvTo(Vector vTo) {
		this._vTo = new Vector(vTo);
	}

// ***************** Operations ******************** //
	
/**
 * p=pc+[((x-#pixelsx/2)+rx/2)vr - ((y-#pixelsy/2)+ry/2)vUp]	
 * @param Nx number of pixels of the width
 * @param Ny number of pixels of the hight
 * @param x the column of the pixel we're sending the ray
 * @param y the row of the pixel we're sending the ray
 * @param screenDist
 * @param screenWidth
 * @param screenHeight
 * @return ray that starts at the center of camera and goes through the given pixel
 */
	
	public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y,
            double screenDist, double screenWidth,double screenHeight)
	{
		 Vector vRtemp = new Vector(_vR); 
		 vRtemp.normalize();
	     Vector vTo = new Vector(this._vTo);
	     vTo.normalize();
	     Vector vUp = new Vector(this._vUp);
	     vUp.normalize();
	     Point3D P0= new Point3D(this._pO);
	     vTo.scale(screenDist);
	     P0.add(vTo);
	     Vector pc= new Vector(P0); //pc
	     double Rx = screenWidth/Nx; //rx
	     double Ry = screenHeight/Ny; //ry
	     double tempX= -((x- (Nx/2.0))*Rx+(Rx/2.0)); //(x-#pixelsx/2)+rx/2)
	     double tempy= -((y- (Ny/2.0))*Ry+(Ry/2.0)); //(y-#pixelsy/2)+ry/2)
	     vRtemp.scale(tempX);  //((x-#pixelsx/2)+rx/2)vr
	     vUp.scale(tempy);   //(y-#pixelsy/2)+ry/2)vUp
	     vRtemp.addVector(vUp); //((x-#pixelsx/2)+rx/2)vr - ((y-#pixelsy/2)+ry/2)vUp
	     pc.addVector(vRtemp);    //p=pc+[((x-#pixelsx/2)+rx/2)vr - ((y-#pixelsy/2)+ry/2)vUp]
	     Point3D tempPoint = new Point3D(_pO);
	     pc.normalize();
	     return new Ray(new Point3D(tempPoint), pc);       
	}
	
	  /**
	   * Construct  rays through a pixel, 4 rays for superSumpling
	   * @param d-double
	   * @param e-double
	   * @param x-double
	   * @param y-double
	   * @param screenDist-double
	   * @param screenWidth-double
	   * @param screenHeight-double
	   * @return ArrayList<Ray>
	   */
	  public ArrayList<Ray> constructRayThroughPixelSuper(double d, double e, double x, double y, double screenDist, double screenWidth,double screenHeight)
	  {
		  ArrayList<Ray> rays=new ArrayList<Ray>();
		  double rx=screenWidth/d;
	      double ry=screenHeight/e;
	      double tempX=(x-(d/2.0))*rx;
	      double tempY=(y-(e/2.0))*ry;
	      
		  //point up  right
	      double urX=tempX+rx;
	      double urY=tempY;
	      Vector vec1 = new Vector(_pO.add2(_vTo.scale1(screenDist)).add2(_vR.scale1(urX).subVectorV(_vUp.scale1(urY))));
	      Point3D tempPoint1 = new Point3D(vec1.getHead());
	      Ray rayUR = new Ray(tempPoint1, vec1);
	      rays.add(rayUR);
	      
	    //point down left
	     double dlX=tempX;
	     double dlY=tempY+ry;
	     Vector vec2 = new Vector(_pO.add2(_vTo.scale1(screenDist)).add2(_vR.scale1(dlX).subVectorV(_vUp.scale1(dlY))));
	     Point3D tempPoint2= new Point3D(vec2.getHead());
	     Ray rayDL = new Ray(tempPoint2, vec2);
	     rays.add(rayDL);
	     
	     //point up left
	     double ulX=tempX;
	     double ulY=tempY;
	     Vector vec3 = new Vector(_pO.add2(_vTo.scale1(screenDist)).add2(_vR.scale1(ulX).subVectorV(_vUp.scale1(ulY))));
	     Point3D tempPoint3= new Point3D(vec3.getHead());
	     Ray rayUL = new Ray(tempPoint3, vec3);
	     rays.add(rayUL);
	     
	     //point down right
	     double drX=tempX;
	     double drY=tempY;
	     Vector vec4 = new Vector(_pO.add2(_vTo.scale1(screenDist)).add2(_vR.scale1(drX).subVectorV(_vUp.scale1(drY))));
	     Point3D tempPoint4= new Point3D(vec4.getHead());
	     Ray rayDR = new Ray(tempPoint4, vec4);
	     rays.add(rayDR);
	      
	     return rays;
		  
	  }
	
}
