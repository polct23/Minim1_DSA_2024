package edu.upc.dsa;

import java.util.ArrayList;

public class Drons {
    String id;
    String name;

    String fabricante;
    String modelo;
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Drons(String id, String name, String fabricante, String piloto) {
        this.id = id;
        this.name = name;
        this.fabricante = fabricante;
        this.modelo = piloto;
        this.horas = 0;
        listavuelos = new ArrayList<reserva>();
    }

    public Drons() {

    }
}
