package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class WelcomeBackActivity extends AppCompatActivity {
//	Deklarasi variabel yang akan dihubungkan pada acivity
	EditText edtEmail;
	EditText edtPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_back);
		
		// Menghubungkan variabel yang dibuat dengan komponen pada activity
		edtEmail = findViewById(R.id.edt_email);
		edtPassword = findViewById(R.id.edt_password);
	}
	
	public static boolean isValidEmail(CharSequence email) {
		return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
	}
	
	//	Untuk tombol/tulisan forget password ketika ditekan
	public void onClickForgot(View view) {
		Intent i = new Intent(WelcomeBackActivity.this, ForgotPasswordActivity.class);
		startActivity(i);
	}
	
	//	Keadaan ketika tombol login ditekan maka akan menampilkan SuccessActivity
	public void onClickBtnLogin(View view) {
		// Validasi jika email dan password kosong
		if (TextUtils.isEmpty(edtEmail.getText().toString().trim()) && TextUtils.isEmpty(edtPassword.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "E-mail & Password tidak boleh kosong", Toast.LENGTH_LONG).show();
		}
		// Validasi jika email kosong
		else if (TextUtils.isEmpty(edtEmail.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "E-mail tidak boleh kosong", Toast.LENGTH_LONG).show();
		}
		// Validasi inputan tipe email
		else if (!isValidEmail(edtEmail.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "Email tidak valid", Toast.LENGTH_LONG).show();
			edtEmail.setText("");
		}
			// Validasi jika password kosong
		else if (TextUtils.isEmpty(edtPassword.getText().toString().trim())) {
				Toast.makeText(view.getContext(), "Password tidak boleh kosong", Toast.LENGTH_LONG).show();
		}
		else {
			Intent i = new Intent(WelcomeBackActivity.this, SuccessActivity.class);
			startActivity(i);
		}
	}
	
	public void clickSignUp(View view) {
		Intent i = new Intent(WelcomeBackActivity.this, RegisterActivity.class);
		startActivity(i);
	}
}
