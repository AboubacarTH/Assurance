package bean;

public class Usage {

    private long id;
    private String usage;

    public Usage() {

    }

    public Usage(long id, String usage) {
        this.id = id;
        this.usage = usage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

}
