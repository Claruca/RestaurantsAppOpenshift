package com.iesemilidarder.RestaurantsApp.core;

import java.util.ArrayList;

public class Restaurant {
    private String nom;
    private String adressa;
    private String llocweb;
    private String telefon;
    private String tipus;
    private String imatge;
    private String Mitjana;


    public void setMitjana(String mitjana) {
        Mitjana = mitjana;
    }

    public String getMitjana() {

        return Mitjana;
    }

    public ArrayList Opinions;

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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdressa(String adressa) {
        this.adressa = adressa;
    }


    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public String getImatge() {
        return imatge;
    }

    public void setLlocweb(String llocweb) {
        this.llocweb = llocweb;


    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
}