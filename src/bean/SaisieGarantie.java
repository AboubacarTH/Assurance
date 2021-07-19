package bean;

public class SaisieGarantie {

    private long id, id_saisie, id_compagnie_garantie;

    public SaisieGarantie() {

    }

    public SaisieGarantie(long id, long id_saisie, long id_compagnie_garantie) {
        this.id = id;
        this.id_saisie = id_saisie;
        this.id_compagnie_garantie = id_compagnie_garantie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_saisie() {
        return id_saisie;
    }

    public void setId_saisie(long id_saisie) {
        this.id_saisie = id_saisie;
    }

    public long getId_compagnie_garantie() {
        return id_compagnie_garantie;
    }

    public void setId_compagnie_garantie(long id_compagnie_garantie) {
        this.id_compagnie_garantie = id_compagnie_garantie;
    }

}
