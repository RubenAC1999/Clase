package Inventario;

public class Tienda {

    public static double precioTotal(Producto[] a) {
        double acumulador = 0;
        for (int i = 0; i < a.length; i++) {
            acumulador += a[i].getPrecio();
        }

        return acumulador;
    }

    public static double productoMasCaro(Producto[] a) {
        double productoMasCaro = a[0].getPrecio();

        for (Producto producto : a) {
            if (producto.getPrecio() > productoMasCaro) {
                productoMasCaro = producto.getPrecio();
            }
        }

        return productoMasCaro;
    }
}
