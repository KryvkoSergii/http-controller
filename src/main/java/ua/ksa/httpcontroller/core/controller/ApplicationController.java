package ua.ksa.httpcontroller.core.controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import ua.ksa.httpcontroller.core.util.Sender;
import ua.ksa.httpcontroller.core.util.SettingsUtil;


import javax.annotation.PostConstruct;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by srg on 2/6/17.
 */
public class ApplicationController implements DialogController {
    private static final Logger logger = Logger.getLogger(ApplicationController.class);
    @Autowired
    private Environment env;
    @Autowired
    private SettingsUtil settingsUtil;
    @Autowired
    private Sender sender;
    @FXML
    public Button action1;
    @FXML
    public Button action2;
    @FXML
    public Button action3;
    @FXML
    public Button action4;
    @FXML
    public Button action5;
    @FXML
    public Button action6;
    @FXML
    public Button action7;
    @FXML
    public Button action8;
    @FXML
    public Button action9;
    @FXML
    public Button action10;
    @FXML
    public Button action11;
    @FXML
    public Button action12;
    @FXML
    public Button action13;
    @FXML
    public Button action14;
    @FXML
    public Button action15;
    @FXML
    public Button action16;
    @FXML
    public TextField address;
    private FXMLDialog dialog;


    //Getters and setters
    @Override
    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }


    //Methods
    @PostConstruct
    private void init() {
        logger.info("INITIALIZED");
    }

    @FXML
    private void initialize() {
        ((Stage) dialog.getOwner()).setTitle("HTTP controller");
        double width = 135;
        Class aClass = getClass();
        Field classField;
        String fromEnv;
        List<Field> fields = Arrays.asList(aClass.getDeclaredFields()).stream().filter(e -> e.getName().contains("action")).collect(Collectors.<Field>toList());
        Collections.sort(fields, new CompareFields());
        for (int i = 1; i <= fields.size(); i++) {
            classField = fields.get(i - 1);
            fromEnv = env.getProperty(classField.getName() + ".name");
            try {
                Button button = (Button) classField.get(this);
                button.setText(fromEnv);
                button.setPrefWidth(width);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        address.setText(settingsUtil.getSettings().getHost());
        address.textProperty().addListener((observable, oldValue, newValue) -> settingsUtil.getSettings().setHost(newValue));
        logger.info("FXML INITIALIZED");
    }

    @FXML
    public void onClickAction1() {
        String action = "action1";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction2() {
        String action = "action2";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction3() {
        String action = "action3";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction4() {
        String action = "action4";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction5() {
        String action = "action5";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction6() {
        String action = "action6";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction7() {
        String action = "action7";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction8() {
        String action = "action8";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction9() {
        String action = "action9";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction10() {
        String action = "action10";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction11() {
        String action = "action11";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction12() {
        String action = "action12";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction13() {
        String action = "action13";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction14() {
        String action = "action14";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction15() {
        String action = "action15";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClickAction16() {
        String action = "action16";
        try {
            sender.makeRequest(action, null);
            logger.debug("Request=" + sender.buildURL(action) + " successful");
        } catch (Exception e) {
            showExpandExceptionDialog(action, e);
        }
    }

    @FXML
    public void onClose() {
        Platform.exit();
    }

    private class CompareFields implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Field b1 = (Field) o1;
            Field b2 = (Field) o2;
            return b1.getName().compareToIgnoreCase(b2.getName());
        }
    }

    private void showExceptionDialog(String action, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText(String.valueOf(e));
        alert.setContentText("Requesting URL=" +
                settingsUtil.getSettings().getHost() +
                env.getProperty(action.concat(".url")) +
                " thrown=" + e.toString());
        alert.showAndWait();
    }

    private void showExpandExceptionDialog(String action, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText(e.getMessage());
        alert.setContentText(e.toString());
        // Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        String s = "Thrown during requesting URL=" +
                settingsUtil.getSettings().getHost() +
                env.getProperty(action.concat(".url")) + '\n';
        pw.write(s);
        e.printStackTrace(pw);
        String exceptionText = sw.toString();
        logger.debug(s, e);

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
    }
}
