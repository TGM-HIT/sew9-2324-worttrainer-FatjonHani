package model;


import java.io.FileNotFoundException;
import java.io.IOException;

public interface SessionStorageStrategy {

    void loadSession();
    void saveSession();
}