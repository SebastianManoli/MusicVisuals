package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

public class DanellesVisual extends Visual
{
    MainVisual main;

    //declare global variables
    int numBalls = 12;
    float spring = 0.05f;
    float gravity = 0.03f;
    float friction = -0.9f;
    Ball[] balls = new Ball[numBalls];

    public DanellesVisual(MainVisual main){
        this.main = main;
    }

    public void render() {

        for (int i = 0; i < numBalls; i++)
        {
            balls[i] = new Ball(main.random(main.width), main.random(main.height), main.random(30, 70), i, balls);
        
        }

        main.noStroke();
        main.fill(255, 204);

        main.background(0);
        for (Ball ball : balls) {
            ball.collide();
            ball.move();
            ball.display();
            //ball.changeColor();
        }
    }


//class that holds methods and attributes for the balls' movement, collision and shape and colour
class Ball 
{
    float x;
    float y;
    float diameter;
    float vx = 0;
    float vy = 0;
    int id;
    Ball[] others;
    //int color;

    //constructor
    Ball(float xin, float yin, float din, int idin, Ball[] oin) {
        x = xin;
        y = yin;
        diameter = din;
        id = idin;
        others = oin;
        //color = main.color(main.random(255), main.random(255), main.random(255));
    }

    /* 
    void changeColor() {
        color = main.color(main.random(180), main.random(180), main.random(80));
    } 
    */

    //method so that the balls move and bounce off sides
    void collide()
    {
        for (int i = id + 1; i < numBalls; i++)
        {
            float dx = others[i].x - x;
            float dy = others[i].y - y;
            float distance = main.sqrt(dx*dx + dy*dy);
            float minDist = others[i].diameter/2 + diameter/2;

            //if the balls collide
            if (distance < minDist)
            {
                float angle = main.atan2(dy, dx);
                float targetX = x + main.cos(angle) * minDist;
                float targetY = y + main.sin(angle) * minDist;
                float ax = (targetX - others[i].x) * spring;
                float ay = (targetY - others[i].y) * spring;
                vx -= ax;
                vy -= ay;
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
        if (y + diameter/2 > main.height/2) {
            y = main.height/2 - diameter/2;
            vy *= friction;
        }
        else if (y - diameter/2 < 0) {
            y = diameter/2;
            vy *=friction;
        }
    }

    void display() {
        main.ellipse(x, y, diameter, diameter);
    }

}

}






























