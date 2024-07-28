package com.classroom;

import com.classroom.controller.CommandProcessor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandProcessor commandProcessor = new CommandProcessor();
        commandProcessor.processUserCommands(scanner);
    }
}