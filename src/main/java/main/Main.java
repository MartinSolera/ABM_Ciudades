package main;

import datos.CiudadDAOImplementss;
import domain.CiudadDTO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CiudadDAOImplementss ciudadDAO = new CiudadDAOImplementss();

        boolean salir = false;
        int opcion;

        while(!salir){

            System.out.println("1 - Listar Ciudades");
            System.out.println("2 - Cargar Ciudad");
            System.out.println("3 - Borrar Ciudad");
            System.out.println("4 - Modificar");
            System.out.println("5 - Buscar datos Ciudad");
            System.out.println("6 - Buscar ciudad por Año");
            System.out.println("7 - Salir");

            try{

            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    List<CiudadDTO> listaCiudades = ciudadDAO.verCiudades();
                    ciudadDAO.mostarCiudades(listaCiudades);
                    break;
                case 2:
                    ciudadDAO.insertarCiudad();
                    break;
                case 3:
                    ciudadDAO.borrarCiudad();
                    break;
                case 4:
                    int idCiudad = ciudadDAO.buscarPorNombreIDciudad();
                    if(idCiudad != 0){
                        CiudadDTO nuevaCiudad = ciudadDAO.crearCiudad();
                        ciudadDAO.update(nuevaCiudad,idCiudad);
                    }
                    break;
                case 5:
                    CiudadDTO ciudadBuscada = ciudadDAO.buscarCiudadPorNombre();
                    ciudadDAO.mostrarCiudad(ciudadBuscada);

                    break;
                case 6:
                    ArrayList<CiudadDTO> listaCiudadAnio = ciudadDAO.buscarCiudadPorAnio();
                    ciudadDAO.mostarCiudades(listaCiudadAnio);
                    if(listaCiudadAnio.isEmpty()){
                        System.out.println("No visito ningun pais ese año");
                    }


                case 7:
                    salir = true;
                    break;
            }
            } catch (InputMismatchException e){
                System.out.println("Debes introducir un numero entre 1-5");
                sc.next();
            }
        }






    }




}
