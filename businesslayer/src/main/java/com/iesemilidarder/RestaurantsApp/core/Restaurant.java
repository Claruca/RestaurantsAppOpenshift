package com.iesemilidarder.restaurants.web;


import java.awt.*;
import java.sql.Blob;
import java.util.ArrayList;



public class Restaurant {
    private String codi;
    private String nom;
    private String adressa;
    private String llocweb;
    private String telefon;
    private String tipus;
    private String imatge;
    private String Mitjana;
    private String Latitud;
    private String Longitud;

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

    public String getMitjana() { return Mitjana; }

    public String getCodi() { return codi; }

    public String getImatge() {
        return imatge;
    }

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

    public void setCodi(String codi) { this.codi = codi; }

    public void setMitjana(String mitjana) {
        Mitjana = mitjana;
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

}

