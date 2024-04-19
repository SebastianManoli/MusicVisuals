package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

public class DanellesVisual extends Visual{
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
    
}
