package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{

	private int nbCartes;
	private Carte[] cartes;
	
	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		
		Carte carte = cartes[0]; int index = 0;
		while(carte!=null && index<cartes.length) {
			index++;
		}
		this.nbCartes = index;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(Carte carte) throws IndexOutOfBoundsException {
		if(nbCartes>=cartes.length) throw new IndexOutOfBoundsException();
		cartes[nbCartes] = carte;
		nbCartes++;
		nbOperationsReference++;
	}
	
	public Carte piocher() {
		Iterator<Carte> ite = iterator();
		Carte carte = ite.next();
		ite.remove();
		return carte;
	}
	

	@Override
	public Iterator<Carte> iterator() {
		return new SabotIterator();
	}
	
	private static int nbOperationsReference = 0;
	
	public class SabotIterator implements Iterator<Carte> {

		private int nbOperations = 0;
		private boolean nextDone = false;
		private int curIndex = 0;
		
		protected SabotIterator() {}
		
		private boolean verificationConcurrent() {
			return this.nbOperations==Sabot.nbOperationsReference;
		}
		
		@Override
		public boolean hasNext() throws ConcurrentModificationException{
			if(curIndex>=nbCartes) return false;
			return true;
		}

		@Override
		public Carte next() throws IndexOutOfBoundsException {
			if(verificationConcurrent()) throw new ConcurrentModificationException();
			if(curIndex>=nbCartes) throw new IndexOutOfBoundsException();
			nextDone = true;
			return cartes[curIndex++];
		}
		
		@Override
		public void remove() throws ConcurrentModificationException, IllegalStateException{
			if(verificationConcurrent()) throw new ConcurrentModificationException();
			if(!nextDone) throw new IllegalStateException();
			nbOperations++;
			for(int i=1; i<nbCartes; i++)
				cartes[i-1] = cartes[i];
			nbCartes--;
			curIndex--;
			nextDone = false;
		}
		
	}

}
