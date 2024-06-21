package Modelo.Enums;

import Excepcion.VehiculoException;
import Vista.Menu;

public enum TipoAutomovil {
    UTILITARIO,
    DEPORTIVO,
    ESTANDAR;

    public static class Main {
        public static void main(String[] args) throws Exception, VehiculoException {
            Menu.menu();
        }
    }
}
