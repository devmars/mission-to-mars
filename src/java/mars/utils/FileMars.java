package mars.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileMars {
    public List<String> readFile(String phase) {
        List<String> items = new ArrayList<>();
        File archivo = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            StringBuilder fileName = new StringBuilder().append(Constans.path).append(phase);
            archivo = new File(String.valueOf(fileName));
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


