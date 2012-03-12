package valtechBiblio.Model;

import java.util.Date;
import java.util.List;

import android.graphics.Bitmap;

// classe représentant un livre physique
public class Book 
{
	// Le titre 
	private String title;
	
	// les auteurs
	private List<String> author;
	
	// nombre de pages 
	private int numberOfPages;
	
	// les différents domaines auxquels appartient le livre
	private List<String> fields;
	
	// image de la couverture du livre
	private Bitmap picture;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getAuthor() {
		return author;
	}
	public void setAuthor(List<String> author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	public Bitmap getPicture() {
		return picture;
	}
	public void setPicture(Bitmap picture) {
		this.picture = picture;
	}
	
	
	
}
