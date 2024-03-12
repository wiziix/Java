package com.mycompany.mavenproject3;


public class Punkt3D {
        private double x;
        private double y;
        private double z;
        
        public Punkt3D(){
            x = 0;
            y = 0;
            z = 0;
        }
        public Punkt3D(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
        
        public double getX(){
            return x;
}
        public void setX(double newX){
            this.x = newX;
}
        
        public double getY(){
            return y;
        }
        public void setY(double newY){
            this.y = newY;
        }
        
        public double getZ(){
            return z;
        }
        public void setZ(double newZ){
            this.z = newZ;
        }
        
        public double Odleglosc(Punkt3D punkt2){
            return Math.sqrt((Math.pow(x,2)-Math.pow(y, 2)-Math.pow(z,2)) + (Math.pow(punkt2.x,2 ) 
                    - Math.pow(punkt2.y,2) - Math.pow(punkt2.z, 2)));
        }
        
        public double odlegloscManhattanowska(Punkt3D punkt2){
            return Math.abs(x - punkt2.x) + Math.abs(y - punkt2.y) + Math.abs(z - punkt2.z);
        }
        
        
}
