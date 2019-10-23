/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada;

/**
 *
 * @author Usuario DAM 2
 */
public class Entrada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //tipo = valor
        int nota1 = 5;
        int nota2;

        switch (nota1) {
            case 1:
                nota2=1;
                break;
            case 2:
                nota2=2;
                break;
            case 3:
                nota2=3;
                break;
            case 4:
                nota2=4;
                break;
            case 5:
                nota2=5;
                break;
            default:
                nota2=20;
                break;
        }
        System.out.println(nota2);
        
         int[] colNumeros = new int[3];
         int[] colNumerosdos = {1,2,3,4,5};
    
    for (int i = 0; i<colNumerosdos.length; i++){
        System.out.println(colNumerosdos[i]);
        }
    
    for (int item : colNumerosdos) {
            System.out.println(item);
        }
    Object[] arrayTipos = {1, false, "hola"};
    
    for (Object item:arrayTipos){
        if (item.getClass()== Integer.class) {
            
        }
    }
        System.out.println("El dato del array es: "+arrayTipos[0]);
        System.out.printf("El dato del array es %d y es del array %s \n", colNumeros[0]," array numeros");
      
    }
   
    
}
