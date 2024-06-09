package Modelo;
import Modelo.Enums.TipoAutomovil;

public class Automovil extends Vehiculo{
    private int cantPuertas;
    private TipoAutomovil tipo;

    public Automovil(int id, String marca, String modelo, String color, Integer anio, Double precio, int cantPuertas, Integer stock,TipoAutomovil tipo) {
        super(id, marca, modelo, color, anio, precio, stock);
        this.cantPuertas = cantPuertas;
        this.tipo = tipo;
    }

    public int getCantPuertas() {
        return cantPuertas;
    }

    public void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }

    public TipoAutomovil getTipo() { return tipo;}

    public void setTipo(TipoAutomovil tipo) {this.tipo = tipo;}

    @Override
    public String toString() {
        return "Auto: \nMarca: " + getMarca() + " - Modelo: " + getModelo() + " (" + getAnio() + ") - Color: " + getColor() + " - Precio: $" + getPrecio() +
                " - Stock: " + getStock() + " - " + cantPuertas + " puertas";
    }


}
