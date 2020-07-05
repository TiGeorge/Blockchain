import java.util.Iterator;

class Range implements Iterable<Long> {

    private long fromInclusive;
    private long toExclusive;

    public Range(long from, long to) {
        this.fromInclusive = from;
        this.toExclusive = to;
    }

    @Override
    public Iterator<Long> iterator() {
        // write your code here

        return new Iterator<Long>() {
            private long nextValue = fromInclusive;

            @Override
            public boolean hasNext() {
                return nextValue < toExclusive;
            }

            @Override
            public Long next() {
                return nextValue++;
            }
        };
    }
}