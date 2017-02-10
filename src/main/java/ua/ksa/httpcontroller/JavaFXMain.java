package ua.ksa.httpcontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ksa.httpcontroller.config.ScreensConfiguration;

/**
 * Created by srg on 2/6/17.
 */
public class JavaFXMain extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ScreensConfiguration.class);
        ScreensConfiguration screens = context.getBean(ScreensConfiguration.class);
        screens.setPrimaryStage(primaryStage);
        screens.addControllerDialog().show();

//        Platform.setImplicitExit(true);
//
//        ApplicationContext context = new AnnotationConfigApplicationContext(ScreensConfiguration.class);
//        ScreensConfiguration screens = context.getBean(ScreensConfiguration.class);
//
//        this.primaryStage = primaryStage;
//        this.primaryStage.setTitle("HTTP controller");
//        initView();
    }

//    public void initView() throws IOException {
//        // Загружаем корневой макет из fxml файла.
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(JavaFXMain.class.getResource("view.fxml"));
//        borderPane = (BorderPane) loader.load();
//
//        // Отображаем сцену, содержащую корневой макет.
//        Scene scene = new Scene(borderPane);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
}
