package utils;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	
	private GestionCartes() {}
	
	private static Random rand = new Random();
	
	public static <T> T extraire(List<T> elements) 
			throws IndexOutOfBoundsException{
		int index = rand.nextInt()%elements.size();
		
		T el = elements.get(index);
		elements.remove(index);
		return el;
	}
	
	public static <T> T extraireListIterator(List<T> elements) 
			throws IndexOutOfBoundsException{
		ListIterator<T> ite = elements.listIterator();
		int index = rand.nextInt()%elements.size();
		
		int curIndex = 0;
		while(ite.hasNext() && index>curIndex) {
			ite.next();
			curIndex++;
		}

		T el = ite.previous();
		ite.remove();
		return el;
	}
	
	public static <T> List<T> melanger(List<T> elements){
		return null;
	}
	
	public static <T> boolean verifierMelange(List<T> elements1, List<T> elements2) {
		return false;
	}
	
	public static <T> List<T> rassembler(List<T> elements){
		return null;
	}
	
	public static <T> boolean verifierRassemblement(List<T> elements) {
		return false;
	}
}
