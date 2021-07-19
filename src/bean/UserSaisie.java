/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;

/**
 *
 * @author ATH
 */
public class UserSaisie {

    private long id_saisie, id_user;
    private Date date;

    public UserSaisie(long id_saisie, long id_user, Date date) {
        this.id_saisie = id_saisie;
        this.id_user = id_user;
        this.date = date;
    }

    public long getId_saisie() {
        return id_saisie;
    }

    public void setId_saisie(long id_saisie) {
        this.id_saisie = id_saisie;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
