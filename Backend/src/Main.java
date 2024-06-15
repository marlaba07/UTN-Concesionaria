import Vista.Menu;

import java.util.List;

import static Utilidades.JSON.guardarJson;
import static Utilidades.JSON.importarJson;

import Excepcion.VehiculoException;

public class Main {
    //private static final String JSON_FILE_USUARIOS  = "Backend/Archivos/usuarios.json";
    //private static final String JSON_FILE_VEHICULOS = "Backend/Archivos/empleados.json";
    //private static final String JSON_FILE_VEHICULOS = "Backend/Archivos/vehiculos.json";

    public static void main(String[] args) throws Exception, VehiculoException {
        Menu.menu();

        // Importar JSON de personas
        //List<Persona> personasFromJson = importarJson(JSON_FILE_USUARIOS, Persona.class);

        // Imprimir detalles de las personas
        //for (Persona persona : personasFromJson) {
        //    System.out.println("Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad());
        //}

        // Importar JSON de otra clase (Ejemplo: Empleado)
        //List<Empleado> empleadosFromJson = importarJson(JSON_FILE_EMPLEADOS, Empleado.class);

        // Imprimir detalles de los empleados
        //for (Empleado empleado : empleadosFromJson) {
        //    System.out.println("Nombre: " + empleado.getNombre() + ", Cargo: " + empleado.getCargo());
        //}

        // Crear un nuevo objeto Persona y agregarlo a la lista
        //Persona nuevaPersona = new Persona("Nuevo", 30);
        //personasFromJson.add(nuevaPersona);

        // Guardar la lista actualizada en el archivo JSON
        //guardarJson(JSON_FILE_USUARIOS, personasFromJson);
    }
}

