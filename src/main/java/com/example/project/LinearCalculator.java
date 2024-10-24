package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coordinate1, String coordinate2) {
        int indexOfComma1 = coordinate1.indexOf(","); // finding the index of the comma
        this.x1 = Integer.parseInt(coordinate1.substring(1, indexOfComma1));
        this.y1 = Integer.parseInt(coordinate1.substring(indexOfComma1 + 1, coordinate1.length() - 1));
    
        int indexOfComma2 = coordinate2.indexOf(","); // finding the index of the comma
        this.x2 = Integer.parseInt(coordinate2.substring(1, indexOfComma2));
        this.y2 = Integer.parseInt(coordinate2.substring(indexOfComma2 + 1, coordinate2.length() - 1));
    }
    
    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){
        return x1;
    }
    public int getY1(){
        return y1;
    }
    public int getX2(){
        return x2;
    }

    public int getY2(){
        return y2;
    }
    public void setX1(int newX1){
        x1 = newX1;
    }
    public void setY1(int newY1){
        y1 = newY1;
    }
    public void setX2(int newX2){
        x2 = newX2;
    }
    public void setY2(int newY2){
        y2 = newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double dist = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)); // equation: sqrt((y2-y1)^2 + (x2-x1)^2)
        return roundedToHundredth(dist); // rounding
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if (x1 == x2) {
            return -999.99; // returning -999.99 if the bottom of the slope equation is undefined
        }
        double slope = slope();
        double b = y1 - (slope * x1); // equation for b
        return roundedToHundredth(b);
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if ((x2 - x1) != 0){
            return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
        } return -999.99;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        double m = slope();
        if (m == -999.99){
            return "undefined";
        } else{
            double b = yInt(); // getting y intercept
            if (m == 0) { // if no slope, return y = b
                return "y=" + b;
            }    
            String equation = "y=" + m + "x";
            if (b > 0) {
                equation += "+" + b;
            } if (b < 0) {
                equation += "-" + Math.abs(b); // making sure to take into account -
            } return equation;            
        }
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x * 100.0) / 100.0;
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint(); 
        return "";
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if (x1 == x2 && y1 == -y2){
            return "Symmetric about the x-axis";
        } else if (x1 == -x2 && y1 == y2){
            return "Symmetric about the y-axis";
        } else if (x1 == -x2 && y1 == -y2){
            return "Symmetric about the origin";
        } else{
            return "No symmetry";
        }
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        int sumOfX = x1 + x2;
        int sumOfY = y1 + y2;
        double n1 = sumOfX / 2.0; // dividing by 2 finds the midpoint
        double n2 = sumOfY / 2.0;
        return "The midpoint of this line is: (" + n1 + "," + n2 + ")";
    }
}



