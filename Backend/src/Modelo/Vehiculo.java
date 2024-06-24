package Modelo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Automovil.class, name = "automovil"),
        @JsonSubTypes.Type(value = Moto.class, name      = "moto")
})

public abstract class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private String color;
    private Integer anio;
    private Double precio;
    private Integer stock;
    private String tipo;

    public Vehiculo(){}

    public Vehiculo(int id, String marca, String modelo, String color, Integer anio, Double precio, Integer stock, String tipo) {
        this.id     = id;
        this.marca  = marca;
        this.modelo = modelo;
        this.color  = color;
        this.anio   = anio;
        this.precio = precio;
        this.stock  = stock;
        this.tipo   = tipo;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", anio=" + anio +
                ", precio=" + precio +
                ", stock=" + stock +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
