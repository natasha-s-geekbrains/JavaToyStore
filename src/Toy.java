import java.util.Objects;

public class Toy {
    private String id;
    private String weight;
    private String name;

    public Toy() {
    }

    //Класс-конструктор у которого принимает минимум 3 строки,
    //содержащие три поля id игрушки, текстовое название и частоту выпадения игрушки
    public Toy(String id, String weight, String name) {
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy toy)) return false;
        return Objects.equals(getId(), toy.getId());
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
