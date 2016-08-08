package br.edu.ifms.requerimentos.ws;

public class RequerimentoWSProxy implements br.edu.ifms.requerimentos.ws.RequerimentoWS {
  private String _endpoint = null;
  private br.edu.ifms.requerimentos.ws.RequerimentoWS requerimentoWS = null;
  
  public RequerimentoWSProxy() {
    _initRequerimentoWSProxy();
  }
  
  public RequerimentoWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequerimentoWSProxy();
  }
  
  private void _initRequerimentoWSProxy() {
    try {
      requerimentoWS = (new br.edu.ifms.requerimentos.ws.RequerimentoWSServiceLocator()).getRequerimentoWS();
      if (requerimentoWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requerimentoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requerimentoWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requerimentoWS != null)
      ((javax.xml.rpc.Stub)requerimentoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.edu.ifms.requerimentos.ws.RequerimentoWS getRequerimentoWS() {
    if (requerimentoWS == null)
      _initRequerimentoWSProxy();
    return requerimentoWS;
  }
  
  public java.lang.String autenticaUsuario(java.lang.String siape, java.lang.String senha) throws java.rmi.RemoteException{
    if (requerimentoWS == null)
      _initRequerimentoWSProxy();
    return requerimentoWS.autenticaUsuario(siape, senha);
  }
  
  public java.lang.String salvaServidor(java.lang.String servidor) throws java.rmi.RemoteException{
    if (requerimentoWS == null)
      _initRequerimentoWSProxy();
    return requerimentoWS.salvaServidor(servidor);
  }
  
  public java.lang.String verificaCpf(java.lang.String cpf) throws java.rmi.RemoteException{
    if (requerimentoWS == null)
      _initRequerimentoWSProxy();
    return requerimentoWS.verificaCpf(cpf);
  }
  
  public java.lang.String getTodosServidores() throws java.rmi.RemoteException{
    if (requerimentoWS == null)
      _initRequerimentoWSProxy();
    return requerimentoWS.getTodosServidores();
  }
  
  public java.lang.String getRequerimentoMobile(java.lang.String cpf) throws java.rmi.RemoteException{
    if (requerimentoWS == null)
      _initRequerimentoWSProxy();
    return requerimentoWS.getRequerimentoMobile(cpf);
  }
  
  
}