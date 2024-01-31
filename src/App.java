import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Домашнее задание по Семинару 5");

        // Задание 1. Написать функцию, создающую резервную копию всех файлов в
        // директории(без поддиректорий) во вновь созданную папку ./backup
        String sourceDirectory = "C:\\Users\\USER\\Desktop\\GB\\DZ_JC\\DZ5_JC";
        Path sourcePath = Paths.get(sourceDirectory);
        String destinationDirectory = "C:\\\\backup";
        Path destinationPath = Paths.get(destinationDirectory);
        BackupFiles.backupFiles(sourcePath, destinationPath);

        // Задание 2. Предположить, что числа в исходном массиве из 9 элементов имеют
        // диапазон[0, 3],
        // и представляют собой, например, состояния ячеек поля для игры в
        // крестикинолики, где 0 – это пустое поле,
        // 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
        // Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
        // Записать в файл 9 значений так,
        // чтобы они заняли три байта.

        String[] arr = new String[] { "1", "3", "2", "0", "0", "2", "3", "1", "1" };

        int num1 = Integer.parseInt(arr[0] + arr[1] + arr[2]);
        int num2 = Integer.parseInt(arr[3] + arr[4] + arr[5]);
        int num3 = Integer.parseInt(arr[6] + arr[7] + arr[8]);

        byte byteValue1 = (byte) num1;
        byte byteValue2 = (byte) num2;
        byte byteValue3 = (byte) num3;

        try (FileOutputStream f = new FileOutputStream("file.bin")) {
            f.write(byteValue1);
            f.write(byteValue2);
            f.write(byteValue3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Задание 3. Написать функцию, добавляющую префикс к каждому из набора файлов,
        // названия которых переданы ей в качестве параметров через пробел.

        // цикл обрабатывающий названия файлов методом addPrefix
        for (String filename : args) {
            try {
                addPrefix(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // метод addPrefix создает новый файл с префиксом “prefix_” перед именем файла.
    private static void addPrefix(String filename) throws IOException {
        String prefix = "prefix_";
        File file = new File(prefix + filename);

        // удалить файл, если уже существует
        if (file.exists()) {

            file.delete();

        }

        System.out.println(prefix + " " + filename + " добавлен.");
    }

}