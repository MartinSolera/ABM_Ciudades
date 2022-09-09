package main;

import datos.CiudadDAOImplementss;
import domain.CiudadDTO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CiudadDAOImplementss ciudadDAO = new CiudadDAOImplementss();
        List<CiudadDTO> listaCiudades = ciudadDAO.verCiudades();
        mostarPersona(listaCiudades);
    }

    public static void mostarPersona(List<CiudadDTO> listaCiudades){
        int i = 0;
        for(CiudadDTO ciudad : listaCiudades){
            i++;
            System.out.println("Ciudad Nro: " + i);
            System.out.println("ID: " + ciudad.getId_ciudad());
            System.out.println("Nombre Ciudad: " + ciudad.getNombre());
            System.out.println("Pais: " + ciudad.getPais());
            System.out.println("Año Visitada: " + ciudad.getAnio_visitada());
            System.out.println("Año Visitada: " + ciudad.getVeces_visitada());
            System.out.println("La visitaste con: " + ciudad.getCompas());
            System.out.println("----------------");
        }
    }

}
