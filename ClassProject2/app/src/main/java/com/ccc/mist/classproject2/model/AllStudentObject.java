package com.ccc.mist.classproject2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salahuddin on 1/24/2017.
 */

public class AllStudentObject {
    private List<HoldObject> students = new ArrayList<HoldObject>();

    public List<HoldObject> getStudents() {
        return students;
    }

    public void setStudents(List<HoldObject> students) {
        this.students = students;
    }
}
