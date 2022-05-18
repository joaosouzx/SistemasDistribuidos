import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class ServidorRMI extends UnicastRemoteObject implements InterfaceRMI {

	public ServidorRMI() throws RemoteException
	{
		super();
	}
	
	static public void main (String rmi[])
	{
		try 
		{
			ServidorRMI objetoServidor = new ServidorRMI();
			String localizacao = "127.0.0.1/data";
			Naming.rebind (localizacao, objetoServidor);
		} 
		catch (Exception exc) 
		{
			System.err.println (exc.toString());
		}
	}	

	//Fatorial
	public long calculaFatorial(long fatNum) {
		if (fatNum <=1 ) return 1;
		else return fatNum * calculaFatorial(fatNum - 1); 
	} 

	// Data
	public String getData(){
		String data = new Date().toString();
		return data;
	}
	
	// Hora
	public String getHora(){
		Date h = new Date();
		//String hora = Integer.toString(h.getHours());
		String hora = Integer.toString(h.getHours()) + ":" + Integer.toString(h.getMinutes());
		return hora;
	}
	
	//BemVindo
	public String boasVindas(String nome){
		String bemVindo = "Ola, " + nome + ". Seja bem vindo(a)! :)";
		return bemVindo;
	}	
	
	//OrdenaLista
	public String ordenaLista(List<Integer> listaNumeros){
		Collections.sort(listaNumeros);
		String listaOrdenada = listaNumeros.toString();
		return listaOrdenada;
	}
	
	//CPF
	public boolean validaCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }

        public static String imprimeCPF(String CPF) {
            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        }
    }