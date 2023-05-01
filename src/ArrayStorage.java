
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    // Добавляем поле о максимальном количестве элементов в хранилище
    protected static final int STORAGE_LIMIT = 10000;

    // Добавляем поле о размере хранилища
    protected int size;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    public void iterateOfStorage(Resume[] storage) {
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] != null) {
                System.out.println(storage[i]);
            }
        }
    }
    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }
    void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("Хранилище переполнено");
        } else {
            int index = findIndex(r.getUuid());
            if (index >= 0) {
                System.out.println("Такой экземпляр уже есть в хранилище");
            } else {
                storage[size] = r;
                size++;
            }
        }
    }
    Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Такого объекта не было найдено");
        } else {
            return storage[index];
        }
        return null;
    }
    void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("Ошибка, такого объекта нет");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }
    int size() {
        return size;
    }
    private Integer findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
