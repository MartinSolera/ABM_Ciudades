package datos;

import domain.CiudadDTO;

import java.util.ArrayList;
import java.util.List;

public interface ICiudadDAO {

     List<CiudadDTO> verCiudades();

     void insertarCiudad();

     void borrarCiudad();

     String buscarCiudad();

    CiudadDTO crearCiudad();

    ArrayList<CiudadDTO> recorrerYcopiar();


}
