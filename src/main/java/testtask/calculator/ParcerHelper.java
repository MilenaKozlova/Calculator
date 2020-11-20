/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask.calculator;

import testtask.calculator.structures.NumbersType;
import testtask.calculator.structures.Operations;
import testtask.calculator.structures.ParcerStruct;
/**
 *
 * @author User
 */
public class ParcerHelper {
    
    
    
       static Operations getOperations(Character ch) throws Exception{
        Operations result = null;
        switch(ch){
            case '+' -> result = Operations.Sum;
            case '-' -> result = Operations.Sub;
            case '*' -> result = Operations.Mul;
            case '/' -> result = Operations.Div;
            default -> {
              throw new Exception("Entered data is incorrect");
            }
        }
        return result;
    }
       
    public static NumbersType GetNumbersType(String inputString){
        NumbersType resultNumbersType = NumbersType.Unknow;        
        Character firstChar =  Character.toUpperCase(inputString.charAt(0));        
        if(firstChar == 'I' || firstChar == 'V' || firstChar == 'X'){
            resultNumbersType = NumbersType.Roman;
        } else{
            if(Character.getNumericValue(firstChar) < 10){            
                resultNumbersType = NumbersType.Arabic;
            }        
        }
        return resultNumbersType;
    }
    
    
    public static Operations parceOperation(String inputString, ParcerStruct struct) throws Exception {   
        char currentChar = inputString.charAt(struct.startPosition);  
        struct.startPosition++;
        return getOperations(currentChar);
    }
    public static Integer parceArabicNumber(String inputString, ParcerStruct struct) throws Exception {    
        Integer resultNumber = null;
        int lastIndex = struct.startPosition;
        for(int i = struct.startPosition; i < inputString.length(); i++) { 
            lastIndex = i;
            char currentChar = inputString.charAt(i);      
            Integer tempNumber = Character.getNumericValue(currentChar);            
            if(tempNumber < 10 && tempNumber >= 0) {
                if(resultNumber == null){                   
                    resultNumber = tempNumber;
                } else {
                    resultNumber *= 10; 
                    resultNumber += tempNumber;       
                }
            } else{                
                break;
            }
        }  
        struct.startPosition = lastIndex;
        return resultNumber;
    }
        public static Integer parceRomanNumber(String inputString, ParcerStruct struct) throws Exception {
            int result = 0;
            int lastIndex = struct.startPosition;
            boolean stopFlag = false;
            for(int i = struct.startPosition; i < inputString.length(); i++) { 
                 if(stopFlag) break;
                 lastIndex = i;             
                 char currentChar = Character.toUpperCase(inputString.charAt(i)); 
                 switch(currentChar) {
                     case 'I' ->{
                         if((result >= 0 && result < 3) || (result >= 5 && result < 8)){
                            result++;
                         } else{
                            throw new Exception("Entered data is incorrect");
                         }
                     }
                     case 'V' -> {
                        result = GetRomanNumberForTenAndFive(5,4, result);
                     }
                     case 'X' -> {
                        result = GetRomanNumberForTenAndFive(10,9, result);
                     }
                     default ->{
                         stopFlag = true;                         
                     }
                 }                     
            }
            struct.startPosition = lastIndex;
            return result;
        }
    
    static int GetRomanNumberForTenAndFive(int thenZero,int thenOne, int currentNumber) throws Exception{
        int result;
        if(currentNumber == 0){
            result = thenZero;
        } else if(currentNumber == 1){
            result = thenOne;
        } else if(currentNumber == 5 && thenZero == 5){
            result = 10;
        } else {                            
            throw new Exception("Entered data is incorrect");
        }     
        return  result;      
    }
       
}
