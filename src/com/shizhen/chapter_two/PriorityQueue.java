package com.shizhen.chapter_two;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PriorityQueue extends BaseSortAlgorithms {

    public static void topMSort(String[] args) {
        int M = Integer.parseInt(args[0]);
        MaxPQ<Transaction> pq = new MaxPQ<>(M + 1);
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M) {
                pq.delMax();
            }
        }
        Stack<Transaction> stack = new Stack<>();
        while (!pq.isEmpty()) {
            stack.push(pq.delMax());
        }
        for (Transaction t : stack) {
            StdOut.println(t);
        }
    }


    public static class MaxPQ<Key extends Comparable<Key>> {
        private Key[] pq;
        private int N = 0;

        private MaxPQ(int max) {
            pq = (Key[]) new Comparable[max + 1];
        }

        private void insert(Key v) {

        }

        public Key max() {
            return null;
        }

        private Key delMax() {
            return null;
        }

        private boolean isEmpty() {
            return false;
        }

        private int size() {
            return 0;
        }

        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }

        private void exch(int i, int j) {
            Key t = pq[i];
            pq[i] = pq[j];
            pq[j] = t;
        }

        private void swim(int k) {
            while (k > 1) {
                if (less(k / 2, k)) {
                    exch(k / 2, k);
                    k = k / 2;
                }
            }
        }

        private void sink(int k) {
            while (k * 2 <= N) {
                int j = k * 2;
                if (j < N && less(j, j + 1)) {
                    j++;
                }
                if (!less(k, j)) {
                    break;
                }
                exch(k, j);
                k = j;
            }
        }
    }


    public static class Transaction implements Comparable<Transaction> {
        private String who;
        private Date date;
        private double amount;

        private Transaction(String transaction) {
            String[] split = transaction.split(" ");
            who = split[0];
            date = new Date(split[1]);
            amount = Double.valueOf(split[2]);
        }

        @Override
        public int compareTo(Transaction o) {
            return (int) (amount - o.amount);
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "who='" + who + '\'' +
                    ", date=" + date +
                    ", amount=" + amount +
                    '}';
        }
    }

    public static class Date implements Comparable<Date> {
        private int month;
        private int day;
        private int year;

        private Date(String date) {
            String[] split = date.split("/");
            month = Integer.valueOf(split[0]);
            day = Integer.valueOf(split[1]);
            year = Integer.valueOf(split[2]);
        }

        @Override
        public int compareTo(Date o) {
            return 0;
        }

        @Override
        public String toString() {
            return "Date{" +
                    "month=" + month +
                    ", day=" + day +
                    ", year=" + year +
                    '}';
        }
    }
}


