package polinema.ac.id.dtschapter03_starter.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import polinema.ac.id.dtschapter03_starter.R;
import polinema.ac.id.dtschapter03_starter.models.Contact;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
	// menginisialisasi variabel context
	private Context mContext;
	
	private List<Contact> listContact = new ArrayList<>();
	
	public ContactAdapter(List<Contact> listContact, Context context) {
		mContext = context;
		this.listContact = listContact;
	}
	
	// Membuat varibel dari interface yang dibuat
	private OnContactClickListener listener;
	
	// Membuat interface ketika ditekan
	// view 		= Untuk tampilan/keadaan ketika ditekan
	// position = Menginisialisasi posisi adapter ketika ditekan
	public interface OnContactClickListener {
		public void onClick(View view, int position);
	}
	
	public void setListener(OnContactClickListener listener) {
		this.listener = listener;
	}
	
	@NonNull
	@Override
	public ContactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View view = LayoutInflater
						.from(mContext)
						.inflate(R.layout.item_contact, viewGroup, false);
		
		ContactViewHolder viewHolder = new ContactViewHolder(view);
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder contactViewHolder, int i) {
		Contact contact = listContact.get(i);
		contactViewHolder.txtName.setText(contact.getName());
		contactViewHolder.txtPhone.setText(contact.getPhone());
		Picasso.with(mContext)
					.load(contact.getImageUrl())
					.placeholder(R.drawable.ic_launcher_foreground)
					.fit()
					.centerCrop()
					.into(contactViewHolder.imageContact);
	}
	
	@Override
	public int getItemCount() {
		return listContact.size();
	}
	
	public class ContactViewHolder extends RecyclerView.ViewHolder {
		public ImageView imageContact;
		public TextView txtName, txtPhone;
		
		public ContactViewHolder(@NonNull View itemView) {
			super(itemView);
			imageContact = itemView.findViewById(R.id.imageContact);
			txtName = itemView.findViewById(R.id.txtName);
			txtPhone = itemView.findViewById(R.id.txtPhoneNumber);
			// Keadaan ketika view ditekan
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					listener.onClick(v, getAdapterPosition());
				}
			});
		}
	}
}
