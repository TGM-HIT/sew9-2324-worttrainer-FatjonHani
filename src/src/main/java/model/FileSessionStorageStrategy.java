import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class FileSessionStorageStrategy implements SessionStorageStrategy {

    private String sessionFileName;

    public FileSessionStorageStrategy(String sessionFileName) {
        this.sessionFileName = sessionFileName;
    }

    @Override
    public void saveSession() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(sessionFileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(SessionData.getSessionData());
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Session saved to a file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadSession() {
        try {
            FileInputStream fileInputStream = new FileInputStream(sessionFileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SessionData.setSessionData((Map<String, Object>) objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("Session loaded from a file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}