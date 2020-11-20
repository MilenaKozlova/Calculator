/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask.calculator;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Startup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String resultString;
        try {
        Integer result = CalculatorProcessor.process(inputString);
        resultString = result.toString();
        } catch(Exception e) {
            resultString = e.getMessage();
        }

        System.out.println(resultString);
    }  
}

