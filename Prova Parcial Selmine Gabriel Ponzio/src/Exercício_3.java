import java.util.Scanner;
import java.util.Random;

public class Exercício_3 {

	public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	int Ncidades;
	
	System.out.print("Informe o número de cidades: ");
	Ncidades = teclado.nextInt();
	String[] cidades = new String[Ncidades];
	int[][] voo = new int[Ncidades][Ncidades];
	cidades = nomeador(cidades);
	voo = tempo_de_voo(voo);
	
	impressor(cidades,voo);
	leitor(cidades,voo);
	
	}
	
	//Parte 1
	public static String[] nomeador(String[] nomes) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o nome das cidades abaixo");
		for(int i = 0; i < nomes.length; i++) {
			System.out.print("Digite o nome da " + (i+1) + "ª cidade: ");
			nomes[i] = teclado.nextLine();
		}
		return nomes;
	}

	//Parte 2
	public static int[][] tempo_de_voo(int[][] cidades){
		Random gerador = new Random();
		for(int i = 0; i < cidades.length; i++) {
			for(int j = 0; j < cidades[i].length; j++) {
				if(i == j) {
					cidades[i][j] = 0;
				}else if(cidades[i][j] == 0) {
					cidades[i][j] = gerador.nextInt(1, 10);
					cidades[j][i] = cidades[i][j];
				}
				
			}
		}
		return cidades;
	}
	
	//Parte 3
	public static void impressor(String[] cidades, int[][] voo) {
		System.out.println();
		for(int i = 0; i < cidades.length; i++) {
			if(i == 0) {
				System.out.print("  \t" + cidades[i] + "\t");
			}else {
				System.out.print("" + cidades[i] + "\t");
			}
		}
		System.out.println();
		for(int i = 0; i < cidades.length; i++) {
			System.out.print(cidades[i] + "\t");
			for(int j = 0 ; j < voo[i].length; j++) {
					System.out.print("|" + voo[i][j] + "| \t");
				
			}
			System.out.println();
		}
	}
	
	//Parte 4
	public static void leitor(String[]cidades,int[][] voo) {
		Scanner teclado = new Scanner(System.in);
		String aux, aux2;
		int indice = -1, indice2 = -1;
		boolean teste = false;
		
	do {
		System.out.println("\nConsultor de tempo de viagem");
		System.out.println("Digite o nome da 1ª cidade (o nome deve ser exatamente igual ao digitado acima): ");
		aux = teclado.nextLine();
		System.out.println("Digite o nome da 2ª cidade (o nome deve ser exatamente igual ao digitado acima): ");
		aux2 = teclado.nextLine();
		
		for(int i = 0; i < cidades.length; i++) {
			if(aux.equals(cidades[i])) {
				indice = i;
			}else if(aux2.equals(cidades[i])) {
				indice2 = i;
			}
			
		}
		if(indice != -1 && indice2 != -1) {
			teste = true;
		}else {
			teste = false;
			System.out.println("Cidade não encontrada! \ntente novamente");
		}
	}while(teste != true);
	
		System.out.println("O tempo de voo entre " + aux + " e " + aux2 + " será de " + voo[indice][indice2] + " horas!");
	}
}
