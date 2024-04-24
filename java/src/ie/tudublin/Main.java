package ie.tudublin;

import c22375341.*;

public class Main {

    public void startUI() {

        MainVisual visual = new MainVisual();

        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, visual);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}