package commands;

import service.Service;

import java.util.Scanner;

public class Info extends MovieCommand {
    public Info(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.info();
    }
}
