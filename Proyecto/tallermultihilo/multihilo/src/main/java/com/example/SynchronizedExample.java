package com.example;

/**
Se define un método increment() que incrementa un contador de manera sincronizada.
Dos hilos ejecutan una tarea que llama al método increment() 1000 veces.
thread1.join() y thread2.join() aseguran que el programa principal espere a que ambos hilos terminen antes de continuar.
El valor final del contador se imprime al final.
 *
 */
public class SynchronizedExample  
{

    private static int counter = 0;

    public static synchronized void increment() {
        counter++;
    }

    public static void main( String[] args )
    {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                increment(); // Incrementa el contador de manera sincronizada
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // Espera a que thread1 termine
            thread2.join(); // Espera a que thread2 termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter); // Imprime el valor final del contador
    }
}
