package model;


import java.io.*;

public class FileSessionStorageStrategy extends StorageStrategy {
    private final String filePath;

    public FileSessionStorageStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(Session session) throws FileNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(session);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Session load() throws ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Session) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}