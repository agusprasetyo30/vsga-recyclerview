package polinema.ac.id.dtschapter03_starter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import polinema.ac.id.dtschapter03_starter.models.Register;

public class RegisterResultActivity extends AppCompatActivity {
	
	//	YANG DIKOMENTARI ADALAH DATA DARI PRAKTIKUM 6
	
	// Inisialisasi variabel
	TextView tvResultNama, tvResultUsername, tvResultTglLahir, tvResultJk;
	
	// Intent Key
	public static final String Key_RegisterActivity = "Key_RegisterActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_result);
		
		// Memasukan view
		tvResultNama = findViewById(R.id.tv_result_nama);
		tvResultUsername = findViewById(R.id.tv_result_username);
		tvResultTglLahir = findViewById(R.id.tv_result_tanggal_lahir);
		tvResultJk = findViewById(R.id.tv_result_jk);
		
		// Get string array berdasarkan KEY
//		String[] stringArray = getIntent().getStringArrayExtra(RegisterActivity.Key_RegisterActivity);
		
//		String data = "";
//
//		for (int i = 0; i < stringArray.length; i++) {
//			data += stringArray[i] + " ";
//		}
//
//		Log.d("Mencoba", data);
		
		// Set value to TextView
//		tvResultNama.setText(stringArray[0]);
//		tvResultUsername.setText(stringArray[1]);
//		tvResultTglLahir.setText(stringArray[2]);
//		tvResultJk.setText(stringArray[3]);
		
		// MENGGUNAKAN PARCELABLE
		Register register = getIntent().getParcelableExtra(Key_RegisterActivity);
		
		tvResultNama.setText(register.getNama());
		tvResultUsername.setText(register.getUsername());
		tvResultTglLahir.setText(register.getTanggalLahir());
		tvResultJk.setText(register.getJenisKelamin());
		
	}
}
