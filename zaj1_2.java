package com.mycompany.mavenproject2;

public class Mavenproject2 {

    public static void main(String[] args) 
    
    {  
        String str = "abbFDSFGe";
        String str2 = "9999";
        
        System.out.println(SzyfrCezara("XYZxyzABCabc", 1));
        
        System.out.println(mytoUpperCase(str));
        System.out.println(mytoLowerCase(str));
      
        System.out.println(Palindrome("kajak"));
        System.out.println(Increment(str2));
       
    }
    
    public static String SzyfrCezara(String Base, int IndexOf)
    {
        String str = "";
     for(int i = 0; i < Base.length(); i++)
     {
         
         if( ((byte)Base.charAt(i) + IndexOf >= 65 && (byte)Base.charAt(i) + IndexOf <= 90 )
                 ||  ((byte)Base.charAt(i) + IndexOf >= 97 && (byte)Base.charAt(i) + IndexOf <= 122 ))
         {
             str += (char)((Base.charAt(i) + IndexOf));
             
         }
         else
         {
             str += (char)((Base.charAt(i)) + IndexOf - 26);
         }
     }
        return str;
    }
    
    public static String mytoUpperCase(String base)
    {
        String str = "";
        for(int i = 0; i < base.length(); i++)
        {
            if((byte)base.charAt(i) >= 97 && (byte)base.charAt(i) <= 122)
                    
            {
                str += (char)(base.charAt(i) - 32);
            }
            else
            {
                str += base.charAt(i);
            }
        }
        
        return str;
    }
    
    public static String mytoLowerCase(String base)
    {
        String str = "";
        for(int i = 0; i < base.length(); i++)
        {
            if((byte)base.charAt(i) >= 65 && (byte)base.charAt(i) <= 90)
                    
            {
                str += (char)(base.charAt(i) + 32);
            }
            else
            {
                str += base.charAt(i);
            }
        }
        
        return str;
    }
      
    public static boolean Palindrome(String base)
    {
        String rev = "";
        
        for(int i = base.length() - 1; i >= 0 ; i--)
        {
            rev += base.charAt(i);
        }
        
        if(!rev.equals(base))
        {
            return false;
        }
        
        return true;
    }
    
       public static int Increment(String base)
       {
           int temp = 1;  
           int[] tab = new int[base.length()];
           int k = tab.length - 1;   
           
           for(int i = 0; i < base.length(); i++)
           {
               tab[i] = (byte)base.charAt(i) - 48;
           }
           
           for(int j = 0; j < tab.length ; j++)
           {
               temp += tab[j] * Math.pow(10, k);                   
               k--;
           }
           
           return temp;
       }
    }

