package com.classroom.controller;

import com.classroom.service.ClassroomService;
import com.classroom.util.Logger;
import java.util.Scanner;

public class CommandProcessor {
    private ClassroomService classroomService = new ClassroomService();

    public void processUserCommands(Scanner scanner) {
        while (true) {
            System.out.print("Enter your action: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the application. Goodbye!");
                break;
            }

            String[] parts = input.split("\\s+", 2);
            String action = parts[0];

            try {
                switch (action) {
                    case "create_room":
                        classroomService.createRoom(parts.length > 1 ? parts[1] : "");
                        break;
                    case "delete_room":
                        classroomService.deleteRoom(parts.length > 1 ? parts[1] : "");
                        break;
                    case "show_rooms":
                        classroomService.showRooms();
                        break;
                    case "register_student":
                        classroomService.registerStudent(parts.length > 1 ? parts[1] : "");
                        break;
                    case "show_students":
                        classroomService.showStudents(parts.length > 1 ? parts[1] : "");
                        break;
                    case "assign_task":
                        classroomService.assignTask(parts.length > 1 ? parts[1] : "");
                        break;
                    case "submit_task":
                        classroomService.submitTask(parts.length > 1 ? parts[1] : "");
                        break;
                    case "set_timetable":
                        classroomService.setTimetable(parts.length > 1 ? parts[1] : "");
                        break;
                    case "grade_task":
                        classroomService.gradeTask(parts.length > 1 ? parts[1] : "");
                        break;
                    case "notify":
                        classroomService.notify(parts.length > 1 ? parts[1] : "");
                        break;
                    default:
                        System.out.println("Unknown action: " + action);
                        break;
                }
            } catch (Exception e) {
                Logger.logError("Error occurred: " + e.getMessage());
            }
        }
    }
}
