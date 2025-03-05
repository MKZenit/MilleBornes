package cartes;

public enum Type {
	FEU("FeuRouge", "FeuVert", "VehiculePrioritaire"),
	ESSENCE("PanneEssence", "Essence", "CiterneEssence"),
	CREVAISON("Crevaison", "RoueDeSecours", "Increvable"),
	ACCIDENT("Accident", "Réparation", "AsDuVolant");
	
	private String attaque;
	private String parade;
	private String botte;
	
	private Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}
	
	public String getAttaque() {
		return attaque;
	}
	public String getParade() {
		return parade;
	}
	public String getBotte() {
		return botte;
	}
}
