package valtechBiblio.appli;

import java.util.ArrayList;

import valtechBiblio.Model.Book;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ValtechBiblioActivity extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
    	ListView listView = (ListView) findViewById(R.id.mylist);
    	/*String[] values = new String[] { "Le rouge et le noir", "Alice au pays des merveilles", "Astérix chez les Bretons",
    		"Ouioui fait de l'Android", "Superman", "Ma vie mon oeuvre", "Guerre et paix", "Les Bidochons",
    		"Linux", "OS/2", "Le rouge et le noir2", "Alice au pays des merveilles2", "Astérix chez les Bretons2"};*/
    	
    	/*final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
    			R.layout.rowlayout, R.id.entry, values);*/
    	
    	Book[] books = new Book[2];
    	Book firstBook = new Book();
    	firstBook.setNumberOfPages(345);
    	firstBook.setTitle("Ah ah ah !");
    	ArrayList<String> auteurs = new ArrayList<String>();
    	auteurs.add("Sartre");
    	auteurs.add("Rousseau");
    	firstBook.setAuthor(auteurs);
    	books[0] = firstBook;
    	
    	Book secondBook = new Book();
    	secondBook.setNumberOfPages(12);
    	secondBook.setTitle("Oh oh oh !");
    	ArrayList<String> auteurs2 = new ArrayList<String>();
    	auteurs2.add("Bertrand Meyer");
    	secondBook.setAuthor(auteurs2);
    	books[1] = secondBook;
    	
    	final ArrayAdapter<Book> adapter2 = new CustomAdapter(this,books);

    		// Assign adapter to ListView
    		listView.setAdapter(adapter2);
    		listView.setOnItemClickListener(new OnItemClickListener() {
    			public void onItemClick(AdapterView<?> parent, View view,
    				int position, long id) {
    				Toast.makeText(getApplicationContext(),
    					"Click ListItem Number " + position, Toast.LENGTH_LONG)
    					.show();
    			}
    		});
    		//EditText filterEditText = (EditText) findViewById(R.id.searchFilter);
    		/*filterEditText.addTextChangedListener(new TextWatcher() {
    		    public void onTextChanged(CharSequence s, int start, int before,
    		      int count) {
    		      adapter.getFilter().filter(s.toString());
    		    }
    		     public void beforeTextChanged(CharSequence s, int start, int count,
    		      int after) {
    		     }
    		 
    		     public void afterTextChanged(Editable s) {
    		     }
    		});*/
    }
    
}