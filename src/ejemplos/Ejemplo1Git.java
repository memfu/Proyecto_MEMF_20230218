package ejemplos;

import java.util.Scanner;

public class Ejemplo1Git {

	public static void main(String[] args) {
		Scanner scDNI = new Scanner (System.in);
		int dni = 0;
		boolean dniright = false;
		String salto = "\n";
		
		Scanner scLetter = new Scanner (System.in);
		char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		boolean letra = false;
		char letradni = 'a';
		
		do {
			System.out.println("Introduzca su DNI (solo los números).");
			if (scDNI.hasNextInt()) { // check if it is a number
				dni = scDNI.nextInt(); // if yes save it into the variable dni
				int dnilength = String.valueOf(dni).length(); // calculate the length by converting it into a string
				if (dni < 0 || dni > 99999999) { // check if the nr is smaller than 0 and bigger than 99999999
					System.out.println("El número proporcionado no es válido." + salto);
				} else if (dnilength < 8) {// check if the number has less than 8 digits
					System.out.println("El número proporcionado no es válido, porque no tiene 8 dígitos." + salto);
					scDNI.next();
				} else {
					dniright = true;
					do {
						System.out.println("Introduzca la letra de su DNI.");
						if (scLetter.hasNextInt()) {
							System.out.println("Por favor introduza solo la letra de su DNI." + salto);
							scLetter.next();
						} else {
							letra = true;
							// 1st change it to upper case 2nd convert the string from scanner into char
							letradni = scLetter.next().toUpperCase().charAt(0); 
						}
					} while (letra == false);	
					
				}
			} else {
				System.out.println("El valor proporcionado no es válido, porque contiene letras." + salto);
				scDNI.next();
			}
		} while (dniright == false);
		
		int compareletter = dni%23;
		
		// https://www.baeldung.com/java-compare-characters
		//Chars are compared numerically. Therefore both of them must be written in upper case
		if (letras[compareletter] == letradni) {
			System.out.println("Su letra se corresponde con su número de DNI.");
		} else {
			System.out.println("La letra indicada no es correcta, ya que no se corresponde con su número de DNI.");
		}
		

	}

}
