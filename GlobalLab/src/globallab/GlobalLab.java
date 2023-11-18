
package globallab;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class GlobalLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
      // Se crea un objeto Scanner para leer la entrada del usuario desde la consola.
Scanner scanner = new Scanner(System.in);

// Se declara un array de Strings llamado 'adn' con capacidad para almacenar 6 filas de secuencia de ADN.
String[] adn = new String[6];

// Se muestran mensajes al usuario para solicitar la entrada de la secuencia de ADN.
System.out.println("Ingrese la secuencia de ADN, fila por fila ");
System.out.println("Solo estos valores son aceptados: A, T, C, G");
System.out.println("Y debe tener una longitud de 6");

// Se utiliza un bucle for para iterar sobre las 6 filas de la secuencia de ADN.
for (int i = 0; i < 6; i++) {
    
    // Se lee la entrada del usuario, se convierte a mayúsculas y se almacena en la variable 'row'.
    String row = scanner.nextLine().toUpperCase();
    
    // Se utiliza un bucle while para verificar si la fila ingresada cumple con la expresión regular "[ATCG]{6}".
    // Si no cumple, se muestra un mensaje de error y se solicita al usuario que ingrese la fila nuevamente.
    while (!row.matches("[ATCG]{6}")) {
        System.out.println("Secuencia inválida. Por favor ingrese una secuencia de 6 caracteres (A, T, C, G):");
        row = scanner.nextLine().toUpperCase();
    }
    
    // La fila validada se almacena en el array 'adn'.
    adn[i] = row;
}

// Se imprime la secuencia de ADN después de haber sido ingresada y validada.
System.out.println("----------------ADN-----------------");
print_adn(adn);

// Se determina si la secuencia de ADN es mutante llamando a la función 'is_mutant' y se imprime el resultado.
System.out.println(is_mutant(adn) ? "Es mutante" : "No es mutante");
}

// Función que verifica si la secuencia de ADN es mutante.
public static boolean is_mutant(String[] adn) {
    int n = adn.length;
    boolean mutant = false;

    // Se realiza la verificación en las columnas de la matriz de ADN.
    for (int j = 0; j < n; j++) {
        for (int i = 0; i < n - 3; i++) {
            if (adn[i].charAt(j) == adn[i + 1].charAt(j) && adn[i + 1].charAt(j) == adn[i + 2].charAt(j) && adn[i + 2].charAt(j) == adn[i + 3].charAt(j)) {
                mutant = true;
            }
        }
    }

    // Se realiza la verificación en las filas de la matriz de ADN.
    for (String row : adn) {
        for (int i = 0; i < n - 3; i++) {
            if (row.charAt(i) == row.charAt(i + 1) && row.charAt(i + 1) == row.charAt(i + 2) && row.charAt(i + 2) == row.charAt(i + 3)) {
                mutant = true;
            }
        }
    }

    // Se realiza la verificación en las diagonales de la matriz de ADN.
    for (int i = 0; i < n - 3; i++) {
        for (int j = 0; j < n - 3; j++) {
            if (adn[i].charAt(j) == adn[i + 1].charAt(j + 1) && adn[i + 1].charAt(j + 1) == adn[i + 2].charAt(j + 2) && adn[i + 2].charAt(j + 2) == adn[i + 3].charAt(j + 3)) {
                mutant = true;
            }
            if (adn[i].charAt(n - j - 1) == adn[i + 1].charAt(n - j - 2) && adn[i + 1].charAt(n - j - 2) == adn[i + 2].charAt(n - j - 3) && adn[i + 2].charAt(n - j - 3) == adn[i + 3].charAt(n - j - 4)) {
                mutant = true;
            }
        }
    }

    // Se retorna el resultado de la verificación.
    return mutant;
}

// Función que imprime cada fila de la secuencia de ADN en líneas separadas.
public static void print_adn(String[] adn) {
    Arrays.stream(adn).forEach(System.out::println);
}
}
        
        
        
        
        
    
    

