package br.com.ifms.areq;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class RequerimentoDAO {

    private static final String URL = "";
    private static final String NAMESPACE = "";
    private static final String CONSULTAR_ALUNO_MOB = "consultaEstudadePorCpf";
    private static final String CONSULTAR_REQUERIMENTOS_MOB = "";

    public boolean consultarAluno(){

        SoapObject aluno = new SoapObject(NAMESPACE, CONSULTAR_ALUNO_MOB);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.setOutputSoapObject(aluno);
        envelope.implicitTypes = true;

        HttpTransportSE http = new HttpTransportSE(URL);

        try {
            http.call("urn:" + CONSULTAR_ALUNO_MOB,envelope);

            SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();

            return Boolean.parseBoolean(resposta.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
