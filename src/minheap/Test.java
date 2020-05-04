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
public class Test {

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(48);
        minHeap.insert(16);
        minHeap.insert(24);
        minHeap.insert(20);
        minHeap.insert(8);
        minHeap.insert(12);
        minHeap.insert(32);
        minHeap.insert(54);
        minHeap.insert(72);
        minHeap.insert(4);

        minHeap.printArray();

        System.out.println("\nAfter deleteMin : " + minHeap.deleteMin());
        minHeap.printArray();

        System.out.println("\nAfter decrease key method :");
        minHeap.decreaseKey(72, 70);
        minHeap.printArray();
        
        minHeap.print();

    }
}
