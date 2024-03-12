package com.mycompany.grafy;

import java.util.ArrayList;
import java.util.Random;


public class Grafy {

    public static void main(String[] args) {
        
        //inicjalizacja zbioru wierzcholkow P, K oraz klasy random, pozwalajacej
        //na utworzenie grafu oraz na ustalenie pozycji wierzcholkow na plaszczyznie
        Random rand = new Random();
        ArrayList<Wierzcholek> list = new ArrayList<Wierzcholek>();
        ArrayList<Wierzcholek> zbiorP = new ArrayList<Wierzcholek>();
        
        
        //wypelnianie zbioru wierzcholkow
        for(int i = 0; i < 10; i++){
            double x = rand.nextDouble(0.00,10.00);
            double y = rand.nextDouble(0.00,10.00);
            list.add(new Wierzcholek(String.valueOf((char)(i + 65)),x,y));
        }
        
        
        //tworzenie grafu na podstawie wczesniej wypelnionej listy
        Graf g = new Graf(list);
        
        
        //dodawanie krawedzi grafu
        for(int i = 0; i < list.size(); i++){
            Wierzcholek w1 = list.get(rand.nextInt(0,10));
            Wierzcholek w2 = list.get(rand.nextInt(0,10));
            g.dodajKrawedz(w1,w2);
            
        }
        
        while(!g.mSasiedztwa.isEmpty()){
        //losowanie wierzcholka
        Wierzcholek r = list.get(rand.nextInt(0, list.size()));
        
        //dodawanie do zbioru P
        zbiorP.add(r);
        
        //usuwanie ze zbioru
        g.usunWierzcholek(r);
        list.remove(r);
        
         //wyliczanie najblizszego wierzcholka      
        double odleglosc = g.obliczOdleglosc(r, list.get(0));;
        Wierzcholek temp = null;
        
        for(int i = 0; i < list.size(); i++){            
                if(odleglosc > g.obliczOdleglosc(r, list.get(i))){
                    odleglosc = g.obliczOdleglosc(r, list.get(i));                    
                    temp = list.get(i);         
                    }
                else{
                    temp = list.get(0);
                }
        }
               
        
        //wyznaczanie lacznej trasy
        g.lacznaTrasa(temp);
        
	
        //wydrukuj macierz sasiedztwa
	System.out.println("Macierz Sasiedztwa: ");
	g.wydrukujmSasiedztwa();
        System.out.println("");

        //usuwanie najblizszego wierzcholka i dodanie go do zbioru P
        g.usunWierzcholek(temp);
        list.remove(temp);
        zbiorP.add(temp);
        }
    }
}
