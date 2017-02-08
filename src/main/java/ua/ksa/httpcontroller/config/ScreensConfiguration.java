package ua.ksa.httpcontroller.config;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.*;
import ua.ksa.httpcontroller.core.controller.ApplicationController;
import ua.ksa.httpcontroller.core.controller.FXMLDialog;

/**
 * Created by srg on 2/7/17.
 */
@Configuration
@Lazy
@ComponentScan(basePackages = "ua.ksa.httpcontroller")
@PropertySource("classpath:application.properties")
public class ScreensConfiguration {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showScreen(Parent screen) {
        primaryStage.setScene(new Scene(screen, 800, 500));
        primaryStage.show();
    }

    @Bean
    @Scope("prototype")
    public FXMLDialog addControllerDialog() {
        return new FXMLDialog(addApplicationController(), getClass().getResource("view.fxml"), primaryStage);
    }

    @Bean
    @Scope("prototype")
    public ApplicationController addApplicationController() {
        return new ApplicationController();
    }
}
