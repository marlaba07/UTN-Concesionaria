package Modelo;
import Modelo.Enums.TipoAutomovil;

public class Automovil extends Vehiculo {
    private int cantPuertas;
    private TipoAutomovil tipoAutomovil;

    // Constructor por defecto: Jackson me pide un constructor vacio, pero necesito setearle un tipo por defecto tambien
    public Automovil() {
        setTipo("automovil");
    }

    public Automovil(int id, String marca, String modelo, String color, Integer anio, Double precio, Integer stock, String tipo, int cantPuertas, TipoAutomovil tipoAutomovil) {
        super(id, marca, modelo, color, anio, precio, stock, tipo);
        this.cantPuertas = cantPuertas;
        this.tipoAutomovil = tipoAutomovil;
    }

    public int getCantPuertas() {
        return cantPuertas;
    }

    public void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }

    public TipoAutomovil getTipoAutomovil() {
        return tipoAutomovil;
    }

    public void setTipoAutomovil(TipoAutomovil tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "cantPuertas=" + cantPuertas +
                ", tipoAutomovil=" + tipoAutomovil +
                '}';
    }
}
