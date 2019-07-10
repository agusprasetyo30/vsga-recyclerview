package polinema.ac.id.dtschapter03_starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ResetPasswordActivity extends AppCompatActivity {
	// Inisialisasi Variabel
	EditText edtResetCode;
	EditText edtNewPassword;
	EditText edtConfirmPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reset_password);
	
		// Menghubungkan variabel dengan ID pada activity
		edtResetCode = findViewById(R.id.edt_reset_code);
		edtNewPassword = findViewById(R.id.edt_new_password);
		edtConfirmPassword = findViewById(R.id.edt_confirm_password);
	}
	
	//	Untuk tombol/tulisan forget password ketika ditekan
	public void postChangePassword(View view) {
		// Validasi inputan
		if (TextUtils.isEmpty(edtResetCode.getText().toString().trim()) && TextUtils.isEmpty(edtNewPassword.getText().toString().trim())
			&& TextUtils.isEmpty(edtResetCode.getText().toString().trim())) {
			
			Toast.makeText(view.getContext(), "Data tidak boleh kosong", Toast.LENGTH_LONG).show();
		}
		// Validasi inputan
		else if (TextUtils.isEmpty(edtResetCode.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "Code tidak boleh kosong", Toast.LENGTH_LONG).show();
		}
		else if (TextUtils.isEmpty(edtNewPassword.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "Password baru tidak boleh kosong", Toast.LENGTH_LONG).show();
		}
		else if (TextUtils.isEmpty(edtConfirmPassword.getText().toString().trim())) {
			Toast.makeText(view.getContext(), "Konfirmasi Password baru tidak boleh kosong", Toast.LENGTH_LONG).show();
		}
		// Validasi password baru dan konfirmasi password
		else if (!edtNewPassword.getText().toString().equals(edtConfirmPassword.getText().toString())) {
			Toast.makeText(view.getContext(), "Konfirmasi password tidak sesuai", Toast.LENGTH_LONG).show();
			edtNewPassword.setText("");
			edtConfirmPassword.setText("");
		} else {
			Intent i = new Intent(ResetPasswordActivity.this, SuccessActivity.class);
			startActivity(i);
		}
		
	}
}
