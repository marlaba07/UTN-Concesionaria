package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concesionaria {
    private String nombre;
    private String direccion;
    private Integer telefono;
    private List<Vehiculo> vehiculos;
    private List<Venta> ventas;
    private Map<Integer, Cliente> clientes;
    private Map<Integer, Empleado> empleados;

    public Concesionaria(String nombre, String direccion, Integer telefono) {
        this.nombre    = nombre;
        this.direccion = direccion;
        this.telefono  = telefono;
        this.vehiculos = new ArrayList<>();
        this.clientes  = new HashMap<>();
        this.ventas    = new ArrayList<>();
        this.empleados = new HashMap<>();
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public Map<Integer, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Map<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    public Map<Integer, Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Map<Integer, Empleado> empleados) {
        this.empleados = empleados;
    }
}
