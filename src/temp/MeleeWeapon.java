package temp;

/**
 * Клас, що представляє холодну зброю
 */
class MeleeWeapon implements Comparable<MeleeWeapon> {
    private String name;
    private double length;
    private double weight;

    /**
     * Конструктор класу MeleeWeapon
     * @param name назва зброї
     * @param length довжина
     * @param weight вага
     */
    public MeleeWeapon(String name, double length, double weight) {
        this.name = name;
        this.length = length;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    /**
     * Порівнює холодну зброю за довжиною
     * @param other інша зброя для порівняння
     * @return від'ємне число, якщо поточна зброя коротша,
     *         додатне число, якщо довша,
     *         0, якщо довжини рівні
     */
    @Override
    public int compareTo(MeleeWeapon other) {
        return Double.compare(this.length, other.length);
    }

    @Override
    public String toString() {
        return "MeleeWeapon{name='" + name + "', length=" + length +
                "cm, weight=" + weight + "kg}";
    }
}
