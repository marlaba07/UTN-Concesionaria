package Modelo;

public class Moto extends Vehiculo {
    private Double cilindrada;

    // Constructor por defecto: Jackson me pide un constructor vacio, pero necesito setearle un tipo por defecto tambien
    public Moto() {
        // Establece el tipo automáticamente en el constructor por defecto
        setTipo("moto");
    }

    public Moto(int id, String marca, String modelo, String color, Integer anio, Double precio, Integer stock, Double cilindrada) {
        super(id, marca, modelo, color, anio, precio, stock, "moto");
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
        return "Moto{" +
                "cilindrada=" + cilindrada +
                '}';
    }
}
