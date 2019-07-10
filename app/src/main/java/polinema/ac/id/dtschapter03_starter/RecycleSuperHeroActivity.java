package polinema.ac.id.dtschapter03_starter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import polinema.ac.id.dtschapter03_starter.adapters.SuperHeroAdapter;
import polinema.ac.id.dtschapter03_starter.models.SuperHero;

public class RecycleSuperHeroActivity extends AppCompatActivity {
	// Instansiasi Recycle View
	RecyclerView rvSuperHero;
	// Instansiasi list superhero
	List<SuperHero> listSuperHero = new ArrayList<>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycle_superhero);
		// Menyambungkan rvSuperHero ke layout
		rvSuperHero = findViewById(R.id.rvSuperHero);
		
		// Membuat object hero
		SuperHero hero = new SuperHero("Petruk");
		// Menambahkan hero ke list
		listSuperHero.add(hero);
		
		// Membuat object baru
		hero = new SuperHero("Gareng");
		// Menambahkan hero ke list
		listSuperHero.add(hero);
		
		// Membuat object baru
		hero = new SuperHero("Bagong");
		// Menambahkan hero ke list
		listSuperHero.add(hero);
		
		// Instansiasi adapter
		SuperHeroAdapter superHeroAdapter = new SuperHeroAdapter(listSuperHero);
		// Set adapter dan LayoutManager
		rvSuperHero.setAdapter(superHeroAdapter);
		rvSuperHero.setLayoutManager(new LinearLayoutManager(this));
	}
}
