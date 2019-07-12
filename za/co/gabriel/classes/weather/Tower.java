package za.co.gabriel.classes.weather;

public abstract class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (observers.contains(flyable)) {
			return ;
		}
		observers.add(flyable);
	}
	public void register (Flyable flyable) {

	}
	public void unregister(Flyable flyable) {

	}
	protected void conditionsChanged () {
		
	}
}
