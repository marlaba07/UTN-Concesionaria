package Servicio.Impl;

import Excepcion.VehiculoException;
import Modelo.Vehiculo;
import Servicio.ConcesionariaServicio;
import Utilidades.JSON;

import java.util.*;

public class ConcesionariaServicioImpl implements ConcesionariaServicio {

    private static final String JSON_FILE_VEHICULOS = "Backend/Archivos/vehiculos.json";
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

    public Vehiculo agregarVehiculo(Vehiculo v) throws VehiculoException {
        try {
            // Ejemplo de nuestra regla de negocio, solo queremos vehículos "modernos"
            if (v.getAnio() >= 2000) {
                // Obtener la lista actual de vehículos desde el JSON
                Map<Integer, Vehiculo> listaVehiculo = obtenerTodosVehiculos();

                // Obtener el último ID registrado
                int ultimoId = listaVehiculo.isEmpty() ? 0 : Collections.max(listaVehiculo.keySet());

                // Generar un nuevo ID autoincremental
                int nuevoId = ultimoId + 1;
                v.setId(nuevoId);

                // Agregar el vehículo a la lista
                listaVehiculo.put(nuevoId, v);

                // Guardar la lista actualizada en el archivo JSON
                JSON.guardarJson(JSON_FILE_VEHICULOS, new ArrayList<>(listaVehiculo.values()));

                return v;
            } else {
                throw new VehiculoException("Error: el vehículo es antiguo, la concesionaria solo puede tener modelos mayores al año 2000");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new VehiculoException("Error al intentar agregar un vehículo: " + e.getMessage());
        }
    }

    @Override
    public HashMap<Integer, Vehiculo> obtenerTodosVehiculos() throws VehiculoException {
        try {
            // Importar el JSON a una lista de objetos de Vehiculo usando la función importarJson
            List<Vehiculo> vehiculosList = JSON.importarJson(JSON_FILE_VEHICULOS, Vehiculo.class);

            // Convertir la lista de vehículos en un HashMap
            HashMap<Integer, Vehiculo> vehiculosMap = new HashMap<>();
            for (Vehiculo vehiculo : vehiculosList) {
                vehiculosMap.put(vehiculo.getId(), vehiculo);
            }

            return vehiculosMap;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new VehiculoException("Error al intentar obtener todos los vehículos: " + e.getMessage());
        }
    }

    @Override
    public Vehiculo obtenerVehiculoPorID(int id) throws VehiculoException {
        try{
            // Si el HashMap está vacío, cargar todos los vehículos desde el JSON
            if(listaVehiculo.isEmpty())
                listaVehiculo = obtenerTodosVehiculos();

            // Obtengo el vehiculo por el id
            Vehiculo vehiculo = listaVehiculo.get(id);

            // Sí se encuentra lo retorno, sino lanzo excepcion
            if(vehiculo != null) return vehiculo;
            else throw new VehiculoException("Vehículo no encontrado con el ID: " + id);

        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new VehiculoException("Error al intentar obtener el vehículo por ID: " + e.getMessage());
        }
    }

    public HashMap<Integer, Vehiculo> obtenerVehiculosPorMarca(String marca) throws VehiculoException {
        try {
            // Si el HashMap está vacío, cargar todos los vehículos desde el JSON
            if (listaVehiculo.isEmpty())
                listaVehiculo = obtenerTodosVehiculos();

            HashMap<Integer, Vehiculo> vehiculosEncontrados = new HashMap<>();

            // Iterar sobre el HashMap para encontrar vehículos por marca
            for (Map.Entry<Integer, Vehiculo> entry : listaVehiculo.entrySet()) {
                Vehiculo vehiculo = entry.getValue();
                if (vehiculo.getMarca().equalsIgnoreCase(marca))
                    vehiculosEncontrados.put(entry.getKey(), vehiculo);
            }

            // Si no se encontró ningún vehículo con la marca especificado, lanzar excepción
            if (vehiculosEncontrados.isEmpty())
                throw new VehiculoException("No se encontraron vehículos con la marca: " + marca);

            return vehiculosEncontrados;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new VehiculoException("Error al intentar obtener los vehículos con la marca: " + e.getMessage());
        }
    }

    @Override
    public HashMap<Integer, Vehiculo> actualizarVehiculo(int id, Vehiculo v) throws VehiculoException {
        try {
            // Si el HashMap está vacío, cargar todos los vehículos desde el JSON
            if (listaVehiculo.isEmpty())
                listaVehiculo = obtenerTodosVehiculos();

            boolean encontrado = false;

            // Iterar sobre la lista de vehículos para actualizar el vehículo con el ID dado
            for (Map.Entry<Integer, Vehiculo> entry : listaVehiculo.entrySet()) {
                int vehiculoId    = entry.getKey();
                Vehiculo vehiculo = entry.getValue();

                if (vehiculoId == id) {
                    vehiculo.setMarca(v.getMarca());
                    vehiculo.setModelo(v.getModelo());
                    vehiculo.setColor(v.getColor());
                    vehiculo.setAnio(v.getAnio());
                    vehiculo.setPrecio(v.getPrecio());
                    vehiculo.setStock(v.getStock());
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado)
                throw new VehiculoException("El vehículo con el ID " + id + " no existe en la lista.");

            // Guardar la lista actualizada en el archivo JSON
            JSON.guardarJson(JSON_FILE_VEHICULOS, new ArrayList<>(listaVehiculo.values()));

            return listaVehiculo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new VehiculoException("Error al intentar actualizar el vehiculo: " + e.getMessage());
        }
    }

    @Override
    public void eliminarVehiculo(int id) throws VehiculoException {
        try {
            // Si el HashMap está vacío, cargar todos los vehículos desde el JSON
            if (listaVehiculo.isEmpty())
                listaVehiculo = obtenerTodosVehiculos();

            Vehiculo vehiculoEliminado = listaVehiculo.remove(id);

            if (vehiculoEliminado == null)
                throw new VehiculoException("El vehículo con el ID " + id + " no existe en la lista.");
            else
                // Guardar la lista actualizada en el archivo JSON
                JSON.guardarJson(JSON_FILE_VEHICULOS, new ArrayList<>(listaVehiculo.values()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new VehiculoException("Error al intentar eliminar el vehículo: " + e.getMessage());
        }
    }
}
