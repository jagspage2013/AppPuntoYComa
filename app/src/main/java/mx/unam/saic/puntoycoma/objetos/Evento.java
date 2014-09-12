package mx.unam.saic.puntoycoma.objetos;

/**
 * Created by jagspage2013 on 06/09/14.
 */
public class Evento {

    private int id;
    private String nombre;

    public Evento(int id, String nombre, String hora_inicio, String hora_final, int id_ponente, int id_lugar, int importante) {
        this.id = id;
        this.nombre = nombre;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.id_ponente = id_ponente;
        this.id_lugar = id_lugar;
        this.importante = importante;
    }

    private String hora_inicio;
    private String hora_final;
    private int id_ponente;
    private int id_lugar;
    private int importante;

    public int getImportante() {
        return importante;
    }

    public void setImportante(int importante) {
        this.importante = importante;
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


}
