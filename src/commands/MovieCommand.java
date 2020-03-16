package commands;

import repository.MovieReader;
import service.Service;

import java.util.Scanner;

abstract public class MovieCommand implements Command{
    protected Service service;
    protected Scanner scanner;
    protected MovieReader movieReader = new MovieReader();

    public MovieCommand(Service service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }
}
