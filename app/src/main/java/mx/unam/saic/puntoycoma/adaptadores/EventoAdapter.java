package mx.unam.saic.puntoycoma.adaptadores;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.objetos.Empresa;
import mx.unam.saic.puntoycoma.objetos.Evento;
import mx.unam.saic.puntoycoma.objetos.Listas;
import mx.unam.saic.puntoycoma.objetos.Lugar;
import mx.unam.saic.puntoycoma.objetos.Ponente;
import mx.unam.saic.puntoycoma.util.Constants;

/**
 * Created by José Ángel García on 05/09/14.
 */
public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder> {

    private List<Evento> items;
    private Context contexto;

    public EventoAdapter(List<Evento> items, Context contexto){
        this.contexto = contexto;
        this.items = items;
    }

    /**
     * Aquí en esta clase traemos los widgets al controlador
     * solo los que vayamos a modificar
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nombre;
        public TextView lbl_hora;
        public TextView lbl_nombre_pon;
        public TextView lbl_nombre_empresa;
        public Button btn_agendar;
        public LinearLayout layout_ponente;
        public LinearLayout layout_empresa;
        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView)v.findViewById(R.id.imageView);
            nombre =(TextView) v.findViewById(R.id.my_text_view);
            lbl_hora =(TextView) v.findViewById(R.id.lbl_hora);
            lbl_nombre_pon =(TextView) v.findViewById(R.id.lbl_nombre_pon);
            lbl_nombre_empresa =(TextView) v.findViewById(R.id.lbl_nombre_empresa);
            btn_agendar =(Button) v.findViewById(R.id.btn_agendar);
            layout_empresa = (LinearLayout)v.findViewById(R.id.layout_empresa);
            layout_ponente = (LinearLayout)v.findViewById(R.id.layout_ponente);
        }
    }

    /**
     * metodo que devuelve el viewholder para el recicler view
     * @param parent es la vista padre.
     * @param i
     * @return ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.evento_adapter_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    /**
     *Aquí podremos modificar nuestros widgets libremente.
     * @param viewHolder que conectamos al adaptador
     * @param i posición del elemento en el recycler view
     */

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Evento ev= items.get(i);
        final Ponente pon  = Listas.ponentes.get(ev.getId_ponente());
        final Empresa emp = Listas.empresas.get(pon.getEmpresa_id());

        viewHolder.nombre.setText(ev.getNombre());
        viewHolder.lbl_hora.setText(ev.getHora_inicio());
        viewHolder.lbl_nombre_empresa.setText(emp.getNombre());
        viewHolder.lbl_nombre_pon.setText(pon.getNombre());
        viewHolder.imageView.setImageResource(ev.getDrawable());
        viewHolder.btn_agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agendar(ev,Listas.lugares.get(ev.getId_lugar()));
            }
        });

        viewHolder.layout_ponente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogPon(pon);
            }
        });

        viewHolder.layout_empresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogEmp(emp);
            }
        });


    }

    private void showDialogEmp(final Empresa emp) {
        ArrayList<String> social = new ArrayList<String>();
        //if(!emp.getFb().equals(""))
              //social.add("Facebook");
        if(!emp.getTw().equals(""))
            social.add("Twitter");
        else
            social.add("Twitter no disponible");


        AlertDialog.Builder dialog = new AlertDialog.Builder(contexto)
                .setAdapter(new ArrayAdapter<String>(contexto, android.R.layout.simple_list_item_1, social)
                ,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //if(i == 0 && !emp.getFb().equals(""))
                            //startSocialIntent(0,emp.getFb());
                        if(i == 0 && !emp.getTw().equals(""))
                            startSocialIntent(1,emp.getTw());
                        //if(i==1)
                            //startSocialIntent(1,emp.getTw());
                    }
                });
                dialog.show();
    }

    private void showDialogPon(final Ponente pon) {
         final List<String> social = new ArrayList<String>();
        if(!pon.getTw().equals(""))
            social.add("Twitter");


        AlertDialog.Builder dialog = new AlertDialog.Builder(contexto)
                .setAdapter(new ArrayAdapter<String>(contexto, android.R.layout.simple_list_item_1, social)
                        ,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i==0)
                            startSocialIntent(1,pon.getFb());
                    }
                });
        dialog.show();

    }

    private void startSocialIntent(int i, String s) {
        try {

            if(i==0) {
                Log.d(Constants.TAG,"id facebook: " + s);
                try {
                    contexto.getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    contexto.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"+s)));
                } catch (Exception e) {
                }
            }
            if(i==1) {
                try {
                    contexto.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + s)));
                } catch (Exception e) {
                    contexto.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/" + s)));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void agendar(Evento evento,Lugar lugar) {

        SimpleDateFormat formatter_fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat formatter_horas = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date horainicio = null;
        Date horafinal = null;

        try {
            Log.d(Constants.TAG,evento.getFecha() + " " + evento.getHora_inicio());
            horainicio = formatter_fecha.parse(evento.getFecha() + " " + evento.getHora_inicio());
            horafinal = formatter_horas.parse(evento.getFecha() + " " + evento.getHora_final());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long calID = 1;
        long startMillis = 0;
        long endMillis = 0;
        startMillis = horainicio.getTime();
        endMillis = horafinal.getTime();

         if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
             ContentResolver cr = contexto.getContentResolver();
             ContentValues values = new ContentValues();
             values.put(CalendarContract.Events.CALENDAR_ID, calID);
             values.put(CalendarContract.Events.DTSTART, startMillis);
             values.put(CalendarContract.Events.DTEND, endMillis);
             values.put(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PUBLIC);
             values.put(CalendarContract.Events.TITLE, evento.getNombre());
             values.put(CalendarContract.Events.DESCRIPTION, "Conferencia en Punto y Coma 2014");
             values.put(CalendarContract.Events.CALENDAR_ID, calID);
             values.put(CalendarContract.Events.STATUS,CalendarContract.Events.STATUS_CONFIRMED );
             values.put(CalendarContract.Events.EVENT_LOCATION, lugar.getNombre());
             values.put(CalendarContract.Events.EVENT_TIMEZONE, "America/Mexico_City");
             Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);

             long eventID = Long.parseLong(uri.getLastPathSegment());

             ContentResolver cr3 = contexto.getContentResolver();
             ContentValues values3 = new ContentValues();
             values3.put(CalendarContract.Reminders.MINUTES, 60);
             values3.put(CalendarContract.Reminders.EVENT_ID, eventID);
             values3.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
             Uri uri3 = cr3.insert(CalendarContract.Reminders.CONTENT_URI, values3);
             Toast.makeText(contexto, "Evento Agendado ", Toast.LENGTH_SHORT).show();
         }else{
             Intent intent = new Intent(Intent.ACTION_INSERT)
                     .setType("vnd.android.cursor.item/event")
                     .putExtra("dtstart", startMillis)
                     .putExtra("dtend",endMillis)
                     .putExtra("title", evento.getNombre())
                     .putExtra("dscription", "Conferencia en Punto y Coma 2014")
                     .putExtra("eventLocation", lugar.getNombre())
                     .putExtra("eventStatus",1)
                     .putExtra("hasAlarm",1);
             contexto.startActivity(intent);
         }
    }

    /**
     * Metodo que regresa la cuenta de elementos en el adaptador
     * @return num_elementos
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

}
