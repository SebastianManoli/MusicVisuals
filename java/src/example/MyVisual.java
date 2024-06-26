package example;

import ie.tudublin.*;

public class MyVisual extends Visual {
    WaveForm wf;
    AudioBandsVisual abv;

    int mode = 0;

    public void settings() {
        size(800, 800, P3D);
    }

    public void setup() {
        startMinim();

        // Call loadAudio to load an audio file to process
        loadAudio("Fred again.. & Lil Yachty & Overmono - stayinit.mp3");

        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
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
        try {
            // Call this if you want to use FFT data
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }

        switch (mode) {
            case 0:
                background(0);
                // Code goes here
                //draw a circle
                ellipse(width / 2, height / 2, 100, 100);

                break;
            case 1:
                abv.render();
                break;

            default:
                mode = 0;
        }

    }
}
