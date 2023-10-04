package model;


public interface SessionStorageStrategy {
    void saveSession();
    void loadSession();
}