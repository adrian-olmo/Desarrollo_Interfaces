/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploherencias;

import java.awt.Point;

/**
 *
 * @author Usuario DAM 2
 */
public class Punto3D extends Point{
    
    int z;
    
    public Punto3D(int x, int y, int z){
        super (x,y);
        this.z = z;
    }

    
    public void move(int x, int y, int z) {
        super.move(x, y); //To change body of generated methods, choose Tools | Templates.
        this.z = z;
    }

   
   
    public void translate(int dx, int dy, int dz) {
        super.translate(dx, dy); //To change body of generated methods, choose Tools | Templates.
        this.z += z;
    }
    
    
    
    
}
