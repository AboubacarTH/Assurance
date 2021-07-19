package bean;

public class Police {

    private long id, id_usage, id_compagnie;
    private long police;

    public Police() {

    }

    public Police(long id, long id_usage, long id_compagnie, long police) {
        this.id = id;
        this.id_usage = id_usage;
        this.id_compagnie = id_compagnie;
        this.police = police;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_usage() {
        return id_usage;
    }

    public void setId_usage(long id_usage) {
        this.id_usage = id_usage;
    }

    public long getId_compagnie() {
        return id_compagnie;
    }

    public void setId_compagnie(long id_compagnie) {
        this.id_compagnie = id_compagnie;
    }

    public long getPolice() {
        return police;
    }

    public void setPolice(long police) {
        this.police = police;
    }

}
