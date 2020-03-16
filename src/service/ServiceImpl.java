package service;

import models.Movie;
import repository.Repository;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceImpl implements Service{
    private final Repository repository;
    private String helpInfo = "history : вывести последние 7 команд (без их аргументов)\n" +
            "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    private boolean verbose = true;

    {
        Class<Service> cls = Service.class;
        helpInfo += Stream.of(cls.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Help.class))
                .map(method -> method.getAnnotation(Help.class).help())
                .collect(Collectors.joining("\n"));
    }

    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void help() {
        System.out.println(helpInfo);
    }

    @Override
    public void add(Movie movie) {
        repository.add(movie);
    }

    @Override
    public void info() {
        System.out.println(repository.getInfoAboutCollection());
    }

    @Override
    public void updateById(Movie movie, int id) {
        repository.updateById(movie, id);
    }

    @Override
    @Help(help = "remove_by_id id : удалить элемент из коллекции по его id")
    public void removeById(int id) {
        repository.removeById(id);
    }

    @Override
    public void clear() {
        repository.clear();
    }

    @Override
    public void save() {
        try {
            repository.save();
        } catch (IOException e) {
            System.out.println("Невозможно сохранить коллекцию");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addIfMin(Movie movie) {
        repository.addIfMin(movie);
    }

    @Override
    public void removeLower(Movie movie) {
        repository.removeLower(movie);
    }

    @Override
    public void maxByTotalBoxOffice() {
        System.out.println(repository.maxByTotalBoxOffice());
    }

    @Override
    public void countByTotalBoxOffice() {
        System.out.println(repository.countByTotalBoxOffice(123L));
    }

    @Override
    public void filterContainsName(String name) {
        System.out.println(repository.filterContainsName(name));
    }

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }
}
