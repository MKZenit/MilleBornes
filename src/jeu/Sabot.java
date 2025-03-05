package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {

	private int nbCartes;
	private Carte[] cartes;
	private int nbOperationsReference = 0;

	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbCartes = cartes.length;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}

	public void ajouterCarte(Carte carte) throws IndexOutOfBoundsException {
		if (nbCartes >= cartes.length)
			throw new IndexOutOfBoundsException();
		cartes[nbCartes] = carte;
		nbCartes++;
		nbOperationsReference++;
	}

	public Carte piocher() {
		Iterator<Carte> ite = iterator();
		Carte carte = null;
		if(ite.hasNext()) {
			carte = ite.next();
			ite.remove();
		}
		return carte;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new SabotIterator();
	}

	public class SabotIterator implements Iterator<Carte> {

		private int nbOperations;
		private boolean nextDone = false;
		private int curIndex = 0;

		protected SabotIterator() {
			this.nbOperations = nbOperationsReference;
		}

		private boolean verificationConcurrent() {
			return this.nbOperations != nbOperationsReference;
		}

		@Override
		public boolean hasNext() {
			return curIndex < nbCartes;
		}

		@Override
		public Carte next() throws NoSuchElementException, ConcurrentModificationException {
			if (verificationConcurrent()) throw new ConcurrentModificationException();
			if (curIndex >= nbCartes) throw new NoSuchElementException();
			nextDone = true;
			return cartes[curIndex++];
		}

		@Override
		public void remove() throws ConcurrentModificationException, IllegalStateException {
			if (verificationConcurrent()) throw new ConcurrentModificationException();
			if (nbCartes<1 || !nextDone) throw new IllegalStateException();
			
			nbOperations++;
			nbOperationsReference++;
			for (int i = curIndex; i < nbCartes; i++)
				cartes[i - 1] = cartes[i];
			nbCartes--;
			curIndex--;
			nextDone = false;
		}

	}

}
