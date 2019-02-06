package com.example.mateus.regex.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mateus.regex.R;
import com.example.mateus.regex.entities.TituloEleitor;

public class TituloViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private TextView mTitulo;
    private TextView mEstado;

    public TituloViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        this.mContext = context;

        //Mapear ids
        mTitulo = (TextView) itemView.findViewById(R.id.titulo);
        mEstado = (TextView) itemView.findViewById(R.id.estado);
    }

    public void bindData(TituloEleitor tituloEleitor){
        mTitulo.setText(tituloEleitor.getTitulo());
        mEstado.setText(tituloEleitor.getEstado());
    }
}
