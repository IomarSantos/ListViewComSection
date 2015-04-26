package br.com.listviewcomsection;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	private static final int TYPE_ITEM = 0;
	private static final int TYPE_SEPARATOR = 1;

	private LayoutInflater mInflater;
	private List<Object> marcas;

	public CustomAdapter(Context context, List<Object> marcas) {
		this.marcas = marcas;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getItemViewType(int position) {
		if (getItem(position) instanceof Modelo) {
			return TYPE_ITEM;
		}
		return TYPE_SEPARATOR;
	}

	@Override
	public boolean isEnabled(int position) {
		return (getItemViewType(position) == TYPE_ITEM);
	}

	@Override
	public int getCount() {
		return marcas.size();
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public Object getItem(int position) {
		return marcas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;

		int type = getItemViewType(position);

		if (convertView == null) {
			holder = new ViewHolder();
			switch (type) {
			case TYPE_ITEM:
				convertView = mInflater.inflate(R.layout.list_item, null);
				holder.textView = (TextView) convertView.findViewById(R.id.text);
				break;
			case TYPE_SEPARATOR:
				convertView = mInflater.inflate(R.layout.list_item_section, null);
				holder.textView = (TextView) convertView.findViewById(R.id.textSeparator);
				break;
			}
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		switch (type) {
		case TYPE_ITEM:
			Modelo modelo = (Modelo) getItem(position);
			holder.textView.setText(modelo.getNomeModelo());
			break;
		case TYPE_SEPARATOR:
			Marca marca = (Marca) getItem(position);
			holder.textView.setText(marca.getNomeMarca());
			break;
		}

		return convertView;
	}

	public static class ViewHolder {
		public TextView textView;
	}
}
