package br.com.ifms.areq;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class Mascara{

    private static String desMascara(String s){
        return s.replaceAll("[.]","").replaceAll("[-]","")
                .replaceAll("[/]","").replaceAll("[(]","")
                .replaceAll("[)]","");
    }

    public static TextWatcher insert(final String mask, final EditText editText){
        return new TextWatcher() {
            boolean atualiza;
            String textoAntigo = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = Mascara.desMascara(s.toString());
                String mascara = "";
                if (atualiza) {
                    textoAntigo = str;
                    atualiza = false;
                    return;
                }

                if (str.length() > textoAntigo.length()) {
                    int i = 0;
                    for (char m : mask.toCharArray()) {
                        if (m != '#') {
                            mascara += m;
                            continue;
                        }
                        try {
                            mascara += str.charAt(i);
                        } catch (Exception e) {
                            break;
                        }
                        i++;
                    }
                } else {
                    mascara = s.toString();
                }
                atualiza = true;
                editText.setText(mascara);
                editText.setSelection(mascara.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }
}
