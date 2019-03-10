package com.microsoft.cognitiveservices.speech.samples.quickstart;

public class DoctorContext {
    public String doctorType;
    public String symptom;

    // Date
    public int year;
    public int month;
    public int day;

    // Time
    public int hourOfDay;
    public int minute;

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setTime (int hourOfDay, int minute) {
        this.hourOfDay = hourOfDay;
        this.minute = minute;
    }

}
