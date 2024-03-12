package com.mycompany.mavenproject3;


public class Pracownik {
    private String imie, nazwisko, stanowisko;
    private int stazPracy;
    private double pensja;
    
    public String getImie()
    {
        return imie;
    }
    public void setImie(String newImie)
    {
        this.imie = newImie;
    }
    
    public String getNazwisko()
    {
        return nazwisko;
    }
    public void setNazwisko(String newNazwisko)
    {
        this.nazwisko = newNazwisko;
    }
    public String getStanowisko(){
        return stanowisko;
    }
    public void setStanowisko(String newStanowisko){
     this.stanowisko = newStanowisko;   
    }
    public int getStazPracy(){
        return stazPracy;
    }
    public void setStazPracy(int newStazPracy){
        this.stazPracy = newStazPracy;
    }
    public double getPensja(){
        return pensja;
    }
    public void setPensja(){
        if(stanowisko.equals("manager")){
            this.pensja = 4500 + 150 * stazPracy + 500;
        }
        else if(stanowisko.equals("kierownik")){
            this.pensja = 4500 + 150 * stazPracy + 1000;
        }
        else
        {
            this.pensja = 4500 + 150 * stazPracy;
        }
    }
    
    public Pracownik(){
        imie = "temp";
        nazwisko = "temp";
        stazPracy = 0;
        pensja = 0;
        stanowisko = "temp";
    }
    
    public Pracownik(Pracownik poprzedniPracownik){
        this.imie = poprzedniPracownik.imie;
        this.nazwisko = poprzedniPracownik.nazwisko;
        this.stanowisko = poprzedniPracownik.stanowisko;
        this.stazPracy = poprzedniPracownik. stazPracy;
        this.pensja = poprzedniPracownik.pensja;
    }
    
    public Pracownik(String imie, String nazwisko, String stanowisko, int stazPracy){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.stazPracy = stazPracy;
        setPensja();
    }
    
    public boolean ZwiekszPensja(double wzrost){
        if(pensja > 10000){
            return false;
        }
        else{
            this.pensja = this.pensja * (1 + wzrost);
            return true;
        }
    }
    
    public void ZwiekszStaz(){
        this.stazPracy ++;
        setPensja();
    }
    
    
}
