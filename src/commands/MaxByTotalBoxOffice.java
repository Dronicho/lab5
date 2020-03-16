package commands;

import service.Service;

import java.util.Scanner;

public class MaxByTotalBoxOffice extends MovieCommand {
    public MaxByTotalBoxOffice(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.maxByTotalBoxOffice();
    }
}
