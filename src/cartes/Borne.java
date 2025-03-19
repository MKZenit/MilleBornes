package cartes;

public class Borne extends Carte {

	private int km;

	public Borne(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return km + "km";
	}

	@Override
	public boolean equals(Object obj) {
		if( super.equals(obj) )
			return this.km == ((Borne) obj).km;
		return false;
	}

}
