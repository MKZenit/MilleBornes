package testsFonctionnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {

	public static void main(String[] args) {
		JeuDeCartes jdc = new JeuDeCartes(
				JeuDeCartes.getConfigurationClassique()
				);
		System.out.println(
				jdc.affichageJeuDeCartes()
				);
	}

}
