import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    final String folderSave = "Result"; // Папка для хранения.
    final String currentDir = System.getProperty("user.dir");// Текущее расположение приложения.............

    public void SaveFile(Item object) throws IOException {
        var path = GetPath(); // получить путь папки
        CreateDirectory(path); // Создать каталог папок
        FileFamily fileFamily = File(path, object.getFamily()); // Создать файл по фамилии

        FileWriter writer = new FileWriter(fileFamily.getFile(), true);
        var text = fileFamily.getRecordDelemiter() +
                "<" + object.getFamily() + ">" +
                "<" + object.getName() + ">" +
                "<" + object.getOtchestvo() + ">" +
                "<" + object.getDR() + ">" +
                "<" + object.getPhone() + ">" +
                "<" + object.getSex() + ">";
        writer.write(text);
        writer.flush();
        writer.close();
    }

    private FileFamily File(String path, String family) throws IOException {
        FileFamily result = new FileFamily();

        var fileFamily = new File(path + "\\" + family + ".txt");
        result.setFile(fileFamily);

        var recordDelemiter = "\n";
        if (!fileFamily.exists()) {
            fileFamily.createNewFile();
            recordDelemiter = "";
        }
        result.setRecordDelemiter(recordDelemiter);

        return result;
    }

    private void CreateDirectory(String path) {
        var directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    private String GetPath() {
        return currentDir + "\\" + folderSave;
    }
}

class FileFamily {
    private File file;
    private String recordDelemiter;

    public void setFile(File value) {
        file = value;
    }

    public File getFile() {
        return file;
    }

    public void setRecordDelemiter(String value) {
        recordDelemiter = value;
    }

    public String getRecordDelemiter() {
        return recordDelemiter;
    }
}
