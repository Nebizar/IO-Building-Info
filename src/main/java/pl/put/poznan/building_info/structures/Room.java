package pl.put.poznan.building_info.structures;
/** Klasa reprezentujaca pomieszczenie budynku. Zawiera podstawowe informacje o pomieszczeniu.  Dziedziczy z klasy Location
 * @since 0.1
 */

public class Room extends Location{
	
	  /** <p>Podstawowe cechy pomieszczenia:</p>
	   * @param length, @param width, @param height - opisuja wymiary pomieszczenia (dlugosc, szerokosc, wysokosc)
	   * @param area - powierzchnia pomieszczenia
	   * @param cube - kubatura pomieszczenia
	   * @param heating - zuzycie energii na ogrzewanie dla calego pomieszczenia
	   * @param lightPower - moc oswietlenia dla calego pomieszczenia
	   */
	private float length;
	private float width;
	private float height;
    private float area;
    private float cube;
    private float heating;
    private float lightPower;

    /**
     * <p>Konstruktor tworzacy pomieszczenie wraz z podstawowymi informacjami o nim</p>
     *
     * @param id- unikalna wartosc opisujaca pomieszczenie
     * @param name-nazwa obiektu
     * dziedziczone z klasy location
     */
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