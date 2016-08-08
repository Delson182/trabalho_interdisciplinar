package br.com.ifms.areq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaRequerimento extends AppCompatActivity {

    private ListView listaRequerimento;
    private ArrayList<Requerimento> requerimentos = new ArrayList<Requerimento>();
    private ArrayAdapter<Requerimento> adaptador;
    private Requerimento requerimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_requerimento);
        String cpf = this.getIntent().getStringExtra("cpf");
        RequerimentoDAO ws = new RequerimentoDAO();

        List<Requerimento> temp = ws.pegarRequerimentos(cpf);
        requerimentos = (ArrayList<Requerimento>) temp;

        listaRequerimento = (ListView) findViewById(R.id.listaRequerimento);
        adaptador = new ArrayAdapter<Requerimento>(ListaRequerimento.this, android.R.layout.simple_list_item_1, requerimentos);

        Requerimento req = requerimentos.get(0);

        Log.d("tag", req.getRequerimento());
        Log.d("tag", req.getDataCriacao());
        Log.d("tag", req.getDetalhamento());
        Log.d("tag", req.getStatus());
        //Log.d("tag", req.getTipoReq());

        listaRequerimento.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();

        listaRequerimento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(ListaRequerimento.this, DetalhesRequerimento.class);
                it.putExtra("req",requerimentos.get(position));
                startActivity(it);
            }
        });

    }

}
