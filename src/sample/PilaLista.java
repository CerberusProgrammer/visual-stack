package sample;

public class PilaLista {
    Nodo punta;
    public PilaLista()
    {
        punta= null;
    }
    public char obtenerTope()
    {
        char res= '\n';
        if( punta != null)
        {
            res = punta.obtenerDato();
        }
        return res;
    }
    public void apilar(char x)
    {
        Nodo q = new Nodo(x);
        if(punta==null)
        {
            punta = q;
        }
        else
        {
            q.asignarLiga(punta);
            punta = q;
        }
    }
    public char desapilar()
    {
        Nodo z;
        char res='\n';
        if( punta != null)
        {
            res= punta.obtenerDato();
            z = punta;
            punta = punta.obtenerLiga();
            z = null;

        }
        return res;
    }
    public boolean estaVacia()
    {
        if( punta== null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
