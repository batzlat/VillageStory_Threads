package threads;

import resources.Barrel;

public final class GrapePicker implements Runnable {

	private Barrel barrel;
	private String name;

	public GrapePicker(Barrel barrel, String name) {
		this.barrel = barrel;
		this.name = name;
	}

	public Barrel getBarrel() {
		return barrel;
	}

	

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.barrel.addGrape(10);
		}
	}
	
	public String getName() {
		return this.name;
	}


}
