package tests_fonctionnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {

	public static void main(String[] args) {
		JeuDeCartes jdc = new JeuDeCartes( JeuDeCartes.getConfigurationClassique() );
		System.out.println( jdc.affichageJeuDeCartes() );
		System.out.println( "check count : " + jdc.checkCount() );
	}

}
