package bean;

import java.sql.Date;

public class Saisie {

    private long id, id_souscripteur, id_automobile, id_compagnie;
    private Date date_saisie, date_effet, date_echeance;
    private double prime_nette, surprime, accessoire, taxe, prime_totale;
    private String numero_police;

    public Saisie() {

    }

    public Saisie(long id, long id_souscripteur, long id_automobile, long id_compagnie, Date date_saisie,
            Date date_effet, Date date_echeance, double prime_nette, double surprime, double accessoire, double taxe,
            double prime_totale, String numero_police) {
        this.id = id;
        this.id_souscripteur = id_souscripteur;
        this.id_automobile = id_automobile;
        this.id_compagnie = id_compagnie;
        this.date_saisie = date_saisie;
        this.date_effet = date_effet;
        this.date_echeance = date_echeance;
        this.prime_nette = prime_nette;
        this.surprime = surprime;
        this.accessoire = accessoire;
        this.taxe = taxe;
        this.prime_totale = prime_totale;
        this.numero_police = numero_police;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero_police() {
        return numero_police;
    }

    public void setNumero_police(String numero_police) {
        this.numero_police = numero_police;
    }

    public long getId_souscripteur() {
        return id_souscripteur;
    }

    public void setId_souscripteur(long id_souscripteur) {
        this.id_souscripteur = id_souscripteur;
    }

    public long getId_automobile() {
        return id_automobile;
    }

    public void setId_automobile(long id_automobile) {
        this.id_automobile = id_automobile;
    }

    public long getId_compagnie() {
        return id_compagnie;
    }

    public void setId_compagnie(long id_compagnie) {
        this.id_compagnie = id_compagnie;
    }

    public Date getDate_saisie() {
        return date_saisie;
    }

    public void setDate_saisie(Date date_saisie) {
        this.date_saisie = date_saisie;
    }

    public Date getDate_effet() {
        return date_effet;
    }

    public void setDate_effet(Date date_effet) {
        this.date_effet = date_effet;
    }

    public Date getDate_echeance() {
        return date_echeance;
    }

    public void setDate_echeance(Date date_echeance) {
        this.date_echeance = date_echeance;
    }

    public double getPrime_nette() {
        return prime_nette;
    }

    public void setPrime_nette(double prime_nette) {
        this.prime_nette = prime_nette;
    }

    public double getSurprime() {
        return surprime;
    }

    public void setSurprime(double surprime) {
        this.surprime = surprime;
    }

    public double getAccessoire() {
        return accessoire;
    }

    public void setAccessoire(double accessoire) {
        this.accessoire = accessoire;
    }

    public double getTaxe() {
        return taxe;
    }

    public void setTaxe(double taxe) {
        this.taxe = taxe;
    }

    public double getPrime_totale() {
        return prime_totale;
    }

    public void setPrime_totale(double prime_totale) {
        this.prime_totale = prime_totale;
    }

}
