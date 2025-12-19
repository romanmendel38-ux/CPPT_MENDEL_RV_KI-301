package temp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Параметризований клас, що реалізує відсік для зброї.
 * Дозволяє зберігати та управляти різними типами зброї.
 *
 * @param <T> тип зброї, що зберігається у відсіку
 */
public class WeaponCompartment<T extends Comparable<T>> {
    private ArrayList<T> weapons;
    private int capacity;

    /**
     * Конструктор класу temp.WeaponCompartment
     * @param capacity максимальна місткість відсіку
     */
    public WeaponCompartment(int capacity) {
        this.capacity = capacity;
        this.weapons = new ArrayList<>();
    }

    /**
     * Додає зброю до відсіку
     * @param weapon зброя для додавання
     * @return true якщо додавання успішне, false якщо відсік повний
     */
    public boolean addWeapon(T weapon) {
        if (weapons.size() < capacity) {
            weapons.add(weapon);
            return true;
        }
        return false;
    }

    /**
     * Виймає зброю з відсіку
     * @param index індекс зброї для виймання
     * @return вийнята зброя або null якщо індекс невірний
     */
    public T removeWeapon(int index) {
        if (index >= 0 && index < weapons.size()) {
            return weapons.remove(index);
        }
        return null;
    }

    /**
     * Знаходить мінімальний елемент у відсіку
     * @return мінімальний елемент або null якщо відсік порожній
     */
    public T findMinWeapon() {
        if (weapons.isEmpty()) {
            return null;
        }
        return Collections.min(weapons);
    }

    /**
     * Отримує поточну кількість зброї у відсіку
     * @return кількість елементів у відсіку
     */
    public int getCurrentLoad() {
        return weapons.size();
    }

    /**
     * Перевіряє чи є вказана зброя у відсіку
     * @param weapon зброя для пошуку
     * @return true якщо зброю знайдено, false якщо ні
     */
    public boolean containsWeapon(T weapon) {
        return weapons.contains(weapon);
    }
}
