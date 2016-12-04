package model;

/**
 * Created by RJzz on 2016/12/3.
 */
public class Keeper {
    private String kKId;
    private String kName;
    private String KEmail;
    private String kPhone;
    public Keeper(String id, String name, String email, String phone) {
        this.kKId = id;
        this.kName = name;
        this.KEmail = email;
        this.kPhone = phone;
    }

    public String getKEmail() {
        return KEmail;
    }

    public String getkKId() {
        return kKId;
    }

    public String getkName() {
        return kName;
    }

    public String getkPhone() {
        return kPhone;
    }

    public void setKEmail(String KEmail) {
        this.KEmail = KEmail;
    }

    public void setkKId(String kKId) {
        this.kKId = kKId;
    }

    public void setkName(String kName) {
        this.kName = kName;
    }

    public void setkPhone(String kPhone) {
        this.kPhone = kPhone;
    }
}

