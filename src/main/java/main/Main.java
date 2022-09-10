package main;

import datos.CiudadDAOImplementss;
import domain.CiudadDTO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CiudadDAOImplementss ciudadDAO = new CiudadDAOImplementss();

        ///AGREGAR CIUDAD
        ciudadDAO.insertarCiudad();

        ///VER LISTA CIUDADAES
        List<CiudadDTO> listaCiudades = ciudadDAO.verCiudades();
        mostarCiudades(listaCiudades);


    }

    public static void mostarCiudades(List<CiudadDTO> listaCiudades){
        int i = 0;
        for(CiudadDTO ciudad : listaCiudades){
            i++;
            System.out.println("Ciudad Nro: " + i);
            mostrarCiudad(ciudad);
        }
    }

    public static void mostrarCiudad(CiudadDTO ciudad){
        System.out.println("ID: " + ciudad.getId_ciudad());
        System.out.println("Nombre Ciudad: " + ciudad.getNombre());
        System.out.println("Pais: " + ciudad.getPais());
        System.out.println("Año Visitada: " + ciudad.getAnio_visitada());
        System.out.println("Año Visitada: " + ciudad.getVeces_visitada());
        System.out.println("La visitaste con: " + ciudad.getCompas());
        System.out.println("----------------");
    }


}
