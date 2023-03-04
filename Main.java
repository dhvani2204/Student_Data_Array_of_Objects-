/**Name:Dhvani Uday Parekh
 Prn:21070126126
 Branch and Batch:AIML-B3
 **/
import java.util.*;
public class Main{

//declare static so that they are retained throughout the code.
  private static Scanner sc = new Scanner(System.in);
  private static Student[] s= new Student[100];
  private static int n= 0;
    
    

    public static void main(String args[]){   
//Ask user for number of students.
    System.out.println("Enter total number of students: ");
    n = sc.nextInt();
    s= new Student[n];
//Menu driven code to ask user for operation.
        int p1=1;
        do{
        System.out.println("Select choice:");
        System.out.println("1. Add Student details:");
        System.out.println("2. Display Student Info:");
        System.out.println("3. Search Student:");
        System.out.println("4. Update/Edit Student Details:");
        System.out.println("5. Delete Student:");
        int ch=sc.nextInt();
        
//Based on userinput method called to add,display,update,delete
        switch(ch){
            case 1:
                addStudent();
                break;
            case 2:
                displayStudent();
                break;
            case 3:
                System.out.println("Enter how do you want to search student");
                System.out.println("1.Search by prn");
                System.out.println("2. Search by name");
                int p=sc.nextInt();
                switch(p){
                    case 1:
                        searchByPrn();
                        break;
                    case 2:
                        searchByName();
                        break;
                }
                break;
            case 4:
                updateStudent();
                break;
            case 5:
                deleteStudent();
                break;
            }
            System.out.println("Enter 1 to continue");
            p1=sc.nextInt();
        }while(p1==1);
    }
public static void addStudent(){
//for loop to add students    
    for(int i=0;i<n;i++){
         if (s[i] == null) {
//ask user for name,prn,marks and dob and store in respective variables
    System.out.println("Enter prn: ");
        int prn = sc.nextInt();
sc.nextLine();
     System.out.println("Enter name: ");
    String name = sc.nextLine();
        System.out.println("Enter marks: ");
        int marks = sc.nextInt();
sc.nextLine();
System.out.println("Enter DoB : ");
        String dob = sc.nextLine();
//create a new array of objects and store entered details in it.then equate it to the earlier created array of objects.
        Student student = new Student(prn,name, dob, marks);
        s[i] = student;

        System.out.println("Student added successfully.");
         }
    }
     System.out.println("No space to add new student.");
    }

public static void displayStudent(){
    //to keep a count of students
        int count = 0;
//display list of students using get method.
        System.out.println("List of students:");
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                count++;
                //display the details using get method.
                System.out.println("Name: " + s[i].getName());
                System.out.println("Prn: " + s[i].getPrn());
                System.out.println("Date of Birth: " + s[i].getDoB());
                System.out.println("Marks:"+s[i].getMarks());
            }
        }
        //otherwise print no students
        if (count == 0) {
            System.out.println("No students to display.");
        }
    }
    public static void searchByName() {
        System.out.print("Enter student name to be searched: ");
        String name = sc.next();

        int c1 = 0;

        for (int i = 0; i < s.length; i++) {
            //check if any name in list matches entered name
            if (s[i] != null && s[i].getName().equals(name)) {
                c1++;
                //if found display the display using get method.
                System.out.println("Student found:");
                System.out.println("Name: " + s[i].getName());
                System.out.println("Prn: " + s[i].getPrn());
                System.out.println("Date of Birth: " + s[i].getDoB());
                System.out.println("Marks: " + s[i].getMarks());
            }
        }
//otherwise print student not found
        if (c1 == 0) {
            System.out.println("No student found with name " + name);
        }
    }

    public static void searchByPrn() {
        //ask user for prn
        System.out.print("Enter prn of student to be searched: ");
        int prn = sc.nextInt();

        int c = 0;
        
        //loop through and display details of the entered prn student.
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null && s[i].getPrn() == prn) {
                c++;

                System.out.println("Student found!");
                System.out.println("Name: " + s[i].getName());
                System.out.println("Roll Number: " + s[i].getPrn());
                System.out.println("Date of Birth: " + s[i].getDoB());
                System.out.println("Marks: " + s[i].getMarks());
            }
        }
//otherwise display below message
        if (c == 0) {
            System.out.println("No student found with roll number " + prn);
        }
    }

public static void updateStudent(){
    //ask user for prn of student to be updated
    System.out.println("\nEnter the prn of the student to be updated: ");
    int updatePrn = sc.nextInt();

    int up=0;
    //for loop to loop through and update the said student details
    for (int i = 0; i <s.length; i++) {
        if (s[i].getPrn() == updatePrn) {
            System.out.println("\nEnter new details of the student:");
            sc.nextLine();
            System.out.println("Enter name: ");
            String name = sc.nextLine();
            System.out.println("Enter DoB: ");
            String DoB = sc.next();
            System.out.println("Enter marks: ");
            int marks = sc.nextInt();
//set methods sets new updated values
            s[i].setName(name);
            s[i].setDoB(DoB);
            s[i].setMarks(marks);

            System.out.println("\nStudent details updated successfully.");
                            up =1;
}
   if (up!=1) {
                        System.out.println("\nStudent record not found.");
                    }
}
}
public static void deleteStudent(){
    //ask user for prn of student to be deleteed
    System.out.println("\nEnter the prn of the student to delete: ");
                    int delPrn = sc.nextInt();
                    //store length in a variable
                    int n=s.length;
                    //del variable to keep a track of student deleted or not.
                    boolean del = false;
                    //2 for loops: 1 to loop through the code and find entered prn student.
                    //second to adjust the remaining students
                    for (int i = 0; i <s.length; i++) {
                        if (s[i].getPrn() == delPrn) {
                            for (int j = i; j < s.length - 1; j++) {
                                s[j] = s[j + 1];
                            }
                            n--;
                            System.out.println("\nStudent record deleted successfully.");
                            del= true;
                        }
                    }
                    //otherwise show not found
                    if (del!=true) {
                        System.out.println("\nStudent record not found.");
                    }
}
}