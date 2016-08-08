<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleRequerimentoWSProxyid" scope="session" class="br.edu.ifms.requerimentos.ws.RequerimentoWSProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleRequerimentoWSProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleRequerimentoWSProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleRequerimentoWSProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        br.edu.ifms.requerimentos.ws.RequerimentoWS getRequerimentoWS10mtemp = sampleRequerimentoWSProxyid.getRequerimentoWS();
if(getRequerimentoWS10mtemp == null){
%>
<%=getRequerimentoWS10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String siape_1id=  request.getParameter("siape18");
            java.lang.String siape_1idTemp = null;
        if(!siape_1id.equals("")){
         siape_1idTemp  = siape_1id;
        }
        String senha_2id=  request.getParameter("senha20");
            java.lang.String senha_2idTemp = null;
        if(!senha_2id.equals("")){
         senha_2idTemp  = senha_2id;
        }
        java.lang.String autenticaUsuario15mtemp = sampleRequerimentoWSProxyid.autenticaUsuario(siape_1idTemp,senha_2idTemp);
if(autenticaUsuario15mtemp == null){
%>
<%=autenticaUsuario15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(autenticaUsuario15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 22:
        gotMethod = true;
        String servidor_3id=  request.getParameter("servidor25");
            java.lang.String servidor_3idTemp = null;
        if(!servidor_3id.equals("")){
         servidor_3idTemp  = servidor_3id;
        }
        java.lang.String salvaServidor22mtemp = sampleRequerimentoWSProxyid.salvaServidor(servidor_3idTemp);
if(salvaServidor22mtemp == null){
%>
<%=salvaServidor22mtemp %>
<%
}else{
        String tempResultreturnp23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(salvaServidor22mtemp));
        %>
        <%= tempResultreturnp23 %>
        <%
}
break;
case 27:
        gotMethod = true;
        String cpf_4id=  request.getParameter("cpf30");
            java.lang.String cpf_4idTemp = null;
        if(!cpf_4id.equals("")){
         cpf_4idTemp  = cpf_4id;
        }
        java.lang.String verificaCpf27mtemp = sampleRequerimentoWSProxyid.verificaCpf(cpf_4idTemp);
if(verificaCpf27mtemp == null){
%>
<%=verificaCpf27mtemp %>
<%
}else{
        String tempResultreturnp28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(verificaCpf27mtemp));
        %>
        <%= tempResultreturnp28 %>
        <%
}
break;
case 32:
        gotMethod = true;
        java.lang.String getTodosServidores32mtemp = sampleRequerimentoWSProxyid.getTodosServidores();
if(getTodosServidores32mtemp == null){
%>
<%=getTodosServidores32mtemp %>
<%
}else{
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getTodosServidores32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
}
break;
case 35:
        gotMethod = true;
        String cpf_5id=  request.getParameter("cpf38");
            java.lang.String cpf_5idTemp = null;
        if(!cpf_5id.equals("")){
         cpf_5idTemp  = cpf_5id;
        }
        java.lang.String getRequerimentoMobile35mtemp = sampleRequerimentoWSProxyid.getRequerimentoMobile(cpf_5idTemp);
if(getRequerimentoMobile35mtemp == null){
%>
<%=getRequerimentoMobile35mtemp %>
<%
}else{
        String tempResultreturnp36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getRequerimentoMobile35mtemp));
        %>
        <%= tempResultreturnp36 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>