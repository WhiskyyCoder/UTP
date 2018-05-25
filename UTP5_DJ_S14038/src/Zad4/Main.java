/**
 *
 *  @author Domański Jan S14038
 *
 */

package Zad4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*<-- niezbędne import */
public class Main {
  public static void main(String[] args) throws IOException {
	  Function<String,List<String>> flines =(n)->{
	    	String line=null;
	    	List<String> ll=new ArrayList<>();
	    	FileReader plik=null;
	    	  BufferedReader br=null;
	        try {
				plik=new FileReader(n);
	          br= new BufferedReader( plik);
	    	while ((line = br.readLine()) != null) {
		           ll.add(line);
		         } 
	    	}catch(Exception e){
	    		
	    		
	    	}

	              return ll;
	    };
	    Function<List<String>,String> join =(n)->{
			
	    	String w="";
	    	for(String q:n){
	    		
	    		w+=q+" ";
	    	}
	    	return w;
	    	
	    	
	    	
	    };
	    Function<String,List<Integer>> collectInts =(n)->{
	    	List<Integer> liczby=new ArrayList<Integer>();
	    	
	    	
	    	
	    	for(String w: n.split(" "))
	    	liczby.add(w.length());
	    	
	    	
	    	return liczby;
	    };
	    Function<List<Integer>,Integer> sum =(n)->{
	    	int r=0;
	    	for(int x:n)
	    	r+=x;
	    	
	    	return r;
	    };

    String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

    // Zadania badawcze:
    // Operacja flines zawiera odczyt pliku, zatem może powstac wyjątek IOException
    // Wymagane jest, aby tę operację zdefiniowac jako lambda-wyrażenie
    // Ale z lambda wyrażeń nie możemy przekazywac obsługi wyjatków do otaczającego bloku
    // I wobec tego musimy pisać w definicji flines try { } catch { }
    // Jak spowodować, aby nie było to konieczne i w przypadku powstania wyjątku IOException
    // zadziałała klauzula throws metody main
  }
}
