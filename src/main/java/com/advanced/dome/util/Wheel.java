package com.advanced.dome.util;

import java.util.Date;

/**
 * @author guohong
 */
public class Wheel implements Cloneable{

    private String brand;
    private Date specification ;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getSpecification() {
        return specification;
    }

    public void setSpecification(Date specification) {
        this.specification = specification;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Wheel clone = (Wheel) super.clone();
        clone.specification = (Date) clone.getSpecification().clone();
        return clone;
    }

    @Override
    public String toString() {
        System.out.println("hah");
        return "Wheel{" +
                "brand='" + brand + '\'' +
                ", specification=" + specification +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Wheel wheel = new Wheel();
        Date date = new Date(1233L);
        wheel.setBrand("a");
        wheel.setSpecification(date);
        System.out.println(wheel);


    }
}
