package com.example.mareklaskowski.listview_f2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
/*
This project demonstrates using an AdapterView subclass called ListView which specializes
in displaying linearly arranged dynamic content
It works with a class called ArrayAdapter
 */

public class MainActivity extends AppCompatActivity {

    /*in order for our ListView to respond to user touches (clicks)
    we need to define a OnItemClickListern object and override its onItemClick method
    (this is very much like the anonymous temporary class pattern we use for Button click handlers)
     */
    private AdapterView.OnItemClickListener myClickListener = new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //parent is the ListView and position stores the index of the item that was clicked

            //extract data from the View that was clicked...
            String data = parent.getItemAtPosition(position).toString();
            //do something with the data, for now just show a Toast - but you can do anything with it
            //notice this code is running in an OnItemClickListener which is not a subclass of Context
            //get a contexdt by using the view that was passed...
            Toast.makeText(view.getContext(), "You clicked  "+ data + " that's COOL!", Toast.LENGTH_LONG).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up a java array that will contain our data that will back the ListView
        //notice that this data could equally well have come from a file, database, internet etc.
        String[] data = new String[] {"Dog", "banana", "pizza", "Cat" };

        /*
        to connect the ListView with our data array we need to create an ArrayAdapter for Strings
        the constructor for ArrayAdaptor requires a "Sample List Item" View or Layout on which
        to base all the items in the list.
        Make sure that you have a sample item in your /res/layout folder
        The constructor arguments for ArrayAdapter are: a Context, sample_layout_id, data (array)
        Recall: the ArrayAdpter is like the "controller" in the Model-View-Controller architecture
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, data);

        //now we need to link the ArrayAdapter with our ListView
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //associate the listview to use the listener or handler that we created as a private, inner class
        listView.setOnItemClickListener(myClickListener);
    }
}
