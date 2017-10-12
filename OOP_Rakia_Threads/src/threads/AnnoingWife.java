package threads;

import resources.Barrel;
import resources.CooperativeStore;
import resources.SugarFactory;

public class AnnoingWife implements Runnable {
	
	private String name;
	private DrunkenPeasant husband;
	private Barrel grapeSource;
	private SugarFactory sugarSource;
	private CooperativeStore villageStore;
	
	public AnnoingWife(String name, DrunkenPeasant husband, SugarFactory sugarSource, Barrel grapeSource, CooperativeStore villageStore) {
		this.name = name;
		this.husband = husband;
		this.grapeSource = grapeSource;
		this.sugarSource = sugarSource;
		this.villageStore = villageStore;
	}

	@Override
	public void run() {
		while(true){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (this.husband.getBottles() > 0){
		System.out.println(Thread.currentThread().getName() + " says: - QUIT DRINKING, " + this.husband.getName() + " !!! YOU HAVE DRUNK " + this.husband.getBottles() + " BOTTLES ALREADY !!! I SHOULD HAVE LISTEN TO MY MOTHER...");
		}
		this.grapeSource.takeGrape(2);
		this.sugarSource.supplySugar(2);
		this.villageStore.accomodateCompote(5);
		System.out.println(this.husband.getName() + " says to " + this.name + " - Stop wasting precious material!!!");
		}
		
	}

}
