package com.recyclerview.firebase;

public class Model {
    String name, syllabus, notes, questions, key;

    Model() {

    }


    public Model(String name, String syllabus, String notes, String questions, String key) {
        this.name = name;
        this.syllabus = syllabus;
        this.notes = notes;
        this.questions = questions;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}
