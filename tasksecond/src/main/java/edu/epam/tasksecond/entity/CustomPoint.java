package edu.epam.tasksecond.entity;

public class CustomPoint {
    private double x;
    private double y;
    private double z;
    public CustomPoint(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){

        return x;
    }
    public void setX(double x){

        this.x = x;
    }
    public double getY(){

        return y;
    }
    public void setY(double y){

        this.y = y;
    }
    public double getZ(){

        return z;
    }
    public void setZ(double z){

        this.z = z;
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null || getClass()!=o.getClass()){
            return false;
        }
        CustomPoint sphere = (CustomPoint)o;
        return x == sphere.x && y == sphere.y && z == sphere.z;
    }
    @Override
    public String toString(){
        final StringBuilder builder = new StringBuilder("Point{");
        builder.append("x=").append(x);
        builder.append(", y=").append(y);
        builder.append(", z=").append(z);
        builder.append('}');
        return builder.toString();
    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + Math.abs((int)(x));
        result = prime * result + Math.abs((int)(y));
        result = prime * result + Math.abs((int)(z));
        return result;
    }
}
