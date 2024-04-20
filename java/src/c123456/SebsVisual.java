package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

public class SebsVisual extends Visual
{

    MainVisual main;

    float angle = 0;
    float angleX = 200;
    float angleY = 0;
    float speedX = 0.01f;
    float speedY = 0.01f;
    int numBands = 8; // Number of frequency bands
    float bandWidth; // Width of each band

    public SebsVisual(MainVisual main) {
        this.main = main;
    }

    public void render()
    {
        main.colorMode(MainVisual.HSB);
        main.sphereDetail(150);
        main.background(0);
        main.noStroke();

        main.calculateAverageAmplitude();


        main.directionalLight(225, 102, 126, 0, -1, 0);
        main.directionalLight(100, 102, 126, 0, 1, 0);

        // Generate random angles for spotlight positions
        float randomAngleX = main.random(MainVisual.TWO_PI);
        float randomAngleY = main.random(MainVisual.TWO_PI);

        // Calculate spotlight positions
        float spotlightX = main.width / 2 + 90 * PApplet.sin(randomAngleX);
        float spotlightY = main.height / 2 + 90 * PApplet.sin(randomAngleY);

        // Update angles for animation
        randomAngleX += speedX;
        randomAngleY += speedY;

        main.spotLight(130, 300, 204, spotlightX, spotlightY, 600, 0, 0, -1, MainVisual.PI/2, 600);
        main.spotLight(20, 300, 204, spotlightY, spotlightY, 600, 0, 0, -1, MainVisual.PI/2, 600);


        main.translate(main.width/2, main.height/2, 0);

        float sphereSize = 100 + (300 * main.getSmoothedAmplitude()); 
        main.sphere(sphereSize);

        // main.calculateAverageAmplitude();
        // main.stroke(MainVisual.map(main.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        // main.strokeWeight(5);
        // main.noFill();
        // main.lights();
        // main.pushMatrix();
        // //
        // main.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        // main.translate(0, 0, -200);
        // main.rotateX(angle);
        // main.rotateZ(angle);       
        // float boxSize = 50 + (200 * main.getSmoothedAmplitude()); 
        // main.box(boxSize);   
        // main.popMatrix();
        // angle += 0.01f;
    }

}