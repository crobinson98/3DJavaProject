package renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageWriter {

	private int _imageWidth; 
	private int _imageHeight;
	private int _Ny, _Nx;
	final String PROJECT_PATH = System.getProperty("user.dir");
	private BufferedImage _image;
	private String _imageName;
	
// ***************** Constructors ********************** // 
	/**
	 * Constructor with parameters
	 * @param imageName name of jpg file
	 * @param width image width in pixels
	 * @param height image height in pixels
	 * @param Ny number of squires per column
	 * @param Nx number of squires per row
	 */
	public ImageWriter(String imageName, int width, int height, int Ny, int Nx)
	{
		_Nx = Nx;
		_Ny = Ny;
		_imageWidth = width;
		_imageHeight = height;
		_imageName = imageName;
		_image = new BufferedImage(_imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);;
	}
	
	/**
	 * copy constructor
	 * @param other the object we want to copy
	 */

	public ImageWriter (ImageWriter imageWriter)
	{
		_Nx = imageWriter._Nx;
		_Ny = imageWriter._Ny;
		_imageWidth = imageWriter.getWidth();
		_imageHeight = imageWriter.getHeight();
		_imageName = imageWriter._imageName;
		_image = new BufferedImage(
				_imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);;
	}
	
// ***************** Getters/Setters ********************** //
	/** 
	 * @return image width
	 */
	public int getWidth()  { return _imageWidth;  }
	
	/**
	 * @return image height
	 */
	public int getHeight() { return _imageHeight; }

	/**
	 * @return number of squares per column
	 */
	public int getNy() { return _Ny; }
	
	/**
	 * @return number of squares per row
	 */
	public int getNx() { return _Nx; }

	/**
	 * @param _Ny number of squares per column
	 */
	public void setNy(int _Ny) { this._Ny = _Ny; }
	
	/**
	 * @param _Nx number of squares per row
	 */
	public void setNx(int _Nx) { this._Nx = _Nx; }
		
// ***************** Operations ******************** // 
	/**
	 * makes the picture that was built by writePixel
	 * the file is store in project path
	 */
	public void writeToimage(){
		File ouFile = new File(PROJECT_PATH + "/" + _imageName + ".jpg");
		try 
		{
			ImageIO.write(_image, "jpg", ouFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * colors a pixel in the given color
	 * @param xIndex
	 * @param yIndex
	 * @param r
	 * @param g
	 * @param b
	 */
	public void writePixel(int xIndex, int yIndex, int r, int g, int b)
	{
		
		int rgb = new Color(r, g, b).getRGB();
		_image.setRGB(xIndex, yIndex, rgb);
		
	}
	
	
	/**
	 * colors a pixel in the given color
	 * @param xIndex
	 * @param yIndex
	 * @param rgbArray
	 */
	public void writePixel(int xIndex, int yIndex, int[] rgbArray)
	{
		
		int rgb = new Color(rgbArray[0], rgbArray[1], rgbArray[2]).getRGB();
		_image.setRGB(xIndex, yIndex, rgb);
		
	}
	
	/**
	 * colors a pixel in the given color
	 * @param xIndex
	 * @param yIndex
	 * @param color
	 */
	public void writePixel(int xIndex, int yIndex, Color color)
	{
		
		_image.setRGB(xIndex, yIndex, color.getRGB());
		
	}
	
}