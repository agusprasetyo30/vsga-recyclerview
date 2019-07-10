package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeSlideCalendarActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_slide_calendar);
		
	}
	
	// Menampilkan Activity WelcomeSlideSuperheroAcitivity
	public void onClickGetStarted(View view) {
		Intent i = new Intent(WelcomeSlideCalendarActivity.this, WelcomeSlideSuperheroActivity.class);
		startActivity(i);
	}
	
	// Menampilkan activity WelcomeBackActivity ketika tulisan Log In ditekan
	public void onClickLogin(View view) {
		Intent i = new Intent(WelcomeSlideCalendarActivity.this, WelcomeBackActivity.class);
		startActivity(i);
	}
	
	public void clickContactUs(View view) {
		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("text/plain");
		i.putExtra(Intent.EXTRA_EMAIL, new String[]{"dts@polinema.ac.id", "danykurniawanapk3@gmail.com"});
		i.putExtra(Intent.EXTRA_CC, new String[]{"jazzmedia998@gmail.com"});
		i.putExtra(Intent.EXTRA_BCC, new String[]{"sindisafitriani@gmail.com"});
		i.putExtra(Intent.EXTRA_SUBJECT, "Test Email");
		i.putExtra(Intent.EXTRA_TEXT, "Test Email");
		startActivity(i.createChooser(i, "Pilih email client"));
	}
}
