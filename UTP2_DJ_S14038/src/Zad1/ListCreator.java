/**
 *
 *  @author Domański Jan S14038
 *
 */

package Zad1;

import java.util.ArrayList;
import java.util.List;

public class ListCreator <T> { // Uwaga: klasa musi być sparametrtyzowana
public  List<T> list;
public ListCreator(List<T> t){
	list=new ArrayList<T>();
	int x=0;
	
	while(x<t.size()){
		list.add(t.get(x));
		x++;
		
	}
}
	public static <T,S> ListCreator<T> collectFrom(List<T> t){
	
		return new ListCreator<T>(t);
	}
	
	public ListCreator<T> when(Selector<T> s){	
		int x=0;
		while(x<list.size()){
		
			if(!s.select(list.get(x))){
			
				list.remove(x);
				x--;
			}
			x++;
		}
		
		return this;
	}
	public <W> List<W> mapEvery(Mapper<T,W> map) {
		// TODO Auto-generated method stub
		
		int x=0;
		ArrayList<W> list2=new ArrayList<W>();
		while(x<list.size()){
			
			list2.add(x,(W) map.map(list.get(x)));
			x++;
			
		}
		
		
		return list2;
		
	}
}  
