package org.programmierbeleg.programmierbeleg;

public class Aminosaeuren {
    private String name;
    private String abkuerzung;
    private String formel;
    private Double molmasse;
    private String eigenschaften;
    private String codetriplett;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbkuerzung() {
        return abkuerzung;
    }

    public void setAbkuerzung(String abkuerzung) {
        this.abkuerzung = abkuerzung;
    }

    public String getFormel() {
        return formel;
    }

    public void setFormel(String formel) {
        this.formel = formel;
    }

    public Double getMolmasse() {
        return molmasse;
    }

    public void setMolmasse(Double molmasse) {
        this.molmasse = molmasse;
    }

    public String getEigenschaften() {
        return eigenschaften;
    }

    public void setEigenschaften(String eigenschaften) {
        this.eigenschaften = eigenschaften;
    }

    public String getCodetriplett() {
        return codetriplett;
    }

    public void setCodetriplett(String codetriplett) {
        this.codetriplett = codetriplett;
    }

    public String toString() {
        return "Name: " + name + "\nAbkürzung: " + abkuerzung + "\nFormel: " + formel + "\nMolmasse: " + molmasse.toString() + "\nEigenschaften: " + eigenschaften + "\nCodetriplett: " + codetriplett;
    }
}
