import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) {

//   В метод put передаете последовательно несколько строк
//   1 2 конструктор;
//   2 2 робот;
//   3 6 кукла.
        String stringToy1 = "1 2 constructor";
        String stringToy2 = "2 2 robot";
        String stringToy3 = "3 6 doll";

//      Из принятой строки id и частоты выпадения(веса) заполнить минимум три
//      массива.

        ArrayList<String> idsArray = new ArrayList<>();
        ArrayList<String> weightsArray = new ArrayList<>();
        ArrayList<String> namesArray = new ArrayList<>();

        idsArray.add(put(stringToy1)[0]);
        weightsArray.add(put(stringToy1)[1]);
        namesArray.add(put(stringToy1)[2]);

        idsArray.add(put(stringToy2)[0]);
        weightsArray.add(put(stringToy2)[1]);
        namesArray.add(put(stringToy2)[2]);

        idsArray.add(put(stringToy3)[0]);
        weightsArray.add(put(stringToy3)[1]);
        namesArray.add(put(stringToy3)[2]);

//        Используя API коллекцию: java.util.PriorityQueue добавить элементы в
//        коллекцию

        PriorityQueue<Toy> pq = new PriorityQueue<>(new ToyComparatorByWeight());

        pq.add(new Toy(idsArray.get(0), Integer.parseInt(weightsArray.get(0)), namesArray.get(0)));
        pq.add(new Toy(idsArray.get(1), Integer.parseInt(weightsArray.get(1)), namesArray.get(1)));
        pq.add(new Toy(idsArray.get(2), Integer.parseInt(weightsArray.get(2)), namesArray.get(2)));


//        Организовать общую очередь.
//        Вызвать Get 10 раз и записать результат в файл.
//        Метод Get должен случайно вернуть либо “2”, либо “3” и соответствии с весом.
//        В 20% случаях выходит единица
//        В 20% двойка
//        И в 60% тройка.
        get(10, pq, "prizeToys.txt");
    }


    public static String[] put(String stringToy) {
        return stringToy.split(" ");
    }

    public static void get(int repeatQty, PriorityQueue<Toy> pq, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < repeatQty; i++) {
                Toy prizeToy = pq.poll();
                if (prizeToy != null) {
                    bw.write(prizeToy.getId() + " " + prizeToy.getName() + "\n");
                    prizeToy.setWeight(prizeToy.getWeight() - 1);
                    if (prizeToy.getWeight() > 0) {
                        pq.offer(prizeToy);
                    }
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}