import java.util.Objects;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/29
 * @version: 1.0
 */
public class People {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return id == people.id &&
                Objects.equals(name, people.name);
    }

}
