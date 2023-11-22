package org.info23;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Exportar_CSV {

    // clase para exportar la lista de clientes al archivo CSV
    public static void exportarCSV(List<Cliente> banco) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./lista.csv"))) {

            // Escribe los headers del CSV
            writer.write("Nombre,DNI\n");

            // Iterar sobre la lista de clientes y escribe cada cliente en una nueva línea

            for (Cliente cliente : banco) {
                String linea = cliente.getTitular() + "," + cliente.getDni() + "\n";
                writer.write(linea);
            }

            System.out.println("Exportación exitosa a " + "./lista.csv");

        } catch (IOException e) {
            System.err.println("Error al exportar a CSV: " + e.getMessage());
        }
    }
}