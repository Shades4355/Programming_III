import java.util.Date;


public class MyBoundedShape {
    // Private variables
    private String color;       // color string (ex: red)
    private boolean filled;     // whether it's filled or not
    private Date dateCreated;   // date it was created

    // Constructors
    public MyBoundedShape() {
        dateCreated = new Date();
    }

    public MyBoundedShape(String c, boolean f) {
        dateCreated = new Date();
        color = c;
        filled = f;
    }

    // toString()
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
        }

    // Accessors and mutators, grouped variable
    // Color
    public String getColor(){
        return color;
    }
    public void setColor(String c) {
        color = c;
    }

    // Filled
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean f) {
        filled = f;
    }

    // Date Created; no setter
    public Date getDateCreated() {
        return dateCreated;
    }
}