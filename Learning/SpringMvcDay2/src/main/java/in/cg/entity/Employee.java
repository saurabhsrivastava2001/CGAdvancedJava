package in.cg.entity;

public class Employee {

    private String fName;
    private String lName;
    private String manager;
    private String doj;
    private String designation;
    private String organization;
    private Address address;

    public Employee(String fName, String lName,
                    String manager, String doj,
                    String designation, String organization,
                    Address address) {

        this.fName = fName;
        this.lName = lName;
        this.manager = manager;
        this.doj = doj;
        this.designation = designation;
        this.organization = organization;
        this.address = address;
    }

    // ✅ CORRECT GETTERS

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}