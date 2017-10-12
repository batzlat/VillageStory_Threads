package threads;

import resources.Barrel;
import resources.CooperativeStore;
import resources.SugarFactory;

public class RakiaBoiler implements Runnable {

	private String name;
	private Barrel barrel;
	private CooperativeStore store;
	private SugarFactory sugarSource;

	public RakiaBoiler(Barrel barrel, SugarFactory sugarSource, CooperativeStore store, String name) {
		this.barrel = barrel;
		this.store = store;
		this.name = name;
		this.sugarSource = sugarSource;
	}

	@Override
	public void run() {
		while (true) {
			this.barrel.takeGrape(25);
			this.sugarSource.supplySugar(25);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.store.accomodateRakia(30);
		}
	}
	
	public String getName() {
		return this.name;
	}

}
