package Zad2;


import java.util.List;
import java.util.function.Function;

public class InputConverter<T> {
public T t;
	public InputConverter(T file) {
		// TODO Auto-generated constructor stub
	    t=file;	  
	}
	
	public <R> R convertBy(Function...tab){
		
		int x=0;
		Object f = t;
		while(x<tab.length){
	    f=tab[x].apply(f);
			x++;
		}
		
	
	return  (R)f ;
		
	}

}
