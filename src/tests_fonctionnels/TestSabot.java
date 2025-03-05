package tests_fonctionnels;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabot;

public class TestSabot {

	public static void main(String[] args) {
		//verificationSabotPiocher();
		verificationSabotIterateur();
		//verificationSabotIterateur2();
	}

	public static Sabot getNouveauSabot() {
		JeuDeCartes jdc = new JeuDeCartes(JeuDeCartes.getConfigurationClassique());
		return new Sabot(jdc.donnerCartes());
	}
	
	public static void verificationSabotPiocher() {
		Sabot sabot = getNouveauSabot();
		StringBuilder sb = new StringBuilder();
		
		while(!sabot.estVide())
			sb.append(sabot.piocher().toString())
			  .append('\n');
		
		System.out.println(sb);
	}

	public static void verificationSabotIterateur() {
		Sabot sabot = getNouveauSabot();
		StringBuilder sb = new StringBuilder();
		Iterator<Carte> ite = sabot.iterator();
		
		while(ite.hasNext()) {
			sb.append(ite.next().toString());
			ite.remove();
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	public static void verificationSabotIterateur2() {
		Sabot sabot = getNouveauSabot();
		StringBuilder sb = new StringBuilder();
		Iterator<Carte> ite = sabot.iterator();
		sb.append(ite.next().toString());
		sb.append("\n");
		ite.remove();
		
		try {
			sb.append(sabot.piocher().toString());
			sb.append("\n");
			
			while(ite.hasNext()) {
				sb.append(ite.next().toString());
				ite.remove();
				sb.append("\n");
			}
		}catch(ConcurrentModificationException e) {
			System.out.println("ConcurrentModificationException thrown !\n");
		}
		
		System.out.println(sb);
	}
	
}
