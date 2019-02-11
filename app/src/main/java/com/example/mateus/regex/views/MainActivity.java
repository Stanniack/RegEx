package com.example.mateus.regex.views;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
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
    Bitmap bitmap;

    // Resultado do OCR/Texto
    private String resultado;
    // requestCode que eu usarei para pegar o conteúdo da intent
    int chaveSegurancaParaResultado = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.mTextView2 = (TextView) findViewById(R.id.teste);
        this.mViewHolder.mButton = (Button) findViewById(R.id.botao);
        this.mViewHolder.mTextView = (TextView) findViewById(R.id.sem_conteudo);

        // Checa se o app tem permissão para usar a câmera, se não tiver, pedir
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,  new String[] {Manifest.permission.CAMERA}, 0);
        }


        // 1 - Definir rec
        this.mViewHolder.mRecyclerView = (RecyclerView) findViewById(R.id.rec_view);

        // Definir layout
        this.mViewHolder.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.setListener();

        // Criar um bitmap a partir de um arquivo drawable
        //Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.teste17);

        // Manda o bitmap para o OCR
        //resultado = manager.startRecognize(bitmap);


    }

    @Override
    protected void onResume() {
        super.onResume();

        //mViewHolder.mTextView2.setVisibility(View.VISIBLE);
        //mViewHolder.mTextView2.setText(resultado);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botao) {
            this.tirarFoto();
        }

    }

    private void setListener() {
        this.mViewHolder.mButton.setOnClickListener(this);
    }

    private void tirarFoto(){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Startar uma intent que retorna conteúdo
        startActivityForResult(intent, chaveSegurancaParaResultado);

    }

    private void businessValidacao(){
        // Se a lista estiver vazia
        if (AplicacaoRegex.aplicacao(this.resultado).isEmpty()) {
            // Manda uma lista vazia para limpar a busca anterior (para não sobrescrever o textview)
            this.mViewHolder.mRecyclerView.setAdapter(
                    new TituloAdapter(
                            AplicacaoRegex.aplicacao(this.resultado)));

            // Deixa visível o textview de não encontrado
            mViewHolder.mTextView.setVisibility(View.VISIBLE);
        } else {
            mViewHolder.mTextView.setVisibility(View.GONE);

            // manda a lista com conteúdo
            this.mViewHolder.mRecyclerView.setAdapter(
                    new TituloAdapter(
                            AplicacaoRegex.aplicacao(this.resultado)));
        }
    }

    // Método responsável por pegar o conteúdo da intent que eu startei
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == this.chaveSegurancaParaResultado && resultCode == RESULT_OK){
            // Bundle responsável por pegar o conteúdo retornado
            Bundle extras = data.getExtras();

            // Pegando a imagem e convertando em bmp
            bitmap = (Bitmap) extras.get("data");

            // Manda para o Tesseract
            OCRManager manager = new OCRManager();
            resultado = manager.startRecognize(bitmap);

            // valida os dados
            this.businessValidacao();

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private static class ViewHolder {
        TextView mTextView;
        TextView mTextView2;
        EditText mEditText;
        Button mButton;
        RecyclerView mRecyclerView;
    }
}
