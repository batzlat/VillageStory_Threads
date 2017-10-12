package threads;

import resources.SugarFactory;

public final class SugarBeetPicker implements Runnable {
	
	private SugarFactory client;
	
	public SugarBeetPicker(SugarFactory client) {
		this.client = client;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			client.getBeet(100);
		}
		
	}

}
