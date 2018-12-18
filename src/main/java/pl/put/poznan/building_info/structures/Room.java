package pl.put.poznan.building_info.structures;

import java.util.ArrayList;

/**
 * Klasa reprezentujaca pomieszczenie budynku. Zawiera podstawowe informacje o
 * pomieszczeniu. Dziedziczy z klasy Location
 * 
 * @since 0.1
 */

public class Room extends Location{
	
	  /** <p>Podstawowe cechy pomieszczenia:</p>
	   * @param length, @param width, @param height - opisuja wymiary pomieszczenia (dlugosc, szerokosc, wysokosc)
	   * @param area - powierzchnia pomieszczenia
	   * @param cube - kubatura pomieszczenia
	   * @param heating - zuzycie energii na ogrzewanie dla calego pomieszczenia
	   * @param lightPower - moc oswietlenia dla calego pomieszczenia
	   * @param rent - cena za wynajecie pomieszczenia
	   */
	private float length;
	private float width;
	private float height;
    private float area;
    private float cube;
    private float heating;
    private float lightPower;
    private float rent;

    /**
     * <p>Konstruktor tworzacy pomieszczenie wraz z podstawowymi informacjami o nim</p>
     *
     * @param id- unikalna wartosc opisujaca pomieszczenie
     * @param name-nazwa obiektu
     * dziedziczone z klasy location
     */
    public Room(int id, String name, float length, float width, float height, float heating, float lightPower, float rent){
        super(id, name, "Room");
        this.length = length;
        this.width = width;
        this.height = height;
        this.area = length * width;
        this.cube = this.area * height;
        this.heating = heating;
        this.lightPower = lightPower;
        this.rent = rent;
    }

    @Override
    public boolean isRoom(){
        return true;
    }

    @Override
    public float getHeating() {
        return heating;
    }
    
    @Override
    public float getCube() {
    	return cube;
    }

    @Override
    public float getArea() {
    	return area;
    }
    
    @Override
    public float getLightPower() {
    	return lightPower;
    }

    @Override
    public float getRent() {
        return rent;
    }

    @Override
    public ArrayList<Location> getLocations() {
        return null;
    }

    @Override
    public Location getEntityByID(int ID) {
        if(this.getID() == ID){
            return this;
        }else{
            return null;
        }
	}

	@Override
	public ArrayList<Location> getEntitiesByIDs(ArrayList<Integer> IDs) {
        ArrayList<Location> result = new ArrayList<Location>();
        if(IDs.contains(this.getID())){
            result.add(this);
        }

        return result;
	}
}