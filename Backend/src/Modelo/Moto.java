package Modelo;

public class Moto extends Vehiculo{
    private Double cilindrada;

    public Moto(int id, String marca, String modelo, String color, Integer anio, Double precio, Double cilindrada) {
        super(id, marca, modelo, color, anio, precio);
        this.cilindrada = cilindrada;
    }

    public Double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Double cilindrada) {
        this.cilindrada = cilindrada;
    }
}
