package threads;

import resources.CooperativeStore;

public class DrunkenPeasant implements Runnable {
	
	private String name;
	private CooperativeStore store;
	private int score = 0;

	public DrunkenPeasant(CooperativeStore store, String name) {
		this.store = store;
		this.name = name;
	}

	@Override
	public void run() {
		while(true){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.store.getRakia(5);
		this.score += 5;
	}
	}

	public String getName() {
		return this.name;
	}

	public int getBottles() {
		return this.score;
	}

}
