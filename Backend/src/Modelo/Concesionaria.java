package Modelo;
import java.util.HashMap;
import java.util.Map;

public class Concesionaria {
    private String nombre;
    private String direccion;
    private Integer telefono;
    private Map<Integer, Vehiculo> vehiculos;

    public Concesionaria(){}

    public Concesionaria(String nombre, String direccion, Integer telefono) {
        this.nombre    = nombre;
        this.direccion = direccion;
        this.telefono  = telefono;
        this.vehiculos = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Map<Integer, Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Map<Integer, Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Concesionaria{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
