package polinema.ac.id.dtschapter03_starter.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Register implements Parcelable {
	private String nama;
	private String username;
	private String password;
	private String tanggalLahir;
	private String jenisKelamin;
	
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.nama);
		dest.writeString(this.username);
		dest.writeString(this.password);
		dest.writeString(this.tanggalLahir);
		dest.writeString(this.jenisKelamin);
	}
	
	
	protected Register(Parcel in) {
		this.nama = in.readString();
		this.username = in.readString();
		this.password = in.readString();
		this.tanggalLahir = in.readString();
		this.jenisKelamin = in.readString();
	}
	
	public static final Parcelable.Creator<Register> CREATOR = new Parcelable.Creator<Register>() {
		@Override
		public Register createFromParcel(Parcel source) {
			return new Register(source);
		}
		
		@Override
		public Register[] newArray(int size) {
			return new Register[size];
		}
	};
	
	public Register(String nama, String username, String password, String tanggalLahir, String jenisKelamin) {
		this.nama = nama;
		this.username = username;
		this.password = password;
		this.tanggalLahir = tanggalLahir;
		this.jenisKelamin = jenisKelamin;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTanggalLahir() {
		return tanggalLahir;
	}
	
	public void setTanggalLahir(String tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	
	public static Creator<Register> getCREATOR() {
		return CREATOR;
	}
}

