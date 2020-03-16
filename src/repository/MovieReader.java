package repository;

import exceptions.StopReadingException;
import models.*;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;


/**
 * класс для считывания Movie из потока
 */
public class MovieReader {
    private Scanner scanner;
    private boolean verbose;

    public MovieReader() {
    }

    /**
     * метод для считывания поля, с возможностью повторного ввода, если пользователь ошибся
     * @param fieldName подсказка для пользователя
     * @param callback метод, которым считываем поле(scanner::<methodName>)
     * @return возвращает объект, поэтому надо кастить в нужный тип
     * @throws StopReadingException выбрасывается, если пользователь ввел break, остановка считывания
     */
    private Object readField(String fieldName, Function<Scanner, Object> callback) throws StopReadingException {
        if (verbose) {
            System.out.println("Введите " + fieldName);
        }
        Object res;
        while (true) {
            try {
                res = callback.apply(scanner);
                if (res.equals("break")) {
                    throw new StopReadingException("Отмена");
                }
                break;
            } catch (IllegalArgumentException e) {
                scanner.nextLine();
                if (verbose) {
                    System.out.println(e.getMessage());
                    System.out.println("Попробуйте еще раз");
                }
            } catch (NoSuchElementException e) {
                throw new StopReadingException("неверный ввод");
            }
        }
        return res;
    }

    /**
     *
     * @param scanner Сканнер с которого считывать
     * @param verbose елси true выводит подсказки для пользователя
     * @return Movie считанные из потока
     * @throws StopReadingException
     */
    public Movie read(Scanner scanner, Boolean verbose) throws StopReadingException {
        this.scanner = scanner;
        this.verbose = verbose;
        return new Movie(
                readName("название фильма", false),
                readCoordinates(),
                readOscars(),
                readTotalBoxOffice(),
                readUsaBoxOffice(),
                readGenre(),
                readPerson()
        );
    }

    /**
     * метод для считывания строки
     * @param fieldName подсказка для пользователя
     * @param leftOver нужно ли переместить курсор на новую строку
     *                 допустим в строке int и мы вызываем scanner.readInt()
     *                 before readInt: _intValue
     *                 after readInt: intValue_ - курсор не переместился на новую строку, поэтому дальнейший вызов
     *                 scanner.nextLine() вернет пустую строку, поэтому нужно вызвать nextLine() еще раз.
     * @return
     * @throws StopReadingException
     */
    public String readName(String fieldName, Boolean leftOver) throws StopReadingException {
        if (leftOver) scanner.nextLine();
        return (String) this.readField(fieldName, Scanner::nextLine);
    }
    // Далее методы для считываения конкретного поля
    public Coordinates readCoordinates() throws StopReadingException {
        Coordinates coordinates = new Coordinates(
                (float) readField("Х координата", Scanner::nextFloat),
                (Long) readField("Y координата", Scanner::nextLong)
        );
        return coordinates;
    }

    public Long readOscars() throws StopReadingException {
        return (Long) readField("количество оскаров", Scanner::nextLong);
    }

    public int readTotalBoxOffice() throws StopReadingException {
        return (int) readField("сборы в мире", Scanner::nextInt);
    }

    public int readUsaBoxOffice() throws StopReadingException {
        return (int) readField("сборы в США", Scanner::nextInt);
    }

    public MovieGenre readGenre() throws StopReadingException {
        String fieldName = String.format("жанр: %s", Arrays.toString(MovieGenre.values()));
        scanner.nextLine();
        return (MovieGenre) readField(fieldName, (scanner) -> MovieGenre.valueOf(scanner.nextLine()));
    }

    public Person readPerson() throws StopReadingException {
        String fieldName = String.format("цвет: %s", Arrays.toString(Color.values()));
        return new Person(
                readName("имя оператора", false),
                (LocalDateTime) readField("дата рождения", (scanner) -> LocalDateTime.parse(scanner.nextLine())),
                (Color) readField(fieldName, (scanner) -> Color.valueOf(scanner.nextLine())),
                new Location(
                        (Integer) readField("X страны", Scanner::nextInt),
                        (int) readField("Y страны", Scanner::nextInt),
                        readName("название страны", true)
                )
        );
    }

    public void setScanner(Scanner fileScanner) {
        scanner = fileScanner;
    }
}
