package com.gofordroid.headerandfooterforexpandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;


public class MainActivity extends Activity {
    ExpandableListView elv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = getLayoutInflater();
        elv = (ExpandableListView)findViewById(R.id.elv);

        elv.setOnGroupExpandListener(onGroupExpandListenser);
        MyExpandableAdapter adapter = new MyExpandableAdapter(this, SampleData.getData());
        elv.setAdapter(adapter);
    }

    ExpandableListView.OnGroupExpandListener onGroupExpandListenser = new ExpandableListView.OnGroupExpandListener() {
        int previousGroup =-1;
        @Override
        public void onGroupExpand(int groupPosition) {
            if(groupPosition!= previousGroup)
                elv.collapseGroup(previousGroup);
            previousGroup = groupPosition;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
