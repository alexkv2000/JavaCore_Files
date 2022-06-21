import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        String path = "D:";
        List<File> folderList = Arrays.asList(
                new File(path),
                new File(path + "//Games"),
                new File(path + "//Games//temp"),
                new File(path + "//Games//src"),
                new File(path + "//Games//res"),
                new File(path + "//Games//savegames"),
                new File(path + "//Games//src//main"),
                new File(path + "//Games//src//test"),
                new File(path + "//Games//res//drawables"),
                new File(path + "//Games//res//vectors"),
                new File(path + "//Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File(path + "//Games//src//main//Main.java"),
                new File(path + "//Games//src//main//Utils.java"),
                new File(path + "//Games//temp//temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " создан\n");
            else sb.append("Каталог " + folder + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter(path + "//Games//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader(path + "//Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
