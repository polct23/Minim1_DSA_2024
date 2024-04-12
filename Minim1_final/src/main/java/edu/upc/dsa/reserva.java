package edu.upc.dsa;

public class reserva {
    String id_dron;
    int dia;
    int hora;
    int duracion;
    double lat_in;
    double lon_in;
    double lat_fin;
    double lon_fin;
    String id_piloto;

    public reserva(String id_dron, int dia, int hora, int duracion, double lat_in, double lon_in, double lat_fin, double lon_fin, String id_piloto) {
        this.id_dron = id_dron;
        this.dia = dia;
        this.hora = hora;
        this.duracion = duracion;
        this.lat_in = lat_in;
        this.lon_in = lon_in;
        this.lat_fin = lat_fin;
        this.lon_fin = lon_fin;
        this.id_piloto = id_piloto;
    }

    public reserva() {
    }

    public String getId_dron() {
        return id_dron;
    }

    public void setId_dron(String id_dron) {
        this.id_dron = id_dron;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getLat_in() {
        return lat_in;
    }

    public void setLat_in(double lat_in) {
        this.lat_in = lat_in;
    }

    public double getLon_in() {
        return lon_in;
    }

    public void setLon_in(double lon_in) {
        this.lon_in = lon_in;
    }

    public double getLat_fin() {
        return lat_fin;
    }

    public void setLat_fin(double lat_fin) {
        this.lat_fin = lat_fin;
    }

    public double getLon_fin() {
        return lon_fin;
    }

    public void setLon_fin(double lon_fin) {
        this.lon_fin = lon_fin;
    }

    public String getId_piloto() {
        return id_piloto;
    }

    public void setId_piloto(String id_piloto) {
        this.id_piloto = id_piloto;
    }
}
