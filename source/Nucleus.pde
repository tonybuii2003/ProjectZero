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
 void orbit(){
   angle = angle + speed;
   if (electron != null){
     for (int i = 0; i < electron.length; i++)  {
       electron[i].orbit();
     }
   }
     
 }
 void showElectron(int total){
   electron = new Nucleus[total];
   for (int i = 0; i < electron.length; i++)  {
     float r = radius*0.25;
     float d =  random(400,500); //DISTANCE
     float o = random(-0.2,0.2);
     electron[i] = new Nucleus(r,d,o,100);
 }
 }
 void show(){
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
