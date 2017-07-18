package com.blazingkin.SAGE.SkyLimit;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class SageMain extends Core {	public static void main(String[] args) { new SageMain().run();
	}

	public void init(){
		super.init();
		things = new LinkedList<Integer>();
		thingsX = new LinkedList<Integer>();
		thingsY = new LinkedList<Integer>();
		s.getFullScreenWindow().addKeyListener(kl);
	}

public void draw(Graphics2D g) {
timer++;
g.clearRect(0, 0, s.getWidth(), s.getHeight());
g.setColor(new Color(0,148,255));
g.fillRect(0, 0, s.getWidth(), s.getHeight());
g.drawImage(new ImageIcon("Images/Sun.png").getImage(), (s.getWidth()/8) , s.getHeight()/8, s.getHeight()/8, s.getHeight()/8, null);

Random r = new Random();
r.setSeed(System.currentTimeMillis());

if (r.nextInt(10) == 0){
	things.add(r.nextInt(4));
	thingsX.add(r.nextInt(100));
	thingsY.add(0);
}


for (int i = 0; i < things.size(); i++){

int posX = (s.getWidth()/100)*thingsX.get(i);
int posY = s.getHeight() - ((s.getHeight()/100)*thingsY.get(i));
g.drawImage(new ImageIcon(links[things.get(i)]).getImage(), posX, posY, s.getWidth()/10, s.getWidth()/10, null);



if (thingsY.get(i) >= 150){
things.remove(i);
thingsX.remove(i);
thingsY.remove(i);
i-=1;
}else{
thingsY.set(i, thingsY.get(i)+1);
}

}
if (timer == 30){
	timer = 0;
	if (textCount != 4){
		textCount++;
	}
}
g.setColor(Color.black);
g.drawString(text[textCount], (s.getWidth()/2) /*- (s.getWidth()/10)*text[textCount].length()*/, s.getHeight()/2);
}


public List<Integer> things;
public List<Integer> thingsX;
public List<Integer> thingsY;
public String links[] = {"Images/BalloonBlue.png","Images/BalloonRed.png","Images/BalloonGreen.png","Images/Cloud.png"};
public String text[] = {"The world seems like an empty place...", "...Until you start to look around...", "...Then suddenly the possibilities become endless...", "...And then...", "The skys the limit!"};
public int timer = 10;
public int textCount = 0;
KeyInput kl = new KeyInput();
}
