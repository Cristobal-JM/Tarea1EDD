import java.util.ArrayList;
import java.util.List;

public class Trie {
    private Nodo root = new Nodo();

    private static int indice(char c){
        return c - 'A';
    }

    public void insertar(String w){
        if (root==null || w ==null || w.length()==0) return;
        insert(root,w, 0);
    }

    private void insert(Nodo n, String w, int i){
        int indice = indice(w.charAt(i));
        if (n.getPuntero(indice)==null){
            n.setPuntero(indice,new Nodo());
        }
        if (i==w.length() - 1){
            n.marcarFinPalabra(indice);
        }
        else {
            insert(n.getPuntero(indice),w,(i+1));
        }
    }

    public boolean buscar(String w) {
        if (root == null || w == null || w.length() == 0) return false;
        return search(root, w, 0);
    }

    private boolean search(Nodo n, String w, int i) {
        int idx = indice(w.charAt(i));
        if (n.getPuntero(idx) == null) {
            return false;
        }
        if (i == w.length() - 1) {
            return n.palabraCompleta(idx);
        }
        return search(n.getPuntero(idx), w, i + 1);
    }

    public boolean eliminar(String w) {
        if (root == null || w == null || w.length() == 0) return false;
        if (!buscar(w)) return false;
        return delete(root, w, 0);
    }

    private boolean delete(Nodo n, String w, int i) {
        int idx = indice(w.charAt(i));
        if (i == w.length() - 1) {
            n.desmarcarFinPalabra(idx);
            return true;
        }
        return delete(n.getPuntero(idx), w, i + 1);
    }

    public ArrayList<String> autocompletar(String prefijo) {
        ArrayList<String> resultados = new ArrayList<>();
        if (root == null || prefijo == null || prefijo.length() == 0) {
            return resultados;
        }
        buscarPrefijo(root, prefijo, 0, resultados);
        return resultados;
    }


    private void buscarPrefijo(Nodo n, String prefijo, int i, ArrayList<String> resultados) {
        int idx = indice(prefijo.charAt(i));

        if (n.getPuntero(idx) == null) {
            System.out.println("No existen palabras con el prefijo ingresado.");
            return;
        }

        if (i == prefijo.length() - 1) {
            if (n.palabraCompleta(idx)) {
                System.out.println(prefijo);
            }
            recolectar(n.getPuntero(idx), prefijo, resultados);
        } else {
            buscarPrefijo(n.getPuntero(idx), prefijo, i + 1, resultados);
        }
    }

    private void recolectar(Nodo n, String palabraActual, ArrayList<String> resultados) {
        if (n == null) return;

        for (int i = 0; i < 26; i++) {
            char letra = (char) ('A' + i);

            if (n.palabraCompleta(i)) {
                System.out.println(palabraActual + letra);
            }

            if (n.getPuntero(i) != null) {
                recolectar(n.getPuntero(i), palabraActual + letra, resultados);
            }
        }
    }
}
