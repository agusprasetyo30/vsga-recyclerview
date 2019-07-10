package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeSlideSuperheroActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_slide_superhero);
	}
	
	// Menampilkan Activity SlideAssignAcitivity ketika ditekan tombol GET STARTED
	public void onClickGetStarted(View view) {
		Intent i = new Intent(WelcomeSlideSuperheroActivity.this, SlideAssignActivity.class);
		startActivity(i);
	}
	
	// Menampilkan activity WelcomeBackActivity ketika tulisan Log In ditekan
	public void onClickLogin(View view) {
		Intent i = new Intent(WelcomeSlideSuperheroActivity.this, WelcomeBackActivity.class);
		startActivity(i);
	}
}
