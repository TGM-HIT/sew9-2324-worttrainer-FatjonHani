package model;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Persistance interface that enables interchangable persistence strategys for scalability
 */
public interface SessionStorageStrategy {
    void save(Rechtschreibtrainer rechtschreibtrainer, String filePath);
    Rechtschreibtrainer load(String filePath);
}