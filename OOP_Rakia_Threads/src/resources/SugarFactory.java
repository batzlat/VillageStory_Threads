package resources;

public final class SugarFactory {

	private static final int MAX_BEET_CAPACITY = 400;
	private int beet = 0;
	private String name;

	public SugarFactory(String name) {
		this.name = name;
	}

	public synchronized void getBeet(int beet) {
		while (this.beet + beet > MAX_BEET_CAPACITY) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.beet += beet;
		System.out.println("New raw material delivery in the sugar factory received from Vietnam.");
		this.notifyAll();
	}

	public synchronized void supplySugar(int sugar) {
		while (this.beet - (sugar * 2) < 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.beet -= sugar * 2;
		System.out.println("New sugar supply from the sugar factory was just made.");
		this.notifyAll();
	}

}
