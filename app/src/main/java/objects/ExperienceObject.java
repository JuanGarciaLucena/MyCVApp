package objects;

/**
 * Created by juanlucena on 07/08/16.
 */
public class ExperienceObject {

    private String dateFrom;
    private String dateTo;
    private String companyName;
    private String roleName;

    public ExperienceObject(String companyName, String dateFrom, String dateTo, String roleName) {
        this.companyName = companyName;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.roleName = roleName;
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
}
