package Zad2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class XList<T> implements List<T> {
	private List<T> lista = new ArrayList<>();

	public XList(T... tab) {

		for (T a : tab)
			lista.add(a);
	}

	public static <X> XList<X> of(X... tab) {
		// TODO Auto-generated method stub
		return new XList<X>(Arrays.asList(tab));
	}

	public static <X> XList<X> of(Collection<X> col) {
		// TODO Auto-generated method stub
		return new XList<X>(col);
	}

	public XList(Collection<T> c) {
		this.lista = new ArrayList<>(c);
	}

	public static <W> XList<W> charsOf(W string) {
		List<W> l = new ArrayList<>();
		for (int x = 0; x < string.toString().toCharArray().length; x++) {
			l.add((W) ("" + string.toString().toCharArray()[x]));

		}

		return new XList<W>(l);
	}

	public static XList<String> tokensOf(String... string) {
		List<String> l = new ArrayList<>();
		if (string.length == 1) {
			for (String s : string[0].split("\\s+"))
				l.add(s);
		}
		if (string.length == 2) {
			for (String s : string[0].split(string[1]))
				l.add(s);

		}
		return new XList<String>(l);
	}

	@Override
	public String toString() {
		return lista.toString();
	}

	public XList<T> union(Collection<T> list2) {
		List<T> l = new ArrayList<T>(lista);
		if (list2 instanceof XList) {
			l.addAll(((XList<T>) list2).getList());
		} else {
			l.addAll(list2);
		}
		return new XList<T>(l);
	}

	@Override
	public boolean add(T e) {
		lista.add(e);
		return true;
	}

	public List<T> getList() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		lista.addAll(c);
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return lista.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return lista.get(index);
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return lista.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return lista.remove(o);
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return lista.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return lista.set(index, element);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean inColl(T s, Collection<T> c) {
		if (c.contains(s))
			return true;

		return false;
	}

	public XList<T> diff(Collection<T> m3) {
		List<T> l = new ArrayList<T>();
		for (T k : lista) {
			if (!m3.contains(k))
				l.add(k);

		}

		return new XList<T>(l);
	}

	public XList<T> unique() {
		ArrayList<T> val = new ArrayList<>();
		HashSet<T> uniqueValues = new HashSet<>(lista);
		for (T value : uniqueValues) {
			val.add(value);
		}
		return new XList<T>(val);
	}

	public static <T> Set<List<T>> getCombinations(List<List<T>> lists) {
		Set<List<T>> combinations = new HashSet<List<T>>();
		Set<List<T>> newCombinations;

		int index = 0;

		// extract each of the integers in the first list
		// and add each to ints as a new list
		for (T i : lists.get(0)) {
			List<T> newList = new ArrayList<T>();
			newList.add(i);
			combinations.add(newList);
		}
		index++;
		while (index < lists.size()) {
			List<T> nextList = lists.get(index);
			newCombinations = new HashSet<List<T>>();
			for (List<T> first : combinations) {
				for (T second : nextList) {
					List<T> newList = new ArrayList<T>();
					newList.addAll(first);
					newList.add(second);
					newCombinations.add(newList);
				}
			}
			combinations = newCombinations;

			index++;
		}

		return combinations;
	}

	public XList<List<T>> combine() {
		Permutacje<T> pg = new Permutacje();

		List<List<T>> output = pg.permutate((List<List<T>>) lista);

		return new XList<List<T>>(output);
	}

	public XList<String> collect(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String join(String ...tab) {
		
		String k="";
		if(lista.get(0) instanceof ArrayList){
		for (int x = 0; x < ((List)lista.get(0)).size(); x++) {
			if(tab.length==1&& x>0)
			k+=tab[0]+((List)lista.get(0)).get(x);
			else
				k+=((List)lista.get(0)).get(x);
			
		}}else{
			for (int x = 0; x < lista.size(); x++) {		
			if(tab.length==1&& x>0)
				k+=tab[0]+lista.get(x);	
			else
				k+=lista.get(x);
			
			
			
			}	
			
			
			
		}
		
		return k;
	}
	public void forEachWithIndex(BiConsumer<T, Integer> object) {
		for (int x = 0; x < lista.size(); x++) {
			object.accept(lista.get(x), x);

		}
	}

	public <X> XList<X> collect(Function<XList<X>,String> c) {
		// TODO Auto-generated method stub
		List<X> ll=new ArrayList<X>();
	
		for(int x=0;x<lista.size();x++){
			
			XList<X> xx=new XList(lista.get(x));
			//System.out.println((X)c.apply(xx));
			X p=(X)c.apply(xx);
			
		ll.add(p);
		
		}
		
		return new XList<X>(ll);
	}

}
