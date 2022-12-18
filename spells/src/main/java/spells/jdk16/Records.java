package spells.jdk16;

public record Records(int min, int max) {
    public Records {
        if (min > max) {
            throw new IllegalArgumentException();
        }
    }
    int getTotal() {
        return max - min;
    }

    public static void main(String[] args) {
        Records records = new Records(1, 3);
        System.out.println(records.min());
        System.out.println(records.max());
        System.out.println(records.getTotal());
    }

}


