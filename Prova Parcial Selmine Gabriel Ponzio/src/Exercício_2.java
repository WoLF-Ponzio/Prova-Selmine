import java.util.Scanner;
public class Exercício_2 {

	public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	String frase, frase_invertida = "";
	
	System.out.println("Insira uma palavra e o programa retornará ela invertida: ");
	frase = teclado.nextLine();
	frase_invertida = inversor(frase, frase_invertida);
	
	System.out.println("\nSua frase inversa ficou assim: " + "\n" + frase_invertida);
	}
	
	public static String inversor(String frase, String frase_invertida) {
		for(int i = (frase.length()-1); i >= 0; i--) {
			frase_invertida += frase.charAt(i);
		}
		return frase_invertida;
	}
}
