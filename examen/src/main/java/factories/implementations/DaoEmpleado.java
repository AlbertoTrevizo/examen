package factories.implementations;

import conection.Conexion;
import factories.interfaces.EmpleadoDao;
import models.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoEmpleado implements EmpleadoDao{


    @Override
    public void create(Empleado obj) {

    }

    @Override
    public List<Empleado> read(String criteria) {
        List<Empleado> empleados = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            Statement st = conexion.getConn().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",Empleado.Q_ALL, criteria));
            while(rs.next()){
                empleados.add(makeEmpleado(rs));
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return empleados;
    }

    @Override
    public Empleado read(Long id) {
        return null;
    }

    @Override
    public void update(Empleado obj) {

    }

    @Override
    public void delete(Long id) {

    }

    private Empleado makeEmpleado(ResultSet rs) throws SQLException {
        Empleado  empleado = new Empleado();
        Integer i = 1;
        empleado.setId((int) rs.getLong(i++));
        empleado.setNombre(rs.getString(i++));
        empleado.setApellido(rs.getString(i++));
        empleado.setFecha_nacimiento(rs.getString(i++));
        empleado.setGerente_id(Integer.valueOf(rs.getString(i++)));
        empleado.setPlaza_id(Integer.valueOf(rs.getString(i++)));
        return empleado;
    }
}
