package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Proovedor {
    private int id;
    private String nombre;
    private Integer telefono;
    private String direccion;
    private List<Vehiculo> vehiculosSuministrados;

    public Proovedor(int id, String nombre, Integer telefono, String direccion) {
        this.id                     = id;
        this.nombre                 = nombre;
        this.telefono               = telefono;
        this.direccion              = direccion;
        this.vehiculosSuministrados = new ArrayList<>();;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Vehiculo> getVehiculosSuministrados() {
        return vehiculosSuministrados;
    }

    public void setVehiculosSuministrados(List<Vehiculo> vehiculosSuministrados) {
        this.vehiculosSuministrados = vehiculosSuministrados;
    }
}
