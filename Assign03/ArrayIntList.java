// Travis Eiler
// CPW 245, Winter '20
// Assignment #3: ArrayIntList
// Due: Jan 22, 2020
//
// The purpose of this program is to manually reproduce methods from Java Class ArrayList<E>.
// specifically to reinforce our understanding of ArrayIntList.

// Class ArrayIntList can be used to store a list of integers.

import java.util.*;

public class ArrayIntList {

    private int[] elementData; // list of integers
    private int size;          // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 100;

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = new int[capacity];
        size = 0;
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    // pre : size() < capacity (throws IllegalStateException if not)
    // post: appends the given value to the end of the list
    public void add(int value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    // pre : size() < capacity (throws IllegalStateException if not) &&
    //       0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    // post: list is empty
    public void clear() {
        size = 0;
    }

    // pre: size() + other.size() <= capacity (throws IllegalStateException
    //      if not)
    // post: appends all values in the given list to the end of this list
    public void addAll(ArrayIntList other) {
        ensureCapacity(size + other.size);
        for (int i = 0; i < other.size; i++) {
            add(other.elementData[i]);
        }
    }

    // post: ensures that the underlying array has the given capacity; if not,
    //       the size is doubled (or more if given capacity is even larger)
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
    
    public int sum() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += elementData[i];
        }
        return total;
    }
    
    public double average() {
        if (isEmpty()) {
            return 0.0;
        } else {
            return (double) sum() / size;
        }
    }
    
    // Method #1
    // public void addAll( int index, ArrayIntList list )
    // https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
    public void addAll( int index, ArrayIntList list ) {
        ensureCapacity(size + list.size);
        int inheritedSize = size();
        int incomingListSize = list.size();
        int j = 0;
        for(int i = index; i<incomingListSize+index; i++){
            add(i,list.get(j));
            j++;
        }
    }
    
    // Method #2
    // public boolean containsAll( ArrayIntList list )
    public boolean containsAll( ArrayIntList list ) {
        for(int i=0; i<list.size; i++) {
            if(!contains(list.get(i) )) {
                return false;
            }
        } 
        return true;
    }
    
    // Method #3
    // public boolean equals( ArrayIntList list )
    public boolean equals( ArrayIntList list ) {
        if(this.size != list.size) {
            return false; 
        }

        for(int i=0; i<list.size; i++) {
            if(elementData[i] != list.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    // Method #4
    // public int lastIndexOf( int value )
    public int lastIndexOf( int value ) {
        int end=-1;
        for(int i=size()-1; i>=0; i--) {
            if( elementData[i] == value) {
                return i;
            }
        }
        return end;
    }
}