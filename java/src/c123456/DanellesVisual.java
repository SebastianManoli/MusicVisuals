package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

/*public class DanellesVisual extends Visual{
    MainVisual main;

    public DanellesVisual(MainVisual main){
        this.main = main;
    }

    public void render(){
        main.colorMode(MainVisual.HSB);
        main.textSize(20);
        main.fill(255);
        main.textAlign(CENTER,CENTER);

    }
    
}*/

class Branch {

    //variable initialisation
    MainVisual main;
    float angle = 0;
    float start;
    float amplitude;

    //branch array initialisation

    Branch[] branches;

    Branch(MainVisual main, float angle, float start, float amplitude, int branches){
        
        this.main = main;
        this.angle = angle;
        this.start = start;
        this.amplitude = amplitude;
    
    }

     
}
