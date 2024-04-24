package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

public class SebsVisual extends Visual
{

    MainVisual main;

    //decalreing variables
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
        main.sphereDetail(currentSphereDetail); // Set sphere detail to the lerped amplitude value
        main.background(0);
        main.stroke(MainVisual.map(10*main.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255); // Setting  stroke color to do cool things
        main.strokeWeight(1);

        // main.noStroke();

        // Set the light direction color based on the amplitude to shine on the top and bottom halves of the sphere
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

    
        //spotlights in the sphere moving sporadically
        main.spotLight(130, 700, 500, spotlightX, spotlightY, 600, 0, 0, -1, MainVisual.PI/2, 600);
        main.spotLight(220, 700, 500, spotlightY, spotlightY, 600, 0, 0, -1, MainVisual.PI/2, 600);


        main.pushMatrix();
        
        main.camera(0, 0, 0, 0, 0, -1, 0, 1, 0); // setting camera position


        // rotating the sphere
        main.translate(0, 0, -200);
        main.rotateX(angle);
        main.rotateZ(angle);   

        // setting the sphere size to move with the ampltide to add a bit more movement 
        float sphereSize = 20 + (150 * main.getSmoothedAmplitude()); 
        main.sphere(sphereSize);

        main.popMatrix();
        angle += 0.01f;


        int gridSize = 10;

        // having a brackgournd grid with a smaller grid size so the spotlights can reflect off the grid 
        for (int x = gridSize; x <= main.width - gridSize; x += gridSize) {
            for (int y = gridSize; y <= main.height - gridSize; y += gridSize) {
                main.noStroke();
                main.fill(255);
                main.rect(x-1, y-1, 3, 3);
                main.stroke(255, 0);
                main.line(x, y, main.width/2, main.height/2);
            }
        }

        gridSize = 50;
        // grid with larger gridsize with lines pointing to every corner
        for (int x = gridSize; x <= main.width - gridSize; x += gridSize) {
            for (int y = gridSize; y <= main.height - gridSize; y += gridSize) {
                float c = Visual.map(main.getSmoothedAmplitude()*10*y, 0, main.getAudioBuffer().size(), 0, 255); // color mapping
                main.stroke(c, 4000*main.getSmoothedAmplitude(), 255); // setting stroke color
                main.rect(x-1, y-1, 1, 1); 
                main.line(x, y, main.width/2, main.height/2);
    
            }
        }
    }

}