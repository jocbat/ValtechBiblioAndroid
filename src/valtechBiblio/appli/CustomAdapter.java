package valtechBiblio.appli;

import java.util.List;

import valtechBiblio.Model.Book;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Book> 
{
	private final Context context;
	private final Book[] values;

	public CustomAdapter(Context context, Book[] values) {
		super(context, R.layout.rowlayout, values);
		this.context = context;
		this.values = values;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
		TextView textViewEntry = (TextView) rowView.findViewById(R.id.entry);
		TextView textViewOk = (TextView) rowView.findViewById(R.id.ok);
		TextView textViewCancel = (TextView) rowView.findViewById(R.id.cancel);
		
		//ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		//textView.setText((Book) values[position]);
		// Change the icon for Windows and iPhone
		
		Book currentBook = values[position];
		textViewEntry.setText(currentBook.getTitle());
		textViewOk.setText(Integer.toString(currentBook.getNumberOfPages()));
		textViewCancel.setText("Nombre d'auteurs : " + Integer.toString(currentBook.getAuthor().size()));

		return rowView;
	}

}
