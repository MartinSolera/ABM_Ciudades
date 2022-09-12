package main;

import datos.CiudadDAOImplementss;
import domain.CiudadDTO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CiudadDAOImplementss ciudadDAO = new CiudadDAOImplementss();

        ///AGREGAR CIUDAD
        ciudadDAO.insertarCiudad();

        ///VER LISTA CIUDADAES
        List<CiudadDTO> listaCiudades = ciudadDAO.verCiudades();
        ciudadDAO.mostarCiudades(listaCiudades);

        ///BORRAR CIUDAD
        System.out.println("BORRANDO CIUDAD");
        ciudadDAO.borrarCiudad();

        ///VER LISTA CIUDADAES
        List<CiudadDTO> nuevaLista = ciudadDAO.verCiudades();
        ciudadDAO.mostarCiudades(nuevaLista);

    }




}
