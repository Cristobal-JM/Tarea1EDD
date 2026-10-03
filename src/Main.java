import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--Menu de opciones--");
            System.out.println("1. Buscar una palabra");
            System.out.println("2. Ingresar una palabra");
            System.out.println("3. Eliminar una palabra");
            System.out.println("4. Ingresar un prefijo y obtener sugerencias de autocompletado");
            System.out.println("5. Seleccionar una de las sugerencias para completar la palabra ingresada");
            System.out.println("6. Salir de la aplicacion");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 2: ingresarPalabra(sc, trie);
            }


        }

    }
    private static void ingresarPalabra(Scanner sc, Trie trie) {
        System.out.println("Ingresar una palabra");
        String palabra = sc.nextLine();
        trie.insertar(palabra.toUpperCase());
    }



    private static void leerTxt(Trie trie) throws IOException {
        String nombreArchivo = "diccionario.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) {
                    continue;
                }
                try {
                    trie.insertar(linea.toUpperCase());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
