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
public class Telephone {

    private long id, id_souscripteur;
    private String telephone;

    public Telephone(long id, long id_souscripteur, String telephone) {
        this.id = id;
        this.id_souscripteur = id_souscripteur;
        this.telephone = telephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_souscripteur() {
        return id_souscripteur;
    }

    public void setId_souscripteur(long id_souscripteur) {
        this.id_souscripteur = id_souscripteur;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
