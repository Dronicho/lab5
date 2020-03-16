package commands;

import service.Service;

import java.util.Scanner;

public class RemoveById extends MovieCommand {
    public RemoveById(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.removeById(Integer.parseInt(args[0]));
    }
}
