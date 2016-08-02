/**
 * RequerimentoWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.edu.ifms.requerimentos.ws;

public interface RequerimentoWS extends java.rmi.Remote {
    public java.lang.String autenticaUsuario(java.lang.String siape, java.lang.String senha) throws java.rmi.RemoteException;
    public java.lang.String salvaServidor(java.lang.String servidor) throws java.rmi.RemoteException;
    public java.lang.String verificaCpf(java.lang.String cpf) throws java.rmi.RemoteException;
    public java.lang.String getTodosServidores() throws java.rmi.RemoteException;
    public java.lang.String getRequerimentoMobile(java.lang.String cpf) throws java.rmi.RemoteException;
}
