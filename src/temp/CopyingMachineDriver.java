package temp;

import java.io.IOException;
/**
 * Клас ScannerDriver є точкою входу в програму та демонструє роботу зі сканером,
 * використовуючи різні методи класу Scanner.
 */
public class CopyingMachineDriver {
    /**
     * Точка входу в програму. Демонструє роботу з телевізором шляхом виклику різних методів.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        try {
            CopyingMachine copier = new CopyingMachine();

            copier.makeCopy("Документ1");
            copier.adjustContrast(75);
            copier.adjustBrightness(60);

            System.out.println(copier.getStatus());
            System.out.println("Контраст: " + copier.getContrastLevel());
            System.out.println("Яскравість: " + copier.getBrightnessLevel());

            copier.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
