package com.example.yogaclassapp;

public class YogaClass {
    private String day;
    private String time;
    private int capacity;
    private int duration;
    private double price;
    private String type;
    private String description;

    public YogaClass(String day, String time, int capacity, int duration, double price, String type, String description) {
        this.day = day;
        this.time = time;
        this.capacity = capacity;
        this.duration = duration;
        this.price = price;
        this.type = type;
        this.description = description;
    }

    // Getters
    public String getDay() { return day; }
    public String getTime() { return time; }
    public int getCapacity() { return capacity; }
    public int getDuration() { return duration; }
    public double getPrice() { return price; }
    public String getType() { return type; }
    public String getDescription() { return description; }
}