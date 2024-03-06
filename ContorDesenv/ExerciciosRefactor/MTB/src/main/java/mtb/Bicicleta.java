
package mtb;

public class Bicicleta
{
    // la clase Bicicleta tiene tres campos
    public int cadencia;
    public int marcha;
    public int velocidad;

    // la clase Bicicleta tiene un constructor
    public Bicicleta(int cadenciaIni, int velocidadIni, int marchaIni)
    {
        marcha = marchaIni;
        cadencia = cadenciaIni;
        velocidad = velocidadIni;
    }

    // la clase Bicicleta tiene cuatro métodos
    public void setCadencia(int nuevoValor) { //establecer cadencia
        cadencia = nuevoValor;
    }

    public void setMarcha(int nuevaMarcha) { //establecer marcha
        marcha = nuevaMarcha;
    }

    public void frenar(int decremento) { //aplicar freno
        velocidad -= decremento;
    }

    public void acelerar(int incremento) {  //acelerar
        velocidad += incremento;
    }

    public int getCadencia()
    {
        return cadencia;
    }

    public int getMarcha()
    {
        return marcha;
    }

    public int getVelocidad()
    {
        return velocidad;
    }
}