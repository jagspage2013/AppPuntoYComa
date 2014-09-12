package mx.unam.saic.puntoycoma.objetos;

import java.util.ArrayList;

/**
 * Created by jagspage2013 on 07/09/14.
 */
public class Listas {

    public static ArrayList<Evento> eventos;
    public static ArrayList<Ponente> ponentes;
    public static ArrayList<Empresa> empresas;
    public static ArrayList<Lugar> lugares;

    public Listas(){
        eventos = new ArrayList<Evento>();
        ponentes = new ArrayList<Ponente>();
        empresas = new ArrayList<Empresa>();
        lugares = new ArrayList<Lugar>();
        setUpEventos();
        setUpPonentes();
        setUpEmpresas();
        setUpLugares();
    }

    private void setUpEventos() {
        eventos.add(new Evento(0, "Presentación Punto y Coma/LMH","9:00","10:00",0 ,0,1));
        eventos.add(new Evento(1, "Inauguración","10:00","10:30",1 ,0,1));
        eventos.add(new Evento(2, "¿Es la computaciòn una Ciencia?","10:30","11:30",2 ,0,1));
        eventos.add(new Evento(3, "¿Problemas de Coordinación en Arquitecturas Multicore","11:30","12:00",3 ,0,0));
        eventos.add(new Evento(4, "PENDIENTE","12:00","13:00",4 ,0,1));
        eventos.add(new Evento(5, "Hacer un videojuego no es un juego","13:00","13:30",5 ,0,0));
        eventos.add(new Evento(6, "PENDIENTE","13:30","14:00",6 ,0,1));
        eventos.add(new Evento(7, "Linux en tu vida cotidiana.....bienvenidos a la Matrix!","14:00","14:30",7 ,0,0));
        eventos.add(new Evento(8, "Lightning Talk 2 30 min","14:30","15:00",8 ,0,0));
        eventos.add(new Evento(9, "RobotOps y el Internet de las cosas","15:00","15:30",11,0,1));
        eventos.add(new Evento(10, "PENDIENTE","15:30","16:00",12,0,0));
        eventos.add(new Evento(11, "Valor de la certificación de las mejores prácticas en tecnologías de la información","16:00","17:00",13,0,1));
        eventos.add(new Evento(12, "Emprendimiento e Incubación en la UNAM","17:00","17:30",14,0,0));
        eventos.add(new Evento(13, "En búsqueda del antídoto del Ebola de las TICs: La postura de EC-Council en la UNAM","17:30","18:00",15,0,1));
        eventos.add(new Evento(14, "Lightning Talk 1","10:00","10:30",16,1,0));
        eventos.add(new Evento(14, "Plataforma Gobierno Abierto CDMX","10:30","11:00",17,1,0));
        eventos.add(new Evento(14, "Tendencia Maker: ¿Hasta donde llega tu imaginación?","11:00","12:00",18,1,1));
        eventos.add(new Evento(14, "Profesionales Web: Él perfil más importante en nuestros tiempos","12:00","13:00",19,1,1));

    }


    private void setUpPonentes() {
       ponentes.add(new Ponente(0,"Comité Organizador","puntoYcoma.saic","SAICFI",0));
       ponentes.add(new Ponente(1,"UNAM","UNAM.MX.Oficial","unam_mx",-1));
       ponentes.add(new Ponente(2,"Dr. Sergio Rajsbaum","srajsbaum","",1));
       ponentes.add(new Ponente(3,"Dr. Armando Castañeda","armando.castaneda.75","",1));
       ponentes.add(new Ponente(4,"IBM","IBM","IBM",-1));
       ponentes.add(new Ponente(5,"Luis Valencia","sodvi","sodvi",2));
       ponentes.add(new Ponente(6,"Dr. Daniel Trejo Medina","dantmdantm","dantmdantm",3));
       ponentes.add(new Ponente(7,"Aarón Luna","jeffedejeffes","aaronlube",4));
       ponentes.add(new Ponente(8,"Angel Perez","","",5));
       ponentes.add(new Ponente(9,"Guillermo Vera","williamvanmpersie2","gveraios",5));
       ponentes.add(new Ponente(10,"Cèsar Islas","C354RHSMROCKS","C354R_ISLAS",5));
       ponentes.add(new Ponente(11,"Javier Cervantes Ponce","solojavier","solojavier",6));
       ponentes.add(new Ponente(12,"PENDIENTE","","",7));
       ponentes.add(new Ponente(13,"Ing. José Manuel Flores","","",8));
       ponentes.add(new Ponente(14,"Mtra. Melva Flores Dueñas","","",9));
       ponentes.add(new Ponente(15,"Alberto Pozada Marín","","",10));
       ponentes.add(new Ponente(16,"Jorge Bojorges","jbojorges","",11));
       ponentes.add(new Ponente(17," Ing. Marco Quiroz Aguayo","","",11));
       ponentes.add(new Ponente(17,"Constanza Gómez-Mont","","",11));
       ponentes.add(new Ponente(17,"Miguel Ángel Gallardo","","",11));
       ponentes.add(new Ponente(17," Stalin Muñoz Gutiérrez","","",12));
       ponentes.add(new Ponente(18,"Ing. Ricardo Rocha","","RRochaMX",13));
       ponentes.add(new Ponente(19,"Miguel Nieva","miguelnieva.com","mikenieva",14));

    }

    private void setUpEmpresas() {
        empresas.add(new Empresa(0,"SAIC","puntoYcoma.saic","SAICFI"));
        empresas.add(new Empresa(1,"Facultad de Ciencias","cienciasunam","fciencias"));
        empresas.add(new Empresa(2,"SODVI","sodvi","sodvi"));
        empresas.add(new Empresa(3,"DSA Soluciones","DSA-Soluciones","DSASoluciones"));
        empresas.add(new Empresa(4,"OpenSuse ","opensusemexico","openSUSE_ES"));
        empresas.add(new Empresa(5,"GSA UNAM ","GSAUNAM","GSAUNAM"));
        empresas.add(new Empresa(6,"HybridGroup","thehybridgroup","hybrid_group"));
        empresas.add(new Empresa(7,"Microsoft","MicrosoftMX","Microsoft"));
        empresas.add(new Empresa(8,"Pink Elephant","",""));
        empresas.add(new Empresa(9,"InnovaUNAM","innovaunam.ingenieria","InnovaUNAMFI"));
        empresas.add(new Empresa(10,"ITSEC","IT4SEC","Microsoft"));
        empresas.add(new Empresa(11,"Teck MX","RevistaTechMX","RevistaTechMX"));
        empresas.add(new Empresa(12,"Lab PLC ","LabPLC","LabPLC"));
        empresas.add(new Empresa(13,"Intel","IntelLatinoAmerica","intel_la"));
        empresas.add(new Empresa(14,"Mejorando.la","mejorandola","mejorandola"));

    }

    private void setUpLugares() {
        lugares.add(new Lugar(0,"Auditorio Javier Barros Sierra",19.3308412,-99.1843327));
        lugares.add(new Lugar(1,"Auditorio Javier Barros Sierra",19.3280742,-99.1816948));
        lugares.add(new Lugar(2,"Auditorio Alberto Barajas Celis",19.3240808,-99.1806862));

    }

}
