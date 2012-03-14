package valtechBiblio.dao;

import java.util.ArrayList;
import java.util.List;

import valtechBiblio.Model.Book;

public class MockLibrary implements ILibrary
{
	public MockLibrary()
	{
		Book book = new Book();
		ArrayList<String> authors = new ArrayList<String>();
		authors.add("Lewis Carol");
		authors.add("Rousseau");
		authors.add("Mickael Jackson");
		book.setAuthor(authors);
		book.setNumberOfPages(234);
		book.setTitle("Ma vie mon oeuvre");
		book.setReserved(false);
		book.setUrlPicture("http://ecx.images-amazon.com/images/I/51PpZM%2BcuXL._SL160_PIsitb-sticker-arrow-dp,TopRight,12,-18_SH30_OU01_AA160_.jpg");
		
		Book book2 = new Book();
		ArrayList<String> authors2 = new ArrayList<String>();
		authors2.add("Anthony D'Hierre");
		book2.setAuthor(authors2);
		book2.setNumberOfPages(11);
		book2.setTitle("HTML5 c'est de la balle !");
		book2.setReserved(true);
		book2.setUrlPicture("http://www.critique-livre.fr/wp-content/uploads/le_rouge_et_le_noir.jpg");
		
		Book book3 = new Book();
		ArrayList<String> authors3 = new ArrayList<String>();
		authors3.add("Lionel Nimong");
		book3.setAuthor(authors3);
		book3.setNumberOfPages(987);
		book3.setTitle("J'ai acheté une radio FM");
		book3.setReserved(false);
		book3.setUrlPicture("http://livre-html5.com/img/livre-html5.jpg");
		
		books.add(book);
		books.add(book2);
		books.add(book3);
		
	}
	
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return books;
	}

	public void addBook(Book book) {
		books.add(book);
		
	}

	public void deleteBook(Book book) {
		books.remove(book);
		
	}

	public void editBook(Book book) 
	{	
		
	}

	public void reserveBook(Book book) {
		// TODO Auto-generated method stub
		
	}

}
