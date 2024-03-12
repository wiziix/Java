package com.mycompany.mavenproject3;


public class Lancuch {
    private String lancuch, koncowka;
    private char pierwszaLitera;
    
    public String getLancuch(){
        return lancuch;
    }
    public String getKoncowka(){
        return koncowka;
    }
    public char getPierwszaLitera(){
        return pierwszaLitera;
    }
    
    public Lancuch(){
        lancuch = "abcdefghij";
        koncowka = "hij";
        pierwszaLitera = 'a';
    }
    public Lancuch(String lancuch){
        while(lancuch.length() < 5){
            if(((byte)lancuch.charAt(lancuch.length() - 1) + 1) <= 122){
                lancuch += (char)((byte)lancuch.charAt(lancuch.length() - 1) + 1);
            }
            else
            {
                lancuch += (char)((byte)lancuch.charAt(lancuch.length() - 1) + 1 - 26);
            }
            
        }
        this.lancuch = lancuch;
        
        this.koncowka = lancuch.substring(lancuch.length() - 3);
        
        this.pierwszaLitera = lancuch.charAt(0);
    }   
    
    public void Merge(Lancuch lancuch){
        int tempCount = 0;
        String tempLancuch = "";
        while(tempCount != this.lancuch.length()){
            tempLancuch += this.lancuch.charAt(tempCount);
            tempLancuch += lancuch.lancuch.charAt(tempCount);
            tempCount ++;
        }
        this.lancuch = tempLancuch;
    }
    
    public int ASCII(){
        int suma = 0;
        for(int i = 0; i < lancuch.length(); i++)
        {
           suma += (byte)lancuch.charAt(i);
        }
        return suma;
    }
}
