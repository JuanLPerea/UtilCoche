package juanluisperea.utilcoche.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import juanluisperea.utilcoche.Modelos.Coche;
import juanluisperea.utilcoche.R;

/**
 * Created by TorreJL on 19/04/2017.
 */

public class CochesAdapter extends RecyclerView.Adapter<CochesAdapter.CochesViewHolder>{

    private Context mContext;
    List<Coche> coches;

    public CochesAdapter(Context context , List<Coche> coches) {
        this.coches = coches;
        this.mContext = context;
    }

    @Override
    public CochesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent, false);
        CochesViewHolder holder = new CochesViewHolder(v);
        return  holder;
    }

    @Override
    public void onBindViewHolder(CochesViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public void onBindViewHolder(CochesViewHolder holder, int position) {

        final Coche coche = coches.get(position);
        holder.imagen.setImageResource(R.drawable.coche);
        holder.nombreCoche.setText(coche.getNombre());
        holder.kilometros.setText(coche.getKilometros() + " Kms.");
        holder.actualizacion.setText(coche.getActualizacion());

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    // aquí acción cuando hacemos long click en un elemento del RecyclerView
                    Toast.makeText(mContext, "#" + position + " -  " + coche.getNombre() + " (Long click)", Toast.LENGTH_SHORT).show();
                } else {
                    // aquí acción cuando hacemos click en un elemento del RecyclerView
                    Toast.makeText(mContext, "#" + position + " - " + coche.getNombre() , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return coches.size();
    }

    public static class CochesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        ImageView imagen;
        TextView nombreCoche, kilometros, actualizacion;
        private ItemClickListener clickListener;

        public CochesViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView)itemView.findViewById(R.id.fotocoche);
            nombreCoche = (TextView)itemView.findViewById(R.id.nombrecoche);
            kilometros = (TextView)itemView.findViewById(R.id.kilometros);
            actualizacion = (TextView)itemView.findViewById(R.id.actualizacion);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);



        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }
    }
}
