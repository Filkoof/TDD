package experiment.TDD;

import java.util.HashMap;

public class Bank {

    private final HashMap<Pair, Integer> rates = new HashMap<>();

    Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    int rate(String from, String to) {
        if (from.equals(to)) return 1;
        return rates.get(new Pair(from, to));
    }

    void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }

    private record Pair(String from, String to) {

        @Override
            public boolean equals(Object obj) {
                Pair pair = (Pair) obj;
                return from.equals(pair.from) && to.equals(pair.to);
            }

            @Override
            public int hashCode() {
                return 0;
            }
        }
}
