package za.co.gabriel.classes.weather;

import java.util.ArrayList;
import java.util.List;

import za.co.gabriel.classes.aircrafts.Flyable;

public abstract class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (observers.contains(flyable)) {
			return ;
		}
		observers.add(flyable);
	}
	
	public void unregister(Flyable flyable) {

	}
	protected void conditionsChanged () {
		
	}
}
