package ua.ksa.httpcontroller.core.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import ua.ksa.httpcontroller.core.util.Sender;


import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by srg on 2/6/17.
 */
public class ApplicationController implements DialogController {
    @Autowired
    private Environment env;
    @Autowired
    private Sender sender;
    private FXMLDialog dialog;
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


    //Methods
    @PostConstruct
    private void init() {
        System.out.println("ApplicationController init()");

    }

    @FXML
    private void initialize() {
        double width = 120;
        System.out.println("ApplicationController initialize()");
        Class aClass = getClass();
        Field classField;
        String buttonFieldName, fromEnv;
        List<Field> fields = Arrays.asList(aClass.getDeclaredFields()).stream().filter(e -> e.getName().contains("action")).collect(Collectors.<Field>toList());
        Collections.sort(fields, new CompareFields());
        for (int i = 1; i <= fields.size(); i++) {
            classField = fields.get(i - 1);
            buttonFieldName = "action" + i;
            fromEnv = env.getProperty(buttonFieldName + ".name");
            if (classField.getName().equals(buttonFieldName) && fromEnv != null) {
                try {
                    Button button = (Button) classField.get(this);
                    button.setText(fromEnv);
                    button.setPrefWidth(width);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void onClickAction1() {
        Dialogs.showErrorDialog(dialog,"error");
        try {
            sender.makeRequest("action1", null);
        } catch (Exception e) {

        }
    }

    @FXML
    public void onClickAction2() {
    }

    @FXML
    public void onClickAction3() {
    }

    @FXML
    public void onClickAction4() {
    }

    @FXML
    public void onClickAction5() {
    }

    @FXML
    public void onClickAction6() {
    }

    @FXML
    public void onClickAction7() {
    }

    @FXML
    public void onClickAction8() {
    }

    @Override
    public void setDialog(FXMLDialog dialog) {
        this.dialog = dialog;
    }

    private class CompareFields implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Field b1 = (Field) o1;
            Field b2 = (Field) o2;
            return b1.getName().compareToIgnoreCase(b2.getName());
        }
    }
}
