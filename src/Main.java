import config.Config;
import controllers.Controller;
import controllers.ControllerImpl;
import models.*;
import persistance.CsvEncoder;
import persistance.MovieDecoder;
import repository.Repository;
import repository.RepositoryImpl;
import service.Service;
import service.ServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Config.isVerbose = true;
        Repository repository = new RepositoryImpl(new File("test.csv"));
        Service service = new ServiceImpl(repository);
        Controller controller = new ControllerImpl(service);
        controller.startListening();
    }
}
