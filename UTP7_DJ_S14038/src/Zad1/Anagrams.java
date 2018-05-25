/**
 *
 *  @author Domański Jan S14038
 *
 */

package Zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagrams {
	Set<String> words=new HashSet<>();
	List<List<String>> dane=new ArrayList<>();
	public Anagrams(String allWords) {
		try{
			FileReader fr=new FileReader(allWords);
			
			BufferedReader br=new BufferedReader(fr);

			String line="";
			while((line=br.readLine())!=null){
				String[] word=line.split("\\s+");
				int x=0;
				while(x<word.length){
					words.add(word[x]);
					
					x++;
				}
				
				
			}br.close();
			fr.close();}catch(IOException ex){
				
			}
		
		for(String k:words){
			int x=0;
			List<String> row=new ArrayList<String>();
			for(String a:words){
				if(isanagram(k, a)&& !inList(a)){
				row.add(a);
			
				x++;
				}
			}
		if(x>0)
		
			dane.add(row);
		}
		
		for(List<String> l:dane){
		l.sort((n,n2)->{
			if(n.compareToIgnoreCase(n2)<0)
				return -1;
			if(n.compareToIgnoreCase(n2)>0)
				return 1;	
				
				return 0;
			});}
		
		
	}

	public boolean inList(String name){
		for(List<String> l:dane)
		for(String a:l)
			if(a.equalsIgnoreCase(name)) return true;
		
		return false;
	}
	public boolean isanagram(String main,String input){
		char[] word1 = main.replaceAll("[\\s]", "").toCharArray();
	     char[] word2 = input.replaceAll("[\\s]", "").toCharArray();
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     return Arrays.equals(word1, word2);
	}
	public List<List<String>> getSortedByAnQty() {
    dane.sort((n,n2)->{
    	if(n.size()>n2.size())
    		return -1;
     	if(n.size()<n2.size())
     		return 1;
     	if(n.get(0).compareToIgnoreCase(n2.get(0))<0 ){
     		return -1;
     	}
     	if(n.get(0).compareToIgnoreCase(n2.get(0))>0 ){
     		return 1;
     	}
    	return 0;
     	
    	
    	
    });
		return dane;
	}
    
	public String getAnagramsFor(String next) {
		// TODO Auto-generated method stub
		
		List<String> ana=new ArrayList<String>();
		for(List<String> l:dane)
			for(String slowo:l)
		if(isanagram(next, slowo) && !slowo.equalsIgnoreCase(next))ana.add(slowo);
		if(ana.size()==0){
			if(!inList(next))
				return (next+":"+null);
		}
		return (next+":"+ana);
	}
}  
