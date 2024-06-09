package Servicio.Impl;

import Excepcion.VehiculoException;
import Modelo.Vehiculo;
import Servicio.ConcesionariaServicio;

import java.util.HashMap;
import java.util.Map;

public class ConcesionariaServicioImpl implements ConcesionariaServicio {
    private HashMap<Integer, Vehiculo> listaVehiculo;

    public ConcesionariaServicioImpl(HashMap<Integer, Vehiculo> listaVehiculo){
        this.listaVehiculo = listaVehiculo;
    }

    public ConcesionariaServicioImpl(){
        listaVehiculo = new HashMap<Integer, Vehiculo>();
    }

    public HashMap<Integer, Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(HashMap<Integer, Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    @Override
    public Vehiculo agregarVehiculo(Vehiculo v) throws VehiculoException {
        try {
            // Ejemplo de nuestra regla de negocio, solo queremos vehiculos "modernos"
            if (v.getAnio() >= 2000) {
                listaVehiculo.put(v.getId(), v);
                return v;
            } else {
                throw new VehiculoException("Error: el vehiculo es antiguo, la concesionaria solo puede tener modelos mayores al año 2.000");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public HashMap<Integer, Vehiculo> obtenerTodosVehiculos() throws VehiculoException {
        try{
            return listaVehiculo;
        } catch (Exception e){
            throw new VehiculoException("Error al intentar obtener todos los vehículos: " + e.getMessage());
        }
    }

    @Override
    public Vehiculo obtenerVehiculo(int id) throws VehiculoException {
        try{
            for (Map.Entry<Integer, Vehiculo> entry : listaVehiculo.entrySet()) {
                int actualId      = entry.getKey();
                Vehiculo vehiculo = entry.getValue();

                if (actualId == id) {
                    return vehiculo;
                }
            }

            throw new VehiculoException("Vehículo no encontrado con el ID: " + id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public HashMap<Integer, Vehiculo> actualizarVehiculo(int id, Vehiculo v) throws VehiculoException {
        try {
            for (Map.Entry<Integer, Vehiculo> entry : listaVehiculo.entrySet()) {
                int vehiculoId = entry.getKey();
                Vehiculo vehiculo = entry.getValue();

                if (vehiculoId == id) {
                    vehiculo.setMarca(v.getMarca());
                    vehiculo.setModelo(v.getModelo());
                    vehiculo.setColor(v.getColor());
                    vehiculo.setAnio(v.getAnio());
                    vehiculo.setPrecio(v.getPrecio());

                    return listaVehiculo;
                }
            }

            throw new VehiculoException("El vehículo con el ID " + id + " no existe en la lista.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void eliminarVehiculo(int id) throws VehiculoException {
        try {
            boolean vehiculoEncontrado = false;
            for (Map.Entry<Integer, Vehiculo> entry : listaVehiculo.entrySet()) {
                int vehiculoId = entry.getKey();
                Vehiculo vehiculo = entry.getValue();

                if (vehiculoId == id) {
                    listaVehiculo.remove(vehiculoId);
                    vehiculoEncontrado = true;
                    break;
                }
            }

            if (!vehiculoEncontrado) {
                throw new VehiculoException("El vehículo con el ID " + id + " no existe en la lista.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
