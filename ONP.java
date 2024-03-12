package com.mycompany.problemonp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ProblemONP {

    public static void main(String[] args) 
    {    
  
        System.out.println("(9+6)*4-(1-6*2)");
        System.out.println();
        String s = Konwerter("(9+6)*4-(1-6*2)");
        System.out.println(s);
        System.out.println();
        System.out.println(Parser(s));
                 
    }   
    
    //metoda przyjmujaca na wejsciu wyrazenie zapisane w zapisie konwencjonalnym
    //a zwracajaca wyrazenie w zapisie ONP
    public static String Konwerter(String str){
        //interfejs map przypisujacy danemu operatorowi priorytet
        Map<Character, Integer> operatory = new HashMap<Character, Integer>(){
            {
                put('*', 3);
                put('/', 3);
                put('+' ,2);
                put('-' , 2);
                put('(', 1);
            }
        };
        //stos sluzacy do przechowywania operatorow i nawiasow
        Stack<Character> stack = new Stack<Character>();
        
        //lista sluzaca do przechowania elementow ONP
        List<Character> wyjscie = new ArrayList<Character>();
        String tempString = "";

        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                wyjscie.add(str.charAt(i));
            }
            else if(str.charAt(i) == '('){
                stack.add(str.charAt(i));
            }
            else if(str.charAt(i) == ')'){
                while(stack.peek() != '('){
                    wyjscie.add(stack.pop());
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && operatory.get(stack.peek()) >= operatory.get(str.charAt(i))){
                    wyjscie.add(stack.pop());
                }
                stack.push(str.charAt(i));
            }
        }
        
        while(!stack.isEmpty()){
            wyjscie.add(stack.pop());
        }
        
        //tworzenie wyjsciowego Stringa na podstawie elementow zawartych w liscie
        for(var i : wyjscie){
            tempString += i + " ";
        }
        
        return tempString.strip();
    }
    
    
    
    //metoda przyjmujaca na wejsciu wyrazenie ONP, nastepnie konwertujaca
    //je do liczby reperezentujacej rozwiazanie danego wyrazenia
    public static int Parser(String str){
       
        Stack stack = new Stack();
        String ONP = str.replace(" ", "");
        
        
        for(int i = 0; i < ONP.length(); i++){
            if(Character.isDigit(ONP.charAt(i))){
                stack.add(Integer.valueOf(String.valueOf(ONP.charAt(i))));
            }
            else{
          
                int v1 = (int)stack.pop();
                int v2 = (int)stack.pop();

                switch(ONP.charAt(i)){
                    case '+':
                        stack.push(v2 + v1);
                        
                        break;
                    case '-':
                        stack.push(v2 - v1);
                        break;
                    case '*':
                        stack.push(v2 * v1);
                        break;
                    case '/':
                        stack.push(v2 / v1);
                        break;
                    default:
                        break;
                }
                
        
            }
        
        }
        return (int)stack.pop();
    }
}
