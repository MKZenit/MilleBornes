package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

	private GestionCartes() {
	}

	private static Random rand = new Random();

	public static <T> T extraire(List<T> elements) throws IndexOutOfBoundsException {
		int index = rand.nextInt(elements.size());

		T el = elements.get(index);
		elements.remove(index);
		return el;
	}

	public static <T> T extraireListIterator(List<T> elements) throws IndexOutOfBoundsException {
		int index = rand.nextInt(elements.size());
		ListIterator<T> ite = elements.listIterator(index);
		T el = ite.next();
		ite.remove();
		return el;
	}

	public static <T> List<T> melanger(List<T> elements) {
		List<T> melange = new ArrayList<>();

		while (!elements.isEmpty()) {
			melange.add(extraireListIterator(elements));
		}

		return melange;
	}

	public static <T> boolean verifierMelange(List<T> elements1, List<T> elements2) {
		T el;
		int nb1;
		int nb2;

		for (Iterator<T> ite = elements1.iterator(); ite.hasNext();) {
			el = ite.next();
			nb1 = Collections.frequency(elements1, el);
			nb2 = Collections.frequency(elements2, el);
			if (nb1 != nb2)
				return false;
		}
		return true;
	}

	public static <T> List<T> rassembler(List<T> elements) {
		List<T> result = new ArrayList<>();
		T el;

		for (Iterator<T> ite = elements.iterator(); ite.hasNext();) {
			el = ite.next();

			if (!result.contains(el)) {
				int nbElement = Collections.frequency(elements, el);
				for (int i = 0; i < nbElement; i++)
					result.add(el);
			}
		}

		return result;
	}

	private static <T> boolean verifierAppartient(Iterator<T> ite, T verifierElement) {
		T curElement;
		while (ite.hasNext()) {
			curElement = ite.next();
			if (curElement.equals(verifierElement))
				return false;
		}
		return true;
	}

	public static <T> boolean verifierRassemblement(List<T> elements) {

		T lastEl = elements.get(0);
		T curEl;

		for (ListIterator<T> ite = elements.listIterator(); ite.hasNext();) {
			curEl = ite.next();

			if (!lastEl.equals(curEl) 
					&& (verifierAppartient(elements.listIterator(ite.nextIndex()), lastEl)) )
				return false;
		}

		return true;
	}
	
}