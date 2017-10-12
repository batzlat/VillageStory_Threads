package village_idyll;

import resources.Barrel;
import resources.CooperativeStore;
import resources.SugarFactory;
import threads.AnnoingWife;
import threads.DrunkenPeasant;
import threads.GrapePicker;
import threads.RakiaBoiler;
import threads.SugarBeetPicker;

public class Demo {

	public static void main(String[] args) {
		
		Barrel villageBarrel = new Barrel();
		SugarFactory gornaOriahovitsa = new SugarFactory("Sugar Factory Gorna Oriahovitsa");
		CooperativeStore villageStore = new CooperativeStore();
		Thread nikola = new Thread (new GrapePicker(villageBarrel, "Nikola"));
		Thread atanas = new Thread (new GrapePicker(villageBarrel, "Atanas"));
		Thread stamat = new Thread (new RakiaBoiler(villageBarrel, gornaOriahovitsa, villageStore, "Stamat"));
		DrunkenPeasant kolioPiandeto = new DrunkenPeasant(villageStore, "Kolio");
		Thread kolio = new Thread(kolioPiandeto);
		Thread minka = new Thread(new AnnoingWife("Minka", kolioPiandeto, gornaOriahovitsa, villageBarrel, villageStore));
		Thread viet = new Thread(new SugarBeetPicker(gornaOriahovitsa));
		nikola.setName("Nikola");
		atanas.setName("Atanas");
		stamat.setName("Stamat");
		kolio.setName("Kolio");
		minka.setName("Minka");
		minka.setDaemon(true);
		viet.start();
		minka.start();
		nikola.start();
		atanas.start();
		stamat.start();
		kolio.start();
		
	}

}
