package temp;

import java.io.IOException;
import temp.Copyable;
import temp.Main;
import temp.ImageProcessor;
import temp.MemoryUnit;
import temp.OpticalSystem;
import temp.Logger;

/**
 * Клас CopyingMachine представляє копіювальний апарат, який розширює функціонал класу Scanner
 * та реалізує операції, визначені інтерфейсом Copyable.
 */
public class CopyingMachine extends Main implements Copyable {
    private int contrastLevel;
    private int brightnessLevel;

    public CopyingMachine() throws IOException {
        super();
        this.contrastLevel = 50;
        this.brightnessLevel = 50;
        logger.log("Копіювальний апарат створено.");
        System.out.println("Копіювальний апарат створено.");
    }

    @Override
    public void startScan(String documentName) throws IOException {
        this.isScanning = true;
        this.currentDocument = documentName;
        logger.log(String.format("Початок сканування документа: %s", documentName));
        System.out.println(String.format("Початок сканування документа: %s", documentName));
    }

    @Override
    public void finishScan() throws IOException {
        if (isScanning) {
            this.isScanning = false;
            String scannedImage = imageProcessor.processImage(opticalSystem.captureImage());
            memoryUnit.saveImage(currentDocument, scannedImage);
            logger.log(String.format("Завершення сканування: %s", currentDocument));
            System.out.println(String.format("Завершення сканування: %s", currentDocument));
            this.currentDocument = "";
        }
    }

    @Override
    public void makeCopy(String documentName) throws IOException {
        startScan(documentName);
        finishScan();
        logger.log(String.format("Створено копію документа: %s", documentName));
        System.out.println(String.format("Створено копію документа: %s", documentName));
    }

    @Override
    public void adjustContrast(int level) throws IOException {
        if (level >= 0 && level <= 100) {
            this.contrastLevel = level;
            logger.log(String.format("Контраст налаштовано на рівень: %d", level));
            System.out.println(String.format("Контраст налаштовано на рівень: %d", level));
        } else {
            logger.log("Помилка: Недійсний рівень контрасту");
            System.out.println("Помилка: Недійсний рівень контрасту");
        }
    }

    @Override
    public void adjustBrightness(int level) throws IOException {
        if (level >= 0 && level <= 100) {
            this.brightnessLevel = level;
            logger.log(String.format("Яскравість налаштовано на рівень: %d", level));
            System.out.println(String.format("Яскравість налаштовано на рівень: %d", level));
        } else {
            logger.log("Помилка: Недійсний рівень яскравості");
            System.out.println("Помилка: Недійсний рівень яскравості");
        }
    }

    public int getContrastLevel() {
        return contrastLevel;
    }

    public int getBrightnessLevel() {
        return brightnessLevel;
    }

    @Override
    public String getStatus() throws IOException {
        String status = super.getStatus() + String.format(", Контраст: %d, Яскравість: %d", contrastLevel, brightnessLevel);
        System.out.println(status);
        return status;
    }
}
