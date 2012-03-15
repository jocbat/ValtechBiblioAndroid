package valtechBiblio.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import valtechBiblio.Model.Book;

public class RemoteLibrary implements ILibrary
{
	Bitmap remotePicture;
	ILibrary mockLibrary = new MockLibrary();
	
	public RemoteLibrary()
	{
		
	}
	
	public List<Book> findAllBooks() 
	{
		List<Book> tempBooks = mockLibrary.findAllBooks();
		HttpClient httpclient = new DefaultHttpClient();
		
		HttpGet httpget = new HttpGet("http://localhost:5984/"); 
		//HttpGet httpget = new HttpGet("http://www.google.fr");
		
		HttpResponse response;
        try {
            response = httpclient.execute(httpget);
            // Examine the response status
            Log.i("Praeda",response.getStatusLine().toString());
 
            // Get hold of the response entity
            HttpEntity entity = response.getEntity();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release
 
            if (entity != null) {
 
                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
                Log.i("Praeda",result);
 
                // A Simple JSONObject Creation
                JSONObject json=new JSONObject(result);
                Log.i("Praeda","<jsonobject>\n"+json.toString()+"\n</jsonobject>");
 
                // A Simple JSONObject Parsing
                JSONArray nameArray=json.names();
                JSONArray valArray=json.toJSONArray(nameArray);
                for(int i=0;i<valArray.length();i++)
                {
                    Log.i("Praeda","<jsonname"+i+">\n"+nameArray.getString(i)+"\n</jsonname"+i+">\n"
                            +"<jsonvalue"+i+">\n"+valArray.getString(i)+"\n</jsonvalue"+i+">");
                }
 
                // A Simple JSONObject Value Pushing
                json.put("sample key", "sample value");
                Log.i("Praeda","<jsonobject>\n"+json.toString()+"\n</jsonobject>");
 
                // Closing the input stream will trigger connection release
                instream.close();
            }
 
 
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		
		
		for(Book book : tempBooks)
		{
			book.setPicture(downloadFile(book.getUrlPicture()));
		}
		return tempBooks;
	}

	public void addBook(Book book) 
	{
		// TODO Auto-generated method stub
		
	}

	public void deleteBook(Book book) 
	{
		// TODO Auto-generated method stub
		
	}

	public void editBook(Book book)
	{
		// TODO Auto-generated method stub
		
	}

	public void reserveBook(Book book)
	{
		// TODO Auto-generated method stub
		
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
	
	
	private static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    
    
	

}
