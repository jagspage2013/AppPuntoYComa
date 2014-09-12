package mx.unam.saic.puntoycoma.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mx.unam.saic.puntoycoma.R;
import mx.unam.saic.puntoycoma.fragments.dummy.DummyContent;

/**
 * Created by José Ángel García on 05/09/14.
 */
public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder> {

    List<DummyContent.DummyItem> items;
    public EventoAdapter(List<DummyContent.DummyItem> items){
        this.items = items;

    }

    /**
     * Aquí en esta clase traemos los widgets al controlador
     * solo los que vayamos a modificar
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cardView;
        public ViewHolder(View v) {
            super(v);
            cardView =(TextView) v.findViewById(R.id.my_text_view);
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
        viewHolder.cardView.setText(items.get(i).toString());

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
