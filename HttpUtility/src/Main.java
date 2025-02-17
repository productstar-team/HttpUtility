public class Main {
    public static void main(String[] args) {
        try {
            // ---------- Вызов GET-запроса ----------
            String getUrl = "https://jsonplaceholder.typicode.com/posts/1"; // Тестовый API для GET-запроса
            System.out.println("Отправка GET-запроса...");
            String getResponse = HttpUtility.sendGetRequest(getUrl); // Выполнение GET-запроса
            System.out.println("Ответ от сервера (GET):");
            System.out.println(getResponse); // Вывод ответа на GET-запрос
            System.out.println();

            // ---------- Вызов POST-запроса ----------
            String postUrl = "https://jsonplaceholder.typicode.com/posts"; // Тестовый API для POST-запроса
            String jsonPayload = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }"; // JSON-данные для отправки

            System.out.println("Отправка POST-запроса...");
            String postResponse = HttpUtility.sendPostRequest(postUrl, jsonPayload); // Выполнение POST-запроса
            System.out.println("Ответ от сервера (POST):");
            System.out.println(postResponse); // Вывод ответа на POST-запрос


        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}