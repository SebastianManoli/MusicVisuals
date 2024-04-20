package c123456;

import ie.tudublin.*;
import processing.core.PApplet;

public class DanellesVisual extends Visual
{
    MainVisual main;

    //declare global variables
    int numBalls = 12;
    float gravity = 0.03f;
    float spring = 0.05f;
    float friction = -0.9f;

    public DanellesVisual(MainVisual main){
        this.main = main;
    }

    public void render(){
        for (int i = 0; i < numBalls; i++)
        {
            balls[i] = new Ball(main.random(main.width), main.random(main.height), main.random(30, 70), i, balls);
        
        }

        main.noStroke();
        main.fill(255, 204);

        main.background(0);
        for (Ball ball : balls) {
            ball.collide();
            //ball.move();
            //ball.display(;)
        }
    }


//class that holds methods and atttributes for the balls' movement, collision and shape and colour
class Ball 
{
    float x;
    float y;
    float diameter;
    float vx = 0;
    float vy = 0;
    int id;
    Ball[] others;

    //constructor
    Ball(float xin, float yin, float din, int idin, Ball[] oin){
        x = xin;
        y = yin;
        diameter = din;
        id = idin;
        others = oin;
    }

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




















}

}






























