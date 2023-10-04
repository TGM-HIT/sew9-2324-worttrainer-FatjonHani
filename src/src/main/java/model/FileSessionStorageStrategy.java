package model;

public class FileSessionStorageStrategy implements SessionStorageStrategy {
    @Override
    public void saveSession() {
        // Implement the logic to save the session to a file
        System.out.println("Session saved to a file.");
    }

    @Override
    public void loadSession() {
        // Implement the logic to load the session from a file
        System.out.println("Session loaded from a file.");
    }
}

