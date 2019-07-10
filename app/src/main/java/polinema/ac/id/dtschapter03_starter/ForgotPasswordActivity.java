package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {
	EditText edtEmailForgot;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgot_password);
	
		edtEmailForgot = findViewById(R.id.edt_email_forgot);
	}
	
	public static boolean isValidEmail(CharSequence email) {
		return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
	}
	
	// Menampilkan Activity ResetPasswordActivity ketika ditekan tombol SEND REQUEST
	public void onClickSendRequest(View view) {
		if (TextUtils.isEmpty(edtEmailForgot.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "E-mail tidak boleh kosong", Toast.LENGTH_LONG).show();
		}
		// Validasi
		else if (!isValidEmail(edtEmailForgot.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "E-mail tidak valid", Toast.LENGTH_LONG).show();
			edtEmailForgot.setText("");
		} else {
			Intent i = new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class);
			startActivity(i);
		}
		
	}
}
