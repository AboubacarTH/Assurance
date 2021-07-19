package bean;

import java.sql.Date;

public class Automobile {

    private long id, id_tarif;
    private int nombre_place;
    private Date date_circulation;
    private String type, numero_plaque, marque, numero_chassis;
    private double charge_utile;

    public Automobile() {

    }

    public Automobile(long id, long id_tarif, int nombre_place, Date date_circulation, String type,
            String numero_plaque, String marque, String numero_chassis, double charge_utile) {
        this.id = id;
        this.id_tarif = id_tarif;
        this.nombre_place = nombre_place;
        this.date_circulation = date_circulation;
        this.type = type;
        this.numero_plaque = numero_plaque;
        this.marque = marque;
        this.numero_chassis = numero_chassis;
        this.charge_utile = charge_utile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_tarif() {
        return id_tarif;
    }

    public void setId_tarif(long id_tarif) {
        this.id_tarif = id_tarif;
    }

    public int getNombre_place() {
        return nombre_place;
    }

    public void setNombre_place(int nombre_place) {
        this.nombre_place = nombre_place;
    }

    public Date getDate_circulation() {
        return date_circulation;
    }

    public void setDate_circulation(Date date_circulation) {
        this.date_circulation = date_circulation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumero_plaque() {
        return numero_plaque;
    }

    public void setNumero_plaque(String numero_plaque) {
        this.numero_plaque = numero_plaque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getNumero_chassis() {
        return numero_chassis;
    }

    public void setNumero_chassis(String numero_chassis) {
        this.numero_chassis = numero_chassis;
    }

    public double getCharge_utile() {
        return charge_utile;
    }

    public void setCharge_utile(double charge_utile) {
        this.charge_utile = charge_utile;
    }

}
