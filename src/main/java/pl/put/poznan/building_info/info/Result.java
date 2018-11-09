package pl.put.poznan.building_info.info;


/**
 * Contains information about the success / failure of the operation.
 */
public class Result{
    private String feedback;
    private int code;

    public Result(String feedback, int code){
        this.feedback = feedback;
        this.code = code;
    }

    /**
     * returns information about the operation in JSON format
     */
    public String getAsJsonString(){
        String rs = "{\"feedback\": \"" + feedback + "\", \"code\": " + Integer.toString(code) + "}";
        return rs;
    }
}