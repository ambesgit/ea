
package cs544.jms1;

import java.io.Serializable;

public class Calculator implements Serializable{
    private int x;
    private int y;
    private String operator;
   public Calculator(int x, int y, String operator){
   this.x=x;
   this.y=y;
   this.operator=operator;   
   }   
   public int add(){ 
       return this.x+this.y; 
   }
   public int subtract(){ 
       return this.x - this.y;
   }
   public int times(){
       return this.x * this.y;
   }
   public int divide(){
       if(this.y !=0){ return this.x/this.y;} 
       else return 0;
   }
   public String calculate(){
     if(this.operator.equals("+")){
         return "The sum of"+this.x+", and "+this.y+" ="+ add();
     }
      if(this.operator.equals("-")){
         return "The difference of"+this.x+", and "+this.y+" ="+subtract();
     }
       if(this.operator.equals("*")){
         return "The product of"+this.x+", and "+this.y+" ="+times();
     }
        if(this.operator.equals("/")){
         return "The quotient of"+this.x+", and "+this.y+" ="+divide();
     }
      return "you have to choose one from here [+,-,*,/]";
   }
   
    
}
