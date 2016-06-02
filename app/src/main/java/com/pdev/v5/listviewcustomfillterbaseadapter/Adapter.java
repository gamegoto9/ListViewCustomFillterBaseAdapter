package com.pdev.v5.listviewcustomfillterbaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by v5 on 2/6/2559.
 */
public class Adapter extends BaseAdapter implements Filterable{

    Context c;
    ArrayList<Player> players;
    CustomFilter filter;
    ArrayList<Player> filterList;

    public Adapter(Context ctx, ArrayList<Player> players){
        this.c = ctx;
        this.players = players;
        this.filterList = players;
    }



    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int position) {
        return players.get(position);
    }

    @Override
    public long getItemId(int position) {
        return players.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item,null);

        }
        TextView nameTxt = (TextView) convertView.findViewById(R.id.name);
        ImageView img = (ImageView) convertView.findViewById(R.id.flag);

        nameTxt.setText(players.get(position).getName());
        img.setImageResource(players.get(position).getImg());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new CustomFilter();
        }
        return filter;
    }

    class CustomFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if(constraint != null && constraint.length()>0){
                constraint = constraint.toString().toUpperCase();
                ArrayList<Player> filters = new ArrayList<Player>();

                for(int i=0;i<filterList.size();i++){
                    if(filterList.get(i).getName().toUpperCase().contains(constraint)){
                        Player p = new Player(filterList.get(i).getName(),
                                filterList.get(i).getImg());
                        filters.add(p);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }else{
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            players = (ArrayList<Player>) results.values;
            notifyDataSetChanged();
        }
    }

}
