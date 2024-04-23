package c123456;

import ie.tudublin.*;

public class JointVisual extends Visual
{

    MainVisual main;

    

    public JointVisual(MainVisual main) {
        this.main = main;
    }

    public void render()
    {

        main.calculateAverageAmplitude();
        main.colorMode(MainVisual.HSB);

        main.loadPixels();
        float n = main.getSmoothedAmplitude() * 50.0f;
        float w = 16.0f;
        float h = 16.0f;
        float dx = w / main.width;
        float dy = h / main.height;
        float x = -w/2;

        for(int i = 0; i < main.width; i++)
        {
            float y = -h/2;

            for(int j = 0; j < main.height; j++)
            {
                float c = Visual.map(i, 0, main.getAudioBuffer().size(), 0, 255);
                float r = MainVisual.sqrt((x*x) + (y*y));
                float theta = MainVisual.atan2(y,x);

                float val = MainVisual.sin(n*MainVisual.cos(r) + 5 * theta);
                main.pixels[i+j*main.width] = main.color((val + 1.0f) * 255.0f/2.0f);
                y += dy;
            }

            x += dx;
        }
        main.updatePixels();     
    }

}