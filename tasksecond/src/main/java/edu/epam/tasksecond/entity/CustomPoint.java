package edu.epam.tasksecond.entity;

/**
 * Sphere points will produce sphere shapes.
 */
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
    public void setX(){

        this.x = x;
    }
    public double getY(){

        return y;
    }
    public void setY(){

        this.y = y;
    }
    public double getZ(){

        return z;
    }
    public void setZ(){

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

        return "x=" + x + ", y=" + y + ", z=" + z;
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
