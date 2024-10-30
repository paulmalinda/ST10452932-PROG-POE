/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public final class Task {
    private final String taskName;
    private final int taskNumber;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration;
    private final String taskID;
    private final String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    // Check if task description is within 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Generate a Task ID based on task name and developer details
    public String createTaskID() {
        String taskInitials = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String developerEnd = developerDetails.length() >= 3 ? developerDetails.substring(developerDetails.length() - 3).toUpperCase() : developerDetails.toUpperCase();
        return taskInitials + ":" + taskNumber + ":" + developerEnd;
    }

    // Format task details for display
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Task Duration: " + taskDuration + " hours";
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public String getTaskSummary() {
        return "<strong>" + taskName + "</strong><br>" +
               "Developer: " + developerDetails + "<br>" +
               "Duration: " + taskDuration + " hrs<br>" +
               "Task ID: " + taskID;
    }
}
