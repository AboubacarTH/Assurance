package bean;

public class VehiculeMoteur {

    private long id;
    private String puissance;
    private long id_energie;

    public VehiculeMoteur() {

    }

    public VehiculeMoteur(long id, String puissance, long id_energie) {
        this.id = id;
        this.puissance = puissance;
        this.id_energie = id_energie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public long getId_energie() {
        return id_energie;
    }

    public void setId_energie(long id_energie) {
        this.id_energie = id_energie;
    }

}
