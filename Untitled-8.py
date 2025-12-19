import math
import struct

# ==================== Модуль обчислень (calc) ====================

def calculate(x):
    """Обчислює значення функції y = tg(x) / (sin(4x) - 2cos(x))."""
    try:
        # Знаменник окремо для перевірки на нуль
        denominator = math.sin(4 * x) - 2 * math.cos(x)
        if denominator == 0:
            raise ValueError("Ділення на нуль: знаменник дорівнює 0")
            
        return math.tan(x) / denominator
    except ValueError as e:
        raise ValueError(f"Помилка обчислення: {e}")

def write_to_text_file(filename, data):
    """Записує дані у текстовий файл."""
    with open(filename, "w", encoding="utf-8") as file:
        for x, y in data:
            file.write(f"x: {x}, y: {y}\n")

def read_from_text_file(filename):
    """Зчитує дані з текстового файлу."""
    with open(filename, "r", encoding="utf-8") as file:
        return file.readlines()

def write_to_binary_file(filename, data):
    """Записує дані у двійковий файл."""
    with open(filename, "wb") as file:
        for x, y in data:
            # Записуємо як два числа з плаваючою крапкою (float)
            file.write(struct.pack("ff", x, y))

def read_from_binary_file(filename):
    """Зчитує дані з двійкового файлу."""
    results = []
    try:
        with open(filename, "rb") as file:
            while chunk := file.read(8):  # Кожен запис - 8 байт (2 float по 4 байти)
                x, y = struct.unpack("ff", chunk)
                results.append((x, y))
    except FileNotFoundError:
        print("Файл не знайдено.")
    return results

# ==================== Головна частина (main) ====================

def main():
    """Головна функція програми."""
    try:
        # Введення значення x з клавіатури
        user_input = input("Введіть значення x (число): ")
        x = float(user_input)

        # Обчислення
        y = calculate(x)
        results = [(x, y)]
        print(f"\nРезультат обчислення: y = {y}")

        # Робота з текстовим файлом
        text_filename = "result.txt"
        write_to_text_file(text_filename, results)
        print(f"Результати записані у текстовий файл: {text_filename}")

        # Робота з двійковим файлом
        binary_filename = "result.bin"
        write_to_binary_file(binary_filename, results)
        print(f"Результати записані у двійковий файл: {binary_filename}")

        # Читання та виведення результатів із текстового файлу
        print("\nЗчитування з текстового файлу:")
        text_data = read_from_text_file(text_filename)
        for line in text_data:
            print(line.strip())

        # Читання та виведення результатів із двійкового файлу
        print("\nЗчитування з двійкового файлу:")
        binary_data = read_from_binary_file(binary_filename)
        for bx, by in binary_data:
            print(f"x: {bx}, y: {by}")

    except ValueError as e:
        print(f"Помилка: {e}. Будь ласка, введіть коректне число.")
    except Exception as e:
        print(f"Виникла непередбачувана помилка: {e}")

if __name__ == "__main__":
    main()