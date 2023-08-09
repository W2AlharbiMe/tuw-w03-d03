package com.example.week03d3homework.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Task {
    private String id;

    private String title;

    private String description;

    private boolean status;

    public String getStatusAsString() {
        return (status ? "Done" : "Not Done.");
    }

    @Override
    public String toString() {
        String output = "";
        output += "ID: " + id + " - ";
        output += "Title: " + title + " - ";
        output += "Description: " + description + " - ";
        output += "Status: " + getStatusAsString() + " - ";

        return output;
    }
}

