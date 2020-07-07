package com.delloil.databasesetups;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.delloil.databasesetups.Data.DatabaseHandler;
import com.delloil.databasesetups.Model.Contact;
import com.delloil.databasesetups.Util.Util;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private ArrayList<Contact> contactArrayList;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DatabaseHandler db = new DatabaseHandler(MainActivity.this);

		//Use this to add contacts the first time only, otherwise will keep adding the same data
		//addContact(db);

		//gets all the data and logs the output of names
		getAllContactDetails(db);

		//gets the count of data and logs it
		getCountOfData(db);

		//gets one contact
		//getAContactData(db);

		//delete a contact
		//deleteAContactData(db);
		//Log.d(Util.TAG, "after deleting");
		//getAllContactDetails(db);

		//update a contact
		updateContactData(db);
		Log.d(Util.TAG, "after updating");
		getAllContactDetails(db);



	}

	private void addContact(DatabaseHandler db){
		db.addContact(new Contact("James1","213986"));
        db.addContact(new Contact("Greg","098765"));
        db.addContact(new Contact("Helena","40678765"));
        db.addContact(new Contact("Carimo","768345"));

        db.addContact(new Contact("Silo","3445"));
        db.addContact(new Contact("Santos","6665"));
        db.addContact(new Contact("Litos","5344"));
        db.addContact(new Contact("Karate","96534"));
        db.addContact(new Contact("Guerra","158285"));
        db.addContact(new Contact("Gema","78130"));

	}

	private void getAllContactDetails(DatabaseHandler db){
		List<Contact> contactList = db.getAllContacts();

		for (Contact contact : contactList) {
			Log.d(Util.TAG, "onCreate: " + contact.getName());
		}

	}

	private void getCountOfData(DatabaseHandler db){
		int countOfData = db.getCount();
		Log.d(Util.TAG, String.valueOf(countOfData));

	}

	private void deleteAContactData(DatabaseHandler db){
		Contact deleteContact = new Contact();
		deleteContact.setId(3);
		db.deleteContact(deleteContact);

	}


	private void updateContactData(DatabaseHandler db){

		Contact updateContact = new Contact();
		updateContact.setId(1);
		updateContact.setName("New Name for "+Math.random());
		db.updateContact(updateContact);


	}

	private void getAContactData(DatabaseHandler db){
		Contact getOneContact = new Contact();
		getOneContact=db.getContact(2);
		Log.d(Util.TAG, "getAContactData: " + getOneContact.getName());
	}



}
