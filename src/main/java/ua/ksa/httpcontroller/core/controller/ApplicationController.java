package ua.ksa.httpcontroller.core.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import ua.ksa.httpcontroller.core.util.Sender;

import javax.annotation.PostConstruct;

/**
 * Created by srg on 2/6/17.
 */
public class ApplicationController implements DialogController {
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
        System.out.println("ApplicationController initialize()");
    }

    @FXML
    public void onClickAction1() {

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
}
