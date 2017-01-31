import Beans.Book;
import Beans.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test_1 {

    private static List<Book> list  = new ArrayList<Book>();

    static {
        /*for(int i = 1; i<=10; i++){
            list.add(new Book("title_" + i, "author_"+i));
        }*/
        IntStream
            .range(1, 11)
            .forEach(i -> list.add(new Book("title_" + i, "author_"+i)));
    }

    public static void main(String[] args) {
        // есть конвеерные(обычно вернут стрим после преобразований; map,filter) и терминальные функции (вернут объект (коллкцию) и закроют стрим; collect,forEach), без вызова терминальной конвеерная не начнет работать
        //
        list.stream().forEach(System.out::println);
        list.stream().forEach((e) -> System.out.println("fe -> " + e.getTitle()));
        //для map если там что то сложнее чем .map(p -> p.name) или есть несколько строк то нужен return
        //в этой строке если убрать в конце терминальный  collect то ни один map не начнет  выполняться
        list.stream().map( e -> {System.out.println("map  " + e.getTitle()); e.setTitle(e.getTitle() + ",") ;return e;}).map( e -> {System.out.println("map  " + e.getTitle()); return e;}).collect(Collectors.toList());;




        List<Person> persons =
            Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));

        String phrase = persons
            .stream()
            .filter(p -> p.getAge() >= 18)
            .map(p -> p.getName())
            .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

       List phrase1 = persons
                    .stream()
                    .filter(p -> p.getAge() >= 18)
                    .map(p -> p.getName())
                    .collect(Collectors.toList());

        System.out.println(phrase);


        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());
    }
}
