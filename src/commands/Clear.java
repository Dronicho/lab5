package commands;

import service.Service;

import java.util.Scanner;

public class Clear extends MovieCommand{
    public Clear(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.clear();
    }
}
