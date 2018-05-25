package Zad1;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {
T k;
	public Maybe(T num) {
	this.k=num;
}

	public void ifPresent(Consumer<T> x){
		if(k!=null){
			
			x.accept(k);
		}
		
	};
	public boolean ifPresent(){
		if(k!=null){
			
			return true;
		}
		return false;
	};

	public static <X>  Maybe<X> of(X num) {
		// TODO Auto-generated method stub
		return new Maybe<X> (num);
	}
   @Override
	public String toString() {
		// TODO Auto-generated method stub
	   if(k!=null)
		return "Maybe has value: "+k;
	   return "Maybe is empty";
	}
	public <W> Maybe<W> map(Function<T,W> fun) {

      if(k!=null){
    	  
    	 return new Maybe<W>(fun.apply(k));
      }
      return new Maybe<W>(null);
	}

	public T get() throws NoSuchElementException {
		// TODO Auto-generated method stub
		
		if(k==null) {
			throw new NoSuchElementException("maybe is empty");
		}
			return k;
	}

	public T orElse(T obj) {
		// TODO Auto-generated method stub
		if(k==null){
			return obj;
			
		}
		return k;
	}

	public Maybe<T> filter(Predicate<T> pred) {
		if(pred.test(k)){
			return this;
		}
		// TODO Auto-generated method stub
		k=null;
		return this;
	}

}
