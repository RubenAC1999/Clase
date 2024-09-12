package Ejercicios;

public class Acronimos {
    public static void main(String[] args) {
        Acronimos instancia = new Acronimos();
        String cadena = "Ruben Agra";
        System.out.println(instancia.obtenerAcronimo(cadena));
    }
    public String obtenerAcronimo(String cadena){
        String resultado="";
        char caracter;
        int n=cadena.length();
        for(int i=0;i<n;i++){
            caracter=cadena.charAt(i);
            if(caracter!=' '){
                if (i==0){
                    resultado=resultado+caracter+'.';
                }
                else{
                    if(cadena.charAt(i-1)==' '){
                        resultado=resultado+caracter+'.';
                    }
                }
            }
        }
        return resultado;
    }
}