import Modelo.Automovil;
import Modelo.Concesionaria;
import Modelo.Enums.TipoAutomovil;
import Modelo.Moto;
import Modelo.Vehiculo;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Concesionaria concesionaria = new Concesionaria("asd","asd123",1551111);
        // Crear algunos Automoviles
        Automovil auto1 = new Automovil(1, "Toyota", "Corolla", "Rojo", 2020, 20000.0, 5, 4, TipoAutomovil.UTILITARIO);
        Automovil auto2 = new Automovil(2, "Honda", "Civic", "Azul", 2019, 22000.0, 3, 4,TipoAutomovil.DEPORTIVO);

        // Crear algunas Motos
        Moto moto1 = new Moto(3, "Yamaha", "MT-07", "Negro", 2021, 7500.0, 2.0, 689);
        Moto moto2 = new Moto(4, "Kawasaki", "Ninja 400", "Verde", 2022, 8000.0, 4.0, 399);

        // Agregar Automoviles y Motos a la concesionaria
        concesionaria.agregarVehiculo(auto1);
        concesionaria.agregarVehiculo(auto2);
        concesionaria.agregarVehiculo(moto1);
        concesionaria.agregarVehiculo(moto2);

        // Mostrar todos los vehículos en la concesionaria por consola
        Map<Integer, Vehiculo> vehiculos = concesionaria.listarVehiculos();
        for (Vehiculo vehiculo : vehiculos.values()) {
            System.out.println(vehiculo);
        }
    }

    }
