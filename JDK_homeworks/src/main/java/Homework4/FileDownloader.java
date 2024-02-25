/*
Создайте приложение, которое скачивает файлы из интернета в несколько потоков.
У пользователя должна быть возможность указать, сколько потоков использовать для загрузки.
 */

package Homework4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {
    public static void main(String[] args) {
        String[] urls = {"http://example.com/file1.txt",
                "http://example.com/file2.txt",
                "http://example.com/file3.txt"};
        int numThreads = 4;  // количество потоков, можно заменить на сканер для ввода с терминала

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (String url : urls) {
            executor.execute(() -> {
                try {
                    downloadFile(url);
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден: " + e.getMessage());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

    private static void downloadFile(String urlStr) throws Exception {

        URL url = new URL(urlStr);
        String fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = url.openStream();
            outputStream = new FileOutputStream(fileName);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Загрузка файла " + fileName + " завершена");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
