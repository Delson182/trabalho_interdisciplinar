package br.com.ifms.areq;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RequerimentoDAO {

    private static final String URL = "http://192.168.0.103:8080/RequerimentoIFMS/services/RequerimentoWS?wsdl";
    private static final String NAMESPACE = "http://ws.requerimentos.ifms.edu.br";
    private static final String CONSULTAR_ALUNO_MOB = "verificaCpf";
    private static final String CONSULTAR_REQUERIMENTOS_MOB = "getRequerimentoMobile";
    public boolean consultarAluno(String cpf){

        SoapObject aluno = new SoapObject(NAMESPACE, CONSULTAR_ALUNO_MOB);
        aluno.addProperty("cpf", cpf);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.setOutputSoapObject(aluno);
        envelope.implicitTypes = true;

        HttpTransportSE http = new HttpTransportSE(URL);

        try {
            http.call("",envelope);

            SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();

            return Boolean.parseBoolean(resposta.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Requerimento> pegarRequerimentos(String cpf){
        Type colection = new TypeToken<List<Requerimento>>(){}.getType();
        List<Requerimento> lista = new ArrayList<>();

        SoapObject requerimentos = new SoapObject(NAMESPACE, CONSULTAR_REQUERIMENTOS_MOB);
        requerimentos.addProperty("cpf", cpf);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.setOutputSoapObject(requerimentos);
        envelope.implicitTypes = true;

        HttpTransportSE http = new HttpTransportSE(URL);

        try {
            http.call("", envelope);


            SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();

            lista = (List<Requerimento>) new Gson().fromJson( resposta.toString(), colection );

            /*int count = resposta.getPropertyCount();
            for (int i = 0; i < count; i++) {
                Object objeto = resposta.getProperty(i);
                Requerimento req = new Requerimento();
                req = objeto.g

                lista.add(req);
            }*/

            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
