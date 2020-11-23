package primitives;

public class Material {
	
	private double _kd; // Diffusion attenuation coefficient   	
	private double _ks; // Specular attenuation coefficient  
	private double _nShininess;  // Refraction inde
	private double _kr; // reflection attenuation coefficient
	private double _kt; // transparencyattenuation coefficient
	
	//***************** Constructors ********************** // 
	
	/**
	 * Constructor with parameters
	 * @param kd
	 * @param ks
	 * @param nShininess
	 * @param kr
	 * @param kt
	 */
	public Material(double kd, double ks, double nShininess,double kr, double kt) 
	{
		 _kr=kr;
		 _kt=kt;
		 _kd=kd;
		 _ks=ks;
		 _nShininess=nShininess;
	}
	
	/**
	 *  copy constructor
	 * @param m
	 */
	public Material(Material m) 
	{
		
		this._kd = m._kd;
		this._ks = m._ks;
		this._nShininess = m._nShininess;
		this._kr = m._kr;
		this._kt = m._kt;
	}
	
	/**
	 * default  constructor
	 */
	public Material() 
	{
		this._kd = 1;
		this._ks = 1;
		this._kr = 0;
		this._kt =0;
		this._nShininess = 1;
	}

	
	//***************** Getters/Setters ********************** //
	
	/***
	 * 
	 * @return Diffusion attenuation coefficient
	 */
	public double get_kd() {
		return _kd;
	}
	
	/**
	 * set Diffusion attenuation coefficient
	 * @param kd
	 */
	public void set_kd(double kd) {
	
		this._kd = kd;
	}
	
	/**
	 * 
	 * @return Specular attenuation coefficient
	 */
	public double get_ks() {
		return _ks;
	}
	
	/**
	 * 
	 * @param ks set Specular attenuation coefficient
	 */
	public void set_ks(double ks) {
	
		this._ks = ks;
	}
	
	/**
	 * 
	 * @return shininess Refraction index
	 */
	public double get_nShininess() {
		return _nShininess;
	}
	
	/**
	 * set shininess Refraction index
	 * @param nShininess
	 */
	public void set_nShininess(double nShininess) {
	
		this._nShininess = nShininess;
	}
	
	/**
	 * 
	 * @return reflection factor
	 */
	public double get_kr() {
		return _kr;
	}

	/**
	 * set reflection factor
	 * @param kr
	 */
	public void set_kr(double kr) {
	
		this._kr = kr;
	}

	/**
	 * 
	 * @return transparency factor
	 */
	public double get_kt() {
		return _kt;
	}

	/**
	 * 
	 * @param kt transparency factor
	 */
	public void set_kt(double kt) {
	 
		this._kt = kt;
	}
	
	//***************** Administration  ******************** // 


	/**
	 * print string with name and value
	 */
	@Override
	public String toString() {
		return "Material [_kd=" + _kd + ", _ks=" + _ks + ", _nShininess=" + _nShininess + ", kt=" + _kt + ", kr=" + _kr+"]";
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
		Material other = (Material) obj;
		if (Double.doubleToLongBits(_kd) != Double.doubleToLongBits(other._kd))
			return false;
		if (Double.doubleToLongBits(_ks) != Double.doubleToLongBits(other._ks))
			return false;
		if (Double.doubleToLongBits(_kr) != Double.doubleToLongBits(other._kr))
			return false;
		if (Double.doubleToLongBits(_kt) != Double.doubleToLongBits(other._kt))
			return false;
		if (Double.doubleToLongBits(_nShininess) != Double.doubleToLongBits(other._nShininess))
			return false;
		return true;
	}
	

}

