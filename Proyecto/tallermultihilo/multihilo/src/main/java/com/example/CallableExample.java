package com.example;

/**
 Explicación:
 
Se crea un ExecutorService con un pool de 2 hilos.
Se define una tarea Callable que calcula la suma de los números del 0 al 4, pausando por 1 segundo entre cada iteración.
La tarea se envía al pool de hilos utilizando executor.submit(), y se recibe un Future que representará el resultado de la tarea.
future.get() se utiliza para obtener el resultado de la tarea una vez que se ha completado.
executor.shutdown() finaliza el pool de hilos una vez que todas las tareas han sido completadas.
 */


 import java.util.concurrent.Callable;
 import java.util.concurrent.ExecutionException;
 import java.util.concurrent.ExecutorService;
 import java.util.concurrent.Executors;
 import java.util.concurrent.Future;
 
 public class CallableExample {
     public static void main(String[] args) {
         ExecutorService executor = Executors.newFixedThreadPool(2); // Crea un pool de 2 hilos
 
         Callable<Integer> task = () -> {
             int sum = 0;
             for (int i = 0; i < 5; i++) {
                 sum += i;
                 try {
                     Thread.sleep(1000); // Pausa el hilo por 1 segundo
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             return sum; // Retorna la suma de los números
         };
 
         Future<Integer> future = executor.submit(task); // Envía la tarea y recibe un Future
 
         try {
             Integer result = future.get(); // Obtiene el resultado de la tarea
             System.out.println("Sum: " + result); // Imprime el resultado
         } catch (InterruptedException | ExecutionException e) {
             e.printStackTrace();
         }
 
         executor.shutdown(); // Finaliza el pool de hilos
     }
 }
