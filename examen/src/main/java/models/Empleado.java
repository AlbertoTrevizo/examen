package models;

import java.util.Date;

public class Empleado extends Model{

    public static final String FIELDS = "id, nombre, apellido, fecha_nacimiento, gerente_id, plaza_id";
    public static final String TABLE = "empleados";
    public static final String Q_ALL = String.format("SELECT %s FROM %s", FIELDS, TABLE);
    public static final String Q_BY_ID = String.format("%s WHERE country_id = ", Q_ALL);
    public static final String INSERT = String.format("INSERT INTO %s (%s) VALUES%s", TABLE, FIELDS, fieldsToInsert(6));
    public static final String UPDATE = String.format("UPDATE %s SET nombre = ?, apellido = ?, fecha_nacimiento =?, gerente_id =?, plaza_id =? WHERE country_id =", TABLE);
    public static final String DELETE = String.format("DELETE FROM %s WHERE country_id = ?", TABLE);

    private Integer id;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private Integer gerente_id;
    private Integer plaza_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getGerente_id() {
        return gerente_id;
    }

    public void setGerente_id(Integer gerente_id) {
        this.gerente_id = gerente_id;
    }

    public Integer getPlaza_id() {
        return plaza_id;
    }

    public void setPlaza_id(Integer plaza_id) {
        this.plaza_id = plaza_id;
    }
}
