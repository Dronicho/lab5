package commands;

import service.Service;

import java.util.Scanner;

public class FilterContainsName extends MovieCommand{

    public FilterContainsName(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.filterContainsName(args[0]);
    }
}
