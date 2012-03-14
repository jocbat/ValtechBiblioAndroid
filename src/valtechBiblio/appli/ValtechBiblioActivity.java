package valtechBiblio.appli;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import valtechBiblio.Model.Book;
import valtechBiblio.dao.ILibrary;
import valtechBiblio.dao.MockLibrary;
import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ValtechBiblioActivity extends Activity 
{
    Bitmap image;
    ImageView imView;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
    	String[] urls = new String[1];
		urls[0] = "http://i714.photobucket.com/albums/ww145/2shay78/book.png";
		imView = (ImageView)findViewById(R.id.imview);
		new DownloadImageTask().execute("http://i714.photobucket.com/albums/ww145/2shay78/book.png");
    	ListView listView = (ListView) findViewById(R.id.mylist);
    	
    	
    	// initialisation du DAO pour récupérer les données
    	ILibrary library = new MockLibrary();
    	List<Book> books = library.findAllBooks();
    	
    	
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
    }
    
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        protected Bitmap doInBackground(String... urls) {
            return downloadFile(urls[0]);
        }

        protected void onPostExecute(Bitmap result) {
        	imView.setImageBitmap(result);
        }
        
        
        Bitmap downloadFile(String fileUrl){
        	Bitmap bmImg = null;
            URL myFileUrl =null;          
            try {
                 myFileUrl= new URL(fileUrl);
            } catch (MalformedURLException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
            }
            try {
                 HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();
                 conn.setDoInput(true);
                 conn.connect();
                 InputStream is = conn.getInputStream();
                 
                 bmImg = BitmapFactory.decodeStream(is);
                 //imView.setImageBitmap(bmImg);
                 return bmImg;
            } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
            }
			return bmImg;
       }
    }
    
}