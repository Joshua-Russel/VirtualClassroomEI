package classroom;

import exceptions.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import postgres.*;
public class Classroom{

    private String className;

    //different types of constructor
    public Classroom(String className) {
        this.className = className;
    }

    public Classroom() {
    }


    //getter and setter for all attributes
    public String getclassName() {
        return className;
    }

    public void setclassName(String className) {
        this.className = className;
    }


    @Override
    public String toString() {
        return "Classroom{" +
                ", className='" + className + '\'' +
                '}';
    }

    //Add Classroom function creates a virtual classroom

}