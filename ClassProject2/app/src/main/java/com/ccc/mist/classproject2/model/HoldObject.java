package com.ccc.mist.classproject2.model;

import android.app.ProgressDialog;

/**
 * Created by Salahuddin on 1/24/2017.
 */

public class HoldObject {
    private  String reg;
    private  String roll;
    private  String year;
    private  String semester;
    private  String gender;
    private  String name;
    private  String small_image;
    private  Details detail = new Details();


    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmall_image() {
        return small_image;
    }

    public void setSmall_image(String small_image) {
        this.small_image = small_image;
    }

    public Details getDetail() {
        return detail;
    }

    public void setDetail(Details detail) {
        this.detail = detail;
    }
}
