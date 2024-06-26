package gb.java_junior.sem1.task1;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Task1_StreamAPI {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        books.add(new Book("Анна Каренина", "Лев Толстой", 1877));

        /**
         * Stream API - это средство обработки данных в коллекции, работа со Stream API всегда
         * начинается с источника, например, массив(Arrays.stream()), коллекция (List, Map) или поток (Stream.empty()
         * и далее можем поток каким-либо образом конфигурировать). Все методы объекта Stream делятся на
         * промежуточные (intermediate) и терминальные (конечные). Промежуточные операции работают по принципу
         * Fluent Interface - одна операция вызывается из другой и каким-то образом модифицирует источник
         * (отфильтровывает или удаляет какие-либо элементы или добавляет и т.д.)
         * метод map() - преобразование элемента в другой заданного типа,
         * distinct() - удаляет дубликаты, filter() - отфильтровывает,
         * sorted() - сортирует, skip() - пропустить n-ое количество элементов источника,
         * pick() - выполняет действие для каждого элемента источника
         *
         */
        // Поиск книг, написанных автором "Лев Толстой"
        /**
         * filter() в него в качестве аргумента передаётся интерфейс Predicate, с этим интерейсом в рамках этого
         * метода можно работать как с некоторым лямбда-выражением. По сути лямбда-выражение - это функция, которая
         * принимает аргумент и возвращает значение. В данном случае предикат представляет из себя функцию, которая
         * принимает аргумент и возвращает значение. Функция, основанная на интерфейсе Predicate принимает на вход
         * элемент коллекции. Предикат - это строгая функция, она всегда возвращает либо true либо false, именно
         * поэтому предикаты всегда используют в рамках какой-либо фильтрации. Наш источник - коллекция с элементами
         * типа Book, поэтому условную переменную лямбда-выражения можно назвать book, тип Book будет понятен
         * компиллятору из контекста потом после стрелки -> нужно описать инструкцию, которая вернёт какое-то значение
         * либо да либо нет. При этом необходимо понимать, что filter() вернёт всё тот же поток, вообще в Stream API
         * каждый метод вернёт ссылку на текущий объект потока.
         *  Чтобы опять вернуться к источнику (коллекции) нужно воспользоваться терминальными операциями - в которых
         *  осуществляется переход от объекта типа поток к каким-то конкретным типам, например toList(), to Array(),
         *  или метод findAny(), который вернёт true или false и скажет, есть ли в источнике хотя бы один элемент.
         *  или метод findFirst(), который вернёт первый элемент, или toSet() to Map(), min() , max() , count() -
         *  вернёт количество элементов после фильтрации
         */
        // Поиск книг, написанных автором "Лев Толстой"
        List<Book> authorBooks = new ArrayList<>(books);

        authorBooks = authorBooks.stream()
                .filter(book -> "Лев Толстой".equals(book.getAuthor()))
                .toList();

        System.out.println("Книги Льва Толстого:\n" + authorBooks);

        // Поиск книг, написанных после 1866 года
        List<Book> booksAfter1866 = new ArrayList<>(books);

        booksAfter1866 = books.stream()
                .filter(book -> book.getYear() > 1866)
                .toList();

        System.out.println("Книги, изданные после 1866 года:\n" + booksAfter1866);

        // Поиск уникальных названий книг
        List<String> uniqueTitles = new ArrayList<>();

        /**
         * Для начала необходимо перейти к колекции другого типа, ведь для решения задачи поиска уникальных
         * названий книг нам не нужна коллекция книг, нужна коллекция наименований книг, а наименования - это
         * строки, и в рамках промежуточных операций в контексте Stream API существует уникальный метод map().
         * Ситуация следующая: мы хотим преобразовать каждый объект типа Book в строку. Здесь в метод map()
         * мы передаём уже не предикат, а функцию. В чём отличие: на вход также передаётся некий объект, у нас
         * этим объектом также как и в предикате является книга, на выходе получим объект какого-то типа, в
         * зависимости от того, что возвращает наше выражение
         *
         */

        uniqueTitles = books.stream()
                        .map(book -> book.getTitle())
                        .distinct()
                        .toList();
        System.out.println("Уникальные названия книг:\n" + uniqueTitles);
         // остановились на 48:22 видео java-junior-семинар_1
    }
}
