package commands;

import service.Service;

import java.util.Scanner;

public class Save extends MovieCommand{
    public Save(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.save();
    }
}
