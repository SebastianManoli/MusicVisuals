package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

public class DanellesVisual extends Visual
{
    MainVisual main;

    //declare global variables
    int numBalls = 20;
    float spring = 0.05f;
    float gravity = 0.05f;
    float friction = -0.9f;
    Ball[] balls = new Ball[numBalls];
    float smoothedAmplitude;
    float[] lerpedBuffer;


    public DanellesVisual(MainVisual main){
        this.main = main;
    }

    public void render() {

        float average = 0;
        float sum = 0;
        float halfHeight = main.height / 2;
        lerpedBuffer = new float[main.width];
        smoothedAmplitude = MainVisual.lerp(smoothedAmplitude, average, 0.1f);

        for (int i = 0; i < main.getAudioBuffer().size(); i++) 
        {
            sum += MainVisual.abs(main.getAudioBuffer().get(i));
            lerpedBuffer[i] = MainVisual.lerp(lerpedBuffer[i], main.getAudioBuffer().get(i), 0.05f);
        }
        average = sum / (float) main.getAudioBuffer().size();

        sum = 0;

        
        main.stroke(MainVisual.map(10*main.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        main.strokeWeight(2);
        main.fill(MainVisual.map(10*main.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);

        main.calculateAverageAmplitude();
        main.colorMode(MainVisual.HSB);

        main.background(0);
        for (Ball ball : balls) {
            ball.collide();
            ball.move();
            ball.display();
            //ball.changeColor();
        }

        for(int i =0; i < main.getAudioBuffer().size(); i++)
        {
            // These are to map through the colour specturm and change colours while visualising
            float c = Visual.map(i, 0, main.getAudioBuffer().size(), 0, 255);
            float c2 = Visual.map(i, 0, main.getAudioBuffer().size(), 255, 0);
            
            // These will add the border to all 4 sides and will be changed with the frequency of the song
            main.stroke(c, 255, 255);
            float side1 = lerpedBuffer[i] * halfHeight * 2.5f;
            main.rect(i*2, halfHeight*1.95f + side1, i, halfHeight - side1);    
            
            float side2 = lerpedBuffer[i] * halfHeight * 2.5f;
            main.rect(i*2,0 + side2, i, 0 - side2); 

            float side3 = lerpedBuffer[i] * halfHeight * 2.0f;
            main.rect(0+side3,i, 0-side3, i); 

            float side4 = lerpedBuffer[i] * halfHeight * 2.0f;
            main.rect(main.width-side4,i, main.height + side4, i);
        }

    }


//class that holds methods and attributes for the balls' movement, collision and shape and colour
public class Ball 
{
    float x;
    float y;
    float diameter;
    float vx = 0;
    float vy = 0;
    int id;
    Ball[] others;
    int[] colors;

    //constructor
    Ball(float xin, float yin, float din, int idin, Ball[] oin) {
        x = xin;
        y = yin;
        diameter = din;
        id = idin;
        others = oin;
    }


    //method so that the balls move and bounce off sides
    void collide()
    {
        for (int i = id + 1; i < numBalls; i++)
        {
            float dx = others[i].x - x;
            float dy = others[i].y - y;
            float distance = MainVisual.sqrt(dx*dx + dy*dy);
            float minDist = others[i].diameter/2 + main.getSmoothedAmplitude()*350 + diameter/2 + main.getSmoothedAmplitude()*350;

            //if the balls collide
            if (distance < minDist)
            {
                float angle = MainVisual.atan2(dy, dx);
                float targetX = x + MainVisual.cos(angle) * minDist;
                float targetY = y + MainVisual.sin(angle) * minDist;
                float ax = (targetX - others[i].x) * spring;
                float ay = (targetY - others[i].y) * spring;
                vx -= ax;
                vy -= ay;
                others[i].vx += ax;
                others[i].vy += ay;
            }
        }
    }

    void move(){
        vy += gravity;
        x += vx;
        y += vy;

        if (x + diameter/2 > main.width) {
            x = main.width - diameter/2;
            vx *= friction;
        }
        else if (x - diameter/2 < 0) {
            x = diameter/2;
            vx *= friction;
        }
        if (y + diameter/2 > main.height) {
            y = main.height - diameter/2;
            vy *= friction;
        }
        else if (y - diameter/2 < 0) {
            y = diameter/2;
            vy *= friction;
        }
    }

    void display() {
        main.ellipse(x, y, diameter+ main.getSmoothedAmplitude()*350, diameter+ main.getSmoothedAmplitude()*350);
    }

}


}


































