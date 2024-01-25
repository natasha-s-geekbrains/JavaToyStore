import java.util.PriorityQueue;

public class ToyStore {
    private PriorityQueue<Toy> nowToyStore;

    // Конструктор принимает минимум 3 строки, содержащие 3 поля:
    // id игрушки, частоту выпадания и текстовое название
    public ToyStore(String toy1, String toy2, String toy3) {
        nowToyStore = new PriorityQueue<>(new ToyComparatorByWeight());

        // Для первой игрушки:
        // Из принятой строки id и частоты выпадения(веса) заполнить минимум три массива

        String[] nextToyArray = toy1.split(" ");
        Toy nextToy = new Toy();
        nextToy.setId(Integer.parseInt(nextToyArray[0]));
        nextToy.setWeight(Integer.parseInt(nextToyArray[1]));
        nextToy.setName(nextToyArray[2]);

        // Используя API коллекцию: java.util.PriorityQueue добавить элементы в коллекцию
        nowToyStore.add(nextToy);

        // Повторяем то же для двух других игрушек

        nextToyArray = toy2.split(" ");
        nextToy = new Toy();
        nextToy.setId(Integer.parseInt(nextToyArray[0]));
        nextToy.setWeight(Integer.parseInt(nextToyArray[1]));
        nextToy.setName(nextToyArray[2]);
        nowToyStore.add(nextToy);

        nextToyArray = toy3.split(" ");
        nextToy = new Toy();
        nextToy.setId(Integer.parseInt(nextToyArray[0]));
        nextToy.setWeight(Integer.parseInt(nextToyArray[1]));
        nextToy.setName(nextToyArray[2]);
        nowToyStore.add(nextToy);
    }

    // Добавляем метод Put, в который передается строковое описание игрушки.
    // Метод добавляет новые игрушки к трем уже имеющимся
    public void put (String stringNewToy){
        String[] newToyArray = stringNewToy.split(" ");
        Toy newToy = new Toy();
        newToy.setId(Integer.parseInt(newToyArray[0]));
        newToy.setWeight(Integer.parseInt(newToyArray[1]));
        newToy.setName(newToyArray[2]);
        nowToyStore.add(newToy);
    }


    @Override
    public String toString() {
        return "ToyStore{" +
                "nowToyStore=" + nowToyStore +
                '}';
    }

    public PriorityQueue<Toy> getNowToyStore() {
        return nowToyStore;
    }

}

