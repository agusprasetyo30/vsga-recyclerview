package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SlideAssignActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide_assign);
	}
	
	// Menampilkan activity WelcomeBackActivity ketika tombol GET STARTED ditekan
	public void onClickGetStarted(View view) {
		Intent i = new Intent(SlideAssignActivity.this, WelcomeBackActivity.class);
		startActivity(i);
	}
	
	// Menampilkan activity WelcomeBackActivity ketika tulisan Log In ditekan
	public void onClickLogin(View view) {
		Intent i = new Intent(SlideAssignActivity.this, WelcomeBackActivity.class);
		startActivity(i);
	}
}
