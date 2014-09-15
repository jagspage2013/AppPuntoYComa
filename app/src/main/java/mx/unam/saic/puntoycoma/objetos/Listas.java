package mx.unam.saic.puntoycoma.objetos;

import android.support.annotation.ArrayRes;

import java.util.ArrayList;
import java.util.Iterator;

import mx.unam.saic.puntoycoma.R;

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


    public static ArrayList<Evento>  getListaPorLugar(int lugar){
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        Iterator<Evento> iter = Listas.eventos.iterator();
        while(iter.hasNext()){
            Evento e = iter.next();
            if(e.getId_lugar() == lugar){
                eventos.add(e);
            }
        }
        return eventos;
    }
    private void setUpEventos() {
        eventos.add(new Evento(0, "Presentación Punto y Coma/LMH","9:00","10:00",0 ,0, R.drawable.logo_saic,"17/09/2014"));
        eventos.add(new Evento(1, "Inauguración","10:00","10:30",1 ,0,R.drawable.logofi,"17/09/2014"));
        eventos.add(new Evento(2, "¿Es la computaciòn una Ciencia?","10:30","11:30",2 ,0,R.drawable.logofc,"17/09/2014"));
        eventos.add(new Evento(3, "¿Problemas de Coordinación en Arquitecturas Multicore","11:30","12:00",3 ,0,R.drawable.logofc,"17/09/2014"));
        eventos.add(new Evento(4, "Big Data","12:00","13:00",4 ,0,R.drawable.ibm,"17/09/2014"));
        eventos.add(new Evento(5, "Hacer un videojuego no es un juego","13:00","13:30",5 ,0,R.drawable.sorvi,"17/09/2014"));
        eventos.add(new Evento(6, "Ponencia","13:30","14:00",6 ,0,R.drawable.dsa,"17/09/2014"));
        eventos.add(new Evento(7, "Linux en tu vida cotidiana.....bienvenidos a la Matrix!","14:00","14:30",7 ,0,R.drawable.opensuse,"17/09/2014"));
        eventos.add(new Evento(8, "RobotOps y el Internet de las cosas ","14:30","15:00",11 ,0,R.drawable.logo_saic,"17/09/2014"));
        eventos.add(new Evento(9, "¿Qué es GSA?","15:00","15:30",34,0,R.drawable.gsa,"17/09/2014"));
        eventos.add(new Evento(10, "¿Y los ingenieros para que necesitamos las matematicas? / El costo de emprender ","15:30","16:00",16,0,R.drawable.tech_mx,"17/09/2014"));
        eventos.add(new Evento(11, "Valor de la certificación de las mejores prácticas en tecnologías de la información","16:00","17:00",13,0,R.drawable.logo_saic,"17/09/2014"));
        eventos.add(new Evento(12, "Emprendimiento e Incubación en la UNAM","17:00","17:30",14,0,R.drawable.innova_unam,"17/09/2014"));
        eventos.add(new Evento(13, "En búsqueda del antídoto del Ebola de las TICs: La postura de EC-Council en la UNAM","17:30","18:00",15,0,R.drawable.logo_saic,"17/09/2014"));
        eventos.add(new Evento(14, "No dejarse vencer por una mala experiencia de emprendimiento","10:00","10:30",16,1,R.drawable.tech_mx,"18/09/2014"));
        eventos.add(new Evento(15, "Plataforma Gobierno Abierto CDMX","10:30","11:00",17,1,R.drawable.lab_plc,"18/09/2014"));
        eventos.add(new Evento(16, "Tendencia Maker: ¿Hasta donde llega tu imaginación?","11:00","12:00",18,1,R.drawable.intel,"18/09/2014"));
        eventos.add(new Evento(17, "Profesionales Web: Él perfil más importante en nuestros tiempos","12:00","13:00",19,1,R.drawable.mejorandola,"18/09/2014"));
        eventos.add(new Evento(18, "Arquitectura de Sistemas Heterogeneos (HSA)","13:00","14:00",20,1,R.drawable.amd,"18/09/2014"));
        eventos.add(new Evento(19, "El Marketing digital","14:00","15:00",21,1,R.drawable.google,"18/09/2014"));
        eventos.add(new Evento(20, "Back End Development: Solving Existing Challenging Problems that Really Drive Technology Forward","15:00","16:00",22,1,R.drawable.oracle,"18/09/2014"));
        eventos.add(new Evento(21, "Internet of everything","15:00","16:00",23,1,R.drawable.cisco,"18/09/2014"));
        eventos.add(new Evento(23, "Microsoft y el ¿Código libre ?","15:00","16:00",24,1,R.drawable.microsoft,"18/09/2014"));
        eventos.add(new Evento(24, "Hackear al Gobierno ","10:00","10:30",25,2,R.drawable.lab_plc,"19/09/2014"));
        eventos.add(new Evento(25, "Lightning Talk 2","10:30","11:00",26,2,R.drawable.proteco,"19/09/2014"));
        eventos.add(new Evento(26, "Redefine IT","11:00","12:00",27,2,R.drawable.emcaa,"19/09/2014"));
        eventos.add(new Evento(27, "PENDIENTE","12:00","12:30",28,2,R.drawable.logo_saic,"19/09/2014"));
        eventos.add(new Evento(28, "Tecnologías de la Información en México","12:30","13:30",29,2,R.drawable.ctin,"19/09/2014"));
        eventos.add(new Evento(29, "Herramientas para el empleo, profesionales de TI","13:30","14:30",30,2,R.drawable.dgose,"19/09/2014"));
        eventos.add(new Evento(30, "Experiencia Android Wear","14:30","15:30",31,2,R.drawable.logo_saic,"19/09/2014"));
        eventos.add(new Evento(31, "PENDIENTE","15:30","16:30",32,2,R.drawable.mozilla,"19/09/2014"));
        eventos.add(new Evento(32, "Cultura Hacker","16:30","17:30",33,2,R.drawable.logo_saic,"19/09/2014"));
        eventos.add(new Evento(32, "Clausura","17:30","18:00",0,2,R.drawable.logo_saic,"19/09/2014"));


    }

    private void setUpPonentes() {
       ponentes.add(new Ponente(0,"Comité Organizador","SAICFI","SAICFI",0));
       ponentes.add(new Ponente(1,"UNAM","UNAM.MX.Oficial","unam_mx",0));
       ponentes.add(new Ponente(2,"Dr. Sergio Rajsbaum","srajsbaum","",1));
       ponentes.add(new Ponente(3,"Dr. Armando Castañeda","armando.castaneda.75","",1));
       ponentes.add(new Ponente(4,"Hugo Sosa Arévalo","IBM","hugo_sosaa",28));
       ponentes.add(new Ponente(5,"Luis Valencia","sodvi","sodvi",2));
       ponentes.add(new Ponente(6,"Dr. Daniel Trejo Medina","dantmdantm","dantmdantm",3));
       ponentes.add(new Ponente(7,"Aarón Luna","jeffedejeffes","aaronlube",4));
       ponentes.add(new Ponente(8,"Angel Perez","","",5));
       ponentes.add(new Ponente(9,"Guillermo Vera","williamvanmpersie2","gveraios",5));
       ponentes.add(new Ponente(10,"Cèsar Islas","C354RHSMROCKS","C354R_ISLAS",5));
       ponentes.add(new Ponente(11,"Javier Cervantes Ponce","solojavier","solojavier",6));
       ponentes.add(new Ponente(12,"Lab PLC ","LabPLC","LabPLC",6));
       ponentes.add(new Ponente(13,"Ing. José Manuel Flores","","",8));
       ponentes.add(new Ponente(14,"Mtra. Melva Flores Dueñas","","",9));
       ponentes.add(new Ponente(15,"Alberto Pozada Marín","","",10));
       ponentes.add(new Ponente(16,"Jorge Bojorges","jbojorges","",11));
       ponentes.add(new Ponente(17,"Lap PLC","labplc","labplc",11));
       ponentes.add(new Ponente(18,"Ing. Ricardo Rocha","","RRochaMX",13));
       ponentes.add(new Ponente(19,"Miguel Nieva","miguelnieva.com","mikenieva",14));
       ponentes.add(new Ponente(20,"David Garza Marín","davidgarzam","adgarzam",15));
       ponentes.add(new Ponente(21,"Julio Soto","juliosotomx","",16));
       ponentes.add(new Ponente(22,"José Luis Nuñez","","",17));
       ponentes.add(new Ponente(23,"Francisco Ramirez","","",18));
       ponentes.add(new Ponente(24,"Amin Espinosa de los Monteros","","aminespinoza",19));
       ponentes.add(new Ponente(25,"Eduardo Daniel Pérez Tello","","_Daniel_Tello",12));
       ponentes.add(new Ponente(26,"Pendiente","","",20));
       ponentes.add(new Ponente(27,"María Andrea Alcántara Silva","","",21));
       ponentes.add(new Ponente(28,"Pendiente","","",22));
       ponentes.add(new Ponente(29,"Pendiente","","",23));
       ponentes.add(new Ponente(30,"Lic. Laura Patricia Montoya Jiménez","","",24));
       ponentes.add(new Ponente(31,"Franco Frías","","DJFrankIPN",25));
       ponentes.add(new Ponente(32,"Luis Sanchez ","","lasr21",26));
       ponentes.add(new Ponente(33,"Enrique Díaz","","nRikeDiaz",27));
       ponentes.add(new Ponente(34,"GSA UNAM","","",29));



    }

    private void setUpEmpresas() {
        empresas.add(new Empresa(0,"SAIC","SAICFI","SAICFI"));
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
        empresas.add(new Empresa(11,"Tech MX","RevistaTechMX","RevistaTechMX"));
        empresas.add(new Empresa(12,"Lab PLC ","LabPLC","LabPLC"));
        empresas.add(new Empresa(13,"Intel","IntelLatinoAmerica","intel_la"));
        empresas.add(new Empresa(14,"Mejorando.la","mejorandola","mejorandola"));
        empresas.add(new Empresa(15,"AMD","AMDMexico","AMD"));
        empresas.add(new Empresa(16,"Google","Google","google"));
        empresas.add(new Empresa(17,"Oracle","OracleMDC","Oracle"));
        empresas.add(new Empresa(18,"Cisco","Cisco","Cisco"));
        empresas.add(new Empresa(19,"Microsoft","MicrosoftMX","MSFTMexico"));
        empresas.add(new Empresa(20,"PROTECO","protecofi","proteco"));
        empresas.add(new Empresa(21,"EMC2 Academic Alliance","EMCacademicalliance","EMCacademics"));
        empresas.add(new Empresa(22,"Itera","pages/Itera/191542910909426","Iteraprocess"));
        empresas.add(new Empresa(23,"CTIN","ctinmexico","CTINMexico"));
        empresas.add(new Empresa(24,"Bolsa Universitaria de Trabajo DGOSE","pages/Bolsa-Universitaria-De-Trabajo-Dgose-UNAM/278771218862689","COEDGOSEUNAM"));
        empresas.add(new Empresa(25,"GSA IPN","GSAIPN",""));
        empresas.add(new Empresa(26,"Mozillla","mozillamx","mozillamx"));
        empresas.add(new Empresa(27,"Android Titlán","pages/Androidtitlan/183928924981340","AndroidTitlan"));
        empresas.add(new Empresa(28,"IBM","IBM","IBM"));
        empresas.add(new Empresa(29,"GSA UNAM","","GSAUNAM"));

    }

    private void setUpLugares() {
        lugares.add(new Lugar(0,"Auditorio Alberto Barajas Celis",19.3240808,-99.1806862));
        lugares.add(new Lugar(1,"Auditorio Javier Barros Sierra",19.3308412,-99.1843327));
        lugares.add(new Lugar(2,"Auditorio Raul J. Marsal",19.3280742,-99.1816948));

    }

}
