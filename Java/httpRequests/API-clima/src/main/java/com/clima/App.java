
package com.clima;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {

    private static final String URL =
        "https://api.open-meteo.com/v1/forecast"
        + "?latitude=40.4168"
        + "&longitude=-3.7038"
        + "&current=temperature_2m"
        + ",relative_humidity_2m"
        + ",apparent_temperature"
        + ",weather_code"
        + ",wind_speed_10m"
        + "&timezone=Europe%2FMadrid";

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("       CLIMA DE MADRID");
        System.out.println("=================================");

        // 1. Crear cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();

        // 2. Construir solicitud GET
        HttpRequest solicitud = HttpRequest.newBuilder()
            .uri(URI.create(URL))
            .header("Accept", "application/json")
            .GET()
            .build();

        try {

            // 3. Enviar solicitud y recibir respuesta
            HttpResponse<String> respuesta =
                cliente.send(
                    solicitud,
                    HttpResponse.BodyHandlers.ofString()
                );

            // 4. Comprobar código HTTP
            System.out.println("Estado HTTP: " +
                respuesta.statusCode());

            if (respuesta.statusCode() != 200) {
                System.out.println("Error al consultar la API.");
                System.out.println(respuesta.body());
                return;
            }

            // 5. Guardar evidencia de la respuesta
            Files.writeString(
                Path.of("evidencias", "respuesta_api.json"),
                respuesta.body()
            );

            Files.writeString(
                Path.of("evidencias", "solicitud_api.txt"),
                URL
            );

            // 6. Procesar JSON con Gson
            JsonObject json = JsonParser
                .parseString(respuesta.body())
                .getAsJsonObject();

            JsonObject actual = json.getAsJsonObject("current");

            // 7. Extraer información meteorológica
            String fecha = actual.get("time").getAsString();

            double temperatura = actual
                .get("temperature_2m").getAsDouble();

            int humedad = actual
                .get("relative_humidity_2m").getAsInt();

            double sensacion = actual
                .get("apparent_temperature").getAsDouble();

            int codigoClima = actual
                .get("weather_code").getAsInt();

            double viento = actual
                .get("wind_speed_10m").getAsDouble();

            // 8. Mostrar resultados
            System.out.println();
            System.out.println("Ciudad: Madrid, España");
            System.out.println("Fecha y hora: " + fecha);
            System.out.println("---------------------------------");

            System.out.println("Temperatura: " +
                temperatura + " °C");

            System.out.println("Sensación térmica: " +
                sensacion + " °C");

            System.out.println("Humedad: " +
                humedad + " %");

            System.out.println("Velocidad del viento: " +
                viento + " km/h");

            System.out.println("Condición climática: " +
                describirClima(codigoClima));

            System.out.println("---------------------------------");
            System.out.println("Consulta realizada correctamente.");

        } catch (IOException e) {

            System.out.println("Error de conexión: " +
                e.getMessage());

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println("La consulta fue interrumpida.");

        } catch (Exception e) {

            System.out.println("Error al procesar la respuesta: " +
                e.getMessage());
        }
    }

    // Traducción de códigos meteorológicos WMO
    private static String describirClima(int codigo) {

        return switch (codigo) {
            case 0 -> "Cielo despejado";
            case 1 -> "Mayormente despejado";
            case 2 -> "Parcialmente nublado";
            case 3 -> "Nublado";
            case 45, 48 -> "Niebla";
            case 51, 53, 55 -> "Llovizna";
            case 56, 57 -> "Llovizna helada";
            case 61, 63, 65 -> "Lluvia";
            case 66, 67 -> "Lluvia helada";
            case 71, 73, 75, 77 -> "Nieve";
            case 80, 81, 82 -> "Chubascos";
            case 85, 86 -> "Chubascos de nieve";
            case 95, 96, 99 -> "Tormenta";
            default -> "Condición no identificada (código " +
                codigo + ")";
        };
    }
}
