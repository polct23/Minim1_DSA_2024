package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.*;

public class DronsManagerImp implements DronsManager {

    Queue<Drons> mantenimiento;
    HashMap<String, Drons> d;
    HashMap<String, Pilot> p;

    ArrayList<reserva> r;
    final static Logger logger = Logger.getLogger(DronsManagerImp.class);
    private static DronsManager instance;
    public static DronsManager getInstance() {
        if (instance==null) instance = new DronsManagerImp();
        return instance;
    }

    public DronsManagerImp() {
        mantenimiento = new LinkedList<>();
        d = new HashMap<>();
        p = new HashMap<>();
        r = new ArrayList<>();
    }

    @Override
    public void addDron(String id, String name, String fabr, String modelo) {

        Drons nuevo = new Drons(id,name,fabr,modelo);
        d.put(nuevo.id, nuevo);
        logger.info("Se ha añadido un dron");

    }

    @Override
    public void addPilot(String id, String name, String surname) {
        Pilot nuevo = new Pilot(id,name,surname);
        p.put(nuevo.id, nuevo);
        logger.info("Se ha añadido un piloto");


    }

    @Override
    public List<Drons> dronsByHours() {
        Collection<Drons> values = d.values();
        ArrayList<Drons> dronsHoras = new ArrayList<Drons>(values);
        dronsHoras.sort((p2, p1) -> Double.compare(p1.getHoras(), p2.getHoras()));

        return dronsHoras;
    }

    @Override
    public List<Pilot> pilotByHours() {
        Collection<Pilot> values = p.values();
        ArrayList<Pilot> pilotHoras = new ArrayList<Pilot>(values);
        pilotHoras.sort((p2, p1) -> Double.compare(p1.getHoras(), p2.getHoras()));

        return pilotHoras;
    }

    @Override
    public void saveDron(String id) {
        Drons dr = d.get(id);
        d.remove(id);
        mantenimiento.offer(dr);
        logger.info("Se ha llevado a mantenimiento el dron con id:" + dr.getId());

    }

    @Override
    public void repairDron() {
        Drons drone = mantenimiento.poll();
        String id = drone.getId();
        d.put(id, drone);
        logger.info("El dron con id:" + id + " ya está disponible");

    }

    @Override
    public void reservar(String id_dron, int dia, int hora, int duracion, double lat_in, double lon_in, double lat_fin, double lon_fin, String id_piloto) {
        Drons dr = d.get(id_dron);

        if(dr == null){
            logger.warn("El dron escogido no está disponible, no se ha hecho la reserva");

        }
        else if(this.dronDisponible(id_dron,r,hora,duracion,dia)==-1){
            logger.warn("Dron no diponible");
        }
        else if (this.pilotoDisponible(id_piloto,r,hora,duracion,dia)==-1) {
            logger.warn("Piloto no disponible");


        }
        else{
            dr.setHoras(duracion);
            Pilot pt = p.get(id_piloto);
            pt.setHoras(duracion);
            reserva res = new reserva(id_dron,dia,hora,duracion,lat_in,lon_in,lat_fin,lon_fin,id_piloto);
            r.add(res);
            logger.info("Se ha completado la reserva");
        }
    }

    @Override
    public List<reserva> reservasByPilot(String id) {
        ArrayList<reserva> reservaPiloto = new ArrayList<reserva>();
        int i = 0;
        while(i<r.size()){
           reserva res = r.get(i);
           if(Objects.equals(res.getId_piloto(), id)){
               reservaPiloto.add(res);

           }
            i++;
        }
        return reservaPiloto;
    }

    @Override
    public List<reserva> reservasByDrone(String id) {
        ArrayList<reserva> reservaDron = new ArrayList<reserva>();
        int i = 0;
        while(i<r.size()){
            reserva res = r.get(i);
            if(Objects.equals(res.getId_dron(), id)){
                reservaDron.add(res);

            }
            i++;
        }
        return reservaDron;
    }
    public int pilotoDisponible(String id, List<reserva> r, int hora, int duracion, int dia){
        int f = 0;
        int i = 0;
        while(i<r.size()){
            reserva res = r.get(i);
            if(Objects.equals(res.getId_piloto(),id)){
                if(Objects.equals(res.getDia(), dia)){
                    if(Objects.equals(res.getHora(),hora)){
                        f=-1;
                    }
                    if(hora<res.getHora()){
                        if ((hora + duracion) > res.getHora()) {
                            f=-1;

                        }

                    }
                    if(hora>res.getHora()){
                        if ((res.getHora() + res.duracion) < hora) {
                            f=-1;

                        }
                    }
                }
            }
            i++;


        }

        return f;

    }
    public int dronDisponible(String id, List<reserva> r, int hora, int duracion, int dia){
        int f = 0;
        int i = 0;
        while(i<r.size()){
            reserva res = r.get(i);
            if(Objects.equals(res.getId_dron(), id)){
                if(Objects.equals(res.getDia(), dia)){
                    if(Objects.equals(res.getHora(),hora)){
                        f=-1;
                    }
                    if(hora<res.getHora()){
                        if ((hora + duracion) > res.getHora()) {
                            f=-1;

                        }

                    }
                    if(hora>res.getHora()){
                        if ((res.getHora() + res.duracion) < hora) {
                            f=-1;

                        }
                    }
                }

            }
            i++;


        }

        return f;

    }
}
