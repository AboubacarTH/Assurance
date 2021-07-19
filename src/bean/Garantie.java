package bean;

public class Garantie {

    private long id;
    private String garantie;

    public Garantie() {

    }

    public Garantie(long id, String garantie) {
        this.id = id;
        this.garantie = garantie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGarantie() {
        return garantie;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

}
