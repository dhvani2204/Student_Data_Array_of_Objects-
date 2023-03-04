import java.util.*;
public class Student{
    //private variables declared
    private int prn;
    private String name;
    private String DoB;
    private int marks;
    
    //constructor to store prn,name dob and marks
    public Student(int prn,String name,String DoB,int marks){
        this.prn=prn;
        this.name=name;
        this.DoB=DoB;
        this.marks=marks;
    }
    //get and set methods for prn,name,marks and dob.
     public int getPrn(){
        return prn;
    }
    public void setPrn(int prn){
        this.prn=prn;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDoB(){
        return DoB;
    }
    public void setDoB(String DoB){
        this.DoB=DoB;
    }
     public int getMarks(){
        return marks;
    }
    public void setMarks(int marks){
        this.marks=marks;
    }
}