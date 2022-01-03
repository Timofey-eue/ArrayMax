import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException { // исключение нужно для 21 строки, он это не спросит 99 %

        ArrayList<Integer> num = new ArrayList<Integer>(); // Создали ArrayList
        ArrayMax arrayMax = new ArrayMax(num); // Создали переменную, чтобы найти максильмальное число
        ArrayMax res; // Это для многопоточной версии

        long start, end;
        start = System.currentTimeMillis();
        num = arrayMax.findMax(num); // сам поиск максимального числа
        System.out.println("Answer: " + num); // вывод ответа
        end = System.currentTimeMillis() - start; // подсчет времени
        System.out.println("Work without thread: " + end + "ms"); // вывод с подсчитанным временем

        MyThread test = new MyThread(num, Runtime.getRuntime().availableProcessors()); // создали переменную для многопоточного поиска. num - наш ArrayList,
                                                                                       // Runtime.getRuntime().availableProcessors() - колличество потоков в соответсвии с характеристиками ПК
        test.startThread(); // запуск потоков
        start = System.currentTimeMillis();
        res = test.parallelFind(); // сам поиск многопоточный максимального числа в ArrayList
        System.out.println("Answer: " + num);
        end = System.currentTimeMillis() - start;
        System.out.println("Work with " + Runtime.getRuntime().availableProcessors() + " threads: " + end + "ms"); // тут ты все это уже знаешь

    }
}







