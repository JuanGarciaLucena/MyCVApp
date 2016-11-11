package objects;

import com.orm.SugarRecord;

/**
 * Created by juanlucena on 07/08/16.
 */
public class ExperienceObject extends SugarRecord{

    private int experienceID;
    private String dateFrom;
    private String dateTo;
    private String companyName;
    private String roleName;
    private String experienceDescription;

    public ExperienceObject(){
    }

    public ExperienceObject(int experienceID, String companyName, String dateFrom, String dateTo, String roleName, String experienceDescription) {
        this.experienceID = experienceID;
        this.companyName = companyName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.roleName = roleName;
        this.experienceDescription = experienceDescription;
    }

    public int getExperienceID() {
        return experienceID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getExperienceDescription(){return experienceDescription;}

    public void setExperienceID(int experienceID) {
        this.experienceID = experienceID;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setExperienceDescription(String experienceDescription){this.experienceDescription = experienceDescription;}
}
