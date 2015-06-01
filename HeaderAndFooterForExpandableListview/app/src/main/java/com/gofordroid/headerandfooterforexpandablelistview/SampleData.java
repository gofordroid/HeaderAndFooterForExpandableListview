package com.gofordroid.headerandfooterforexpandablelistview;

import com.gofordroid.headerandfooterforexpandablelistview.Model.ChildObject;
import com.gofordroid.headerandfooterforexpandablelistview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TrangHo on 10-05-2015.
 */
public class SampleData {
    public static List<ParentObject> getData()
    {
        List<ParentObject> parentObjects = new ArrayList<ParentObject>();
        for (int i = 0; i<20; i++)
        {
            parentObjects.add(new ParentObject("Mother " +i, "Father " +i, "Header " + i, "Footer " +i, getChildren(i)));

        }
        return parentObjects;
    }

    private static List<ChildObject> getChildren(int childCount)
    {
        List<ChildObject> childObjects = new ArrayList<ChildObject>();
        for (int i =0; i<childCount; i++)
        {
                childObjects.add(new ChildObject("Child " + i, 10 +i ));
        }
        return childObjects;
    }

}
