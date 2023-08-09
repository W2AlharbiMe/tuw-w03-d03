package com.example.week03d3homework.Controller;

import com.example.week03d3homework.ApiResponse.ApiResponse;
import com.example.week03d3homework.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tasks")
public class TasksController {

    private ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @GetMapping("/search/{title}")
    public ApiResponse findByTaskTitle(@PathVariable String title) {
        for (Task t: tasks) {
            if(t.getTitle().contains(title)) {
                return (new ApiResponse("Found:  -  " + t.toString(), 200));
            }
        }

        return (new ApiResponse("Not Found", 404));
    }

    @PostMapping("/save")
    public ApiResponse postTask(@RequestBody Task task) {
        task.setId(String.valueOf(tasks.size() + 1));

        tasks.add(task);

        return (new ApiResponse("the task: "+ task.getTitle() +" have been added.", 201));
    }


    @PutMapping("/{id}/update")
    public ApiResponse updateTask(@PathVariable int id, @RequestBody Task task) {
        try {
            Task saved_task = tasks.get(id - 1);

            saved_task.setTitle(task.getTitle());
            saved_task.setDescription(task.getDescription());
            saved_task.setStatus(task.isStatus());

            return (new ApiResponse("the task of ID: "+ id +" have been updated.", 200));
        } catch(IndexOutOfBoundsException e1) {
            return (new ApiResponse("no task with that id.", 404));
        }
    }

    @PutMapping("/{id}/toggle")
    public ApiResponse markTaskAsDone(@PathVariable int id) {
        try {
            Task task = tasks.get(id - 1);

            task.setStatus(!task.isStatus());

            return (new ApiResponse("Task: " + task.getTitle() + " have been marked as " + task.getStatusAsString(), 200));
        } catch(IndexOutOfBoundsException e2) {
            return (new ApiResponse("no task with that id.", 404));
        }
    }


    @DeleteMapping("/{id}/delete")
    public ApiResponse deleteTask(@PathVariable int id) {
        try {
            tasks.remove(id - 1);

            // I need to update all indexes
            int counter = 1;
            for (Task t: tasks) {
                t.setId(String.valueOf(counter));
                counter += 1;
            }


            return (new ApiResponse("the task with ID: "+ id +" have been updated.", 200));
        } catch(IndexOutOfBoundsException e1) {
            return (new ApiResponse("no task with that id.", 404));
        }
    }
}
