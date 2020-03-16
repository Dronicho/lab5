package commands;

import config.Config;
import exceptions.StopReadingException;
import service.Service;

import java.util.Scanner;

public class RemoveLower extends MovieCommand {
    public RemoveLower(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        try {
            service.removeLower(movieReader.read(scanner, Config.isVerbose));
        } catch (StopReadingException e) {
            System.out.println(e.getMessage());
        }
    }
}
