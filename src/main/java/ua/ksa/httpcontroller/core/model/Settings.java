package ua.ksa.httpcontroller.core.model;

/**
 * Created by srg on 2/11/17.
 */
public class Settings {
    private String host;


    //Constructors
    public Settings() {
    }

    public Settings(String host) {
        this.host = host;
    }


    //Getters and setters
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }


    //Methods
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Settings{");
        sb.append("host='").append(host).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
