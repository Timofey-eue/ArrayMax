import java.util.*;

public class ArrayMax {
    private final ArrayList<Integer> nums;

    public ArrayMax(ArrayList<Integer> nums) {
        this.nums = nums;
    }

    public ArrayList<Integer> findMax(ArrayList<Integer> nums) { // Поиск максимального элемента в ArrayList
        ArrayList<Integer> max = new ArrayList<Integer>(); // Создание аррейлист куда будем записывать максимаьный элемент
        Integer[] array = new Integer[1000]; // Я сделал так. Сначала работаю с массивом, потом этот массив переделываю в Эррэйлист в 29 строчке
        Integer[] res = new Integer[array.length]; // Это я сделал чтобы записать сюда результат поиска максимального числа в массиве.// Например массв такой array[1, 2, 3, 4, 5, 6, 7], то в res он будет таким res[1, 7, 7, 7, 7, 7, 7] строка 26 и 28// А потом таким [0, 0, 0, 0, 0, 0, 7] строка 29.// Все числа меньше максимального заменются нулями в строке 30. Если j-тый элемент не равен последнему элементу// То заменяем j-тый жемент на нули
        int maxNum = 0;
        Random r = new Random();
        for(int i = 0; i < array.length; i++) { // Заполнил рандомными числами массив
            array[i] = r.nextInt(100000) + 1; // Рандомные числа от 0 до 100, если бы не написал + 1, то было бы до 99
        }
        System.arraycopy(array, 0, res, 0, array.length); // скопировал массив эррей в res
        for(int j = 0; j < res.length; j++) {
            if (res[j] > maxNum) { // если проверяемое число больше чем наш max который равен 0,
                maxNum = res[j]; // то max становится этим числом
            }
            res[j] = maxNum; // записываем максимальные числа в массив
            if (!res[j].equals(res[res.length - 1])) { // объяснение в 14 строке
                res[j] = 0; // объяснение в 14 строке
            }
        }
        max = new ArrayList<>(Arrays.asList(res)); // Скопировали массив res в ArrayList max, как сказано в задании
        System.out.println(Arrays.toString(array)); // Вывели первоначальный массив, после опереции заполнения рандомными числами
        max.removeIf(nSet -> nSet == 0); // удалили все 0 из ArrayList, чтобы отсалось только одно число
        return max; // Вернули максимальный результат.
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nums);
        return sb.toString();
    }
}
