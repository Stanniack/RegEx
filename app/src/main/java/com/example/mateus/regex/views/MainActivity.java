package com.example.mateus.regex.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mateus.regex.Business.AplicacaoRegex;
import com.example.mateus.regex.R;
import com.example.mateus.regex.adapter.TituloAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.mEditText = (EditText) findViewById(R.id.edit_text);
        this.mViewHolder.mButton = (Button) findViewById(R.id.botao);
        this.mViewHolder.mTextView = (TextView) findViewById(R.id.sem_conteudo);

        // 1 - Definir rec
        this.mViewHolder.mRecyclerView = (RecyclerView) findViewById(R.id.rec_view);

        // Definir layout
        this.mViewHolder.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.setListener();

    }

    @Override
    protected void onResume() {
        super.onResume();

        // 2 - Definir Adapter


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botao) {

            // Se a lista estiver vazia
            if (AplicacaoRegex.aplicacao(this.mViewHolder.mEditText.getText().toString()).isEmpty()) {
                // Manda uma lista vazia para limpar a busca anterior (para não sobrescrever o textview)
                this.mViewHolder.mRecyclerView.setAdapter(
                        new TituloAdapter(
                                AplicacaoRegex.aplicacao(this.mViewHolder.mEditText.getText().toString())));

                // Deixa visível o textview de não encontrado
                mViewHolder.mTextView.setVisibility(View.VISIBLE);
            } else {
                mViewHolder.mTextView.setVisibility(View.GONE);

                // manda a lista com conteúdo
                this.mViewHolder.mRecyclerView.setAdapter(
                        new TituloAdapter(
                                AplicacaoRegex.aplicacao(this.mViewHolder.mEditText.getText().toString())));
            }


        }

    }

    private void setListener() {
        this.mViewHolder.mButton.setOnClickListener(this);
    }


    private static class ViewHolder {
        TextView mTextView;
        EditText mEditText;
        Button mButton;
        RecyclerView mRecyclerView;
    }
}
