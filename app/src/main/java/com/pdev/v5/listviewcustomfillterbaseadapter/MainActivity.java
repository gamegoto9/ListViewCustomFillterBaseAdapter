package com.pdev.v5.listviewcustomfillterbaseadapter;

import android.bluetooth.BluetoothA2dp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    SearchView sv;

    String[] name={"Juan Mata","ander Herera"};
    int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.list_view);
        sv = (SearchView) findViewById(R.id.search_view);

        final Adapter adapter = new Adapter(this,getPlayers());
        lv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

    }

    private ArrayList<Player> getPlayers(){
        ArrayList<Player> players = new ArrayList<Player>();
        Player p;

        for(int i =0;i<name.length;i++){
            p = new Player(name[i],images[i]);
            players.add(p);
        }
        return players;

    }
}
