import java.util.Comparator;

public class ToyComparatorByWeight implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}
