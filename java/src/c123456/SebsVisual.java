package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

public class SebsVisual extends Visual {

    MainVisual main;

    public SebsVisual(MainVisual main) {
        this.main = main;
    }

    public void render() 
    {
        main.colorMode(MainVisual.HSB);
        main.background(0);
        
    }

}