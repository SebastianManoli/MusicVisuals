# Music Visualiser Project

Name: Sebastian Manoli, Danelle Pillay

Student Number: C22375341, C22348731

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
## Sebastian
For my visual I created a rotating geometric sphere where the edges increase and the detial of the sphere improves as the music plays. I also added directional lights to the sphere which gave it more life. I also created spotlights that move sporadically inside and around the sphere which I thought was really cool and added to the movement of the visual. For the background I made a grid and an iteration of lines pointing to every square in the grid covering the background of the screen. Finally I synced all the hues, colors and brightness' of all the different stroke edges in my visual to react differently with the amplitude of the music.

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

# What I am most proud of in the assignment
## Sebastian
I am most proud of overcoming the trial and error stages when I only had a circle in the middle of my screen. And I am really glad I could express myself creatively through code which I never really thought I could do up until now. And I am more than happy with my final visual and how far I have come since i started this project. 

# Video

[![YouTube](https://youtu.be/sg9C6jNJK3Y)

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

