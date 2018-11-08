package pl.put.poznan.building_info.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */

public class BuildingOperations{

    private final String[] transforms;

    public BuildingOperations(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        // of course normally it would to something based on transforms
        return text.toUpperCase();
    }
}
