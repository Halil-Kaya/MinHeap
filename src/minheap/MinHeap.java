/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minheap;

/**
 *
 * @author minter
 */
public class MinHeap<T extends Comparable> {

    private T[] heap;
    private int size;

    public MinHeap(int capacity) {
        this.heap = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    private int parent(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private void swap(int parentIndex, int childIndex) {
        T temp = heap[parentIndex];
        heap[parentIndex] = heap[childIndex];
        heap[childIndex] = temp;
    }

    public void insert(T newData) {
        if (size < heap.length) {

            heap[size] = newData;
            int current = size++;

            while (heap[current].compareTo(heap[parent(current)]) < 0) {

                swap(parent(current), current);
                current = parent(current);
            }

        } else {
            System.out.println("heap is full !");
        }

    }

    public void heapify() {

        int lastIndex = size - 1;

        for (int i = parent(lastIndex); i >= 0; i--) {
            minHeap(i);
        }

    }

    private void minHeap(int i) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int min = i;

        if (left < size && heap[left].compareTo(heap[left]) > 0) {

            min = left;

        } else if (right < size && heap[right].compareTo(heap[right]) > 0) {

            min = right;

        }

        if (min != i) {
            swap(min, i);
            minHeap(min);
        }

    }

    public T deleteMin() {
        T deletedElement = heap[0];

        heap[0] = heap[size - 1];
        size--;

        // TODO: control from root to end, on a specific path
        minHeap(0);

        return deletedElement;

    }

    public void printArray() {

        for (T element : heap) {
            System.out.print(element + " ");
        }
        System.out.println("");
    }

    // TODO: print parent nodes with their left child and right child
    // 0. Seviye    Parent: 4       Left Child: 8       Right Child: 12
    // 1. Seviye    Parent: 8       Left Child: 48      Right Child: 16
    // 1. Seviye    Parent: 12      Left Child: 24      Right Child: 32
    // 2. Seviye    Parent: 48      Left Child: 54      Right Child: 72
    // 2. Seviye    Parent: 16      Left Child: 20      Right Child: -
    public void print() {

        int parentCount = (size - 1) / 2;

        for (int i = 0; i <= parentCount; i++) {

            if ((2 * i + 2) >= size) {
                System.out.println(i + ".Seviye  Parent: " + heap[i] + " Left Child: " + heap[2 * i + 1] + " Right Child: -");

            } else {
                System.out.println(i + ".Seviye  Parent: " + heap[i] + " Left Child: " + heap[2 * i + 1] + " Right Child: " + heap[2 * i + 2]);
            }

        }

    }

    public void decreaseKey(int key, int amount) {

        for (int i = 0; i < size; i++) {

            if (heap[i].equals(key)) {
                heap[i] = (T) new Integer(key - amount);

                while (heap[i].compareTo(heap[parent(i)]) < 0) {
                    swap(parent(i), i);
                    i = parent(i);
                }
                return;
            }
        }
    }

    public void increaseKey(int key, int amount) {

        for (int i = 0; i < size; i++) {

            if (heap[i].equals(key)) {
                heap[i] = (T) new Integer(key + amount);

                minHeap(i);
                return;
            }

        }

    }

}
