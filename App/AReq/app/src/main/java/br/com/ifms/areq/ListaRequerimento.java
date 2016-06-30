package br.com.ifms.areq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaRequerimento extends AppCompatActivity {

    private ListView listaRequerimento;
    private ArrayList<Requerimento> requerimentos = new ArrayList<Requerimento>();
    private ArrayAdapter<Requerimento> adaptador;
    private Requerimento requerimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_requerimento);

        listaRequerimento = (ListView) findViewById(R.id.listaRequerimento);
        adaptador = new ArrayAdapter<Requerimento>(ListaRequerimento.this, android.R.layout.simple_list_item_1, requerimentos);
        listaRequerimento.setAdapter(adaptador);

        requerimento = new Requerimento("0012345", "29/jun/16","Convalidação","Alguma marmota","Em estudo");

        requerimentos.add(requerimento);
        adaptador.notifyDataSetChanged();

        listaRequerimento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(ListaRequerimento.this, DetalhesRequerimento.class);
                it.putExtra("req",requerimento);
                startActivity(it);
            }
        });

    }

}
