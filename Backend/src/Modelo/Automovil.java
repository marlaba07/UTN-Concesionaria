package Modelo;

public class Automovil extends Vehiculo{
    private int cantPuertas;

    public Automovil(int id, String marca, String modelo, String color, Integer anio, Double precio, int cantPuertas) {
        super(id, marca, modelo, color, anio, precio);
        this.cantPuertas = cantPuertas;
    }

    public int getCantPuertas() {
        return cantPuertas;
    }

    public void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }
}
