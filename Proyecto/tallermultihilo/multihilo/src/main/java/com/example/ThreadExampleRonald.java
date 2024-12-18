package com.example;

/**
Explicación:

Se crea un nuevo hilo utilizando la clase Thread.
La lógica del hilo se define dentro de un bloque Runnable proporcionado al constructor de Thread.
El hilo imprime un contador de 0 a 4, pausando por 1 segundo entre cada impresión.
thread.start() inicia la ejecución del hilo.
 *
 */
public class ThreadExampleRonald
{
    public static void main( String[] args )
    {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: " + i);
                try {
                    Thread.sleep(1000); // Pausa el hilo por 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        );

        thread.start(); // Inicia el hilo
    }
}
