/*
Author: Miguel Aquino
Date: 3/19/2019
Purpose: Modified version of the ArrayList class.
*/

import java.util.Arrays;


public class PersonArrayList {
    private Person[] list;
    private int size = 0;
    private PersonArrayList newPersonArrList;

    public PersonArrayList(int capacity) {
        this.list = new Person[capacity];
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > list.length) {
            Person[] tmp = new Person[2*minCapacity];
            System.arraycopy(list, 0, tmp, 0, list.length);
            list = tmp;
        }
    }

    public void add(Person p) {
        if (size >= list.length) {
            ensureCapacity(list.length);
            list[size] = p;
            size++;
        }

    }

    public void add(int index, Person value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size >= list.length) {
            ensureCapacity(list.length);
            list[index] = value;
            size++;
        }

    }

    public Person remove(int index) {
        Person tmp;
        tmp = list[index];
        Person[] newArr = new Person[size - 1];

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            for (int i = 0; i < list.length; i++) {

                System.arraycopy(list, 0, newArr, 0, index);
                System.arraycopy(list, index + 1, newArr, index, size - index - 1);
            }
        }
        return tmp;
    }

    public boolean remove(Person s) {
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < list.length; i++){
            if (list[i] == s && !flag) {
                remove(i);
                flag = true;
            }
        }
        return flag;
    }

    public Person get(int index) {
        Person tmp;
        tmp = list[index];
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return tmp;
    }

    public int size() {
        return size;
    }

//    public PersonArrayList greaterThan(Person p) {
//        PersonArrayList newPersonArrList;
//        return newPersonArrList > p;
//
//    }

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
                newPersonArrList.add(p);
            }
        }
        return newPersonArrList;
    }

    Person[] sort() {

        Person[] tmp = new Person[size];
        for (int i= 0; i < size; i++) {
            tmp[i] = list[i];
        }
        Arrays.sort(tmp);
        return tmp;
    }
}
