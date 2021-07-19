package bean;

public class Energie {

    private long id;
    private String energie;

    public Energie() {

    }

    public Energie(long id, String energie) {
        this.id = id;
        this.energie = energie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

}
