package polinema.ac.id.dtschapter03_starter.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import polinema.ac.id.dtschapter03_starter.R;
import polinema.ac.id.dtschapter03_starter.models.SuperHero;

public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.MyViewHolder> {
	// Menambahkan variabel
	List<SuperHero> heroList;
	
	public SuperHeroAdapter(List<SuperHero> heroList) {
		this.heroList = heroList;
	}
	
	@NonNull
	@Override
	public SuperHeroAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
		// object context dapat diambil dari parent atau variabel lainnya yang menginisialisasi ViewGroup
		Context context = parent.getContext();
		// object context digunakan untuk membuat object LayoutInflater
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		// Object layoutInflater digunakan untuk membuat object view yang merupakan hasil inflate layout ( menghubungkan adapter dengan layout )
		View superHeroView = layoutInflater.inflate(R.layout.item_super_hero, parent, false);
		// object superHeroView digunakan untuk membua objek viewHolder
		MyViewHolder viewHolder = new MyViewHolder(superHeroView);
		
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(@NonNull SuperHeroAdapter.MyViewHolder myViewHolder, int i) {
		// Ambil satu item hero
		SuperHero hero = heroList.get(i);
		// set text heroName berdasarkan data dari model hero
		myViewHolder.heroName.setText(hero.getHeroName());
	}
	
	@Override
	public int getItemCount() {
		return heroList.size();
	}
	
	public class MyViewHolder extends RecyclerView.ViewHolder {
		public TextView heroName;
		
		public MyViewHolder(@NonNull View itemView) {
			super(itemView);
			// Variabel disesuaikan dengan layout, karena pada layout item_super_hero terdapat 1 TextView
			// maka pada kode program ini dibuat satu TextView yang melakukan findViewById ke ID layout yang bersesuaian
			heroName = itemView.findViewById(R.id.heroName);
		}
	}
}
