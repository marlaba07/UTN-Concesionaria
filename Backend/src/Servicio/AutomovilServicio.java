package Servicio;


import Modelo.Automovil;

import java.util.List;

public interface AutomovilServicio {
    Automovil crearAutomovil(Automovil A);
    Automovil traerAutomovil(int id);
    List<Automovil> getAll();
    Automovil actualizarAutomovil(int id, Automovil A);
    void eliminarAutomovil(int id);
}
