package commands;

import config.Config;
import exceptions.StopReadingException;
import repository.MovieReader;
import service.Service;

import java.util.Scanner;

public class AddIfMin extends MovieCommand{
    public AddIfMin(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        try {
            service.addIfMin(movieReader.read(scanner, Config.isVerbose));
        } catch (StopReadingException e) {
            System.out.println(e.getMessage());
        }
    }
}
