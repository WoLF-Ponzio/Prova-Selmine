import java.util.Scanner;
import java.util.Random;
public class Exercício_4 {

	public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	String[]meses = {"jan","fev","mar","abr","mai","jun","jul","ago","set","out","nov","dez"};
	String[]modelos = {"A","B","C","D","E","F","G","H","I","j","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	int Ntvs;
	
	System.out.print("Informe a quantidade de modelos de tvs: ");
	Ntvs = teclado.nextInt();
	int[][]tvs = new int[2][Ntvs];
	tvs = valvulas(tvs, modelos);
	impressor(tvs, modelos);
	estimativa(Ntvs,tvs, modelos, meses);
	}
	
	//Parte 1
	public static int[][] valvulas(int[][]tvs,String[]modelo) {
		Scanner teclado = new Scanner(System.in);
		for(int i = 0; i < tvs.length; i++) {
			for(int j = 0; j < tvs[i].length; j++) {
				if(i == 0) {
					System.out.print("Informe o número de valvulas do modelo " + modelo[j] + ": ");
					tvs[i][j] = teclado.nextInt();
				}else {
					System.out.print("Informe o número de auto-falantes do modelo " + modelo[j] + ": ");
					tvs[i][j] = teclado.nextInt();
				}
			}
		}
		return tvs;
	}
	
	//Parte2
	public static void impressor(int[][] tvs, String[] modelo) {
		System.out.println();
		
		for(int i = 0; i < tvs[0].length; i++) {
			if(i == 0) {
				System.out.print("\t Modelo " + (modelo[i]) + "\t");
			}else {
				System.out.print("Modelo " + (modelo[i]) + "\t");
			}
		}
		System.out.println();
		for(int i = 0; i < tvs.length; i++) {
			if(i == 0) {
				System.out.print(String.format("%.20s", "Valvulas \t"));
			}else {
				System.out.print(String.format("%.20s", "Auto-Falantes \t"));
			}
			
			for(int j = 0 ; j < tvs[i].length; j++) {
				System.out.print("|" + tvs[i][j] + "| \t");
			}
			
			System.out.println();
		}
	}
	
	//Parte 3
	public static void estimativa(int Ntvs, int[][] tvs, String[] modelo,String[] meses) {
		Scanner teclado = new Scanner(System.in);
		Random gerador = new Random();
		int mes1, mes2, aux;
		int[][] totalMes = new int[2][meses.length];
		
		System.out.println();
		System.out.println("Digite em número, o 1º mês que você deseja ver a estimativa (caso seja janeiro, digitar 0)");
		mes1 = teclado.nextInt();
		System.out.println("Digite em número, o último mês que você deseja ver a estimativa");
		mes2 = teclado.nextInt();
		aux = mes2 - mes1;
		int[][] tabela = new int [Ntvs][aux]; 
		
		for(int i = 0; i < tabela.length; i++) {
			for(int j = 0; j < tabela[i].length; j++) {
				tabela[i][j] = gerador.nextInt(3,30);
			}
		}
		
		System.out.println();
		for(int i = 0; i < aux; i++) {
			if(i == 0) {
				System.out.print("\t" + (meses[i]) + "\t");
			}else {
				System.out.print((meses[i]) + "\t");
			}
		}
		
		System.out.println();
		for(int i = 0; i < tabela.length; i++) {
				System.out.print(String.format("%.20s", "Modelo " + modelo[i] + "\t"));
			for(int j = 0 ; j < tabela[i].length; j++) {
				System.out.print("|" + tabela[i][j] + "| \t");
			}
			
			System.out.println();
		}
		
		System.out.println("Total extimado de valvulas e auto-falantes por mês");
		for(int j = 0; j < aux; j++) {
			System.out.print(String.format("%.20s", meses[j] + "\t"));
			for(int i = 0; i < tabela.length; i++ ) {
				totalMes[i][j] += tabela[j][i] * tvs[i][j];
			}
			System.out.println("Valvilas: " + totalMes[0][j] + " e Auto-falantes: " + totalMes[1][j]);
		}
		System.out.println();
		
	}
}
