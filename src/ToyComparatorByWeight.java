import java.util.Comparator;

public class ToyComparatorByWeight implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}
