package com.classroom.service;

import com.classroom.model.Classroom;
import com.classroom.util.DateUtil;
import com.classroom.util.Logger;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassroomService {
    private static Map<String, Classroom> classroomMap = new HashMap<>();

    public void createRoom(String roomName) {
        if (classroomMap.containsKey(roomName)) {
            Logger.logInfo("Room " + roomName + " already exists.");
        } else {
            classroomMap.put(roomName, new Classroom(roomName));
            Logger.logInfo("Room " + roomName + " has been created successfully.");
        }
    }

    public void deleteRoom(String roomName) {
        if (classroomMap.remove(roomName) != null) {
            Logger.logInfo("Room " + roomName + " has been deleted.");
        } else {
            Logger.logInfo("Room " + roomName + " does not exist.");
        }
    }

    public void showRooms() {
        if (classroomMap.isEmpty()) {
            Logger.logInfo("No rooms available.");
        } else {
            Logger.logInfo("Available rooms:");
            for (String roomName : classroomMap.keySet()) {
                Logger.logInfo(" - " + roomName);
            }
        }
    }

    public void registerStudent(String input) {
        String[] parts = input.split("\\s+");
        if (parts.length != 2) {
            Logger.logInfo("Usage: register_student <student_id> <room_name>");
            return;
        }
        String studentId = parts[0];
        String roomName = parts[1];

        Classroom room = classroomMap.get(roomName);
        if (room != null) {
            room.addStudent(studentId);
        } else {
            Logger.logInfo("Room " + roomName + " not found.");
        }
    }

    public void showStudents(String roomName) {
        Classroom room = classroomMap.get(roomName);
        if (room != null) {
            List<String> students = room.getStudents();
            if (students.isEmpty()) {
                Logger.logInfo("No students in " + roomName + ".");
            } else {
                Logger.logInfo("Students in " + roomName + ":");
                for (String studentId : students) {
                    Logger.logInfo(" - " + studentId);
                }
            }
        } else {
            Logger.logInfo("Room " + roomName + " not found.");
        }
    }

    public void assignTask(String input) {
        String[] parts = input.split("\\s+", 3);
        if (parts.length != 3) {
            Logger.logInfo("Usage: assign_task <room_name> <task_details> <deadline>");
            return;
        }
        String roomName = parts[0];
        String taskDetails = parts[1];
        LocalDate deadline;
        try {
            deadline = LocalDate.parse(parts[2], DateUtil.getDateFormatter());
        } catch (Exception e) {
            Logger.logInfo("Invalid date format. Use yyyy-MM-dd.");
            return;
        }

        Classroom room = classroomMap.get(roomName);
        if (room != null) {
            room.addAssignment(taskDetails, deadline);
        } else {
            Logger.logInfo("Room " + roomName + " not found.");
        }
    }

    public void submitTask(String input) {
        String[] parts = input.split("\\s+", 3);
        if (parts.length != 3) {
            Logger.logInfo("Usage: submit_task <student_id> <room_name> <task_details>");
            return;
        }
        String studentId = parts[0];
        String roomName = parts[1];
        String taskDetails = parts[2];

        Classroom room = classroomMap.get(roomName);
        if (room != null) {
            room.submitAssignment(studentId, taskDetails);
        } else {
            Logger.logInfo("Room " + roomName + " not found.");
        }
    }

    public void setTimetable(String input) {
        String[] parts = input.split("\\s+", 2);
        if (parts.length != 2) {
            Logger.logInfo("Usage: set_timetable <room_name> <schedule_details>");
            return;
        }
        String roomName = parts[0];
        String scheduleDetails = parts[1];

        Classroom room = classroomMap.get(roomName);
        if (room != null) {
            room.setTimetable(scheduleDetails);
        } else {
            Logger.logInfo("Room " + roomName + " not found.");
        }
    }

    public void gradeTask(String input) {
        String[] parts = input.split("\\s+", 4);
        if (parts.length != 4) {
            Logger.logInfo("Usage: grade_task <student_id> <room_name> <task_details> <grade>");
            return;
        }
        String studentId = parts[0];
        String roomName = parts[1];
        String taskDetails = parts[2];
        String grade = parts[3];

        Classroom room = classroomMap.get(roomName);
        if (room != null) {
            room.gradeAssignment(studentId, taskDetails, grade);
        } else {
            Logger.logInfo("Room " + roomName + " not found.");
        }
    }

    public void notify(String input) {
        String[] parts = input.split("\\s+", 2);
        if (parts.length != 2) {
            Logger.logInfo("Usage: notify <room_name> <message>");
            return;
        }
        String roomName = parts[0];
        String message = parts[1];

        Classroom room = classroomMap.get(roomName);
        if (room != null) {
            room.notify(message);
        } else {
            Logger.logInfo("Room " + roomName + " not found.");
        }
    }
}
