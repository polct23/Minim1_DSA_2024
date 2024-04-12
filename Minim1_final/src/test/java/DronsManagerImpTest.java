import edu.upc.dsa.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DronsManagerImpTest {
    DronsManager dm;
    @Before
        public void setUp(){
        this.dm = new DronsManagerImp();
        dm.addDron("1", "x1","upc","c3");
        dm.addDron("2", "x2", "upc", "a1");
        dm.addPilot("1", "Pol", "Carreno");
        dm.addPilot("2", "Juan", "Gomez");

    }
    @After
    public void tearDown(){this.dm = null;}

    @Test
    public void reservar(){
        dm.reservar("1",23,16,30,124,231,126,252,"2");

        dm.reservar("1",23,16,30,124,231,126,252,"1");
        //Reservar con dron ya ocupado



    }
    @Test
    public void horasPiloto(){
        dm.reservar("1",23,16,30,124,231,126,252,"1");
        dm.reservar("1",10,16,3,124,231,126,252,"2");
        List<Pilot> pil = dm.pilotByHours();
        Pilot p = pil.get(0);
        Assert.assertEquals("1", p.getId());
    }
    @Test
    public void vuelosPiloto(){
        dm.reservar("1",23,16,30,124,231,126,252,"2");
        dm.reservar("1",10,16,3,124,231,126,252,"2");
        List<reserva> r = dm.reservasByPilot("2");
        reserva res = r.get(0);
        System.out.println(res.getDia());
    }
    @Test
    public void horasDrones(){
        dm.reservar("2",23,16,30,124,231,126,252,"2");
        dm.reservar("1",10,16,3,124,231,126,252,"1");
        List<Drons> pil = dm.dronsByHours();
        Drons d = pil.get(0);
        Assert.assertEquals("2", d.getId());
    }
}
