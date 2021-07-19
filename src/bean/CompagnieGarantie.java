package bean;

public class CompagnieGarantie {

    private long id, id_compagnie, id_garantie;
    private double montant;

    public CompagnieGarantie() {

    }

    public CompagnieGarantie(long id, long id_compagnie, long id_garantie, double montant) {
        this.id = id;
        this.id_compagnie = id_compagnie;
        this.id_garantie = id_garantie;
        this.montant = montant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_compagnie() {
        return id_compagnie;
    }

    public void setId_compagnie(long id_compagnie) {
        this.id_compagnie = id_compagnie;
    }

    public long getId_garantie() {
        return id_garantie;
    }

    public void setId_garantie(long id_garantie) {
        this.id_garantie = id_garantie;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}
