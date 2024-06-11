package Modelo;
import Modelo.Enums.TipoAutomovil;

public class Automovil extends Vehiculo{
    private int cantPuertas;
    private TipoAutomovil tipo;

    public Automovil(){

    }

    public Automovil(int id, String marca, String modelo, String color, Integer anio, Double precio, Integer stock, String tipo, int cantPuertas, TipoAutomovil tipo1) {
        super(id, marca, modelo, color, anio, precio, stock, tipo);
        this.cantPuertas = cantPuertas;
        this.tipo = tipo1;
    }

    public int getCantPuertas() {
        return cantPuertas;
    }

    public void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }
}