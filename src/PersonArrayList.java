public class PersonArrayList {
    private Person[] list;
    private int size = 0;

    public PersonArrayList(int capacity) {
        Person[] newList = new Person[capacity];
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > list.length) {
            Person[] tmp = new Person[minCapacity]
            System.arraycopy(list, 0, tmp, 0, list.length);
            list = tmp;
        }
    }

    public void add(Person p) {
        if (size >= list.length) {
            ensureCapacity(2*list.length);
        }
        else {
            list[size] = p;
            size++;
        }
    }

    public void add(int index, Person value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size >= list.length) {
            ensureCapacity(2*list.length);
        }
        list[index] = value;
        size++;
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
//
//    public Person[] sort() {
//
//    }


}
