package commands;

import config.Config;
import exceptions.StopReadingException;
import service.Service;

import java.util.Arrays;
import java.util.Scanner;

public class Update extends MovieCommand{
    public Update(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        try {
            service.updateById(movieReader.read(scanner, Config.isVerbose), Integer.parseInt(args[0]));
        } catch (StopReadingException e) {
            System.out.println(e.getMessage());
        }
    }
}
