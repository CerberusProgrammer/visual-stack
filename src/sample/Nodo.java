package sample;

public class Nodo {
    private char dato;
    private Nodo liga;
    public Nodo()
    {
        dato = '\n';
        liga = null;
    }
    public Nodo(char x)
    {
        dato = x;
        liga = null;
    }
    public char obtenerDato()
    {
        return dato;

    }
    public Nodo obtenerLiga()
    {
        return liga;
    }
    public void asignarDato(char x)
    {
        dato= x;
    }
    public void asignarLiga(Nodo x)
    {
        liga = x;
    }
}
