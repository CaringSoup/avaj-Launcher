package com.gabriel.classes.weather;

import com.gabriel.classes.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;


public abstract class Tower {
	private List<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable) {
		if (observers.contains(flyable)) {
			return ;
		}
		observers.add(flyable);
	}
	
	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	void conditionsChanged () {
//		System.out.println(observers.size());
//		for (Flyable flyable: observers) {
//////			System.out.println("conditions changed");
////			flyable.updateConditions();
////		}
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
	}
}
