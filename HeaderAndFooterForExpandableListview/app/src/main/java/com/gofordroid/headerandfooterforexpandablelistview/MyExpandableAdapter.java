package com.gofordroid.headerandfooterforexpandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.gofordroid.headerandfooterforexpandablelistview.Model.ChildObject;
import com.gofordroid.headerandfooterforexpandablelistview.Model.ParentObject;

import java.util.List;

/**
 * Created by TrangHo on 10-05-2015.
 */
public class MyExpandableAdapter extends BaseExpandableListAdapter {
    Context context;
    List<ParentObject> parentObjects;

    public MyExpandableAdapter(Context context, List<ParentObject> parentObjects)
    {
        this.context = context;
        this.parentObjects = parentObjects;
    }
    @Override
    public int getGroupCount() {
        return parentObjects.size();
    }

    //Cộng thêm 2 vào childrenCount.Row đầu tiên và row cuối cùng dẽ được sử làm header và footer
    //Add 2 to childcount. The first row and the last row are used as header and footer to childview
    @Override
    public int getChildrenCount(int i) {
        return parentObjects.get(i).childObjects.size() +2;
    }

    @Override
    public ParentObject getGroup(int i) {
        return parentObjects.get(i);
    }

    @Override
    public ChildObject getChild(int i, int i2) {
        return parentObjects.get(i).childObjects.get(i2);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup)
    {
        ParentObject currentParent = parentObjects.get(i);
        if(view ==null)
        {
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.parent_row,null);
        }
        TextView txtMother = (TextView)view.findViewById(R.id.txtMother);
        TextView txtFather = (TextView)view.findViewById(R.id.txtFather);
        txtMother.setText(currentParent.mother);
        txtFather.setText(currentParent.father);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        ParentObject currentParent = getGroup(groupPosition);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //the first row is used as header
        if(childPosition ==0)
        {
            view = inflater.inflate(R.layout.child_header, null);
            TextView txtHeader = (TextView)view.findViewById(R.id.txtHeader);
            txtHeader.setText(currentParent.textToHeader);
        }

        //Here is the ListView of the ChildView
        if(childPosition>0 && childPosition<getChildrenCount(groupPosition)-1)
        {
            ChildObject currentChild = getChild(groupPosition,childPosition-1);
            view = inflater.inflate(R.layout.child_row,null);
            TextView txtChildName = (TextView)view.findViewById(R.id.txtChildName);
            TextView txtChildAge = (TextView)view.findViewById(R.id.txtChildAge);
            txtChildName.setText(currentChild.childName);
            txtChildAge.setText("Age: " + String.valueOf(currentChild.age));
        }
        //the last row is used as footer
        if(childPosition == getChildrenCount(groupPosition)-1)
        {
            view = inflater.inflate(R.layout.child_footer,null);
            TextView txtFooter = (TextView)view.findViewById(R.id.txtFooter);
            txtFooter.setText(currentParent.textToFooter);
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
