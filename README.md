# Music Visualiser Project

Names: Sebastian Manoli, Danelle Pillay

Student Numbers: C22375341, C22348731

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
## Sebastian
For my visual I created a rotating geometric sphere where the edges increase and the detial of the sphere improves as the music plays. I also added directional lights to the sphere which gave it more life. I also created spotlights that move sporadically inside and around the sphere which I thought was really cool and added to the movement of the visual. For the background I made a grid and an iteration of lines pointing to every square in the grid covering the background of the screen. Finally I synced all the hues, colors and brightness' of all the different stroke edges in my visual to react differently with the amplitude of the music.

## Danelle
For my visual, I have multiple balls that bounce against each other and the borders of the screen. They change colours according to the amplitude. They also grow or shrink (pulse) dynamically according to the amplitude of the song. I have also added rectangles as a border that pulses based on the amplitude and creates a sort of 3D wave effect. I wanted to create a sort of "fast paced" and "rapid" visual to really match the tempo/energy of the song. I feel like the dynamic border and "flashy" bouncy balls really work well together to achieve this effect. I also really like how the bright colours compliment each other.

## Joint
For our joint visual, we decided to create an aesthetic multicoloured spiral effect. It twists according to the amplitude of the music. More spirals and details can be seen as the amplitude increases. It gets "softer" and less detailed with less spirals as the amplitude decreases. We especially like this design as it creates a sort of mesmerizing and hypnotic effect. 

# Instructions
Upon runnning the program, the main window will appear with one of the visuals showing on the screen.
| Press Key | Visual |
|-----------|-----------|
| Spacebar | Play music |
| '0' | Danelles's Visual (Default)|
| '1' | Seb's Visual |
| '2' | Our Joint Visual |


# How it works
## Sebastian
I mainly used ```getSmoothedAmplitude()``` and ``` main.getAudioBuffer().size() ``` to make the shapes and colors react with the music. I lerped the amplitude value to be the value of ```sphereDetail()``` to give the sphere the effect that it evolves and gets more defined as the music plays. It also gives it a really cool visual effect when paired with the stroke color, which I also synced to the amplitude. The background features a for loop with lines pointing in every direction of a grid. I used ``` main.getAudioBuffer().size() ``` to give the lines a rainbow effect and I used  ```getSmoothedAmplitude()``` to move the colors up and down the lines according to the music in the loop.

## Danelle
My visual responds to audio input by changing the size, colour and position of the balls based on the amplitude of the music. The rectangles create a border that represent the audio waves/spectrum, with their size and colour changing dynamically based on the amplitude of the music. In my class, I have a lerped buffer that stores the amplitude of the audio and this makes the rectangles on the border to change size and colour depending on the amplitude of the music. Overall, I mainly used the ```lerp()```, ```getAudioBuffer()``` and ```getSmoothedAmplitude()``` functions to help me achieve this. 

## Joint
The dynamic twisting spiral effect is achieved by continuously updating the pixel colours based on the audio amplitude, and the calculated value from the sine and cosine functions. As the audio changes, the amplitude affects the colour and saturation of the pixels, while the sine and cosine functions create a swirling motion.

# What I am most proud of in the assignment
## Sebastian
I am most proud of overcoming the trial and error stages when I only had a circle in the middle of my screen. And I am really glad I could express myself creatively through code which I never really thought I could do up until now. And I am more than happy with my final visual and how far I have come since i started this project. 

## Danelle
I am most proud of how my partner and I worked together. We assigned parts based on our strengths to create some pretty awesome visuals. I am most proud of how I got the balls to bounce as that took a lot of trial and error, but I am glad it was achieved. I am also proud of the spiral effect we created and this visual helped me develop my knowledge of the trigonometric methods in processing. Developing this project has also made me more confident with using git and its commands.

# Video

[![YouTube](http://img.youtube.com/vi/sg9C6jNJK3Y/0.jpg)](https://youtu.be/sg9C6jNJK3Y)

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

