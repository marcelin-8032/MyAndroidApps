package com.example.myframeworkapp.login;

public class Contact {
    private String nom;
    private String prénom;
    private String telephone;
    private String email;

   // private Adresse adresse;


    public Contact(String nom, String prénom, String telephone, String email) {
        this.nom = nom;
        this.prénom = prénom;
        this.telephone = telephone;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }
    public String getPrénom() {
        return prénom;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getEmail() {
        return email;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prénom='").append(prénom).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
