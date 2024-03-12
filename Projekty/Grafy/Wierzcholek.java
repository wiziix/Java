package com.mycompany.grafy;

public class Wierzcholek {
        //nazwa wierzcholka oraz jego wspolrzedne pozwalajace zainicjalizowac
        //jego pozycje na plaszczyznie
        String nodeName;
        double x;
        double y;
	Wierzcholek(String name, double x, double y)
	{
		this.nodeName = name;
                this.x = x;
                this.y = y;
	}    
}
