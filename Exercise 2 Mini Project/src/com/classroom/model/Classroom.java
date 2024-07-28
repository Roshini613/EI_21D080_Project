package com.classroom.model;

import com.classroom.util.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classroom {
    private String name;
    private List<String> students;
    private Map<String, Assignment> assignments;
    private String timetable;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new HashMap<>();
        this.timetable = "";
    }

    public void addStudent(String studentId) {
        if (!students.contains(studentId)) {
            students.add(studentId);
            Logger.logInfo("Student " + studentId + " has been added to " + name + ".");
        } else {
            Logger.logInfo("Student " + studentId + " is already in " + name + ".");
        }
    }

    public List<String> getStudents() {
        return students;
    }

    public void addAssignment(String assignmentDetails, LocalDate deadline) {
        assignments.put(assignmentDetails, new Assignment(assignmentDetails, deadline));
        Logger.logInfo("Assignment assigned to " + name + " with deadline " + deadline + ".");
    }

    public void submitAssignment(String studentId, String assignmentDetails) {
        if (students.contains(studentId)) {
            Assignment assignment = assignments.get(assignmentDetails);
            if (assignment != null) {
                if (LocalDate.now().isBefore(assignment.getDeadline())) {
                    Logger.logInfo("Assignment submitted by Student " + studentId + " in " + name + ".");
                } else {
                    Logger.logInfo("Assignment submitted by Student " + studentId + " in " + name + " (Late).");
                }
            } else {
                Logger.logInfo("Assignment " + assignmentDetails + " not found.");
            }
        } else {
            Logger.logInfo("Student " + studentId + " is not enrolled in " + name + ".");
        }
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
        Logger.logInfo("Timetable set for " + name + ": " + timetable);
    }

    public void gradeAssignment(String studentId, String taskDetails, String grade) {
        if (students.contains(studentId)) {
            // Example implementation. This could be more complex depending on requirements.
            Logger.logInfo("Graded assignment \"" + taskDetails + "\" for student " + studentId + " with grade " + grade + " in " + name + ".");
        } else {
            Logger.logInfo("Student " + studentId + " is not enrolled in " + name + ".");
        }
    }

    public void notify(String message) {
        Logger.logInfo("Notification for " + name + ": " + message);
    }
}
