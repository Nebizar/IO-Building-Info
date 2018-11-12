package pl.put.poznan.building_info.structures;

public class Room extends Location{
	private float length;
	private float width;
	private float height;
    private float area;
    private float cube;
    private float heating;
    private float lightPower;

    public Room(int id, String name, float length, float width, float height, float heating, float lightPower){
        super(id, name);
        this.length = length;
        this.width = width;
        this.height = height;
        this.area = length * width;
        this.cube = this.area * height;
        this.heating = heating;
        this.lightPower = lightPower;
    }

    public float getHeating() {
        return heating;
    }
    
    public float getCube() {
    	return cube;
    }
    
    public float getArea() {
    	return area;
    }
    
    public float getLightPower() {
    	return lightPower;
    }
}