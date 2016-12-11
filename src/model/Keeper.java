package model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by RJzz on 2016/12/3.
 */
public class Keeper {
    private final SimpleStringProperty kName = new SimpleStringProperty("");
    private final SimpleStringProperty KEmail = new SimpleStringProperty("");
    private final SimpleStringProperty kPhone = new SimpleStringProperty("");
    public Keeper(String name, String email, String phone) {
        this.kName.set(name);
        this.KEmail.set(email);
        this.kPhone.set(phone);
    }
    public Keeper() {

    }

    public String getkName() {
        return kName.get();
    }



    public void setkName(String kName) {
        this.kName.set(kName);
    }

    public String getkPhone() {
        return kPhone.get();
    }

    public String getKEmail() {
        return KEmail.get();
    }

    public void setkPhone(String kPhone) {
        this.kPhone.set(kPhone);
    }

    public void setKEmail(String KEmail) {
        this.KEmail.set(KEmail);
    }

}

