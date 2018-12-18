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

    /**
     * <p>Funkcja określająca typ lokalizacji jako Room</p>
     */
    @Override
    public boolean isRoom(){
        return true;
    }

    /**
     * <p>Zwraca zużycie energii na ogrzewanie pokoju</p>
     */
    @Override
    public float getHeating() {
        return heating;
    }
    
    /**
     * <p>Zwraca kubaturę pokoju</p>
     */
    @Override
    public float getCube() {
    	return cube;
    }

    /**
     * <p>Zwraca powierzchnię pomieszczenia</p>
     */
    @Override
    public float getArea() {
    	return area;
    }
    
    /**
     * <p>Zwraca moc oświetlenia dla całego pomieszczenia</p>
     */
    @Override
    public float getLightPower() {
    	return lightPower;
    }

    /**
     * <p>Zwraca cenę wynajmu pomieszczenia</p>
     */
    @Override
    public float getRent() {
        return rent;
    }

    /**
     * <p>Zwraca lokacje wewnątrz pomieszczenia</p>
     */
    @Override
    public ArrayList<Location> getLocations() {
        return null;
    }

    /**
     * <p>
     * Zwraca referencję na siebie jeżeli ID pokoju jest równe szukanemu ID,
     * null w innym przypadku
     * </p>
     * @param ID - szukane ID
     */
    @Override
    public Location getEntityByID(int ID) {
        if(this.getID() == ID){
            return this;
        }else{
            return null;
        }
	}

    /**
     * <p>
     * Zwraca referencję na siebie jako listę jednoelementową jeżeli ID pokoju jest równe szukanemu ID,
     * lista pusta w innym przypadku
     * </p>
     * @param ID - szukane ID
     */
	@Override
	public ArrayList<Location> getEntitiesByIDs(ArrayList<Integer> IDs) {
        ArrayList<Location> result = new ArrayList<Location>();
        if(IDs.contains(this.getID())){
            result.add(this);
        }

        return result;
    }
    
    @Override
    public ArrayList<Room> getRooms(){
        ArrayList<Room> found = new ArrayList<Room>();
        found.add(this);
        return found;
    }
}