package commands;

import service.Service;

import java.util.Scanner;

public class CountByTotalBoxOffice extends MovieCommand {
    public CountByTotalBoxOffice(Service service, Scanner scanner) {
        super(service, scanner);
    }

    @Override
    public void execute(String[] args) {
        service.countByTotalBoxOffice();
    }
}
