package model;

import jdk.internal.util.jar.JarIndex;

public class FileSessionStorageStrategy implements SessionStorageStrategy {
    @Override
    public void saveSession() {
        // Implement the logic to save the session to a file
        String data = "This is a sample text that we are writing to a file.";
        byte[] bytes = data.getBytes();

    }
        System.out.println("Session saved to a file.");
    }

    @Override
    public void loadSession() {
        // Implement the logic to load the session from a file
        System.out.println("Session loaded from a file.");
    }
}

