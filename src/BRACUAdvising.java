
import java.util.*;
public class BRACUAdvising {

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        
        USIS obj=new USIS();
        
        System.out.println("[ Program Running ]");
        
        for ( ; ; ){
            System.out.println("|--------------------------------|");
            System.out.println("| L or l to Log in               |");
            System.out.println("| R or r to Register             |");
            System.out.println("| Anything Else to Close Program |");
            System.out.println("|--------------------------------|");
            
        String key=kb.next();
        if(key.equalsIgnoreCase("L")){
            obj.logIn();
            continue;
        }
        if(key.equalsIgnoreCase("R")){
            obj.register();
            continue;
        }
        else{
                break;
            }
        }
        System.out.println("|--------------------------|");
        System.out.println("| Program has been CLOSED! |");
        System.out.println("|--------------------------|");
    }
    
}
