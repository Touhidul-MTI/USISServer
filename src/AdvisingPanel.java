
import java.util.*;
public class AdvisingPanel {
    Scanner kb=new Scanner(System.in);
    
    private int seatTotal=3;
    private int sectionNumber=3;
    private int size=0;
    Course courseArray[]=new Course[seatTotal*sectionNumber];
    
    public int sec1=0;
    public int sec2=0;
    public int sec3=0;
    String courseName="CSE310";
    
    public void option(String name, String ID){
        System.out.println("[ Loged In Successfully ]");
        for(int i=0; i<1; i++){
            System.out.println("[ Command (Supports IgnoreCase)]");
            System.out.println(" ------------------------------");
            System.out.println("| A or a to Add Course            |");
            System.out.println("| D or d to Drop a Course        |");
            System.out.println("| P or p to Print Your Details  |");
            System.out.println("| Anything Else to Log Out     |");
            System.out.println(" ------------------------------");
            
            String key=kb.next();
            if(key.equalsIgnoreCase("A")){
                add(name, ID);
                i--;
            }else if(key.equalsIgnoreCase("D")){
                drop(name, ID);
                i--;
            }else if(key.equalsIgnoreCase("P")){
                show(name, ID);
                i--;
            }else{
                i++;
            }
        }
        System.out.println(" --------------------");
        System.out.println("| You are Loged Out! |");
        System.out.println(" --------------------");
    }
    
    public void add(String name, String ID){
        
        if(!repeatCheck(ID)){
            System.out.println("[ You Have Already Taken This Course ]");
        }else{
        System.out.println("[ Only Course "+courseName+" is Available ]");
        System.out.println(" -----------------------");
        System.out.println("| Choose a Section:     |");
        System.out.println("| _____________________ |");
        System.out.println("| Enter 1 for Section 1 |");
        System.out.println("| Enter 2 for Section 2 |");
        System.out.println("| Enter 3 for Section 3 |");
        System.out.println(" -----------------------");
        
            int sec=kb.nextInt();
        if(sec==1){
            if(sec1<seatTotal){
                System.out.println("[ Section 1 Has Been Added Successfully ]");
                courseArray[size]=new Course(name, ID, courseName, 1, "10:00am-11:30am");
                size++;
                sec1++;
            }else{
                System.out.println("[ Sorry! No Seat Available in Section 1 ]");
            }
        }else if(sec==2){
            if(sec2<seatTotal){
                System.out.println("[ Section 2 Has Been Added Successfully ]");
                courseArray[size]=new Course(name, ID, courseName, 2, "12:00pm-01:30pm");
                size++;
                sec2++;
            }else{
                System.out.println("[ Sorry! No Seat Available in Section 2 ]");
            }
        }else if(sec==3){
            if(sec3<seatTotal){
                System.out.println("[ Section 3 Has Been Added Successfully ]");
                courseArray[size]=new Course(name, ID, courseName, 3, "02:00pm-03:30pm");
                size++;
                sec3++;
            }else{
                System.out.println("[ Sorry! No Seat Available in Section 3 ]");
            }
        }
        }
        
    }
    public boolean repeatCheck(String ID){
      for(int i=0; i<size; i++){
        if(courseArray[i].getId().equals(ID)){
          if(courseArray[i].getCourseName().equals(courseName)){
            return false;
          }
        }
      }return true;
    }
    public void drop(String name, String ID){
        int idCheck=0;
        for(int i=0; i<size; i++){
            if(ID.equals(courseArray[i].getId())){
                
                int secDrop=courseArray[i].getSection();
                if(secDrop==1){sec1--;}
                else if(secDrop==2){sec2--;}
                else if(secDrop==3){sec3--;}
                
                for(int j=i; j<size-1; j++){
                    courseArray[j]=courseArray[j+1];
                }
                courseArray[size-1]=null;
                size--;
                idCheck++;
                break;
            }
        }
        if(idCheck==0){
            System.out.println("| Name: "+name);
            System.out.println("| ID: "+ID);
            System.out.println("[ No Courses in the List to Drop]");
        }else{
            System.out.println("[ Course was Successfully Droped ]");
        }
    }
    public void show(String name, String ID){
        
        int idCheck=0;
        String takenCourse="";
        int takenSec=0;
        String classTime="";
        for(int i=0; i<size; i++){
            if(ID.equals(courseArray[i].getId())){
                idCheck++;
                takenCourse=courseArray[i].getCourseName();
                takenSec=courseArray[i].getSection();
                classTime=courseArray[i].getTime();
                break;
            }
        }
        if(idCheck==0){
            System.out.println("[ Advised Course Details ]");
            System.out.println(" ------------------------");
            System.out.println("| Name: "+name);
            System.out.println("| ID: "+ID);
            System.out.println("| No Courses in the List |");
            System.out.println(" ------------------------");
        }else{
            System.out.println("[ Advised Course Details ]");
            System.out.println(" -------------------------------");
            System.out.println("| Name: "+name);
            System.out.println("| ID: "+ID);
            System.out.println("| Course Name: "+takenCourse);
            System.out.println("| Section: "+takenSec);
            System.out.println("| Class Time: "+classTime);
            System.out.println(" -------------------------------");  
        }
        
    }
}
