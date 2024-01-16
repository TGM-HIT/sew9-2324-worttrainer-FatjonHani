package model;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface SessionStorageStrategy {
    void save(Rechtschreibtrainer rechtschreibtrainer, String filePath);
    Rechtschreibtrainer load(String filePath);
}