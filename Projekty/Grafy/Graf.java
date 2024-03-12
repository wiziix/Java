package com.mycompany.grafy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

public class Graf {
    HashMap<Wierzcholek, ArrayList<Wierzcholek>> mSasiedztwa;

     Graf(List<Wierzcholek> lista) {
         this.mSasiedztwa = new HashMap<Wierzcholek, ArrayList<Wierzcholek>>();
         for(Wierzcholek w : lista){
            mSasiedztwa.put(w, new ArrayList<Wierzcholek>());
         }     
    }
     
     HashMap<Wierzcholek, ArrayList<Wierzcholek>> getmSasiedztwa(){
         return mSasiedztwa;
     }
     
     
     //metoda przyjmujaca na wejsciu dwa wierzcholki
     //nastepnie tworzaca krawedz, ktora je laczy
     void dodajKrawedz(Wierzcholek w1, Wierzcholek w2){
     if(w1.equals(w2)){
         mSasiedztwa.get(w1).add(w2);
     }
     else{
         mSasiedztwa.get(w1).add(w2);
        mSasiedztwa.get(w2).add(w1);
     }    
     }
     
     
     //metoda sluzaca do drukowania macierzy sasiedztwa
     void wydrukujmSasiedztwa(){
         for(Map.Entry mapElementy : mSasiedztwa.entrySet()){
             
             Wierzcholek w = (Wierzcholek)mapElementy.getKey();
             System.out.print(w.nodeName + "->");
             
             ArrayList<Wierzcholek> list = mSasiedztwa.get(w);
            for(Wierzcholek a : list)
            	System.out.print(a.nodeName + " ");
            
            System.out.println();           
         }
     }
    
     //metoda przyjmujaca dwa wierzcholki
     //pozwalajca wyznaczyc odleglosc miedzy nimi
     double obliczOdleglosc(Wierzcholek w1, Wierzcholek w2){    
         return Double.valueOf(String.format(Locale.US,
                 "%.2f", Math.sqrt( Math.pow( (w2.x - w1.x)
                         , 2 ) + Math.pow( (w2.y - w1.y ) , 2) )));
     }
     
     //metoda przyjmujaca na wejsciu wierzcholek bedacy punktem startowym trasy
     //obliczajaca oraz wypisujaca laczna odleglosc oraz odwiedzone punkty
     void lacznaTrasa(Wierzcholek start)
{    
        ArrayList<Wierzcholek> odwiedzone = new ArrayList<Wierzcholek>();
	Stack<Wierzcholek> stk = new Stack<Wierzcholek>();
        double dlugoscTrasy = 0;
	stk.add(start);		
	while(!stk.isEmpty())
	{
		Wierzcholek currNode = stk.pop();
		if(!odwiedzone.contains(currNode))
		{
			odwiedzone.add(currNode);
                        
			for(Wierzcholek w : mSasiedztwa.get(currNode)){
                            stk.push(w);                           
                            dlugoscTrasy += obliczOdleglosc(currNode,w);
                        }
				
		}
	}		
	ArrayList<String> dfs = new ArrayList<String>();
	for(Wierzcholek w : odwiedzone)
		dfs.add(w.nodeName);		
        
        System.out.println("Odwiedzone punkty oraz odleglosc: ");
	System.out.println(dfs + " " + dlugoscTrasy + "km");		
}
     
     
     //metoda przyjmujaca dwa wierzcholki
     //usuwajaca krawedz, ktora je laczy
     void usunKrawedz(Wierzcholek w1, Wierzcholek w2){
         ArrayList<Wierzcholek> w1Lista = mSasiedztwa.get(w1);
         ArrayList<Wierzcholek> w2Lista=  mSasiedztwa.get(w2);
         
         w1Lista.remove(w2);
         w2Lista.remove(w1);
     }
     
     //metoda przyjmuje wierzcholek i usuwa go z grafu
     void usunWierzcholek(Wierzcholek w1){
         ArrayList<Wierzcholek> list = mSasiedztwa.get(w1);
         ArrayList<Wierzcholek> listaKrawedzi = new ArrayList<Wierzcholek>();
         for(Wierzcholek w : list){
             listaKrawedzi.add(w);
         }
         
         for(Wierzcholek w : listaKrawedzi){
             this.usunKrawedz(w1, w);
         }
         
         mSasiedztwa.remove(w1); 
         }
}
