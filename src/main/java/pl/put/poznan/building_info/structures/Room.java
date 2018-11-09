package pl.put.poznan.building_info.structures;

public class Room extends Location{
    private float area;
    private float cube;
    private float heating;
    private float lightPower;

    public Room(int id, String name, float area, float cube, float heating, float lightPower){
        super(id, name);

        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.lightPower = lightPower;
    }
}