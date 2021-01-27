package springcore_example;

import java.util.HashMap;
import java.util.Map;

public class AreaCalculator {
	
	private String shapeName;
	private boolean drawable; //for circle only
	
	public String getShapeName() {
		return shapeName;
	}

	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}
	
	public boolean isDrawable() {
		return drawable;
	}

	public double square(double side) {
		if(side<0) {
			return -1;
		}
		return side*side;
	}
	
	/*Allowed length between 0 and 10000*/
	public int rectangle(int length, int width) {
		if(length<0 || width<0) {
			return -1; //Negative values
		}else if (length>10000 || width>10000) {
			return -2; //Length/width exceeds limit
		}
		return length * width;
	}
	
	/*Allowed units - cms and inches*/
	public float triangle(int base, int height, String unit) {
		if(base<0 || height<0) {
			return -1;//Negative values
		}
		if(unit.equals("cms") || unit.equals("inches")) {
			return 0.5f*base*height;
		}else{
			return -2; //Unit is neither cms nor inches
		}
		
	}
	
	/*Returns map with key as area and HEX color as value*/
	public Map<Float,String> circle(float radius, int red, int green, int blue) {
		HashMap<Float,String> hm = new HashMap<Float,String>();
		if(radius<0) {
			hm.put(-1.0f, ""); //For negative radius
			return hm;
		}
		float area = 3.14f*radius*radius;
		String hex = String.format("#%02x%02x%02x", red, green, blue);  
		hm.put(area, hex);
		drawable=true;
		return hm;
	}
	
	public String getRoundShape(int verticalDiameter, int horizontalDiameter) {
		if(verticalDiameter== horizontalDiameter) {
			return "Circle";
		}else if(verticalDiameter>horizontalDiameter) {
			return "Vertical Oval";
		}else {
			return "Horizontal Oval";
		}
	}
	
	

}
