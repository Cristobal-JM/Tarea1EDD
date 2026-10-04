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

    //no se que falta aca

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
}
