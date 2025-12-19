# ==================== Клас Scanner (Базовий) ====================
class Scanner:
    """
    Базовий клас Scanner, що представляє пристрій для сканування документів.
    """

    def __init__(self, brand, model, scan_resolution):
        """
        Ініціалізує об'єкт сканера.
        """
        self.brand = brand
        self.model = model
        self.scan_resolution = scan_resolution
        self.is_powered_on = False
        self.color_mode = "кольоровий"

    def turn_on(self):
        """Увімкнення сканера."""
        self.is_powered_on = True
        print(f"{self.brand} {self.model} увімкнений.")

    def turn_off(self):
        """Вимкнення сканера."""
        self.is_powered_on = False
        print(f"{self.brand} {self.model} вимкнений.")

    def scan_document(self, document_name):
        """Сканування документа."""
        if not self.is_powered_on:
            print(f"{self.brand} {self.model} вимкнений. Увімкніть сканер для сканування.")
            return
        print(f"Сканування документу '{document_name}' в режимі {self.color_mode} з роздільною здатністю {self.scan_resolution}.")

    def set_color_mode(self, mode):
        """Встановлення режиму сканування (кольоровий/чорно-білий)."""
        self.color_mode = mode
        print(f"Режим сканування змінено на {mode}.")

    def set_scan_resolution(self, resolution):
        """Встановлення роздільної здатності сканування."""
        self.scan_resolution = resolution
        print(f"Роздільна здатність змінена на {resolution}.")

    def perform_maintenance(self):
        """Виконання технічного обслуговування."""
        print(f"{self.brand} {self.model} обслуговано. Все готово до роботи.")

    def get_status(self):
        """Отримання статусу сканера."""
        power_status = "увімкнений" if self.is_powered_on else "вимкнений"
        return f"Сканер {self.brand} {self.model}: {power_status}, роздільна здатність {self.scan_resolution}, режим {self.color_mode}."


# ==================== Клас Copier (Похідний) ====================
class Copier(Scanner):
    """
    Похідний клас Copier, що додає функціональність копіювання до базового класу Scanner.
    """

    def __init__(self, brand, model, scan_resolution, copy_speed):
        """
        Ініціалізує об'єкт копіювального апарата.
        """
        # Виклик конструктора базового класу
        super().__init__(brand, model, scan_resolution)
        self.copy_speed = copy_speed

    def copy_document(self, document_name, copies=1):
        """Копіює документ у заданій кількості."""
        if not self.is_powered_on:
            print(f"{self.brand} {self.model} вимкнений. Увімкніть пристрій для копіювання.")
            return
        print(f"Копіювання документу '{document_name}' ({copies} копій) зі швидкістю {self.copy_speed} стор./хв.")

    def set_copy_speed(self, new_speed):
        """Змінює швидкість копіювання."""
        self.copy_speed = new_speed
        print(f"Швидкість копіювання змінена на {new_speed} стор./хв.")

    def scan_and_copy(self, document_name):
        """Сканує документ і одразу створює його копію."""
        self.scan_document(document_name)
        self.copy_document(document_name)

    def get_status(self):
        """Отримує статус копіювального апарата (перевизначення методу)."""
        base_status = super().get_status()
        return f"{base_status}, швидкість копіювання: {self.copy_speed} стор./хв."

    def set_copy_quality(self, quality):
        """Змінює якість копіювання."""
        print(f"Якість копіювання встановлено: {quality}.")


# ==================== Головна частина програми ====================
if __name__ == "__main__":
    # Створюємо копіювальний апарат
    copier = Copier(brand="Xerox", model="X1000", scan_resolution="2400x2400 dpi", copy_speed=30)

    # Демонструємо початковий статус пристрою
    print("\n1. Початковий стан пристрою:")
    print(copier.get_status())

    # Виконуємо кілька дій (спочатку треба увімкнути!)
    print("\n2. Спроба дій без живлення:")
    copier.scan_document("Квитанція.pdf")

    print("\n3. Управління живленням та робота:")
    copier.turn_on()
    copier.scan_document("Квитанція.pdf")
    copier.copy_document("Рахунок.docx")
    copier.copy_document("Інструкція.pdf", copies=3)

    # Використання сканера у кольоровому та чорно-білому режимах
    print("\n4. Сканування у різних режимах:")
    copier.set_color_mode("чорно-білий")
    copier.scan_document("Заява.docx")

    # Перевірка налаштувань роздільної здатності
    print("\n5. Зміна роздільної здатності:")
    copier.set_scan_resolution("300x300 dpi")
    copier.scan_document("Чек.pdf")

    # Встановлення нової швидкості копіювання
    print("\n6. Зміна швидкості копіювання:")
    copier.set_copy_speed(50)

    # Виконання обслуговування
    print("\n7. Технічне обслуговування:")
    copier.perform_maintenance()

    # Демонстрація фінального статусу
    print("\n8. Фінальний статус пристрою:")
    print(copier.get_status())