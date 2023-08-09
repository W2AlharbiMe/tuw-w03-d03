package com.example.week03d3homework.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private int status;
}
