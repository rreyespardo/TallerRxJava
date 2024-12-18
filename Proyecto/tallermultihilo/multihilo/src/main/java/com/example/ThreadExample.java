package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
Explicación:
 *Vamos a calcular el número de días para un CDT
 para cada flujo, debe evaluar la fecha de inicio y fin y calcular el numero de dpias de cada flujo
 por ejemplo un CDT a 12 meses (fkujos)
 */
public class ThreadExample 
{

    // Método que calcula los días entre dos fechas
    public static int calcularDias(LocalDate fechaInicial, LocalDate fechaFinal, int numeroHilo) {
        
        // Calcular la diferencia en días entre las dos fechas
        long diasEntreFechas = ChronoUnit.DAYS.between(fechaInicial, fechaFinal);
        System.out.println("Hilo: " + numeroHilo + ", Fecha Inicial: " + fechaInicial + ", Fecha Final: " + fechaFinal + " Días entre fechas: " + diasEntreFechas );
        // Retorna el número de días
        return (int) diasEntreFechas;
    }

    // Método que crea los hilos y llama a calcularDias
    public static void calcularFlujos(int numeroFlujos) {

         // Inicializar la fechaInicial fuera del ciclo for
        LocalDate fechaInicial = LocalDate.of(2025, 1, 1);

                 // Crear un bucle que lanza un hilo para cada flujo
        for (int i = 1; i <= numeroFlujos; i++) {
         
            final int numeroHilo = i; // Se debe declarar final para poder usarlo en el hilo
         
            final LocalDate fechaInicialx = fechaInicial.plusDays(30);
            final LocalDate fechaFinal = fechaInicialx.plusDays(30);

            // Crear y arrancar un hilo que ejecuta calcularDias
            Thread hilo = new Thread(() -> {
                calcularDias(fechaInicialx, fechaFinal, numeroHilo);
            });

            // Iniciar el hilo
            hilo.start();

            // Actualizar fechaInicial para la siguiente iteración
            fechaInicial = fechaFinal;
        }
    }


    public static void main( String[] args )
    {
        // Llamar al método calcularFlujos con el número de flujos que quieras
        int numeroFlujos = 12; // Lanzar 12 hilos, 1 por cada flujoo para un CDT de plazo ANUAL
        calcularFlujos(numeroFlujos);
    }
}
