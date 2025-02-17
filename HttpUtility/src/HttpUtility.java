import java.io.*;
import java.net.*;

public class HttpUtility {

    // Метод для выполнения GET-запроса
    public static String sendGetRequest(String url) throws Exception {
        // Создание URL-объекта
        URL obj = new URL(url);

        // Открытие соединения
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        // Установка метода запроса: GET
        connection.setRequestMethod("GET");

        // Чтение кода ответа от сервера
        int responseCode = connection.getResponseCode();
        System.out.println("GET-запрос к URL: " + url);
        System.out.println("Код ответа: " + responseCode);

        // Чтение ответа сервера
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Возвращаем тело ответа
        return response.toString();
    }

    // Метод для выполнения POST-запроса
    public static String sendPostRequest(String url, String jsonPayload) throws Exception {
        // Создание URL-объекта
        URL obj = new URL(url);

        // Открытие соединения
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        // Установка метода запроса: POST
        connection.setRequestMethod("POST");

        // Установка необходимых заголовков (JSON)
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");

        // Указание, что запрос содержит тело
        connection.setDoOutput(true);

        // Запись данных в тело запроса
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonPayload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Чтение кода ответа от сервера
        int responseCode = connection.getResponseCode();
        System.out.println("POST-запрос к URL: " + url);
        System.out.println("Код ответа: " + responseCode);

        // Чтение ответа сервера
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Возвращаем тело ответа
        return response.toString();
    }
}