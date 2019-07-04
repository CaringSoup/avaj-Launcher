package za.co.gabriel.classes.weather;

public class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();
	private List<Flyable> landed = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (observers.contains(flyable)) {
			return ;
		}
		observers.add(flyable);
	}
}
