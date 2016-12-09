package model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by RJzz on 2016/12/3.
 */
public class Duty {
    private final SimpleStringProperty dName;
    private final SimpleStringProperty dEmail;
    private final SimpleStringProperty dPhone;
    public Duty(String dName, String dPhone, String dEmail) {
        this.dName = new SimpleStringProperty(dName);
        this.dEmail = new SimpleStringProperty(dEmail);
        this.dPhone = new SimpleStringProperty(dPhone);
    }

    public String getdPhone() {
        return dPhone.get();
    }

    public String getdName() {
        return dName.get();
    }

    public String getdEmail() {
        return dEmail.get();
    }

    public void setdPhone(String dPhone) {
        this.dPhone.set(dPhone);
    }

    public void setdName(String dName) {
        this.dName.set(dName);
    }

    public void setdEmail(String dEmail) {
        this.dEmail.set(dEmail);
    }
}
