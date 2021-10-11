//Program on checking BAlanced Brackets
package com.mycompany.labsession11oct2021;

import java.util.Stack;

import java.util.Scanner;

public class BalancedBrackets {
    // function to check if the brackets are balanced
    static boolean checkIfBracketsBalanced(String expression){
        Stack<Character> stack = new Stack<Character>();
        
        // Traversing the Expression expression
        for(int i =0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            switch(ch){
                case '(':
                case '{':
                case '[': stack.push(ch);
                          continue;
            }
            if (stack.isEmpty()){
                return false;
            }
            char localChar = stack.pop();// pop a character from the stack
            switch(ch){
                case ')':{
                          if (localChar == '{' || localChar =='[')
                             return false;
                          break;
                         }
                case '}':{
                          if (localChar == '(' || localChar =='[')
                             return false;
                          break;
                         }
                case ']':{
                          if (localChar == '{' || localChar =='(')
                             return false;
                          break; 
                         } 
                }
        
        }
      return stack.isEmpty();
      
    }
    public static void main(String args[]) {
       String expression;
       Scanner sc = new Scanner(System.in);
       System.out.println( " Enter an expression ");
       expression = sc.nextLine();
       if (checkIfBracketsBalanced(expression))
           System.out.println("The entered string contains BAlanced Brackets ");
       else
           System.out.println("Brackets are not BAlanaced in the string");
    }
}
