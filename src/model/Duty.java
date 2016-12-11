package model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by RJzz on 2016/12/3.
 */
public class Duty {
    private final SimpleStringProperty dName = new SimpleStringProperty("");
    private final SimpleStringProperty dEmail = new SimpleStringProperty("");
    private final SimpleStringProperty dPhone = new SimpleStringProperty("");
    public Duty(String dName, String dEmail, String dPhone) {
        this.dName.set(dName);
        this.dEmail.set(dEmail);
        this.dPhone.set(dPhone);
    }
    public Duty() {

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
