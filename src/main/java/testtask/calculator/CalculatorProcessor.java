/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask.calculator;

import testtask.calculator.structures.Operations;
import testtask.calculator.structures.ParcerStruct;
import testtask.calculator.structures.NumbersType;

/**
 *
 * @author User
 */
public class CalculatorProcessor {
      static int process(String inputString) throws Exception {
         ParcerStruct struct = new ParcerStruct();
         Integer firstNumber;
         Operations operation;
         Integer secondNumber;
         
         switch(ParcerHelper.GetNumbersType(inputString)){
             case Arabic -> {                
                firstNumber = ParcerHelper.parceArabicNumber(inputString, struct);        
                operation = ParcerHelper.parceOperation(inputString, struct);
                secondNumber = ParcerHelper.parceArabicNumber(inputString, struct);             
             }
             case Roman -> {
                firstNumber = ParcerHelper.parceRomanNumber(inputString, struct);        
                operation = ParcerHelper.parceOperation(inputString, struct);
                secondNumber = ParcerHelper.parceRomanNumber(inputString, struct);              
             }
             default -> throw new Exception("Entered data is incorrect");        
         } 
         
        validateInputData(struct, inputString, firstNumber, secondNumber);
        return process(firstNumber, secondNumber, operation);
    }    
    static int process(Integer firstNumber, Integer secondNumber, Operations operation){
        Integer result = 0;
        switch(operation){
            case Sum:
                result = firstNumber + secondNumber;
                break;
            case Sub:
                result = firstNumber - secondNumber;
                break;
            case Mul:
                result = firstNumber * secondNumber;
                break;
            case Div:
                result = firstNumber / secondNumber;
                break;        
        }
        return result;
    }  
    static void validateInputData(ParcerStruct struct, String inputString,Integer firstNumber,Integer secondNumber) throws Exception {
        validateNumber(firstNumber);
        validateNumber(secondNumber);
        if(struct.startPosition >  inputString.length()){
            throw new Exception("Entered data is incorrect");
        }    
     
    }
    static void validateNumber(Integer number) throws Exception {
       if(number == null || number > 10 || number < 1){
            throw new Exception("Entered data is incorrect");
       }
    }
            
            
}
