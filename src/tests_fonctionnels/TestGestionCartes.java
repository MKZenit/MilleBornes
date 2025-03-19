package tests_fonctionnels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {
	public static void main(String... args) {
		JeuDeCartes jeu = new JeuDeCartes(JeuDeCartes.getConfigurationClassique());
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		Collections.addAll(listeCarteNonMelangee, jeu.donnerCartes());
		
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		
		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println(
				"liste mélange sans erreur ? " 
				+ GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		
		listeCartes = GestionCartes.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println(
				"liste rassembl�e sans erreur ? " 
				+ GestionCartes.verifierRassemblement(listeCartes));

	}

}