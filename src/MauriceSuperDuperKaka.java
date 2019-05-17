import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MauriceSuperDuperKaka {

    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<Integer>();
        List<Bin> bins = new ArrayList<Bin>();

        elements.add(3);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(9);
        elements.add(5);
        elements.add(7);
        elements.add(2);
        elements.add(3);
        elements.add(8);
        elements.add(3);
        elements.add(1);
        elements.add(2);

        for (int element : elements){

            boolean worked = false;

            for (Bin bin : bins){

                if (bin.addElement(element)){
                    worked = true;
                    break;
                }

            }

            if (!worked) {
                bins.add(new Bin());
                bins.get(bins.size()-1).addElement(element);
            }
        }

        for (Bin bin : bins){
            System.out.println("Restplatz im Bin: " + bin.getFreeSpace());
        }

        System.out.println("Anzahl bins: " + bins.size());
    }






/*
    Buffer buffer = new Buffer(2);

    Thread producerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                buffer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    Thread consumerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
}
    static class Buffer {
        private Queue<Integer> list;
        private int size;
        public Buffer(int size) {
            this.list = new LinkedList<>();
            this.size = size;
        }
        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    while (list.size() >= size) {
                        // wait for the consumer
                        wait();
                    }
                    list.add(value);
                    System.out.println("Produced " + value);
                    value++;
                    // notify the consumer
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (list.size() == 0) {
                        // wait for the producer
                        wait();
                    }
                    int value = list.poll();
                    System.out.println("Consume " + value);
                    // notify the producer
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
        */

}
