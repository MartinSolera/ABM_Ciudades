package datos;

import domain.CiudadDTO;

import java.util.List;

public interface ICiudadDAO {

    public List<CiudadDTO> verCiudades();

    public void insertarCiudad();

    public void borrarCiudad();

}
