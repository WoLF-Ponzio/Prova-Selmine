import java.util.Scanner;
public class Exercício_1 {

	public static void main(String[] args) {
	int[] a = new int[5];
	int[] b = new int[5];
	int comparador = 0;
	
	a = preencher(a);
	System.out.println("\nSegundo Vetor");
	b = preencher(b);
	comparador = comparar(a,b,comparador);
	
	System.out.println("O 1º número do 1º vetor aparece " + comparador + " vezes!");
	}
	
	//Parte 1
	public static int[] preencher(int[] MA) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escolha 5 numeros para a matriz");
		for(int i = 0; i < MA.length; i++) {
			System.out.print("Digite o " + (i+1) + "º número: ");
			MA[i] = teclado.nextInt();
		}
		return MA;
	}
	
	//Parte 2
	public static int comparar(int[]a, int[] b, int comparar) {
		for(int i = 0; i < b.length; i++) {
			if(a[0] == b[i]) {
				comparar++;
			}
		}
		return comparar;
	}
}
