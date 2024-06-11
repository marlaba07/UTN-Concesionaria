package Modelo;

public class Moto extends Vehiculo{
    private Double cilindrada;

    public Moto(){

    }

    public Moto(int id, String marca, String modelo, String color, Integer anio, Double precio, Integer stock, String tipo, Double cilindrada) {
        super(id, marca, modelo, color, anio, precio, stock, tipo);
        this.cilindrada = cilindrada;
    }

    public Double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Double cilindrada) {
        this.cilindrada = cilindrada;
    }
}
