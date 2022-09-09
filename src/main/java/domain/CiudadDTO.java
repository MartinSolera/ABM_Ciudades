package domain;

public class CiudadDTO {
    private int id_ciudad;
    private String nombre;
    private String pais;
    private int anio_visitada;
    private int veces_visitada;
    private String compas;

    public CiudadDTO() {
    }

    public CiudadDTO(int id_ciudad, String nombre, String pais, int anio_visitada, int veces_visitada, String compas) {
        this.id_ciudad = id_ciudad;
        this.nombre = nombre;
        this.pais = pais;
        this.anio_visitada = anio_visitada;
        this.veces_visitada = veces_visitada;
        this.compas = compas;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAnio_visitada() {
        return anio_visitada;
    }

    public void setAnio_visitada(int anio_visitada) {
        this.anio_visitada = anio_visitada;
    }

    public int getVeces_visitada() {
        return veces_visitada;
    }

    public void setVeces_visitada(int veces_visitada) {
        this.veces_visitada = veces_visitada;
    }

    public String getCompas() {
        return compas;
    }

    public void setCompas(String compas) {
        this.compas = compas;
    }
}
