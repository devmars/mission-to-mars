package mars.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileMars {
    private static final ClassLoader loader = Constans.class.getClassLoader();

    public List<String> readFile(String phase) {
        List<String> items = new ArrayList<>();
        File archivo = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            archivo = new File(Objects.requireNonNull(loader.getResource(phase)).getPath());
            fileReader = new FileReader(archivo);
            bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                items.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileReader) {
                    fileReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return items;
    }
}


