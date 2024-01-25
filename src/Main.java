

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore("1 2 constructionSet", "2 2 robot", "3 6 doll");
        System.out.println(toyStore);

        toyStore.put("1 2 constructionSet");
        toyStore.put("2 2 robot");
        toyStore.put("3 6 doll");
        System.out.println(toyStore);

    }
}