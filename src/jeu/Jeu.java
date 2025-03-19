package jeu;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import cartes.JeuDeCartes;
import cartes.Carte;
import utils.GestionCartes;

public class Jeu {
	
	private Sabot sabot;
	
	public Jeu() {
		List<Carte> listeCartes = new ArrayList<>();
		JeuDeCartes jdc = new JeuDeCartes(JeuDeCartes.getConfigurationClassique());
		Collections.addAll(listeCartes, jdc.donnerCartes());
		GestionCartes.melanger(listeCartes);
		this.sabot = new Sabot(listeCartes.toArray(new Carte[0]));
	}
	
}
