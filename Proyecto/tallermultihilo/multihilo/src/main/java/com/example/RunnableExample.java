package com.example;

/**
 Explicación:

Se define una tarea Runnable que imprime un contador de 0 a 4, pausando por 1 segundo entre cada impresión.
Se crea un nuevo hilo utilizando el Runnable como argumento para el constructor de Thread.
thread.start() inicia la ejecución del hilo.
 *
 */
public class RunnableExample  
{
    public static void main( String[] args )
    {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Runnable: " + i);
                try {
                    Thread.sleep(1000); // Pausa el hilo por 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(task); // Crea un hilo con el Runnable
        thread.start(); // Inicia el hilo
    }
}