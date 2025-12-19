package temp;

/**
 * Клас, що представляє вогнепальну зброю
 */
class Firearm implements Comparable<Firearm> {
    private String name;
    private double caliber;
    private int ammoCapacity;

    /**
     * Конструктор класу temp.Firearm
     * @param name назва зброї
     * @param caliber калібр
     * @param ammoCapacity ємність магазину
     */
    public Firearm(String name, double caliber, int ammoCapacity) {
        this.name = name;
        this.caliber = caliber;
        this.ammoCapacity = ammoCapacity;
    }

    public String getName() {
        return name;
    }

    public double getCaliber() {
        return caliber;
    }

    /**
     * Порівнює вогнепальну зброю за калібром
     * @param other інша зброя для порівняння
     * @return від'ємне число, якщо поточна зброя має менший калібр,
     *         додатне число, якщо більший,
     *         0, якщо калібри рівні
     */
    @Override
    public int compareTo(Firearm other) {
        return Double.compare(this.caliber, other.caliber);
    }

    @Override
    public String toString() {
        return "temp.Firearm{name='" + name + "', caliber=" + caliber +
                "mm, ammoCapacity=" + ammoCapacity + "}";
    }
}
