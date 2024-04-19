package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

public class SebsVisual extends Visual
{

    MainVisual main;

    float angleX = 200;
    float angleY = 0;
    float speedX = 0.05f;
    float speedY = 0.05f;

    public SebsVisual(MainVisual main) {
        this.main = main;
    }

    public void render()
    {
        main.colorMode(MainVisual.HSB);
        main.sphereDetail(150);
        main.background(0);
        main.noStroke();

        main.directionalLight(225, 102, 126, 0, -1, 0);
        main.directionalLight(100, 102, 126, 0, 1, 0);

        // Calculate spotlight positions
        float spotlightX = main.width / 2 + 90 * PApplet.sin(angleX);
        float spotlightY = main.height / 2 + 90 * PApplet.sin(angleY);

        main.spotLight(130, 300, 204, spotlightX, 360, 600, 0, 0, -1, MainVisual.PI/2, 600);
        main.spotLight(130, 300, 204, 360, spotlightY, 600, 0, 0, -1, MainVisual.PI/2, 600);

        // Update angles for animation
        angleX += speedX;
        angleY += speedY;

        main.translate(main.width/2, main.height/2, 0);

        main.sphere(120);
    }

}