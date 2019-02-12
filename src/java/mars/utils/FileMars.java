package mars.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileMars {
    private static final ClassLoader loader = Constans.class.getClassLoader();

    public List<String> readFile(String phase) {
        List<String> items = new ArrayList<>();

        try {
            InputStream stream = loader.getResourceAsStream(phase);
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(stream)));

            String line;
            while ((line = reader.readLine()) != null){
                items.add(line);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return items;
    }
}


