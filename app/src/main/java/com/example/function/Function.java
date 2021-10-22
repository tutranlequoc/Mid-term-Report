package com.example.function;

public class Function {
    private String function;
    private int functionImage;

    public Function(String function, int functionImage) {
        this.function = function;
        this.functionImage = functionImage;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getFunctionImage() {
        return functionImage;
    }

    public void setFunctionImage(int functionImage) {
        this.functionImage = functionImage;
    }
}
