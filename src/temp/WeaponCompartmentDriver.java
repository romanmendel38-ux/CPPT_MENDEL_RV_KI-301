package temp;

/**
 * Головний клас для тестування функціональності відсіку зброї
 */
public class WeaponCompartmentDriver {
    public static void main(String[] args) {
        // Створюємо відсік для вогнепальної зброї
        WeaponCompartment<Firearm> firearmCompartment = new WeaponCompartment<>(5);

        // Додаємо вогнепальну зброю
        firearmCompartment.addWeapon(new Firearm("AK-47", 7.62, 30));
        firearmCompartment.addWeapon(new Firearm("M4A1", 5.56, 30));
        firearmCompartment.addWeapon(new Firearm("Desert Eagle", 12.7, 7));

        // Знаходимо зброю з найменшим калібром
        Firearm smallestCaliber = firearmCompartment.findMinWeapon();
        System.out.println("Зброя з найменшим калібром: " + smallestCaliber);

        // Створюємо відсік для холодної зброї
        WeaponCompartment<MeleeWeapon> meleeCompartment = new WeaponCompartment<>(3);

        // Додаємо холодну зброю
        meleeCompartment.addWeapon(new MeleeWeapon("Katana", 103.0, 1.2));
        meleeCompartment.addWeapon(new MeleeWeapon("Combat Knife", 30.0, 0.3));
        meleeCompartment.addWeapon(new MeleeWeapon("Machete", 45.0, 0.5));

        // Знаходимо найкоротшу холодну зброю
        MeleeWeapon shortestWeapon = meleeCompartment.findMinWeapon();
        System.out.println("Найкоротша холодна зброя: " + shortestWeapon);

        // Демонструємо виймання зброї
        Firearm removedFirearm = firearmCompartment.removeWeapon(0);
        System.out.println("Вийнята вогнепальна зброя: " + removedFirearm);
        System.out.println("Залишилось одиниць вогнепальної зброї: " +
                firearmCompartment.getCurrentLoad());
    }
}
