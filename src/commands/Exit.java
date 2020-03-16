package commands;

import service.Service;

import java.util.Scanner;

public class Exit extends MovieCommand {
    public Exit(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Завершение работы");
        System.exit(0);
    }
}
