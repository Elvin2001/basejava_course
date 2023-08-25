package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume r) {
        if (findIndex(r.getUuid()) == -1) {
            System.out.println("Такого объекта нет");
        } else {
            storage[findIndex(r.getUuid())] = r;

        }

    }

    @Override
    public void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            System.out.println("Хранилище переполнено");
        } else {
            if (findIndex(r.getUuid()) >= 0) {
                System.out.println("Такой экземпляр уже есть в хранилище");
            } else {
                storage[size] = r;
                size++;
            }
        }
    }

    @Override
    public Resume get(String uuid) {
        if (findIndex(uuid) < 0) {
            System.out.println("Такого объекта не было найдено");
            return null;
        }
        return storage[findIndex(uuid)];
    }

    @Override
    public void delete(String uuid) {
        if (findIndex(uuid) < 0) {
            System.out.println("Такого объекта не было найдено");
        } else {
            storage[findIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public int size() {
        return size;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
