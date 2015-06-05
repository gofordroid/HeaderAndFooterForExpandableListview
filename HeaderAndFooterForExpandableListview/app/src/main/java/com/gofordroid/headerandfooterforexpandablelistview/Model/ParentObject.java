package com.gofordroid.headerandfooterforexpandablelistview.Model;

import java.util.List;

/**
 * Created by TrangHo on 10-05-2015.
 */
public class ParentObject {
    public String mother;
    public String father;
    public String textToHeader;
    public String textToFooter;
    public List<ChildObject> childObjects;

    public ParentObject(String mother, String father, String textToHeader, String textToFooter, List<ChildObject> childObjects)
    {
        this.mother = mother;
        this.father = father;
        this.textToFooter = textToFooter;
        this.textToHeader = textToHeader;
        this.childObjects = childObjects;
    }
}
