package br.com.ifms.areq;

import android.graphics.MaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.MaskFilterSpan;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtRa;
    private EditText edtCPF;
    private EditText edtNomeMae;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCPF = (EditText) findViewById(R.id.edtCPF);
        edtCPF.addTextChangedListener(Mascara.insert("###.###.###-##", edtCPF));
    }
}
