import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public interface InterfaceRMI extends Remote
{
	public long calculaFatorial(long fatNum) throws RemoteException;
	public String getData() throws RemoteException;
	public String getHora() throws RemoteException;
	public String boasVindas(String nome) throws RemoteException;
	public String ordenaLista(List<Integer> listaNumeros) throws RemoteException;
	public boolean validaCPF(String CPF) throws RemoteException;
}