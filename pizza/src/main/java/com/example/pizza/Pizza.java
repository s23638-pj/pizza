package com.example.pizza;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {
    public Pizza(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nazwa;
    private int rozmiar;
    private String skladnik1;
    private String skladnik2;
    private String skladnik3;
    private boolean czy_sos = true;
    private boolean czy_cienkie = true;
    private int min_w_piecu;
    private int dni_fermentacji;

    Pizza(String nazwa, int rozmiar, String skladnik1, String skladnik2, String skladnik3, boolean czy_sos, boolean czy_cienkie, int min_w_piecu, int dni_fermentacji)
    {
        this.nazwa = nazwa;
        this.rozmiar = rozmiar;
        this.skladnik1 = skladnik1;
        this.skladnik2 = skladnik2;
        this.skladnik3 = skladnik3;
        this.czy_sos = czy_sos;
        this.czy_cienkie = czy_cienkie;
        this.min_w_piecu = min_w_piecu;
        this.dni_fermentacji = dni_fermentacji;
    }

    @Override //nadpisuje
    public String toString() {
        return "Pizza{" +
                "nazwa='" + nazwa + '\'' +
                ", rozmiar=" + rozmiar +
                ", skladnik1='" + skladnik1 + '\'' +
                ", skladnik2='" + skladnik2 + '\'' +
                ", skladnik3='" + skladnik3 + '\'' +
                ", czy_sos=" + czy_sos +
                ", czy_cienkie=" + czy_cienkie +
                ", min_w_piecu=" + min_w_piecu +
                ", dni_fermentacji=" + dni_fermentacji +
                '}';
    }

    public int getDni_fermentacji() {
        return dni_fermentacji;
    }



    public void setDni_fermentacji(int dni_fermentacji) {
        this.dni_fermentacji = dni_fermentacji;
    }

    public int getMin_w_piecu() { return min_w_piecu; }

    public void setMin_w_piecu(int min_w_piecu) {
        this.min_w_piecu = min_w_piecu;
    }

    public boolean isCzy_cienkie() {
        return czy_cienkie;
    }

    public void setCzy_cienkie(boolean czy_cienkie) {
        this.czy_cienkie = czy_cienkie;
    }

    public boolean isCzy_sos() {
        return czy_sos;
    }

    public void setCzy_sos(boolean czy_sos) {
        this.czy_sos = czy_sos;
    }

    public String getSkladnik3() {
        return skladnik3;
    }

    public void setSkladnik3(String skladnik3) {
        this.skladnik3 = skladnik3;
    }

    public String getSkladnik2() {
        return skladnik2;
    }

    public void setSkladnik2(String skladnik2) {
        this.skladnik2 = skladnik2;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }

    public String getSkladnik1() {
        return skladnik1;
    }

    public void setSkladnik1(String skladnik1) {
        this.skladnik1 = skladnik1;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
