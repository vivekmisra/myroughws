package org.vivek.algos;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.vivek.algos.sorting.MergeSort;

public class MergesortTest {

        private Integer[] numbers;
        private final static int SIZE = 7;
        private final static int MAX = 20;

        @Before
        public void setUp() throws Exception {
                numbers = new Integer[SIZE];
                Random generator = new Random();
                for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = generator.nextInt(MAX);
                }
                
                printArray(numbers);
        }

        @Test
        public void testMergeSort() {
                long startTime = System.currentTimeMillis();

                MergeSort sorter = new MergeSort();
                sorter.sort(numbers);

                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.println("Mergesort " );
               printArray(numbers);

                for (int i = 0; i < numbers.length - 1; i++) {
                        if (numbers[i] > numbers[i + 1]) {
                                fail("Should not happen");
                        }
                }
                assertTrue(true);

        }

        @Test
        public void itWorksRepeatably() {
                for (int i = 0; i < 200; i++) {
                        numbers = new Integer[SIZE];
                        Random generator = new Random();
                        for (int a = 0; a < numbers.length; a++) {
                                numbers[a] = generator.nextInt(MAX);
                        }
                        MergeSort sorter = new MergeSort();
                        sorter.sort(numbers);
                        for (int j = 0; j < numbers.length - 1; j++) {
                                if (numbers[j] > numbers[j + 1]) {
                                        fail("Should not happen");
                                }
                        }
                        assertTrue(true);
                }
        }

        @Test
        public void testStandardSort() {
                long startTime = System.currentTimeMillis();
                Arrays.sort(numbers);
                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.println("Standard Java sort " + elapsedTime);

                for (int i = 0; i < numbers.length - 1; i++) {
                        if (numbers[i] > numbers[i + 1]) {
                                fail("Should not happen");
                        }
                }
                assertTrue(true);
        }
        
        
        private static void printArray(Integer[] anArray) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < anArray.length; i++) {
               if (i > 0) {
                  sb.append(", ");
               }
               sb.append(anArray[i]);
            }
            System.out.println(sb.toString());
         }

}