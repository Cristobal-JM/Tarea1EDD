import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Trie trie = new Trie();
        leerTxt(trie);
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
                case 1:
                    System.out.println("Ingrese la palabra a buscar");
                    String palabra = sc.nextLine();
                    System.out.println("Esta la palabra "
                            + palabra.toUpperCase() + " en la lista?: " + trie.buscar(palabra));
                case 2:
                    System.out.println("Ingrese la palabra a insertar");
                    String wIngresar = sc.nextLine();
                    trie.insertar(wIngresar.toUpperCase());
                    break;

                case 3:
                    System.out.println("Ingrese la palabra a eliminar:");
                    String wEliminar = sc.nextLine().toUpperCase();
                    trie.eliminar(wEliminar);
                    System.out.println("Palabra eliminada.");
                    break;

                case 4:
                    System.out.println("Ingrese el prefijo:");
                    String pref = sc.nextLine().toUpperCase();
                    ArrayList<String> listPrefijos = trie.autocompletar(pref);
                    for (String p : listPrefijos) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el prefijo:");
                    String prefCompletar = sc.nextLine().toUpperCase();
                    String[] listPrefCompletar = trie.autocompletar(prefCompletar).toArray(new String[0]);
                    if (listPrefCompletar.length != 0) {
                        for (int i = 0; i < listPrefCompletar.length; i++) {
                            System.out.println(i);
                            System.out.println((i + 1) + ". " + listPrefCompletar[i]);
                        }
                        System.out.println("Seleccione un numero");
                        int prefijoSeleccionado = sc.nextInt();
                        System.out.println("Palabra seleccionada: " + listPrefCompletar[prefijoSeleccionado-1]);
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
            }
        }
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
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
