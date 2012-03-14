package valtechBiblio.dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
	
	
	
    
    
	

}
