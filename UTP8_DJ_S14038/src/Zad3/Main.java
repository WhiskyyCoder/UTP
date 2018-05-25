/**
 *
 *  @author Domański Jan S14038
 *
 */

package Zad3;

import static java.util.stream.Collectors.toMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.corba.se.impl.naming.cosnaming.NamingContextDataStore;

public class Main {
	public static String sortChars(String input) {
	    char[] characters = input.toCharArray();
	    Arrays.sort(characters);
	    return new String(characters);
	}
  public static void main(String[] args) {
	  try {
		  Set<String> map =  new HashSet<>();
		  BufferedReader reader= new BufferedReader(new InputStreamReader(new URL("http://www.puzzlers.org/pub/wordlists/unixdict.txt").openConnection().getInputStream()));
	      Stream<String> stream = reader.lines();
	      Map<String, List<String>> anagramy = stream.collect(Collectors.groupingBy(w -> sortChars(w)));
	      String max =anagramy.entrySet().stream().max((entry1, entry2) -> entry1.getValue().size() > entry2.getValue().size() ? 1 : -1).get().getKey();
	      Map<String, List<String>>  an2 =anagramy.entrySet().stream().filter(n->n.getValue().size()==anagramy.get(max).size()).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
	     for(String a:an2.keySet()){
	    	 an2.get(a).sort((n,n2)->{
	 			if(n.compareToIgnoreCase(n2)<0)
					return -1;
				if(n.compareToIgnoreCase(n2)>0)
					return 1;	
					
					return 0;
				});
	      System.out.println(a+" "+an2.get(a) );
	     }
	     
	  }catch(Exception ex){
		  
	  }
  }

}
