package edu.upc.dsa;

import java.util.ArrayList;

public class Pilot {
    String id;
    String name;
    String surname;
    int horas;

    ArrayList<reserva> listavuelos;

    public ArrayList<reserva> getListavuelos() {
        return listavuelos;
    }

    public void setListavuelos(ArrayList<reserva> listavuelos) {
        this.listavuelos = listavuelos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = this.horas + horas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Pilot(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.horas = 0;
        listavuelos = new ArrayList<reserva>();
    }

    public Pilot() {
    }
}
