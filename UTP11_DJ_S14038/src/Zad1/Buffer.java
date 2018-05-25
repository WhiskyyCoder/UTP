package Zad1;


import java.util.concurrent.ArrayBlockingQueue;

public class Buffer {
private ArrayBlockingQueue<Integer> arbq;

public Buffer(int x) {
	arbq=new ArrayBlockingQueue<>(x);
}
	
public int get(){
	try {
		int i=arbq.take();
		 System.out.println("get() "+i);
		 System.out.println("Queue: "+arbq);
		return i;
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		return -1;
	}
}
 public void put (int x) {
	 
	 try {
		 System.out.println("put() "+x);
		arbq.put(x);
		System.out.println("Queue: "+arbq);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		return ;
	}
	 
 }




}
