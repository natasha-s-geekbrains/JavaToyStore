import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

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

        // Организовываем общую очередь.
        // Вызываем Get в кол-ве раз, равном сумме весов принятых игрушек и записываем результат в файл.
        ToyStore.get(newPq, "prizeToys.txt");

        // В соответствии с тремя предложенными выше строками (игрушками) и их весом:
        // Метод Get должен случайно вернуть либо “2”, либо “3” и соответствии с весом.
        // В 20% случаях выходит единица
        // В 20% двойка
        // И в 60% тройка.
    }
}