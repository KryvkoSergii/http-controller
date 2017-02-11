package ua.ksa.httpcontroller.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import ua.ksa.httpcontroller.core.model.Settings;

import javax.annotation.PostConstruct;

/**
 * Created by srg on 2/11/17.
 */
@Component
@Description("Settings holder")
public class SettingsUtil {
    @Autowired
    private Environment env;
    private Settings settings = new Settings();


    //Getters and setters
    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }


    //Methods
    @PostConstruct
    private void init() {
        settings.setHost(env.getProperty("urls.prefix.default"));
    }
}
