package br.com.ifms.areq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtRa;
    private EditText edtCPF;
    private EditText edtNomeMae;
    private ImageView imgAutentica;
    private boolean trocarVerificador = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAutentica = (ImageView) findViewById(R.id.imgAutentica);
        edtCPF = (EditText) findViewById(R.id.edtCPF);

        //variavel que faz a verificação da quantidade de caracteres para calculo do cpf
        TextWatcher verifica = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edtCPF.length() < 14 && trocarVerificador){
                    imgAutentica.setImageResource(R.drawable.interrogacao);
                    trocarVerificador = false;
                }
                if (edtCPF.length() >= 14){
                    if(autenticaCPF(Mascara.desMascara(edtCPF.getText().toString()))) {
                        imgAutentica.setImageResource(R.drawable.check_verde);
                    } else {
                        imgAutentica.setImageResource(R.drawable.check_vermelho);
                        Toast.makeText(getApplicationContext(), "CPF Inválido", Toast.LENGTH_SHORT).show();
                    }
                    trocarVerificador = true;
                }
            }
        };

        edtCPF.addTextChangedListener(Mascara.insert("###.###.###-##", edtCPF));
        edtCPF.addTextChangedListener(verifica);
    }

    //metodo que verifica a autenticação do cpf
    public boolean autenticaCPF(String cpf){
        int soma, result, numero, peso;
        char digito10, digito11;
        soma = 0;
        peso = 10;
        for(int i = 0; i < 9; i++){
            numero = (int) (cpf.charAt(i) - 48);
            soma += (numero * peso);
            peso -= 1;
        }
        result = 11 - (soma % 11);
        if (result == 10 || result == 11){
            digito10 = '0';
        } else {
            digito10 = (char)(result + 48);
        }

        soma = 0;
        peso = 11;
        for(int i = 0; i < 10; i++){
            numero = (int) (cpf.charAt(i) - 48);
            soma += (numero * peso);
            peso -= 1;
        }
        result = 11 - (soma % 11);
        if (result == 10 || result == 11){
            digito11 = '0';
        } else {
            digito11 = (char)(result + 48);
        }
        if (digito10 == cpf.charAt(9) && digito11 == cpf.charAt(10)){
            return true;
        } else {
            return false;
        }
    }
}
