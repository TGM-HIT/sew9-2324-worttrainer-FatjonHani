package model;

public class DatabaseSessionStorageStrategy implements SessionStorageStrategy {
    @Override
    public void saveSession() {
        // Implement the logic to save the session to a database
        System.out.println("Session saved to a database.");
    }

    @Override
    public void loadSession() {
        // Implement the logic to load the session from a database
        System.out.println("Session loaded from a database.");
    }
}
