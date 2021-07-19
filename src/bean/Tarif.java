package bean;

public class Tarif {

    private long id, id_classe, id_groupe, id_zone, id_usage;
    private double tarif;

    public Tarif() {

    }

    public Tarif(long id, long id_classe, long id_groupe, long id_zone, long id_usage, double tarif) {
        this.id = id;
        this.id_classe = id_classe;
        this.id_groupe = id_groupe;
        this.id_zone = id_zone;
        this.id_usage = id_usage;
        this.tarif = tarif;
    }

    public long getId() {
        return id;
    }

    public long getId_usage() {
        return id_usage;
    }

    public void setId_usage(long id_usage) {
        this.id_usage = id_usage;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_classe() {
        return id_classe;
    }

    public void setId_classe(long id_classe) {
        this.id_classe = id_classe;
    }

    public long getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(long id_groupe) {
        this.id_groupe = id_groupe;
    }

    public long getId_zone() {
        return id_zone;
    }

    public void setId_zone(long id_zone) {
        this.id_zone = id_zone;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

}
