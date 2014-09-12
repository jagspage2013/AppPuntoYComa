package mx.unam.saic.puntoycoma.objetos;

/**
 * Created by jagspage2013 on 06/09/14.
 */
public class Empresa {

    private int id;
    private String nombre;
    private String fb;
    private String tw;

    public Empresa(int id, String nombre, String fb, String tw) {
        this.id = id;
        this.nombre = nombre;
        this.fb = fb;
        this.tw = tw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getTw() {
        return tw;
    }

    public void setTw(String tw) {
        this.tw = tw;
    }
}
