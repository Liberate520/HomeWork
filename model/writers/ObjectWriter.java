package model.writers;

// Применяем SRP: Разделяем интерфейсы на ObjectWriter и ObjectReader.
public interface ObjectWriter {
    void write(Object obj);
}