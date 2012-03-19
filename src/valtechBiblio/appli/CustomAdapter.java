package valtechBiblio.appli;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import valtechBiblio.Model.Book;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Book> 
{
	private final Context context;
	private final List<Book> values;
	Bitmap image;

	public CustomAdapter(Context context, List<Book> books) {
		super(context, R.layout.rowlayout, books);
		this.context = context;
		this.values = books;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
		TextView textViewEntry = (TextView) rowView.findViewById(R.id.entry);
		TextView textViewOk = (TextView) rowView.findViewById(R.id.ok);
		TextView textViewCancel = (TextView) rowView.findViewById(R.id.cancel);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.label);
		RelativeLayout reservedImageContainer = (RelativeLayout) rowView.findViewById(R.id.imagecontainer);
		
		Book currentBook = values.get(position);
		textViewEntry.setText(currentBook.getTitle());
		textViewOk.setText(Integer.toString(currentBook.getNumberOfPages()));
		//textViewCancel.setText("Nombre d'auteurs : " + Integer.toString(currentBook.getAuthor().size()));
		
		//Uri uri = Uri.parse("http://icons-search.com/img/icons-land/IconsLandVistaHalloweenEmoticonsDemo.zip/IconsLandVistaHalloweenEmoticonsDemo-PNG-16x16-Wink.png-16x16.png");
		imageView.setImageBitmap(currentBook.getPicture());
		
		//reservedImageContainer.setBackgroundDrawable(background);
		if(!currentBook.isReserved())
		{

		}
		else
		{
			imageView.setAlpha((float) 0.4);
		}
		
		return rowView;
	}




}
