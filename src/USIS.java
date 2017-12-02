
import java.util.*;
public class USIS {
    Scanner kb=new Scanner(System.in);
    
    public int size=0;
    public User userArray[]=new User[20];
    AdvisingPanel apObj=new AdvisingPanel();
    
    public void logIn(){
        System.out.println("[ Your E-mail ]");
        String mail=kb.nextLine();
        System.out.println("[ Password ]");
        String pass=kb.nextLine();
        
        if(size==0){
           System.out.println("[ Invalid Email & Password, Please Register First ]");
           register(); 
        }else{
            int match=0;
            int logSuccess=0;

            for(int c=0; c<size; c++){
                int mailCheck=0;
                int passCheck=0;
                
                if(mail.equalsIgnoreCase(userArray[c].getEmail())){
                    mailCheck++;
                    match++;
                }
                if(pass.equals(userArray[c].getPass())){
                    passCheck++;
                }
                if(mailCheck>0 && passCheck>0){
                    apObj.option(userArray[c].getName(), userArray[c].getId());
                    logSuccess++;
                    break;
                }
            }
            if(logSuccess>0){}
            else{
                if(match==0){
                    System.out.println("[ Invalid Email & Password, Please Register First ]");
                    register();
                }else if(match>0){
                    System.out.println("[ Invalid Password, Try Again ]");
                    logIn();
                }
            }
        }
    }
    public void register(){
        if(size==userArray.length){
           User reArray[]=new User[userArray.length+3];
           for(int i=0; i<size; i++){
               reArray[i]=userArray[i];
           }
           userArray=reArray;
        }
        System.out.println(" ------------------------");
        System.out.println("| USIS Registration Form |");
        System.out.println(" ------------------------");
        
            System.out.println("[ Give Your Name ]");
            String name=kb.nextLine();
            
            System.out.println("[ Give Your Student ID ]");
            String id=kb.nextLine();
            
            System.out.println("[ Give Valid E-mail ]");
            String email=kb.nextLine();
            
            System.out.println("[ Enter password ]");
            String password=kb.nextLine();
            
            userArray[size]=new User(name, id, email, password);
            
            size++;
            
            System.out.println("[ Registration Successful! ]");
    }
}
