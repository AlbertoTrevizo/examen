import factories.implementations.DaoCiudad;
import factories.implementations.DaoPlaza;
import models.Ciudad;
import models.Plaza;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PlazaTest {
    public static Long id = new Long("2");
    public static Long id_ciudad = new Long("1");
    @Test
    public void CreateTest(){
        DaoCiudad daoCiudad = new DaoCiudad();
        DaoPlaza daoPlaza = new DaoPlaza(daoCiudad);
        Ciudad ciudad = daoPlaza.getDaoCiudad().read(id_ciudad);
        Plaza plaza = new Plaza(id, "Otra nueva", ciudad);
        daoPlaza.create(plaza);
    }

    @Test
    public void ReadTest(){
        DaoPlaza daoPlaza = new DaoPlaza();
        List<Plaza> plazas = daoPlaza.read("");
        Assert.assertNotNull(plazas);
        for (Plaza plaza : plazas){
            System.out.println(plaza.getCategoria());
        }
    }

    @Test
    public void ReadByIdTest(){
        DaoCiudad daoCiudad = new DaoCiudad();
        DaoPlaza daoPlaza = new DaoPlaza(daoCiudad);
        Plaza plaza = daoPlaza.read(id);
        Assert.assertNotNull(plaza);
        System.out.println(plaza.getCategoria());
    }

    @Test
    public void UpdateTest(){
        DaoPlaza daoPlaza = new DaoPlaza();
        Plaza plaza = daoPlaza.read(id);
        plaza.setCategoria("Vieja");
        daoPlaza.update(plaza);
        System.out.println(plaza.getCategoria());
    }

    @Test
    public void DeleteTest(){
        DaoCiudad daoCiudad = new DaoCiudad();
        daoCiudad.delete(id);
        Ciudad ciudadToTry = daoCiudad.read(id);
        Assert.assertNull(ciudadToTry);
    }
}
