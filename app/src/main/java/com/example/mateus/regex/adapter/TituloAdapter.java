package com.example.mateus.regex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mateus.regex.R;
import com.example.mateus.regex.entities.TituloEleitor;
import com.example.mateus.regex.viewholder.TituloViewHolder;

import java.util.List;

public class TituloAdapter extends RecyclerView.Adapter<TituloViewHolder> {
    private List<TituloEleitor> listaTitulos;

    public TituloAdapter(List<TituloEleitor> listaTitulos) {
        this.listaTitulos = listaTitulos;
    }

    // instancia o layout para fazer as manipulações
    @NonNull
    @Override
    public TituloViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();

        // inflando o layout que eu criei para essa RV
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View TituloEleitorView = layoutInflater.inflate(R.layout.layout_recview, viewGroup, false);


        return new TituloViewHolder(TituloEleitorView, context);
    }

    // com o layout instanciado é possível fazer a associação com um valor da lista sendo trabalhada
    @Override
    public void onBindViewHolder(@NonNull TituloViewHolder tituloViewHolder, int i) {
        // pega valor na posição da lista
        TituloEleitor tituloEleitor = listaTitulos.get(i);

        // transfere responsabilidade de associar dados para o viewholder
        tituloViewHolder.bindData(tituloEleitor);

    }

    @Override
    public int getItemCount() {
        return listaTitulos.size();
    }
}
