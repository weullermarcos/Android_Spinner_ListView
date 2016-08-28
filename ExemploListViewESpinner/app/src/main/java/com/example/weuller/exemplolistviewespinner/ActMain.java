package com.example.weuller.exemplolistviewespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ActMain extends AppCompatActivity implements View.OnClickListener {

    private EditText edtValor;
    private Spinner spnOpcoes;
    private Button btnAdicionar;
    private Button btnExcluir;
    private ListView lstDados;

    //criando um objeto do tipo ArrayAdapter para poder preencher o ListView
    private ArrayAdapter<String> adpOpcoes;

    //criando um objeto do tipo ArrayAdapter para poder preencher o Spinner
    private ArrayAdapter<String> adpDados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        edtValor = (EditText) findViewById(R.id.edtValor);
        spnOpcoes = (Spinner) findViewById(R.id.spnOpcoes);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);
        btnExcluir = (Button) findViewById(R.id.btnExcluir);
        lstDados = (ListView) findViewById(R.id.lstDados);

        btnExcluir.setOnClickListener(this);
        btnAdicionar.setOnClickListener(this);

        //instanciando um novo ArrayAdapter<String>
        //ele espera como parâmetro um contexto, que no caso é a classe que estamos
        //e um layout no caso estaremos usando o layout padrão do componente spinner
        //que pode se encontrado em: android.R.layout.simple_spinner_item
        adpOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);

        //setando estilo para quando o componente for selecionado
        adpOpcoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //vinculando o Adapter ao componente de Spinner
        spnOpcoes.setAdapter(adpOpcoes);

        //adicionando valores ao Spinner
        adpOpcoes.add("Opção 1");
        adpOpcoes.add("Opção 2");
        adpOpcoes.add("Opção 3");
        adpOpcoes.add("Opção 4");

        //instaciando um novo Adapter para a ListView e passando o layout que será utilizado
        adpDados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        //vinculando adapter a ListView
        lstDados.setAdapter(adpDados);

    }

    @Override
    public void onClick(View v) {

        if (v == btnAdicionar ){

            //recuperando o texto digitado no componente EditText
            String item = edtValor.getText().toString();

            //concatenando valor recuperado com o item selecionado no componente Spinner
            item += spnOpcoes.getSelectedItem();

            //adicionando o valor ao Adapter de dados
            adpDados.add(item);

        }
        else{

            //verifico se existem itens na lista para que seja feita a exclusão
            if(adpDados.getCount() > 0){

                //recupero o item da posição 0 no adapater
                String item = adpDados.getItem(0);

                //removo o item recuperado
                adpDados.remove(item);
            }

        }

    }
}
