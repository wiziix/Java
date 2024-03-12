package com.mycompany.mavenproject3;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Mavenproject3 {
    
    
    public static void main(String[] args) {
        Punkt3D p3d = new Punkt3D();
        
        Punkt3D p2d = new Punkt3D(5,4,1);
        
        System.out.println(p3d.Odleglosc(p2d));
        System.out.println(p3d.odlegloscManhattanowska(p2d));
        
        Lancuch l1 = new Lancuch();
        
        Lancuch l2 = new Lancuch("aaaaa");
        
        System.out.println(l2.getPierwszaLitera());
        System.out.println(l2.getLancuch());
        System.out.println(l2.getKoncowka());
        
        Lancuch l3 = new Lancuch("aaa");
        Lancuch l4 = new Lancuch("bbb");
        
        l4.Merge(l3);
        
        System.out.println(l4.getLancuch());
        System.out.println(l2.getLancuch() + " " +  l2.ASCII());
        
        Pracownik p1 = new Pracownik();
        System.out.println(p1.getImie() + " " + p1.getNazwisko() +
                " " + p1.getStanowisko() + " " + p1.getStazPracy() + " " + p1.getPensja());
        
        Pracownik p2 = new Pracownik("Jan", "Nowak", "Kierowca", 2);
        System.out.println(p2.getImie() + " " + p2.getNazwisko() +
                " " + p2.getStanowisko() + " " + p2.getStazPracy() + " " + p2.getPensja());
        
        p2.ZwiekszStaz();
        
        System.out.println(p2.getImie() + " " + p2.getNazwisko() +
                " " + p2.getStanowisko() + " " + p2.getStazPracy() + " " + p2.getPensja());
        
        p2.ZwiekszPensja(0.2);
        
        System.out.println(p2.getImie() + " " + p2.getNazwisko() +
                " " + p2.getStanowisko() + " " + p2.getStazPracy() + " " + p2.getPensja());
        
        Pracownik[] tabPrac = new Pracownik[15];
        
        String[] imiona = {"Michal", "Piotr", "Artur", "Wiktor", "Jan", "Milosz", "Bartosz", "Krzysztof"};
        String[] stanowiska = {"młodszy specjalista", "starszy specjalista",
            "księgowy", "manager", "kierownik"};
        Random rand = new Random();
        byte[] array = new byte[rand.nextInt(3,15)];
        byte Kierownik = 3;
        byte manager = 10;
        for(int i = 0; i < tabPrac.length ; i++){
           tabPrac[i] = new Pracownik();
           tabPrac[i].setImie(imiona[rand.nextInt(0,imiona.length)]);
            
            String tempString = "";
            for(byte x = 0; x <= array.length; x ++)
            {
                tempString += (char)(byte)rand.nextInt(97,122);
                
            }
           tabPrac[i].setNazwisko(tempString);
           
           if(stanowiska[rand.nextInt(0,stanowiska.length)].equals("kierownik")
                   && Kierownik != 0)
           {
               tabPrac[i].setStanowisko(stanowiska[rand.nextInt(0,stanowiska.length)]);
               Kierownik --;
           }
           else if(stanowiska[rand.nextInt(0,stanowiska.length)].equals("manager")
                   && manager != 0)
           {
               tabPrac[i].setStanowisko(stanowiska[rand.nextInt(0,stanowiska.length -1)]);
               manager --;
           }
           else
           {
               tabPrac[i].setStanowisko(stanowiska[rand.nextInt(0,stanowiska.length -2)]);
           }
           
           tabPrac[i].setStazPracy(rand.nextInt(0,25));
        }
        
        for(Pracownik i : tabPrac)
        {
            System.out.print(i.getImie() + " " + i.getNazwisko() + " "
            + i.getStanowisko() + " " + i.getStazPracy());
            System.out.println();   
        }
        System.out.println();
        System.out.println();
        Ranking(tabPrac , 1);
        
        for(Pracownik i : tabPrac)
        {
            System.out.print(i.getImie() + " " + i.getNazwisko() + " "
            + i.getStanowisko() + " " + i.getStazPracy());
            System.out.println();   
        }
        
        System.out.println();
        
        Pracownik p4 = new Pracownik("Rafal", "abc", "menager", 4);
        
        Pracownik p5 = new Pracownik(p4);
        
        System.out.println(p5.getImie() + " " + p5.getPensja());
        
    }
    public static void Ranking(Pracownik[] firma, int klucz){
        switch(klucz){
            case 0:
                   Arrays.sort(firma, Comparator.comparing(Pracownik :: getImie));
                   break;
            case 1:
            {
                Arrays.sort(firma, Comparator.comparing(Pracownik :: getStanowisko));
                   break;
            }
            case 2:
            {
                Arrays.sort(firma, Comparator.comparing(Pracownik :: getPensja));
                   break;
            }
        }
    }
}
