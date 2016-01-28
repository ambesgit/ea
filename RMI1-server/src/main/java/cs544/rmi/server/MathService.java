
package cs544.rmi.server;

public class MathService implements ICalculator{

    public String getCalculator(Calculator calculator) {
        String answer=calculator.calculate();
        return answer;
    }
    
    
    
}
