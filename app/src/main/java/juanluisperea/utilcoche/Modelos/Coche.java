package juanluisperea.utilcoche.Modelos;

/**
 * Created by TorreJL on 19/04/2017.
 */

public class Coche {

    private int id;
    private String nombre;
    private String combustible;
    private int kilometros;
    private String actualizacion;
    private Mantenimiento mantenimiento;
    private PeriodosMantenimiento periodosMantenimiento;

    public Coche() {
    }

    public Coche(int id, String nombre, String combustible, int kilometros, String actualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.combustible = combustible;
        this.kilometros = kilometros;
        this.actualizacion = actualizacion;
    }


    public String getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(String actualizacion) {
        this.actualizacion = actualizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public PeriodosMantenimiento getPeriodosMantenimiento() {
        return periodosMantenimiento;
    }

    public void setPeriodosMantenimiento(PeriodosMantenimiento periodosMantenimiento) {
        this.periodosMantenimiento = periodosMantenimiento;
    }
}
