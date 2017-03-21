package objects;


import com.orm.SugarRecord;

public class TechObject extends SugarRecord {

    private String name;

    public TechObject(){}

    public TechObject(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
