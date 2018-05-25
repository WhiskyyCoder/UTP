package Zad2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
public static String getMod(int x){
   if(Modifier.PROTECTED==x)
	 return "PROTECTED";  
   if(Modifier.PUBLIC==x)
		 return "PUBLIC"; 
   if(Modifier.PRIVATE==x)
		 return "PRIVATE";  
   if(Modifier.STATIC==x)
		 return "STATIC";  
   if(Modifier.FINAL==x)
		 return "FINAL";  
   if(Modifier.VOLATILE==x)
		 return "VOLATILE";  
return null;
	
	
	
	
}
	public static void main(String[] args) {
	//Nie wiedzialem jak wczytac klasy z innego katalogu !
      Class c=Ciezarowka.class;
      
      System.out.print("Nadklasy : ");
		
      Class nad =c.getSuperclass();
      while(nad !=null){
    	  System.out.print(nad.getName()+", ");
    	  nad=nad.getSuperclass();
      }
		
      System.out.println("");
      System.out.print("Konstruktory : ");
      for(Constructor cc:c.getConstructors()){
    	  
    	 if(cc.getParameters().length>0){
    		 String param="";
    		 for(Class ccc:cc.getParameterTypes())
    		 param+=ccc.getSimpleName()+",";
    		 param=param.substring(0, param.length()-1);
    		 System.out.print(Modifier.toString(cc.getModifiers())+" "+cc.getName().split("\\.")[1]+"s("+param +"), " ); 
    	 } 
    	  
      }
      System.out.println("");
      System.out.print("Metody : ");
      for(Method mm:c.getMethods()){
    	  
    	  
    	  if(mm.getParameters().length>0){
    		  String param="";
     		 for(Class mmm:mm.getParameterTypes())
     		 param+=mmm.getSimpleName()+",";
     		 param=param.substring(0, param.length()-1);
     		 try{
     		if(!getMod(mm.getModifiers()).equalsIgnoreCase("PRIVATE"))
    		 System.out.print(Modifier.toString(mm.getModifiers())+" "+mm.getName()+"("+param +"), " ); 
     		  
     		 
    	  }catch(NullPointerException n){
    		  
    			 System.out.print(Modifier.toString(mm.getModifiers())+" "+mm.getName()+"("+param +"), " ); 
    		  }
    	  }
      }
    	   System.out.println("");
    	      System.out.print("Pola: ");
    	      for(Field ff:c.getFields()){
    	    	  
    	    	  
    	    	
    	     		if(!getMod(ff.getModifiers()).equalsIgnoreCase("PRIVATE"))
    	    		 System.out.print(Modifier.toString(ff.getModifiers())+" "+ff.getName()+","); 
    	     		  
    	     		 
    	    
    	    	  } 	  
    	      System.out.println("");
    	      System.out.print("Pola z nadklasy dostepne w tej klasie: ");
    	      
    	      List<Field> lista=new ArrayList<>(Arrays.asList(c.getFields()));
    	      for(Field ff:c.getSuperclass().getFields()){
    	    	  
    	    	  
      	    	
  	     		if(lista.contains(ff))
  	    		 System.out.print(Modifier.toString(ff.getModifiers())+" "+ff.getName()+","); 
  	     		  
  	     		 
  	    
  	    	  }
    	      
    	      
    	       try {
    	
				Ciezarowka v = Ciezarowka.class.getConstructor(String.class).newInstance("Ciezaroweczka");
			System.out.println("\nNazwa: "+v.getNazwa());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    	  
      
		
	}

}
