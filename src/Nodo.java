public class Nodo {
    private Nodo[] p = new Nodo[26];
    private int b = 0;

    public Nodo getPuntero(int posicion) {
        return p[posicion];
    }

    public void setPuntero(int posicion, Nodo p) {
        this.p[posicion] = p;
    }

    public void marcarFinPalabra(int i){
        b |= (1 << i);
    }

    public void desmarcarFinPalabra(int i){
        b &= ~(1 << i);
    }

    public boolean palabraCompleta(int i){
        return (b & (1 << i)) != 0;
    }
}
