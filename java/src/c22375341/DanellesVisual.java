package c22375341;

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
    float smoothedAmplitude; 
    float[] lerpedBuffer;

    //create an array of balls
    Ball[] balls = new Ball[numBalls]; 
    
    public DanellesVisual(MainVisual main){
        this.main = main;
    }

    public void render() {

        float average = 0;
        float sum = 0;

        //calculate half the height of the screen
        float halfHeight = main.height / 2;

        //create a new array of floats that is the width of the screen
        lerpedBuffer = new float[main.width];
        smoothedAmplitude = MainVisual.lerp(smoothedAmplitude, average, 0.1f);

        //for loop to iterate through the audio buffer and calculate the average
        for (int i = 0; i < main.getAudioBuffer().size(); i++) 
        {
            //sum of all the values in the audio buffer
            sum += MainVisual.abs(main.getAudioBuffer().get(i));
            lerpedBuffer[i] = MainVisual.lerp(lerpedBuffer[i], main.getAudioBuffer().get(i), 0.05f);
        }

        //this calculates the average of the sum of the values in the audio buffer
        average = sum / (float) main.getAudioBuffer().size();

        sum = 0;

        //set the stroke, stroke weight and fill to change with the amplitude of the song
        main.stroke(MainVisual.map(10*main.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        main.strokeWeight(2);
        main.fill(MainVisual.map(10*main.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);

        main.calculateAverageAmplitude();
        main.colorMode(MainVisual.HSB);

        main.background(0);

        //for loop that iterates through the balls array and calls the methods
        for (Ball ball : balls) {
            ball.collide();
            ball.move();
            ball.display();
        }

        for(int i =0; i < main.getAudioBuffer().size(); i++)
        {
            // Variables to map through the colour spectrum and change colours while visualising
            float c = Visual.map(i, 0, main.getAudioBuffer().size(), 0, 255);
            float c2 = Visual.map(i, 0, main.getAudioBuffer().size(), 255, 0);
            
            // Adds the border to all 4 sides and will be changed with the frequency of the song
            main.stroke(c, 255, 255);

            float side1 = lerpedBuffer[i] * halfHeight * 2.5f;
            main.rect(i*2, halfHeight*1.95f + side1, i, halfHeight - side1);    
            
            float side2 = lerpedBuffer[i] * halfHeight * 2.5f;
            main.rect(i*2,0 + side2, i, 0 - side2); 

            float side3 = lerpedBuffer[i] * halfHeight * 2.0f;
            main.rect(0+side3,i, 0-side3, i); 

            float side4 = lerpedBuffer[i] * halfHeight * 2.0f;
            main.rect(main.width,i, main.height + side4, i);
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
        //for loop to iterate through the balls and check if they collide 
        for (int i = id + 1; i < numBalls; i++)
        {
            float dx = others[i].x - x;
            float dy = others[i].y - y;

            //calculate the distance between the balls
            float distance = MainVisual.sqrt(dx*dx + dy*dy);

            //calculate the minimum distance between the balls and set it to change with the amplitude of the song
            float minDist = others[i].diameter/2 + main.getSmoothedAmplitude()*350 + diameter/2 + main.getSmoothedAmplitude()*350;

            //if the balls collide
            if (distance < minDist)
            {
                //calculate the angle and target x and y
                float angle = MainVisual.atan2(dy, dx);
                float targetX = x + MainVisual.cos(angle) * minDist;
                float targetY = y + MainVisual.sin(angle) * minDist;

                //calculate the new velocity
                float ax = (targetX - others[i].x) * spring;
                float ay = (targetY - others[i].y) * spring;

                //change the velocity
                vx -= ax;
                vy -= ay;
                others[i].vx += ax;
                others[i].vy += ay;
            }
        }
    }

    //method that controls the movement of the balls
    void move(){
        vy += gravity;
        x += vx;
        y += vy;

        //if the balls hit the sides of the screen
        if (x + diameter/2 > main.width) {
            x = main.width - diameter/2;
            vx *= friction;
        }

        else if (x - diameter/2 < 0) {
            x = diameter/2;
            vx *= friction;
        }

        //if the balls hit the top or bottom of the screen
        if (y + diameter/2 > main.height) {
            y = main.height - diameter/2;
            vy *= friction;
        }
        else if (y - diameter/2 < 0) {
            y = diameter/2;
            vy *= friction;
        }
    }

    //method to display the balls
    void display() {
        //set the fill to change with the amplitude of the song
        main.ellipse(x, y, diameter+ main.getSmoothedAmplitude()*350, diameter+ main.getSmoothedAmplitude()*350);
    }

}


}


































