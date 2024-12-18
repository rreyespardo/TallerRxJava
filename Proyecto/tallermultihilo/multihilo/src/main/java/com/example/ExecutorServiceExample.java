package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 Explicación:

Se crea un ExecutorService con un pool de 2 hilos.
Se definen dos tareas Runnable que imprimen un contador de 0 a 4, pausando por 1 segundo entre cada impresión.
Las tareas se envían al pool de hilos utilizando executor.submit().
executor.shutdown() finaliza el pool de hilos una vez que todas las tareas han sido completadas.
 *
 */


public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Crea un pool de 2 hilos

        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 1: " + i);
                try {
                    Thread.sleep(1000); // Pausa el hilo por 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 2: " + i);
                try {
                    Thread.sleep(1000); // Pausa el hilo por 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        executor.submit(task1); // Envía la tarea 1 al pool de hilos
        executor.submit(task2); // Envía la tarea 2 al pool de hilos

        executor.shutdown(); // Finaliza el pool de hilos una vez completadas las tareas
    }
}