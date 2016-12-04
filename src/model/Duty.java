package model;

/**
 * Created by RJzz on 2016/12/3.
 */
public class Duty {
    private String dDid;
    private String dName;
    private String dEmail;
    private String dPhone;
    public Duty(String dDid, String dName, String dEmail, String dPhone) {
        this.dDid = dDid;
        this.dName = dName;
        this.dEmail = dEmail;
        this.dPhone = dPhone;
    }

    public void setdDid(String dDid) {
        this.dDid = dDid;
    }

    public void setdEmail(String dEmail) {
        this.dEmail = dEmail;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public void setdPhone(String dPhone) {
        this.dPhone = dPhone;
    }

    public String getdDid() {
        return dDid;
    }

    public String getdEmail() {
        return dEmail;
    }

    public String getdName() {
        return dName;
    }

    public String getdPhone() {
        return dPhone;
    }

}
