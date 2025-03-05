package cartes;

public class DebutLimite extends Limite {

	@Override
	public String toString() {
		return "Limite";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof DebutLimite;
	}
	
}
