/*
Author: Miguel Aquino
Date: 3/19/2019
Purpose: Modified version of the ArrayList class.
*/

import java.util.Arrays;

public class PersonArrayList {
    private Person[] list;
    private int size = 0;

    public PersonArrayList(int capacity) {
        this.list = new Person[capacity];
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > list.length) {
            Person[] tmp = new Person[minCapacity];
            System.arraycopy(list, 0, tmp, 0, list.length);
            list = tmp;
        }
    }

    public void add(Person p) {
        if (size >= list.length) {
            ensureCapacity(2*list.length);

        }
        list[size] = p;
        size++;

    }

    public void add(int index, Person value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size >= list.length) {
            ensureCapacity(2*list.length);

        }
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = value;
        size++;

    }

    public Person remove(int index) {
        Person tmp;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            tmp = list[index];
            System.arraycopy(list, index + 1, list, index, size - index - 1);
        }
        size--;
        return tmp;
    }

    public boolean remove(Person s) {
        boolean flag = false;
        for (int i = 0; i < size && !flag; i++){
            if (list[i].equals(s)) {
                remove(i);
                flag = true;
            }
        }
        return flag;
    }

    public Person get(int index) {
        Person tmp;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        tmp = list[index];

        return tmp;
    }

    public int size() {
        return size;
    }

    public PersonArrayList greaterThan(Person p) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list[i].compareTo(p) > 0) {
                count++;
            }
        }
        PersonArrayList newPersonArrList = new PersonArrayList(count);
        for (int i = 0; i < size; i++) {
            if (list[i].compareTo(p) > 0) {
                newPersonArrList.add(list[i]);
            }
        }
        return newPersonArrList;
    }

    Person[] sort() {

        Person[] tmp = new Person[size];
        System.arraycopy(list, 0, tmp, 0, size);
        Arrays.sort(tmp);
        return tmp;
    }
}
