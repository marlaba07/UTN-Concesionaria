package Modelo;

public class Moto extends Vehiculo{
    private Double cilindrada;

    public Moto(int id, String marca, String modelo, String color, Integer anio, Double precio, Double cilindrada, Integer stock) {
        super(id, marca, modelo, color, anio, precio, stock);
        this.cilindrada = cilindrada;
    }

    public Double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Double cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Moto: \nMarca: " + getMarca() + " - Modelo: " + getModelo() + " (" + getAnio() + ") - Color: " + getColor() + " - Precio: $" + getPrecio() +
                " - Stock: " + getStock() + " - Cilindrada: " + cilindrada + " cc";

    }
}
