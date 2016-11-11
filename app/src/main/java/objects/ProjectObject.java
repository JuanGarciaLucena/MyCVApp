package objects;

import com.orm.SugarRecord;

/**
 * Created by Juan Lucena on 11/11/2016.
 */

public class ProjectObject extends SugarRecord{

    private int projectID;
    private String projectName;
    private String projectDescription;
    private String projectDate;
    private String projectCompany;

    public ProjectObject(){}

    public ProjectObject(int projectID, String projectName, String projectDescription, String projectDate, String projectCompany){
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectDate = projectDate;
        this.projectCompany = projectCompany;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(String projectDate) {
        this.projectDate = projectDate;
    }

    public String getProjectCompany() {
        return projectCompany;
    }

    public void setProjectCompany(String projectCompany) {
        this.projectCompany = projectCompany;
    }
}
