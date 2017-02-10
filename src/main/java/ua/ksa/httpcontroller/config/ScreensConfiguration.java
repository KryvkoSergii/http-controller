package ua.ksa.httpcontroller.config;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import ua.ksa.httpcontroller.JavaFXMain;
import ua.ksa.httpcontroller.core.controller.ApplicationController;
import ua.ksa.httpcontroller.core.controller.FXMLDialog;

import java.io.IOException;

/**
 * Created by srg on 2/7/17.
 */
@Configuration
@Lazy
@ComponentScan(basePackages = "ua.ksa.httpcontroller")
@PropertySource("classpath:application.properties")
public class ScreensConfiguration {
    private Stage primaryStage;
//    @Autowired
//    private ApplicationContext context;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showScreen(Parent screen) {
        primaryStage.setScene(new Scene(screen, 800, 500));
        primaryStage.show();
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog addControllerDialog() throws IOException {
        return new FXMLDialog(addApplicationController(), /*context.getResource("classpath:view.fxml").getURL()*/ JavaFXMain.class.getResource("core/controller/view.fxml"), primaryStage);
    }

    @Bean
    @Scope("prototype")
    public ApplicationController addApplicationController() {
        return new ApplicationController();
    }
}
