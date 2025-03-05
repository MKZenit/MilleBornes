package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getParade();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Parade parade)
			return parade.getType().equals(this.getType());
		return false;
	}
	
}
