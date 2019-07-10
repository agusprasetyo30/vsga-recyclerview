package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import polinema.ac.id.dtschapter03_starter.models.Register;

public class RegisterActivity extends AppCompatActivity {
	//	YANG DIKOMENTARI ADALAH DATA DARI PRAKTIKUM 6
	
	// Variabel global
	private final String TAG = RegisterActivity.class.getName();
	// Variabel untuk array
	public static final String Key_RegisterActivity = "Key_RegisterActivity";
	
	EditText etNama, etTanggalLahir, etUsername, etPassword;
//	RadioButton radioLaki, radioPerempuan;
	RadioButton radioButtonJk;
	RadioGroup rgJenisKelamin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		etNama = findViewById(R.id.edt_name);
		etTanggalLahir = findViewById(R.id.edt_tanggal_lahir);
		etUsername = findViewById(R.id.edt_username);
		etPassword = findViewById(R.id.edt_password);
//		radioLaki = findViewById(R.id.rb_laki);
//		radioPerempuan = findViewById(R.id.rb_perempuan);
		rgJenisKelamin = findViewById(R.id.rg_jenis_kelamin);
	}
	
	public void clickSignUp(View view) {
		if (TextUtils.isEmpty(etNama.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
			etNama.requestFocus();
		} else if (TextUtils.isEmpty(etTanggalLahir.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "Tanggal Lahir tidak boleh kosong", Toast.LENGTH_SHORT).show();
			etTanggalLahir.requestFocus();
		}else if (rgJenisKelamin.getCheckedRadioButtonId() == -1) {
			Toast.makeText(view.getContext(), "Harap mengisi jenis kelamin", Toast.LENGTH_LONG).show();
			rgJenisKelamin.requestFocus();
		} else if (TextUtils.isEmpty(etUsername.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
			etUsername.requestFocus();
		} else if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
			etPassword.requestFocus();
		} else {
			String username = etUsername.getText().toString();
			String password = etPassword.getText().toString();
			String nama = etNama.getText().toString();
		
			// Mengambil ID dari radio button yang dipilih
			int selectedJK = rgJenisKelamin.getCheckedRadioButtonId();
			
			// Jadikan ID radio button sebagai rujukan binding view
			radioButtonJk = findViewById(selectedJK);
		
			// Hasilnya akan sama dengan baris 40
			String jk = radioButtonJk.getText().toString();
			
			String tanggal_lahir = etTanggalLahir.getText().toString();
			Log.d("postSignUp: ", username);
			Log.d("postSignUp: ", password);
			Log.d("postSignUp: ", nama);
			Log.d("postSignUp: ", jk);
			Log.d("postSignUp: ", tanggal_lahir);
			
			Register register = new Register(nama, username, password, tanggal_lahir, jk);
			
			Intent intent = new Intent(RegisterActivity.this, RegisterResultActivity.class);
			intent.putExtra(Key_RegisterActivity, register);
			// intent.putExtra(Key_RegisterActivity, new String[] { nama, username, tanggal_lahir, jk, password });
			startActivity(intent);
		}
	}
}
