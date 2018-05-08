import factories.implementations.DaoCiudad;
import factories.interfaces.CiudadDao;
import models.Ciudad;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CiudadTest {

    public static Long id = new Long("3");
    @Test
    public void CreateTest(){
        DaoCiudad daoCiudad = new DaoCiudad();
        Ciudad ciudad = new Ciudad(id, "Parral", true);
        daoCiudad.create(ciudad);
        Ciudad ciudadToTry = daoCiudad.read(id);
        System.out.println(ciudadToTry.getId());
        System.out.println(ciudadToTry.getNombre());
    }

    @Test
    public void ReadTest(){
        DaoCiudad daoCiudad = new DaoCiudad();
        List<Ciudad> ciudades = daoCiudad.read("");
        Assert.assertNotNull(ciudades);
        for (Ciudad ciudad : ciudades){
            System.out.println(ciudad.getNombre());
            Assert.assertNotNull(ciudad);
        }
    }

    @Test
    public void ReadByIdTest(){
        DaoCiudad daoCiudad = new DaoCiudad();
        Ciudad ciudad = daoCiudad.read(id);
        Assert.assertNotNull(ciudad);
        System.out.println(ciudad.getNombre());
    }

    @Test
    public void dUpdateTest(){
        DaoCiudad daoCiudad = new DaoCiudad();
        Ciudad ciudad = daoCiudad.read(id);
        ciudad.setNombre("Cuauhtemoc");
        daoCiudad.update(ciudad);
        System.out.println(ciudad.getNombre());
    }

    @Test
    public void eDeleteTest(){
        DaoCiudad daoCiudad = new DaoCiudad();
        daoCiudad.delete(id);
        Ciudad ciudadToTry = daoCiudad.read(id);
        Assert.assertNull(ciudadToTry);
    }
}
