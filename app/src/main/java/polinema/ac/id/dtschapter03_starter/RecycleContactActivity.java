package polinema.ac.id.dtschapter03_starter;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import polinema.ac.id.dtschapter03_starter.adapters.ContactAdapter;
import polinema.ac.id.dtschapter03_starter.models.Contact;

public class RecycleContactActivity extends AppCompatActivity implements ContactAdapter.OnContactClickListener {
	public RecyclerView recyclerView; // menginisialisasi recycler
	public ContactAdapter contactAdapter; // menginisialisasi Adapter
	public RecyclerView.LayoutManager layoutManager; // menginisialisasi layout yang akan digunakan
	public List<Contact> listContact = new ArrayList<>(); // Membuat variabel array untuk model Contact
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycle_contact);
		
		recyclerView = findViewById(R.id.rvContact);
		
		listContact.add(new Contact("Iron Man",
			"102018308",
			"https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-14-512.png"));
		
		listContact.add(new Contact("Bat Man",
			"102018309",
			"https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-22-512.png"));
		
		listContact.add(new Contact("Groot",
			"102018307",
			"https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-21-512.png"));
		
		listContact.add(new Contact("Sonic",
			"102018301",
			"https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-26-512.png"));
		
		listContact.add(new Contact("Bapak Nurhadi",
			"187316373",
			"https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1547767551/u3wutzogf853ksr2lncw.jpg"));
		
		listContact.add(new Contact("Mbak Lucinta Luna",
			"932847238",
			"https://cdn.brilio.net/news/2019/02/05/158912/986405-1000xauto-lucinta-luna-berhijab.jpg"));
		
		listContact.add(new Contact("Rizal",
			"934372423",
			"https://i.pinimg.com/originals/d5/66/f4/d566f4dbe3be3f1ac2fca7253430c014.jpg"));
		
		listContact.add(new Contact("Spongebob",
			"483264324",
			"https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/SpongeBob_SquarePants_character.svg/220px-SpongeBob_SquarePants_character.svg.png"));
		
		listContact.add(new Contact("Upin botak",
			"131422335",
			"https://i.pinimg.com/originals/06/1b/a3/061ba385919d6da221e377e23d145d2f.jpg"));
		
		contactAdapter = new ContactAdapter(listContact, RecycleContactActivity.this);
		contactAdapter.setListener(this);
		
		layoutManager = new LinearLayoutManager(getApplicationContext());
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setHasFixedSize(true);
		
		// Membuat garis dibawah recycler view
		DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
		itemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.line));
		recyclerView.addItemDecoration(itemDecoration);
		recyclerView.setAdapter(contactAdapter);
	}
	
	@Override
	public void onClick(View view, int position) {
		Contact contact = listContact.get(position);
		Toast.makeText(this, contact.getName(), Toast.LENGTH_LONG).show();
	}
}
