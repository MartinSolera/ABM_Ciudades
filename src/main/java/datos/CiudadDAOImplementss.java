package datos;

import domain.CiudadDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAOImplementss implements ICiudadDAO {

    private static final String SQL_SELECT = "SELECT * FROM ciudades.ciudad;";

    @Override
    public List<CiudadDTO> verCiudades() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CiudadDTO ciudad = null;
        List<CiudadDTO> listaCiudades = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_ciudades = rs.getInt("id_ciudad");
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");
                int anioVisitada = rs.getInt("anio_visitada");
                int vecesVisitada = rs.getInt("veces_visitada");
                String compas = rs.getString("compas");

                ciudad = new CiudadDTO(id_ciudades, nombre, pais, anioVisitada, vecesVisitada, compas);
                listaCiudades.add(ciudad);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaCiudades;
    }
}
