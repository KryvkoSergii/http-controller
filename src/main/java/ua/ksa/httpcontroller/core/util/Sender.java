package ua.ksa.httpcontroller.core.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by srg on 2/7/17.
 */
@Component
@Description("Sending request")
public class Sender {
    @Autowired
    private Environment env;
    @Autowired
    private SettingsUtil settingsUtil;
    private static final Logger logger = Logger.getLogger(Sender.class);

    @PostConstruct
    private void init() {
        logger.info("INITIALIZED");
    }

    public void makeRequest(String action, String body) throws Exception {
        URL url = new URL(buildURL(action));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(getMethod(action));
        connection.setDoOutput(body != null ? true : false);
        connection.setDoInput(true);
        connection.connect();
        if (body != null) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), Charset.forName("UTF-8")));
            bw.write(body);
            bw.flush();
            bw.close();
        }
        logger.debug("Request=" + url.toURI() + " returned code=" + connection.getResponseCode());
        connection.disconnect();
    }

    public String buildURL(String action) {
        return settingsUtil.getSettings().getHost() + env.getProperty(action.concat(".url"));
    }

    private String getMethod(String method) {
        return env.getProperty(method.concat(".method"));
    }
}
