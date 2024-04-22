package c123456;

import ie.tudublin.*;

public class MainVisual extends Visual {
    

    int mode = 0;

    DanellesVisual danelle;
    SebsVisual seb;

    public int branchCounter = 0;
    public float fCounter = 0;

    
    public void settings() {
        size(700, 700, P3D);
    }

    public void setup() {
        startMinim();

        // Call loadAudio to load an audio file to process
        loadAudio("Fred again.. & Lil Yachty & Overmono - stayinit.mp3");

        colorMode(HSB);

        
        seb = new SebsVisual(this);
        danelle = new DanellesVisual(this);
        for (int i = 0; i < danelle.numBalls; i++)
        {
            danelle.balls[i] = danelle.new Ball(random(width), random(height), random(30, 70), i, danelle.balls);
        
        }

        noStroke();
        fill(255, 204);

    }

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw() {
        
        background(0);

        try 
        {
            // Call this if you want to use FFT data
            calculateFFT();
        } 
        catch (VisualException e) 
        {
            e.printStackTrace();
        }

        switch (mode) 
        {
            case 0:
                danelle.render();
                break;

            case 1:
                seb.render();
                break;

            default:
                mode = 0;
        }

    }


}
