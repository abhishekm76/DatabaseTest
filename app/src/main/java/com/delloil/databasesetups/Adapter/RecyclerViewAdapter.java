package com.delloil.databasesetups.Adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.delloil.databasesetups.Model.Contact;
import com.delloil.databasesetups.R;
import com.delloil.databasesetups.UI.DetailsActivity;
import com.delloil.databasesetups.Util.Util;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

	private Context context;
	private List<Contact> contactList;

	public RecyclerViewAdapter(Context context, List<Contact> contactList) {
		this.context = context;
		this.contactList = contactList;
	}
	// this is the constructor for the adapter




	// This returns the viewholder after instantiating a new viewholder (based on the code at the bottom)
	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View view = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.contact_row, viewGroup, false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
		Contact contact = contactList.get(position); // each contact object inside of our list

		viewHolder.contactName.setText(contact.getName());
		viewHolder.phoneNumber.setText(contact.getPhoneNumber());
	}


	@Override
	public int getItemCount() {
		Log.d(Util.TAG, "size"+contactList.size());
		return contactList.size();

	}

	public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		// this gets the items from the layout and we can then use these items by setting onClick etc
		public TextView contactName;
		public TextView phoneNumber;
		public ImageView iconButton;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);

			itemView.setOnClickListener(this);

			contactName = itemView.findViewById(R.id.name);
			phoneNumber = itemView.findViewById(R.id.phone_number);
			iconButton = itemView.findViewById(R.id.icon_button);

			iconButton.setOnClickListener(this);



		}

		@Override
		public void onClick(View v) {

			int position = getAdapterPosition();
			Contact contact = contactList.get(position);

			Intent intent = new Intent(context, DetailsActivity.class);
			intent.putExtra("name", contact.getName());
			intent.putExtra("number", contact.getPhoneNumber());

			context.startActivity(intent);


//            switch (v.getId()) {
//                case R.id.icon_button:
//                    Log.d("IconClicked", "onClick: " + contact.getPhoneNumber());
//                    break;
//            }


			// Log.d("Clicked", "onClick: " + contact.getName());

		}
	}
}
