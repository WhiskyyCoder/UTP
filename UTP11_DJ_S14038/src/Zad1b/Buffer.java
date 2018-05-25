package Zad1b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
private List<Integer> l;
private int ilosc;
private ReentrantLock lock ;
private Condition get;
private Condition put;
public Buffer(int x) {
	ilosc=x;
	l=new ArrayList<>(x);
	lock=new ReentrantLock();
	get = lock.newCondition();
	put = lock.newCondition();
}

int get(){
	int x = 0;
	lock.lock();
	try{
	while(l.size()==0)get.await();
     x=l.get(l.size()-1); 
    System.out.println("get() "+x);
 
	 l.remove(l.size()-1); 
		System.out.println("Queue: "+l);
		put.signal();
	} catch (InterruptedException e) {
		return -1;
	}
	finally{
		lock.unlock();
	}
	return x;
}

void put(int x){
	lock.lock();
	try{
		while(isFull()) put.await();
	l.add(x);
	System.out.println("put() "+x);
	System.out.println("Queue: "+l);
	get.signal();
	
} catch (InterruptedException e) {
	
}
finally{
	
	lock.unlock();

}

}
boolean isFull(){
	if(l.size()<ilosc)
		return false;
	
	return true;
}



}
