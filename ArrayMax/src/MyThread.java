import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MyThread implements Runnable{
    private int threadsNum = Runtime.getRuntime().availableProcessors(); // сколько ядер, столько потоков будет задействовано Runtime.getRuntime().availableProcessors()
    private Integer[] array;
    private ArrayList<Integer> max = new ArrayList<Integer>();
    private ArrayMax result; // Создали result типа ArrayMax, чтобы мы могли найти максимальное число в ArrayList

    public MyThread(ArrayList<Integer> max, int threadsNum) { // с каким ArrayList работаем, и сколько потоков задействовать.
        this.max = max;
        this.threadsNum = threadsNum;
        this.result = new ArrayMax(max); // записываем результат поиска максимального числа в result.
    }

    public ArrayMax parallelFind() throws InterruptedException {
        return this.result; // Странно работает, лучше спросить у Вадима, но оно работает, я сам в ахуе если честно, что так можно было.
                            
    }

    public void run() { // Сам поиск максимального числа.
        int maxNum = 0;
        for(int j = 0; j < array.length; j++) {
            if(array[j] > maxNum) {
                maxNum = array[j];
            }
            array[j] = maxNum;
            if(!array[j].equals(array[array.length - 1])) {
                array[j] = 0;
            }
        }

        max = new ArrayList<>(Arrays.asList(array));
        max.removeIf(nSet -> nSet == 0); // Та же история что и в ArrayMax
    }

    public ArrayList<Integer> getMax() { // Юзлес хуйня, можно удалить, но можно и оставить, он не доебется.
                                         // Мб спросит зачем это. Скажешь типа хотел сначала таким способом выводить максимальное число, забыл удалить
        return max;
    }

    public void startThread() throws InterruptedException { // Подключение потока. Вообще тоже лучше у вадима узнать нужно ли это или нет, но оно и без этой хуйни работает
        Thread t = new Thread();
        t.start(); // Запустили поток
        t.join(); // Зашли в поток
    }
}
