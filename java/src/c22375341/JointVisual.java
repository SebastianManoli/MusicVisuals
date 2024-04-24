package c22375341;

import ie.tudublin.*;

public class JointVisual extends Visual
{

    MainVisual main;

    // constructor
    public JointVisual(MainVisual main) {
        this.main = main;
    }

    public void render()
    {
        main.calculateAverageAmplitude();

        // set the colour mode to HSB
        main.colorMode(MainVisual.HSB);

        // load the pixel data
        main.loadPixels();
        float n = main.getSmoothedAmplitude() * 50.0f;
        float w = 16.0f;
        float h = 16.0f;
        float dx = w / main.width;
        float dy = h / main.height;

        // initialising the starting x coordinate
        float x = -w/2;

        // mapping the audio amplitude to a saturation value
        float saturation = Visual.map(main.getSmoothedAmplitude(), 0, 1, 0, 255);

        // nested loops to iterate over each pixel in the grid
        for(int i = 0; i < main.width; i++)
        {
            // initialising the starting y coordinate
            float y = -h/2;
            
            for(int j = 0; j < main.height; j++)
            {
                // mapping the audio amplitude to a colour value
                float c = MainVisual.map(main.getSmoothedAmplitude()*700, 0, main.getAudioBuffer().size(), 0, 255);
                
                // calculating the radial distance from the center of the grid
                float r = MainVisual.sqrt((x*x) + (y*y));

                // calculating the angle from the center to the current pixel
                float theta = MainVisual.atan2(y,x);

                // generate a value based on sine and cosine functions  
                float val = MainVisual.sin(n*MainVisual.cos(r) + 2 * theta);

                // set the current pixel colour based on the calculated values
                main.pixels[i+j*main.width] = main.color(c,(val + 1.0f) * 255.0f/2.0f, 255);

                // increment the y coordinate for the next pixel in the column
                y += dy;
            }
            
            // incrementing the x coordinate for the next pixel in the row
            x += dx;
        }
        // update the pixel data
        main.updatePixels();

    }

}