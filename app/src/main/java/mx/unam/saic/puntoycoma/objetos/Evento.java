package mx.unam.saic.puntoycoma.objetos;

/**
 * Created by jagspage2013 on 06/09/14.
 */
public class Evento {

    private int id;
    private String nombre;

    public Evento(int id, String nombre, String hora_inicio, String hora_final, int id_ponente, int id_lugar, int drawable,String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.id_ponente = id_ponente;
        this.id_lugar = id_lugar;
        this.drawable = drawable;
        this.fecha = fecha;
    }

    private String hora_inicio;
    private String hora_final;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    private String fecha;
    private int id_ponente;
    private int id_lugar;
    private int drawable;

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int importante) {
        this.drawable = importante;
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

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public int getId_ponente() {
        return id_ponente;
    }

    public void setId_ponente(int id_ponente) {
        this.id_ponente = id_ponente;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
}
