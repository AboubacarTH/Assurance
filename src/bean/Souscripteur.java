package bean;

public class Souscripteur {

    private long id;
    private String numero_assure, nom_prenom, type_piece, numero_piece, adresse, profession, personnalite;
    private boolean exempter_taxe;

    public Souscripteur() {

    }

    public Souscripteur(long id, String numero_assure, String nom_prenom, String type_piece,
            String numero_piece, String adresse, String profession, String personnalite, boolean exempter_taxe) {
        this.id = id;
        this.numero_assure = numero_assure;
        this.nom_prenom = nom_prenom;
        this.type_piece = type_piece;
        this.numero_piece = numero_piece;
        this.adresse = adresse;
        this.profession = profession;
        this.personnalite = personnalite;
        this.exempter_taxe = exempter_taxe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero_assure() {
        return numero_assure;
    }

    public void setNumero_assure(String numero_assure) {
        this.numero_assure = numero_assure;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public String getType_piece() {
        return type_piece;
    }

    public void setType_piece(String type_piece) {
        this.type_piece = type_piece;
    }

    public String getNumero_piece() {
        return numero_piece;
    }

    public void setNumero_piece(String numero_piece) {
        this.numero_piece = numero_piece;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPersonnalite() {
        return personnalite;
    }

    public void setPersonnalite(String personnalite) {
        this.personnalite = personnalite;
    }

    public boolean isExempter_taxe() {
        return exempter_taxe;
    }

    public void setExempter_taxe(boolean exempter_taxe) {
        this.exempter_taxe = exempter_taxe;
    }

}
