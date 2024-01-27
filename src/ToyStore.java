import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ToyStore {
    private static PriorityQueue<Toy> priorityQueue;

    static {
        priorityQueue = new PriorityQueue<>(new ToyComparatorByWeight());
    }

    private static int repeatQty;

    public ToyStore() {
    }


    public static PriorityQueue<Toy> getPriorityQueue() {
        return priorityQueue;
    }

    public static void put(String stringToy) {
        String[] toyArray = stringToy.split(" ");

        // Из принятой строки id и частоты выпадения(веса) заполняем минимум три массива.
        ArrayList<String> idsArray = new ArrayList<>();
        ArrayList<String> weightsArray = new ArrayList<>();
        ArrayList<String> namesArray = new ArrayList<>();

        idsArray.add(toyArray[0]);
        weightsArray.add(toyArray[1]);
        namesArray.add(toyArray[2]);

        // Используя API коллекцию: java.util.PriorityQueue добавляем элементы в коллекцию
        priorityQueue.add(new Toy(idsArray.getFirst(), weightsArray.getFirst(), namesArray.getFirst()));
    }

    public static void get(PriorityQueue<Toy> pq, String filePath) {
        for (Toy toy : pq) {
            repeatQty += Integer.parseInt(toy.getWeight());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Организуем общую очередь.
            // Вызываем Get 10(repeatQty) раз
            for (int i = 0; i < repeatQty; i++) {
                Toy prizeToy = pq.poll();
                if (prizeToy != null) {
                    // Записываем результат в файл.
                    bw.write(prizeToy.getId() + "\n");

                    // Делаем так, чтобы метод Get возвращал либо “2”, либо “3” и соответствии с весом.
                    // В 20% случаях выходит единица
                    // В 20% двойка
                    // И в 60% тройка.
                    int newPrizeToyWeight = Integer.parseInt(prizeToy.getWeight()) - 1;
                    prizeToy.setWeight(String.valueOf(newPrizeToyWeight));
                    if (newPrizeToyWeight > 0) {
                        pq.offer(prizeToy);
                    }
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
