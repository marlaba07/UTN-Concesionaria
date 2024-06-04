package Model;

public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private Double salario;

    public Empleado(int id, String nombre, String puesto, Double salario) {
        this.id      = id;
        this.nombre  = nombre;
        this.puesto  = puesto;
        this.salario = salario;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
