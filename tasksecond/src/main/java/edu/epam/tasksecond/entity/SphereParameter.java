package edu.epam.tasksecond.entity;

public class SphereParameter {
    private double square;
    private double volume;
    public  SphereParameter (double square, double volume){
        this.square = square;
        this.volume = volume;
    }
    public double getSquare(){

        return square;
    }
    public void setSquare(double square){

        this.square = square;
    }
    public double getVolume(){

        return volume;
    }
    public void setVolume(double volume){

        this.volume = volume;
    }
    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null || getClass()!=o.getClass()){
            return false;
        }
        SphereParameter parameter = (SphereParameter) o;
        return square == parameter.square && volume == parameter.volume ;
    }
    @Override
    public String toString(){
        final StringBuilder builder = new StringBuilder("SphereParameter{");
        builder.append("square=").append(square);
        builder.append(", volume=").append(volume);
        builder.append('}');
        return builder.toString();
    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)square;
        result = prime * result + (int)(volume);
        return result;
    }
}
