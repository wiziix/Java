package com.mycompany.mavenproject1;

public class Mavenproject1 {

    public static void main(String[] args) 
    {
       
         String str = "cddeabbce";
         
         System.out.println(MyendsWith(str, "bce"));         
         
         System.out.println(myIndexOf("cddeabbce","eab"));
         System.out.println(str.indexOf("eab"));
         
         System.out.println(myReplace(str, 'd', 'g'));
         System.out.println(str.replace('d', 'g'));
         
         System.out.println(str.substring(4));
         System.out.println(mySubstring(4, str));
    }
    
      static boolean MyendsWith(String base, String suffix)
    {
        String tempStr = "";
        
        if(suffix.length() > base.length())
        {
            return false;
        }
        else
        {
            for(int i = 0; i < base.length(); i++)
            {
               if(i >= base.length() - suffix.length())
               {
                   tempStr += base.charAt(i);
               }  
            }
            for(int i = 0; i < suffix.length(); i ++)
            {
                if(tempStr.charAt(i) != suffix.charAt(i))
                {
                    return false;
                }
            }
            
            return true;
        }
                
    }
    
          static int myIndexOf(String base, String searchedFor)
        {
            String tempStr = "";
            int IndexOf = -1;
            
        for(int i = 0; i < base.length(); i++)
        {
            if(base.charAt(i) == searchedFor.charAt(0))
            {
                if( (i + searchedFor.length()) < base.length())
                {
                for(int k = i; k < (i + searchedFor.length()); k++)
                {
                    tempStr += base.charAt(k);
                }
                }
                else
                {
                    break;
                }
                if(tempStr.length() == searchedFor.length())
                {
                for(int j = 0; j < tempStr.length(); j++)
                {
                    
                 if(tempStr.charAt(j) != searchedFor.charAt(j))
                    {
                       break;
                    }      
                 else
                    {
                     IndexOf = i;
                    }
                }
                }
                else
                {
                    break;
                }
        
            }
            else
            {
                tempStr = "";
            }
        }      
        return IndexOf;
        }
          
      static String myReplace(String base, char oldChar, char newChar)
    {
        String str = "";
        for(int i = 0; i < base.length(); i++)
        {
            if(base.charAt(i) == oldChar)
            {
                str += newChar;
            }
            else
            {
                str += base.charAt(i);
            }
        }
        return str;
    }
    
     static String mySubstring(int beginindex, String base)
    {
        String str = "";
        for(int i = beginindex; i < base.length(); i++)
        {
         str += base.charAt(i);
        }
        return str;
    }
     
     
}
