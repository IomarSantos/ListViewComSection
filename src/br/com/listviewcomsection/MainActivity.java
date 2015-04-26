package br.com.listviewcomsection;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    ListView listView = (ListView) findViewById(R.id.listView);
	    		
		ArrayList<Object> marcas = new ArrayList<>();
		
		// MODELOS FIATS
		Modelo fiat500 = new Modelo("FIAT 500");
		Modelo fiatBravo = new Modelo("FIAT BRAVO");
		
		//Modelos FORDS
		Modelo fordCourier = new Modelo("FORD COURIER");
		Modelo fordEcoSport = new Modelo("FORD ECOSPORT");
		
		//Modelos VOLKSWAGENS
		Modelo volkswagenAmarok = new Modelo("VOLKSWAGEN AMAROK");
		Modelo volkswagenCrossFox = new Modelo("CROSSFOX");
		
		// FIAT
		Marca marcaFiat = new Marca("Fiat");	
		marcas.add(marcaFiat);
		marcas.add(fiat500);
		marcas.add(fiatBravo);

		
		// FORD
		Marca marcaFord = new Marca("Ford");
		marcas.add(marcaFord);
		marcas.add(fordCourier);
		marcas.add(fordEcoSport);

		// VOLKSWAGEN
		Marca marcaVolkswagen = new Marca("Volkswagen");
		marcas.add(marcaVolkswagen);
		marcas.add(volkswagenAmarok);
		marcas.add(volkswagenCrossFox);

		
		listView.setAdapter(new CustomAdapter(this, marcas));
				
	}

}
