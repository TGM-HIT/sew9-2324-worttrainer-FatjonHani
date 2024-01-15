package model;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class StorageStrategy {
        public abstract void save(Session session) throws IOException, FileNotFoundException;
        public abstract Session load() throws IOException, ClassNotFoundException;
}

