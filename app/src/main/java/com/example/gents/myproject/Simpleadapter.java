package com.example.gents.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android . view . View;
import android . widget . AdapterView;
import android . widget . ListView;
import android . widget . SimpleAdapter;
import android . widget . Toast;

import java . util . ArrayList;
import java . util . HashMap;

public class Simpleadapter extends AppCompatActivity {

    //initialize view's
    ListView simpleListView;
    String [] animalNames = { "dove" , "elephant" , "horse" , "lion" }; //animal names array

    int [] animalImages = { R . drawable . dove , R . drawable . elephant , R . drawable . horse ,
            R . drawable . lion  }; //animal images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleadapter);
        simpleListView =( ListView ) findViewById ( R . id . simplelistview );

        ArrayList < HashMap < String , String >> arrayList = new ArrayList <>();
        for ( int i = 0 ; i < animalNames . length ; i ++)
        {

            HashMap < String , String > hashMap = new HashMap <>();
            hashMap . put ( "name" , animalNames [ i ]);
            hashMap . put ( "image" , animalImages [ i ]+ "" );
            arrayList . add ( hashMap );
        }
        String [] from ={ "name" , "image" };
        int [] to ={ R . id . textView, R . id . imageView };


    SimpleAdapter simpleAdapter = new
            SimpleAdapter ( this , arrayList , R . layout . list_view_items , from , to );
simpleListView . setAdapter ( simpleAdapter ); //sets the adapter for listView


//perform listView item click event
simpleListView . setOnItemClickListener ( new AdapterView . OnItemClickListener () {
        @Override
        public void onItemClick ( AdapterView <?> adapterView , View view , int i , long l ) {
            Toast . makeText ( getApplicationContext (), animalNames [ i ], Toast . LENGTH_LONG ). show ();
        }
    });
    }
}
