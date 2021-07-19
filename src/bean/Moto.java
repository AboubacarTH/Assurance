package bean;

public class Moto {

    private long id, id_puissance;

    public Moto() {

    }

    public Moto(long id, long id_puissance) {
        this.id = id;
        this.id_puissance = id_puissance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_puissance() {
        return id_puissance;
    }

    public void setId_puissance(long id_puissance) {
        this.id_puissance = id_puissance;
    }

}
