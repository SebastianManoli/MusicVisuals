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
        main.loadPixels();
        float n = (main.mouseX * 10.0f) / main.width;
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