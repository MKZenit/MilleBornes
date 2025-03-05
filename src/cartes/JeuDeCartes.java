package cartes;

public class JeuDeCartes {

	private static class Configuration {

		private Carte carte;
		private int nbExemplaires;
		
		protected Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}
		
		public Carte getCarte() {
			return carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}
	}
	
	public static Configuration[] getConfigurationClassique() {
		return new Configuration[] {
			new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),
			
			new Configuration(new Parade(Type.FEU), 14),
			new Configuration(new FinLimite(), 6),
			new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6),
			
			new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new DebutLimite(), 4),
			new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ACCIDENT), 3),

			new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Botte(Type.ACCIDENT), 1),
		};
	}

	
	private Configuration[] configurations;
	
	public JeuDeCartes(Configuration[] configurations) {
		this.configurations = configurations;
	}

	public String affichageJeuDeCartes() {
		StringBuilder sb = new StringBuilder();
		for(var config : configurations) {
			sb.append(config.getNbExemplaires())
			  .append(" ")
			  .append(config.getCarte().toString())
			  .append("\n");
		}
		return sb.toString();
	}
	
	public Carte[] donnerCartes() {
		int nbCartes = 0;
		for(var config : this.configurations) {
			nbCartes += config.getNbExemplaires();
		}
		Carte[] cartes = new Carte[nbCartes];
		int indexCartes = 0;
		for(var config : this.configurations) {
			for(int i=0; i<config.getNbExemplaires(); i++) {
				cartes[indexCartes] = config.getCarte();
				indexCartes++;
			}
		}
		return cartes;
	}
	
}
