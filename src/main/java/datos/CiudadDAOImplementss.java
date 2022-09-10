package datos;

import domain.CiudadDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CiudadDAOImplementss implements ICiudadDAO {

    Scanner sc = new Scanner(System.in);

    private static final String SQL_SELECT = "SELECT * FROM ciudades.ciudad;";
    private static final String SQL_INSERT = "INSERT INTO ciudades.ciudad(nombre,pais, anio_visitada, veces_visitada, compas) VALUES (?,?,?,?,?)";

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

    public void insertarCiudad(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            CiudadDTO ciudadNueva = crearCiudad();

            stmt.setString(1,ciudadNueva.getNombre());
            stmt.setString(2,ciudadNueva.getPais());
            stmt.setInt(3, ciudadNueva.getAnio_visitada());
            stmt.setInt(4,ciudadNueva.getVeces_visitada());
            stmt.setString(5, ciudadNueva.getCompas());

            registro = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String solicitarValorString(){
        System.out.println("Ingrese el valor: ");
        String valor = sc.next();
        return valor;
    }

    public CiudadDTO crearCiudad(){
        CiudadDTO ciudad = new CiudadDTO();

        System.out.println("Nombre Ciudad:");
        ciudad.setNombre(sc.next());

        System.out.println("Nombre Pais:");
        ciudad.setPais(sc.next());

        System.out.println("Año visitada:");
        ciudad.setAnio_visitada(sc.nextInt());

        System.out.println("Cantidad de veces visitada:");
        ciudad.setVeces_visitada(sc.nextInt());

        System.out.println("Compañeros de viaje:");
        ciudad.setCompas(sc.next());

        return ciudad;
    }




}
