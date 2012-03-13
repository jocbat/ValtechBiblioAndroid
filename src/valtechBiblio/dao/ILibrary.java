package valtechBiblio.dao;

import java.util.List;

import valtechBiblio.Model.Book;

// interface représentant la bibliothèque de livres
public interface ILibrary 
{
	List<Book> findAllBooks();
	
	void addBook(Book book);
	
	void deleteBook(Book book);
	
	void editBook(Book book);
	
	void reserveBook(Book book);
}
