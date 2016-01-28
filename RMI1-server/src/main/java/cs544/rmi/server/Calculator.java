
package cs544.rmi.server;

import java.io.Serializable;

public class Calculator implements Serializable{
    private int number=0;   
    private String operator;
    private int input;

    public int getInput() {
        return input;
    }
    
   public Calculator(int x, String operator){
   this.input=x;   
   this.operator=operator;   
   }   
   public synchronized int add(int y){ 
       return this.number+=y; 
   }
   public synchronized int subtract(int y){ 
       return this.number -=y;
   }
   public synchronized int times(int y){
       return this.number *=y;
   }
   public synchronized int divide(int y){
       if(y !=0){ return this.number /=y;} 
       else return 0;
   }
   public String calculate(){
     if(this.operator.equals("+")){
         return "The current state of Number property is ="+ add(input);
     }
      if(this.operator.equals("-")){
         return "The current state of Number property is ="+subtract(input);
     }
       if(this.operator.equals("*")){
         return "The current state of Number property is ="+times(input);
     }
        if(this.operator.equals("/")){
         return "The current state of Number property is ="+divide(input);
     }
      return "you have to choose one from here [+,-,*,/]";
   }
   
    
}
