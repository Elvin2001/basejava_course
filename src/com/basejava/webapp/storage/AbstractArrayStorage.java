package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 100000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;
    
    public Resume get(String uuid) {
        if (findIndex(uuid) < 0) {
            System.out.println("Такого объекта не было найдено");
            return null;
        }
        return storage[findIndex(uuid)];
    }

    protected abstract int findIndex(String uuid);

    public int size() {
        return size;
    }
}
