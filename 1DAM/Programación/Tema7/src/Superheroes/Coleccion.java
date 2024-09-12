package Superheroes;

import java.util.ArrayList;
import java.util.Arrays;
public class Coleccion {
    private String nombreColeccion;
    private ArrayList<Figura> listaFiguras;

    public Coleccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
        listaFiguras = new ArrayList<>();
    }

    public String getNombreColeccion() {
        return nombreColeccion;
    }

    public void setNombreColeccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
    }

    public void anhadirFigura(Figura e) {
        listaFiguras.add(e);
    }

    public void subirPrecio(double cantidad, String codigo) {
        for (Figura f : listaFiguras) {
            if (codigo.equals(f.getCodigo())) {
                f.setPrecio(cantidad);
            }
        }
    }

    public String conCapa() {
        int contador = 0;
        for (Figura f : listaFiguras) {
            if (f.getSuperheroe().isCapa()) {
                contador++;
            }
        }
        String[] listaFigurasConCapa = new String[contador];
        contador = 0;

        for (int i = 0; i < listaFiguras.size(); i++) {
         if (listaFiguras.get(i).getSuperheroe().isCapa()) {
             listaFigurasConCapa[contador] = listaFiguras.get(i).getSuperheroe().toString();
         }
        }

        return Arrays.toString(listaFigurasConCapa);
    }

    public Figura masValioso() {
        Figura figuraMasValiosa = listaFiguras.get(0);
        double comparador = listaFiguras.get(0).getPrecio();
        for (int i = 0; i < listaFiguras.size(); i++) {
            if (listaFiguras.get(i).getPrecio() > comparador) {
                figuraMasValiosa = listaFiguras.get(i);
            }
        }

        return figuraMasValiosa;


    }

    public double getValorColeccion() {
        double acumulador = 0;
        for (Figura f : listaFiguras) {
            acumulador += f.getPrecio();
        }

        return acumulador;
    }

    public double getVolumenColeccion() {
        double acumulador = 0;
        double volumen = 0;
        for (Figura f : listaFiguras) {
            volumen += f.getDimensiones().getAlto() + f.getDimensiones().getAncho() + f.getDimensiones().getProfundidad();
            acumulador += volumen;

        }

        return acumulador + 200;
    }

    @Override
    public String toString() {
        return "Coleccion{" +
                "nombreColeccion='" + nombreColeccion + '\'' +
                ", listaFiguras=" + listaFiguras +
                '}';
    }
}
