package com.raparison.desktop.model;

public class TrainingState {
    private String color;
    private String message;

    public TrainingState(String color, String message) {
        this.color = color;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}