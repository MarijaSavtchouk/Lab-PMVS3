package com.bsu.mariacco.multiscreen;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        String [] islands = {getResources().getString(R.string.canari), getResources().getString(R.string.curili), getResources().getString(R.string.maldivi), getResources().getString(R.string.philipini)};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, islands);
        setListAdapter(adapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, Canari.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, Curili.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, Maldivi.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, Philipini.class);
                        break;
                    default:
                        intent =  new Intent(MainActivity.this, Canari.class);
                }
                Toast.makeText(getApplicationContext(), "Вы выбрали " +
                                parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        };
        getListView().setOnItemClickListener(itemListener);
    }
}
