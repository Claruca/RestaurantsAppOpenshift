package com.iesemilidarder.RestaurantsApp.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;


//Le señala que esta clase es la representación de una tabla de BD
@Entity()
public class Restaurant extends DBObject{
    @Column(name="RES_CODI")
    private String codi;

    @Column(name="RES_NOM")
    private String nom;

    @Column(name="RES_ADRECA")
    private String adressa;

    @Column(name="RES_WEB")
    private String llocweb;

    @Column(name="RES_TELEFON")
    private String telefon;

    @Column(name="TRS_DESCRIPCIO")
    private String tipus;

//    @Column(name="RES_URL_IMG")
//    private String imatge;

    @Column(name="RES_MITJANA")
    private String Mitjana;

    @Column(name="RES_LATITUD")
    private String Latitud;

    @Column(name="RES_LONGITUD")
    private String Longitud;

    //Cream arraylist de la classe opinons

    private ArrayList<Opinions> Opinions;

    public String getNom() {
        return nom;
    }

    public String getAdressa() {
        return adressa;
    }

    public String getLlocweb() {
        return llocweb;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getTipus() {
        return tipus;
    }

    public String getMitjana() {
        return Mitjana;
    }

    public String getCodi() {
        return codi;
    }

//    public String getImatge() {
//        return imatge;
//    }

    public String getLatitud() {
        return Latitud;
    }

    public String getLongitud() {
        return Longitud;
    }

    public ArrayList<Opinions> getOpinions() {
        return Opinions;
    }

    public void setOpinions(ArrayList<Opinions> opinions) {
        Opinions = opinions;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setMitjana(String mitjana) {
        Mitjana = mitjana;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdressa(String adressa) {
        this.adressa = adressa;
    }


//    public void setImatge(String imatge) {
//        this.imatge = imatge;
//    }


    public void setLlocweb(String llocweb) {
        this.llocweb = llocweb;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setLatitud(String latitud) {
        Latitud = latitud;
    }

    public void setLongitud(String longitud) {
        Longitud = longitud;
    }

//    public Restaurant(String nom, String adressa, String llocweb, String telefon, String tipus, String imatge, String mitjana) {
//        this.nom = nom;
//        this.adressa = adressa;
//        this.llocweb = llocweb;
//        this.telefon = telefon;
//        this.tipus = tipus;
//        this.imatge = imatge;
//        Mitjana = mitjana;
//    }

    public Restaurant(String nom, String adressa) {
        this.nom = nom;
        this.adressa = adressa;
    }

    public Restaurant() {
    }

    protected void beforeSave() {
        doLog(String.format("Saving %s", this.getClass().getCanonicalName()));
        System.out.println("Saving users");
    }
}

