package resources;

public final class CooperativeStore {

	private static final int MAX_CAPACITY = 400;
	private int stock = 0;
	private int compotes = 0;
	
	
	public CooperativeStore() {
		
	}
	
	
	public synchronized void accomodateRakia(int bottles){
		while (this.stock + bottles > MAX_CAPACITY){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.stock += bottles;
		System.out.println(Thread.currentThread().getName() + " delivers into the Cooperative Store " + bottles + " bottles of rakia drink.");
		this.notifyAll();
		
	}
	
	public synchronized void getRakia(int bottles){
		while (this.stock - bottles < 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.stock -= bottles;
		System.out.println(Thread.currentThread().getName() + " collects from the Cooperative Store " + bottles + " bottles of rakia drink.");
		this.notifyAll();
		
	}
	
	public synchronized void accomodateCompote(int jars){
		this.compotes += jars;
		System.out.println(Thread.currentThread().getName() + " just supplied the Cooperative Store with " + jars + " of grape compotes.");
		
	}
	

}
