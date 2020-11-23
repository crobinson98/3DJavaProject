package scene;
import elements.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import geometries.*;

public class Scene {
	protected String _sceneName;
	protected Color _backgraound;
	protected AmbientLight _ambientLight;
	protected Camera _camera;
	protected double _screenDistance;
	protected ArrayList<Geometry> _geometries;
	protected ArrayList<Light> _lights;
	
	// ***************** Constructors ********************** //
	
	/**
	 * default constructor
	 */
	public Scene() {
	
		this._sceneName = new String();
		this._backgraound = Color.black;
		this._ambientLight = new AmbientLight();
		this._camera = new Camera();
		this._screenDistance = 150;
		this._geometries = new  ArrayList<Geometry>();
		this._lights=new ArrayList<Light>(); 
	}
	
	/**
	 * constructor with parameters
	 * @param sceneName
	 * @param backgraound
	 * @param ambientLight
	 * @param camera
	 * @param screenDistance
	 * @param geometries
	 * @param l
	 */
	public Scene(String sceneName, Color backgraound, AmbientLight ambientLight, Camera camera,
			double screenDistance, ArrayList<Geometry> geometries,ArrayList<Light> l) {
	
		this._sceneName = new String(sceneName);
		this._backgraound = backgraound;
		this._ambientLight = new AmbientLight(ambientLight);
		this._camera = new Camera(camera);
		this._screenDistance = screenDistance;
		this._geometries = new ArrayList<Geometry>(geometries);
		this._lights=new ArrayList<Light>(l); 
	}
	
	/**
	 * copy constructor
	 * @param s obj to copy
	 */
	public Scene(Scene s) {
	
		this._sceneName = new String(s._sceneName);
		this._backgraound = s._backgraound;
		this._ambientLight = new AmbientLight(s._ambientLight);
		this._camera = new Camera(s._camera);
		this._screenDistance = s._screenDistance;
		this._geometries = new ArrayList<Geometry>(s._geometries);
		this._lights=new ArrayList<Light>(s._lights); 
	}
	
	
	
	//***************** Getters/Setters ********************** //
	
	/**
	 * return value
	 * @return name of the scene
	 */
	public String getSceneName() {
		return new String(_sceneName);
	}

	/**
	 * set name of the scene
	 * @param sceneName
	 */
	public void setSceneName(String sceneName) {
		 if (sceneName == null) 
	            _sceneName = new String();
		 else
	           this._sceneName = new String(sceneName);
	}

	/**
	 * 
	 * @return background  color
	 */
	public Color getBackground() {
		return new Color(_backgraound.getRGB());
	}

	
	/**
	 * set color
	 * @param background
	 */
	public void setBackground(Color background) {
		if (_backgraound == null) 
            this._backgraound = new Color(255,255,255);
		else 
            this._backgraound =new Color(background.getRGB());
        
	}

	/**
	 * 
	 * @return AmbientLight
	 */
	public AmbientLight getAmbientLight() {
		return new AmbientLight(_ambientLight);
	}

	
	/**
	 * set AmbientLight
	 * @param ambientLight
	 */
	public void setAmbientLight(AmbientLight ambientLight) {
		this._ambientLight = new AmbientLight(ambientLight);
	}

	/**
	 * 
	 * @return the list of geometries in the scene
	 */
	public ArrayList<Geometry> getGeometries() {
		ArrayList<Geometry> list = new ArrayList<Geometry>();
        for (Iterator<Geometry> iterator = this._geometries.iterator(); iterator.hasNext();) 
        {
        	Geometry next = iterator.next();
            list.add(next);
        }
        return list;	
     
	}

	/**
	 * set the list of geometries in the scene
	 * @param geometries
	 */
	public void setGeometries(ArrayList<Geometry> geometries) {
		if(geometries == null) 
        {
            this._geometries = new ArrayList<Geometry>();
        }
        this._geometries = new ArrayList<Geometry>(geometries);	
    
	}

	/**
	 * 
	 * @return
	 */
	public Camera getCamera() {
		return new Camera(_camera);
	}

	
	/**
	 * set value of camera
	 * @param camera
	 */
	public void setCamera(Camera camera) {
		this._camera = new Camera(camera);
	}

	/**
	 *return the Screen Distance
	 * @return
	 */
	public double getScreenDistance() {
		return _screenDistance;
	}

	
	/**
	 * set the Screen Distance
	 * @param screenDistance
	 */
	public void setScreenDistance(double screenDistance) {
		this._screenDistance = screenDistance;
	}
	

/**
 * 
 * @return list of the lights in the scene
 */
	public ArrayList<Light> get_lights() {
		return 	new ArrayList<Light>( _lights);
	}

	/**
	 * set list of the lights in the scene
	 * @param lights
	 */
	public void set_lights(ArrayList<Light> lights) {
		if(_lights==null)
		{
		this._lights = new ArrayList<Light>( lights);
		}
		else 
			this._lights=new ArrayList<Light>(lights);
	}

	// ***************** Administration  ******************** // 
	
	/**
	 *  print string with name and value
	 */
	@Override
	public String toString() {
		return "Scene [_sceneName=" + _sceneName + ", _backgraound=" + _backgraound + ", _ambientLight=" + _ambientLight
				+ ", _camera=" + _camera + ", _screenDistance=" + _screenDistance + ", _geometries=" + _geometries
				+ "]";
	}

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
		Scene other = (Scene) obj;
		if (_ambientLight == null) {
			if (other._ambientLight != null)
				return false;
		} else if (!_ambientLight.equals(other._ambientLight))
			return false;
		if (_backgraound == null) {
			if (other._backgraound != null)
				return false;
		} else if (!_backgraound.equals(other._backgraound))
			return false;
		if (_camera == null) {
			if (other._camera != null)
				return false;
		} else if (!_camera.equals(other._camera))
			return false;
		if (_geometries == null) {
			if (other._geometries != null)
				return false;
		} else if (!_geometries.equals(other._geometries))
			return false;
		if (_sceneName == null) {
			if (other._sceneName != null)
				return false;
		} else if (!_sceneName.equals(other._sceneName))
			return false;
		if (Double.doubleToLongBits(_screenDistance) != Double.doubleToLongBits(other._screenDistance))
			return false;
		return true;
	}
	
	// ***************** Operations ******************** //
	/**
	 * 
	 * @return an iterator to geometry
	 */
	public Iterator<Geometry>getGeometriesIterator()
	{
		return _geometries.iterator();

	}

	/**
	 * adds a new geometry to the scene
	 * @param g a new geometry in the scene
	 */
	public void addGeometry(Geometry g) {
		this._geometries.add(g);
	}
	
	/**
	 * 
	 * @param geometries is a new geometry in the scene
	 * @return the  new list with the added geometry in the scene
	 */
	public ArrayList<Geometry> addGeometryreturn(Geometry geometries)
	{
		this._geometries.add(geometries);
		return _geometries;
	}

/**
 * @param light a new light in the scene
 * @return updated list of all the lights in the scene
 */
	public ArrayList<Light> addLight(Light light)
	{
		this._lights.add(light);
		return _lights;
	}

	/**
	 * @return Iterator to the lights list
	 */
	public Iterator<Light> getLightsIterator()
	{
		return _lights.iterator();
		
	}
	
}
