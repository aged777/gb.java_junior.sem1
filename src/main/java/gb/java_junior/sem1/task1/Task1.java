package gb.java_junior.sem1.task1;

import java.util.ArrayList;
import java.util.List;

/*
    Задача №1: Реализовать систему учёта книг в библиотеке. У каждой книги есть название,
    автор и год издания. Необходимо создать список книг и выполнить следующие действия:

    1. Обычный способ:
        - Найти все книги, написанные определённым автором (например, "Лев Толстой").
        - Найти все книги, изданные после определённого года, (например, 1967).
        - Найти все уникальные названия книг в библиотеке.

    2. Использование лямбда-выражений:
        - Те же самые задачи, но с использованием лямбда-выражений и Stream API для более
          компактного и выразительного кода.
 */
public class Task1 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        books.add(new Book("Анна Каренина", "Лев Толстой", 1877));

        // Поиск книг, написанных автором "Лев Толстой"
        List<Book> authorBooks = new ArrayList<>();

        for (Book book : books) {
            if ("Лев Толстой".equals(book.getAuthor())) {
                authorBooks.add(book);
            }
        }
        System.out.println("Книги Льва Толстого:\n" + authorBooks);

        // Поиск книг, написанных после 1866 года
        List<Book> booksAfter1866 = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > 1866) {
                booksAfter1866.add(book);
            }
        }
        System.out.println("Книги, изданные после 1866 года:\n" + booksAfter1866);

        // Поиск уникальных названий книг
        List<String> uniqueTitles = new ArrayList<>();
        for (Book book : books) {
            if (!uniqueTitles.contains(book.getTitle())) {
                uniqueTitles.add(book.getTitle());
            }
        }
        System.out.println("Уникальные названия книг:\n" + uniqueTitles);
    }
}
