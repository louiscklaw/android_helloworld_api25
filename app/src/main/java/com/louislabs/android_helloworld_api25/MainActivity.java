package com.louislabs.android_helloworld_api25;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    ArrayList<String> items_name;
//    ArrayList<String> items_description;

    List<String> l_string = new ArrayList<String>();
    List<List<String>> test_ll_string = new ArrayList<List<String>>();

    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;

    public void init_parts_list(){
        for (int i=0; i < 10; i++){

            l_string = new ArrayList<String>();
            l_string.add(String.format("<tag ID %d>", i));
            l_string.add("aluminium nuts");
            test_ll_string.add(l_string);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView)findViewById(R.id.lvItems);
//        items = new ArrayList<>();
//         itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        itemsAdapter = new ArrayAdapter (this, android.R.layout.simple_list_item_2, android.R.id.text1, test_ll_string)
        {
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                text1.setText(test_ll_string.get(position).get(0) );
                text2.setText(test_ll_string.get(position).get(1));

                return view;
            }
        };
        lvItems.setAdapter(itemsAdapter);

//
//        l_string.add("<tag ID 1>");
//        l_string.add("aluminium scaffold");
//        test_ll_string.add(l_string);
//
//        l_string = new ArrayList<String>();
//        l_string.add("<tag ID 2>");
//        l_string.add("aluminium nuts");
//        test_ll_string.add(l_string);
        init_parts_list();

    }
}
