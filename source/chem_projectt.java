/* autogenerated by Processing revision 1278 on 2022-01-20 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import peasy.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class chem_projectt extends PApplet {


PImage h;
PImage hd;
Nucleus es;
PeasyCam cam;
 public void setup() {
  /* size commented out by preprocessor */;
  cam = new PeasyCam(this, 100);
  es = new Nucleus(50, 0, 0, 255);
  h = loadImage("hand.jpg");
  hd = loadImage("hand_dead.jpg");
  es.showElectron(99);
}
 public void draw() {
  background(0);
  
  //ES
  beginShape();
  textSize(40);
  fill(135, 19, 200);
  text("ES", -20, 0, 100);
  textSize(15);
  text("EINSTEINIUM",-40,40,100);
  textSize(15);
  text("99", 40, -40, 100);
  text("254",-40,-40,100);
  //
  if (keyPressed){
    if (key == 'a' || key == 'A'){
  textSize(120);
  text("Melting point: 860°C", 400, 400, 100);
  text("Boiling point: 996°C", 400, 300, 100);
  text("Density: 8.84 g/cm",400,200,100);
  text("isotope: Es 253",-1500,200,100);
  endShape();
    }
  //FACT
  if (key == 'f' || key == 'F'){
  textSize(100);
  text("FACT: ES is the heaviest", 400, 500, 100);
  text("element availible to mankind", 400, 600, 100); 
  text("to use in chemical, physical experments", 400, 700, 100);
  text("ES was discovered as a component",-1500,500,100);
  text("of the fragment of the first ",-1500,600,100);
  text("hydrogen bomb in 1952",-1500,700,100);
  }
  if (key == 'd' || key == 'D'){
    textSize(100);
  
  // 
  text("Soft, silvery, paramagnetic metal",-400,-600,100); 
  text("-> highly reactive",-400,-500,100);
  }
  
  
   if (key == 'x' || key == 'X'){
  image(h,mouseX-100,mouseY-100,200,200);
  if (mouseX-100 < 500){
    image(hd,mouseX-100,mouseY-100,200,200);
  }
   }
  }
  es.show();
  es.orbit();
}
class Nucleus{
  float radius;
  float angle;
  float distance;
 PVector pos;
 PVector v;
 Nucleus[] electron;
 float speed;
 Nucleus(float r, float d,float o,int num){
   v=PVector.random3D();
   radius = r;
   angle = random(TWO_PI);
   distance = d;
   speed = o;
   v.mult(distance);
   noStroke();
   fill(num);
 }
  public void orbit(){
   angle = angle + speed;
   if (electron != null){
     for (int i = 0; i < electron.length; i++)  {
       electron[i].orbit();
     }
   }
     
 }
  public void showElectron(int total){
   electron = new Nucleus[total];
   for (int i = 0; i < electron.length; i++)  {
     float r = radius*0.25f;
     float d =  random(400,500); //DISTANCE
     float o = random(-0.2f,0.2f);
     electron[i] = new Nucleus(r,d,o,100);
 }
 }
  public void show(){
   pushMatrix();
   fill(196,202,206);
   lights();
   PVector v2 = new PVector(1,0,1);
   PVector p =v.cross(v2);
   rotate(angle,p.x,p.y,p.z);
   translate(v.x,v.y,v.z);
   sphere(radius*2 );
   if (electron != null){
   for (int i = 0; i < electron.length; i++)  {
     electron[i].show();
   }
   }
  popMatrix();
 }
 
}


  public void settings() { size(1500, 900, P3D); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "chem_projectt" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}