package com.mspr.arosaje.common;

public class Utilisateur {
    private final int id;
    private final String nom;

    public Utilisateur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}