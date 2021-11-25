package myprogram.circle;

import java.util.Objects;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {

        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius(){
        return this.radius;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString(){
        return "Circle {radius = " + radius + ", color = " + color + "}";
    }

    public double getArea(){
        double result = radius*radius*Math.PI;
        return result;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Circle c = (Circle) o;
        return getRadius() == c.getRadius() && Objects.equals(getColor(),c.getColor());
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31*result + Long.valueOf(Double.doubleToLongBits(radius)).hashCode();
        result = 31*result + color.hashCode();

        return result;
    }
}
