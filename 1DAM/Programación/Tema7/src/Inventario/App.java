package Inventario;

public class App {
    public static void main(String[] args) {
        Producto producto1 = new Producto("jeje", 20);
        Producto producto2 = new Producto("jojo", 50);
        Producto producto3 = new Producto("jiji", 10);

        Producto[] listaProductos = {producto1, producto2, producto3};

        System.out.println(Tienda.precioTotal(listaProductos));
        System.out.println(Tienda.productoMasCaro(listaProductos));
        }
    }

