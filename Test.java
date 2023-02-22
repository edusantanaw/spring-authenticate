import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(540);
        numbers.add(5);
        var a = filterData(numbers);
        a.forEach(e -> {
            System.out.println(e);
        });
    }

    static Stream<Integer> filterData(List<Integer> data) {
        return data.stream().filter(n -> n > 20);
    }

}
