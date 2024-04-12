package edu.upc.dsa;

import java.util.ArrayList;
import java.util.List;

public interface DronsManager {
    public void addDron(String id, String name, String fabr, String modelo);
    public void addPilot(String id, String name, String surname);
    public List<Drons> dronsByHours();
    public List<Pilot> pilotByHours();

    public void saveDron(String id);

    public void repairDron();

    public void reservar(String id_dron, int dia, int hora, int duracion, double lat_in, double lon_in, double lat_fin, double lon_fin, String id_piloto);
    public List<reserva> reservasByPilot(String id);
    public List<reserva> reservasByDrone(String id);

}
