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
}
