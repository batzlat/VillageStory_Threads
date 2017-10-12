package resources;

public final class Barrel {

	private static final int MAX_LOAD = 100;
	private int grapeLoad = 0;

	public Barrel() {

	}

	public synchronized void addGrape(int grape) {
		while (this.grapeLoad + grape > MAX_LOAD)
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.grapeLoad += grape;
		System.out.println(Thread.currentThread().getName() + " pours " + grape + " kilos of grape into the barrel.");
		this.notifyAll();
	}

	public synchronized void takeGrape(int grape) {
		while (this.grapeLoad - grape < 0)
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.grapeLoad -= grape;
		System.out.println(Thread.currentThread().getName() + " grabs " + grape + " kilos of grape into the barrel.");
		this.notifyAll();
	}

}
