import java.util.Objects;

public class Toy {
    private String id;
    private int weight;
    private String name;

    public Toy() {
    }

    //Напишите класс-конструктор у которого принимает минимум 3 строки,
    //содержащие три поля id игрушки, текстовое название и частоту выпадения игрушки
    public Toy(String id, int weight, String name) {
        this.id = id;
        this.weight = weight;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy toy)) return false;
        return getId().equals(toy.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }

}
