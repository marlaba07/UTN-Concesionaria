package Servicio;
import Excepcion.VehiculoException;
import Modelo.Vehiculo;
import java.util.Map;

public interface ConcesionariaServicio {
    Vehiculo agregarVehiculo(Vehiculo v) throws VehiculoException;
    Map<Integer, Vehiculo> obtenerTodosVehiculos() throws VehiculoException;
    Map<Integer, Vehiculo> obtenerVehiculosPorMarca(String marca) throws VehiculoException;
    Vehiculo obtenerVehiculoPorID(int id) throws VehiculoException;
    Map<Integer, Vehiculo> actualizarVehiculo(int id, Vehiculo v) throws VehiculoException;
    void eliminarVehiculo(int id) throws VehiculoException;
}
