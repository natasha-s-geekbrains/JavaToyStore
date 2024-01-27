import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        int newRepeatQty = 10;

//   В метод put передаем последовательно несколько строк
//   1 2 конструктор;
//   2 2 робот;
//   3 6 кукла.
        String stringToy1 = "1 2 constructor";
        String stringToy2 = "2 2 robot";
        String stringToy3 = "3 6 doll";

        ToyStore.put(stringToy1);
        ToyStore.put(stringToy2);
        ToyStore.put(stringToy3);

        PriorityQueue<Toy> newPq = ToyStore.getPriorityQueue();
        System.out.println(newPq);

//        Организовываем общую очередь.
//        Вызываем Get 10 раз (newRepeatQty) и записываем результат в файл.

        ToyStore.get(newRepeatQty, newPq, "prizeToys.txt");

        // Метод Get должен случайно вернуть либо “2”, либо “3” и соответствии с весом.
        // В 20% случаях выходит единица
        // В 20% двойка
        // И в 60% тройка.
    }
}