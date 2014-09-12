package mx.unam.saic.puntoycoma.objetos;

/**
 * Created by jagspage2013 on 06/09/14.
 */
public class Ponente {

    private int id;
    private String nombre;
    private String fb;
    private String tw;
    private int empresa_id;

    public Ponente(int id, String nombre, String fb, String tw, int empresa_id) {
        this.id = id;
        this.nombre = nombre;
        this.fb = fb;
        this.tw = tw;
        this.empresa_id = empresa_id;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
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
