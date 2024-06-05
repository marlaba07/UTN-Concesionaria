package Modelo;

import java.util.Date;

public class Venta {
    private int id;
    private Date fecha;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private Double total;

    public Venta(int id, Date fecha, Vehiculo vehiculo, Cliente cliente, Double total) {
        this.id       = id;
        this.fecha    = fecha;
        this.vehiculo = vehiculo;
        this.cliente  = cliente;
        this.total    = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
