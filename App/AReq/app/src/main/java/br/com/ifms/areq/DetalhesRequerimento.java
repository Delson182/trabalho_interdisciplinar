package br.com.ifms.areq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetalhesRequerimento extends AppCompatActivity {

    private EditText edtDetalhamento;
    private TextView requerimento;
    private TextView dataCriacao;
    private TextView tipoReq;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_requerimento);

        requerimento = (TextView) findViewById(R.id.textReqDet);
        dataCriacao = (TextView) findViewById(R.id.textDataCriacaoDet);
        tipoReq = (TextView) findViewById(R.id.textTipoReqDet);
        status = (TextView) findViewById(R.id.textStatusDet);
        edtDetalhamento = (EditText) findViewById(R.id.edtDetelhamento);

        Requerimento req = (Requerimento) getIntent().getSerializableExtra("req");

        requerimento.setText(req.getRequerimento());
        dataCriacao.setText(req.getDataCriacao());
        tipoReq.setText(req.getTipoReq());
        status.setText(req.getStatus());
        edtDetalhamento.setText(req.getDetalhamento());
    }
}
