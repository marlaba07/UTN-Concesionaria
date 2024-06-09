package Modelo;

public abstract class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private String color;
    private Integer anio;
    private Double precio;

    private Integer stock;

    public Vehiculo(int id, String marca, String modelo, String color, Integer anio, Double precio, Integer stock) {
        this.id     = id;
        this.marca  = marca;
        this.modelo = modelo;
        this.color  = color;
        this.anio   = anio;
        this.precio = precio;
        this.stock =stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {return stock;}

    public void setStock(Integer stock) {this.stock = stock;}

    @Override
    public abstract String toString();
}
