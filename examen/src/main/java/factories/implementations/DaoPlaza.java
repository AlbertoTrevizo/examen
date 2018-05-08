package factories.implementations;

import conection.Conexion;
import factories.interfaces.CiudadDao;
import factories.interfaces.PlazaDao;
import models.Plaza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPlaza implements PlazaDao{
    private DaoCiudad daoCiudad;

    public DaoPlaza(DaoCiudad daoCiudad){this.daoCiudad = daoCiudad; }

    public DaoPlaza() {
    }

    @Override
    public void create(Plaza obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn().prepareStatement(Plaza.INSERT);
            Integer i =1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getCategoria());
            ps.setLong(i++, obj.getCiudad().getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    @Override
    public List<Plaza> read(String criteria) {
        List<Plaza> paises = new ArrayList<>();
        try {
            Conexion conexion = Conexion.getInstance();
            Statement st = conexion.getConn().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",Plaza.Q_ALL, criteria));
            while(rs.next()){
                paises.add(makePlaza(rs));
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return paises;
    }

    @Override
    public Plaza read(Long id) {
        Plaza plaza = null;
        try {
            Connection conexion = Conexion.getInstance().getConn();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s",Plaza.Q_BY_ID, id));
            if(rs.next()){
                plaza = makePlaza(rs);
            }
        }catch (ClassNotFoundException | SQLException ex){

        }
        return plaza;
    }

    @Override
    public void update(Plaza obj) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn()
                    .prepareStatement(String.format("%s %s",Plaza.UPDATE, obj.getId()));
            Integer i =1;
            ps.setLong(i++, obj.getId());
            ps.setString(i++, obj.getCategoria());
            ps.setLong(i++, obj.getCiudad().getId());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    @Override
    public void delete(Long id) {
        try {
            Conexion conexion = Conexion.getInstance();
            PreparedStatement ps = conexion.getConn()
                    .prepareStatement(Plaza.DELETE);
            Integer i =1;
            ps.setLong(i++, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    private Plaza makePlaza(ResultSet rs) throws SQLException {
        Plaza plaza = new Plaza();
        Integer i = 1;
        plaza.setId(rs.getLong(i++));
        plaza.setCategoria(rs.getString(i++));
        Long ciudadId = rs.getLong(i++);
        plaza.setCiudad(daoCiudad.read(ciudadId));
        return plaza;
    }

    public DaoCiudad getDaoCiudad() {
        return daoCiudad;
    }

    public void setDaoCiudad(DaoCiudad daoCiudad) {
        this.daoCiudad = daoCiudad;
    }
}
