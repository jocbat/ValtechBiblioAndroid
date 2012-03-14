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
import valtechBiblio.dao.RemoteLibrary;
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
    List<Book> books;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
    	String[] urls = new String[1];
		urls[0] = "http://i714.photobucket.com/albums/ww145/2shay78/book.png";
		imView = (ImageView)findViewById(R.id.imview);
		new DownloadImageTask().execute("http://ecx.images-amazon.com/images/I/51PpZM%2BcuXL._SL160_PIsitb-sticker-arrow-dp,TopRight,12,-18_SH30_OU01_AA160_.jpg");
    	
    	
    	
    	// initialisation du DAO pour récupérer les données
    	
    	
    	//List<Book> books2 = new MockLibrary().findAllBooks();
    	
    	
    }
    
    private class DownloadImageTask extends AsyncTask<String, Void, List<Book>> 
    {
        protected List<Book> doInBackground(String... urls) 
        {
        	ILibrary library = new RemoteLibrary();
        	List<Book> books = library.findAllBooks();
        	return books;
        }

        protected void onPostExecute(List<Book> result) 
        {
        	final ArrayAdapter<Book> adapter2 = new CustomAdapter(ValtechBiblioActivity.this,result);
        	ListView listView = (ListView) findViewById(R.id.mylist);
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
        
        
        Bitmap downloadFile(String fileUrl)
        {
        	Bitmap bmImg = null;
            URL myFileUrl =null;          
            try 
            {
                 myFileUrl= new URL(fileUrl);
            } catch (MalformedURLException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
            }
            try 
            {
                 HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();       
                 conn.setDoInput(true);
                 conn.connect();
                 InputStream is = conn.getInputStream();
                 bmImg = BitmapFactory.decodeStream(is);
                 //conn.disconnect();
                 //imView.setImageBitmap(bmImg);
                 return bmImg;
            } 
            catch (IOException e) 
            {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
            }
			return bmImg;
       }
        
        
       
    }
    
}