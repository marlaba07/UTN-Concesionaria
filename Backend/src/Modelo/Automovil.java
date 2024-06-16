package Modelo;
import Model.Enums.TipoAutomovil;

public class Automovil extends Vehiculo {
    private int cantPuertas;
    private TipoAutomovil tipoAutomovil;

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
}
