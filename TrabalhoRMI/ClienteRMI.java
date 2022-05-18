import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ClienteRMI
{
	static public void main (String rmi[])
	{
		try 
		{
			String localizacao = "127.0.0.1/data";
			InterfaceRMI objeto = (InterfaceRMI) Naming.lookup (localizacao);

			Scanner ler = new Scanner(System.in);
			
			//variavel menu
			int opcao = 0;
			
			//variavel para calcular o fatorial
			long fatNum = 0;
			
			//variavel para a mensagem de boas vindas
			String nome = "";
			
			//variavel para ler os números digitados
			String numeros = "";
			
			//variavel para ordernar a lista de numeros digitados
			List<Integer> listaNumeros = new ArrayList<Integer>();
			
			//variavel para validar cpf
			String CPF = "";
			
			while (opcao != 7) {
				System.out.println("\n****Menu RMI****");
				System.out.println("\n1. Fatorial");
				System.out.println("\n2. Data Atual");
				System.out.println("\n3. Hora Atual");
				System.out.println("\n4. Boas Vindas");
				System.out.println("\n5. Ordernar Lista");
				System.out.println("\n6. Validar CPF");
				System.out.println("\n7. Sair\n");
				
				opcao = ler.nextInt();
				
				//menu
				switch (opcao) {
					case 1:
						System.out.println("Digite o valor desejado para calcular o fatorial: ");
						fatNum = ler.nextInt();
						System.out.println(fatNum + "! = " + objeto.calculaFatorial(fatNum));
						break;
					case 2:
						System.out.println("A data atual no servidor eh: " + objeto.getData());
						break;
					case 3:
						System.out.println("A Hora atual no servidor eh: " + objeto.getHora());
						break;
					case 4:
						System.out.println("Digite um nome para receber a mensagem de boas vindas: ");
						ler.nextLine();
						nome = ler.nextLine();
						System.out.println(objeto.boasVindas(nome));
						break;
					case 5:
						System.out.println("Digite os numeros inteiros separando por virgula: ");
						ler.nextLine();
						numeros = ler.next();
						
						for(String numero : numeros.split(",")) {
							listaNumeros.add(Integer.parseInt(numero));
						}
						
						System.out.println("Lista ordenada: ");
						System.out.println(objeto.ordenaLista(listaNumeros));
						break;
					case 6:
						System.out.println("Digite o CPF a ser validado, sem espaços nem caracteres especiais:");
						ler.nextLine();
						CPF = ler.next();
						System.out.printf("\nResultado: ");
						if(objeto.validaCPF(CPF) == true)
							System.out.printf("O CPF eh valido");
						else System.out.printf("Erro, CPF invalido !!!\n");
						break;
					case 7:
						System.out.println("Saindo...");
						break;
					default:
						System.out.println("Opcao invalida!");
				}
				
			}

		}
		catch (Exception exc) 
		{
			System.err.println (exc.toString());
		}
	}	
}
