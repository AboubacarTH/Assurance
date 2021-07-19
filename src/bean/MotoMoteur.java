package bean;

public class MotoMoteur {

    private long id;
    private String puissance;

    public MotoMoteur() {
    }

    public MotoMoteur(long id, String puissance) {
        this.id = id;
        this.puissance = puissance;
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

}
