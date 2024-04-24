package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

public class SebsVisual extends Visual
{

    MainVisual main;

    float angle = 0;
    float angleX = 200;
    float angleY = 0;
    float speedX = 0.05f;
    float speedY = 0.05f;
    int targetSphereDetail = 0;
    int currentSphereDetail = 0;
    float lerpAmount = 0.1f;

    public SebsVisual(MainVisual main) {
        this.main = main;
    }

    public void render()
    {
        main.calculateAverageAmplitude();
        main.colorMode(MainVisual.HSB);

        targetSphereDetail = (int) ((200 * main.getSmoothedAmplitude()));

        // Smoothly interpolate between current and target sphereDetail
        currentSphereDetail = (int) PApplet.lerp(currentSphereDetail, targetSphereDetail, lerpAmount);

        int sphereDetail = (int) ((100 * main.getSmoothedAmplitude()));
        main.sphereDetail(currentSphereDetail);
        main.background(0);
        main.stroke(MainVisual.map(10*main.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        main.strokeWeight(1);

        // main.noStroke();


        main.directionalLight(main.getSmoothedAmplitude() * 10, 700, 206, 0, -1, 0);
        main.directionalLight(main.getSmoothedAmplitude() * 1500, 500, 126, 0, 1, 0);


        // Generate random angles for spotlight positions
        float randomAngleX = main.random(MainVisual.TWO_PI);
        float randomAngleY = main.random(MainVisual.TWO_PI);

        // Update angles for animation
        randomAngleX += speedX;
        randomAngleY += speedY;

        // Calculate spotlight positions
        float spotlightX = main.width / 2 + 90 * PApplet.sin(randomAngleX);
        float spotlightY = main.height / 2 + 90 * PApplet.sin(randomAngleY);

    
        //spotlights in the sphere
        main.spotLight(130, 700, 500, spotlightX, spotlightY, 600, 0, 0, -1, MainVisual.PI/2, 600);
        main.spotLight(220, 700, 500, spotlightY, spotlightY, 600, 0, 0, -1, MainVisual.PI/2, 600);


        main.pushMatrix();
        // //
        main.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);

        // main.translate(main.width/2, main.height/2, 0);
        main.translate(0, 0, -200);
        main.rotateX(angle);
        main.rotateZ(angle);   

        float sphereSize = 20 + (150 * main.getSmoothedAmplitude()); 
        main.sphere(sphereSize);

        main.popMatrix();
        angle += 0.01f;

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

        int gridSize = 10;
        for (int x = gridSize; x <= main.width - gridSize; x += gridSize) {
            for (int y = gridSize; y <= main.height - gridSize; y += gridSize) {
                main.noStroke();
                main.fill(255);
                main.rect(x-1, y-1, 3, 3);
                main.stroke(255, 600* main.getSmoothedAmplitude()*0);
                main.line(x, y, main.width/2, main.height/2);
            }
        }

        gridSize = 50;
        for (int x = gridSize; x <= main.width - gridSize; x += gridSize) {
            for (int y = gridSize; y <= main.height - gridSize; y += gridSize) {
                float c = Visual.map(main.getSmoothedAmplitude()*10*y, 0, main.getAudioBuffer().size(), 0, 255);
                // main.stroke(3);
                // main.fill(255);
                main.stroke(c, 255, 4000*main.getSmoothedAmplitude());
                main.rect(x-1, y-1, 1, 1);
                main.line(x, y, main.width/2, main.height/2);
    
            }
        }
    }

}