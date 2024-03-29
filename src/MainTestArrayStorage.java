import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.ArrayStorage;
import com.basejava.webapp.storage.Storage;

import java.util.Arrays;

/**
 * Test for your com.basejava.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    public static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume();
        r1.setUuid("uuid1");
        final Resume r2 = new Resume();
        r2.setUuid("uuid2");
        final Resume r3 = new Resume();
        r3.setUuid("uuid3");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

//        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
//        System.out.println("Size: " + ARRAY_STORAGE.size());
//
//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
//
////        System.out.println("Index of r2: " + Arrays.binarySearch(ARRAY_STORAGE.storage, 0, ARRAY_STORAGE.size(), r2));
//
//
//        printAll();
//        ARRAY_STORAGE.delete(r1.uuid);
//        printAll();
//        ARRAY_STORAGE.clear();
//        printAll();
//
//        System.out.println("Size: " + ARRAY_STORAGE.size());
//    }
//
//    static void printAll() {
//        System.out.println("\nGet All");
//        for (com.basejava.webapp.model.Resume r : ARRAY_STORAGE.getAll()) {
//            System.out.println(r);
//        }
//    }
    }
}
