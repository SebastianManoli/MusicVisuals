package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

public class SebsVisual extends Visual
{

    MainVisual main;

    public SebsVisual(MainVisual main) {
        this.main = main;
    }

    public void render()
    {
        main.colorMode(MainVisual.HSB);
        main.sphereDetail(150);
        main.background(0);
        main.noStroke();

        
        main.directionalLight(51, 102, 126, 0, -1, 0);

        main.spotLight(130, 300, 204, main.mouseX, 360, 600, 0, 0, -1, MainVisual.PI/2, 600);
        main.spotLight(130, 300, 204, 360, main.mouseY, 600, 0, 0, -1, MainVisual.PI/2, 600);

        main.translate(main.width/2, main.height/2, 0);

        main.sphere(120);
    }

}