package model;
public class Session {
    private SessionStorageStrategy sessionStorageStrategy;


    public Session(SessionStorageStrategy sessionStorageStrategy) {
        this.sessionStorageStrategy = sessionStorageStrategy;
    }

    public void save() {
        sessionStorageStrategy.saveSession();
    }

    public void load() {
        sessionStorageStrategy.loadSession();
    }

    public void setSessionStorageStrategy(SessionStorageStrategy sessionStorageStrategy) {
        this.sessionStorageStrategy = sessionStorageStrategy;
    }
}






