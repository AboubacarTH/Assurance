package bean;

public class Compagnie {

    private long id;
    private String compagnie;

    public Compagnie() {

    }

    public Compagnie(long id, String compagnie) {
        this.id = id;
        this.compagnie = compagnie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

}
