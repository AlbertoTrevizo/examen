import conection.Conexion;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.logging.Logger;

public class ConectionTest {
    @Test
    public void conecctionSingletonTest(){
        try{
            Conexion con = Conexion.getInstance();
            Assert.assertFalse(con.getConn().isClosed());
        }catch (ClassNotFoundException | SQLException ex){
            Logger.getAnonymousLogger().warning("La conexión es invalida.");
        }
    }
}
