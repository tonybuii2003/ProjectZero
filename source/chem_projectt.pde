import peasy.*;
PImage h;
PImage hd;
Nucleus es;
PeasyCam cam;
void setup() {
  size (1500, 900, P3D);
  cam = new PeasyCam(this, 100);
  es = new Nucleus(50, 0, 0, 255);
  h = loadImage("hand.jpg");
  hd = loadImage("hand_dead.jpg");
  es.showElectron(99);
}
void draw() {
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
