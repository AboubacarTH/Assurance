package bean;

public class Zone {

    private long id;
    private String zone;

    public Zone() {
        // TODO Auto-generated constructor stub
    }

    public Zone(long id, String zone) {
        this.id = id;
        this.zone = zone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}
