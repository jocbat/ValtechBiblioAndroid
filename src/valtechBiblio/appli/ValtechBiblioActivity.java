package valtechBiblio.appli;
import java.util.List;
import valtechBiblio.Model.Book;
import valtechBiblio.dao.ILibrary;
import valtechBiblio.dao.RemoteLibrary;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class ValtechBiblioActivity extends Activity 
{
    Bitmap image;
    ImageView imView;
    List<Book> books;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
		imView = (ImageView)findViewById(R.id.imview);
		new DownloadBooksTask().execute();
    }
    
    private class DownloadBooksTask extends AsyncTask<Void, Void, List<Book>> 
    {
        protected List<Book> doInBackground(Void... unused) 
        {
        	ILibrary library = new RemoteLibrary();
        	List<Book> books = library.findAllBooks();
        	return books;
        }

        protected void onPostExecute(List<Book> result) 
        {
        	final ArrayAdapter<Book> adapter2 = new CustomAdapter(ValtechBiblioActivity.this,result);
        	ListView listView = (ListView) findViewById(R.id.mylist);
    		listView.setAdapter(adapter2);
    		listView.setOnItemClickListener(new OnItemClickListener() {
    			public void onItemClick(AdapterView<?> parent, View view,
    				int position, long id) {
    				Toast.makeText(getApplicationContext(),
    					"Click ListItem Number " + position, Toast.LENGTH_LONG)
    					.show();
    			}
    		});
        }
    }  
}