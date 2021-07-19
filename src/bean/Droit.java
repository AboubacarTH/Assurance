/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ATH
 */
public class Droit {

    private long id_user;
    private boolean ecriture, lecture, supression, modification, administration;

    public Droit(long id_user, boolean ecriture, boolean lecture, boolean supression, boolean modification, boolean administration) {
        this.id_user = id_user;
        this.ecriture = ecriture;
        this.lecture = lecture;
        this.supression = supression;
        this.modification = modification;
        this.administration = administration;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public boolean isEcriture() {
        return ecriture;
    }

    public void setEcriture(boolean ecriture) {
        this.ecriture = ecriture;
    }

    public boolean isLecture() {
        return lecture;
    }

    public void setLecture(boolean lecture) {
        this.lecture = lecture;
    }

    public boolean isSupression() {
        return supression;
    }

    public void setSupression(boolean supression) {
        this.supression = supression;
    }

    public boolean isModification() {
        return modification;
    }

    public void setModification(boolean modification) {
        this.modification = modification;
    }

    public boolean isAdministration() {
        return administration;
    }

    public void setAdministration(boolean administration) {
        this.administration = administration;
    }

}
