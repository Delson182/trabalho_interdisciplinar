package br.com.ifms.areq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaRequerimento extends AppCompatActivity {

    private ListView listaRequerimento;
    private ArrayList<String> requerimentos = new ArrayList<String>();
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_requerimento);

        listaRequerimento = (ListView) findViewById(R.id.listaRequerimento);
        adaptador = new ArrayAdapter<String>(ListaRequerimento.this, android.R.layout.simple_list_item_1, requerimentos);
        listaRequerimento.setAdapter(adaptador);

        requerimentos.add("Não há Requerimentos");
        requerimentos.add("Texto um pouco maior para teste de alinhamento");
        adaptador.notifyDataSetChanged();

    }
}
