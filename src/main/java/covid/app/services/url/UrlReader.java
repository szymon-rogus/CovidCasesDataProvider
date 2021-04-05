package covid.app.services.url;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
public class UrlReader {

    private URL urlReader;

    public UrlReader(String url) {
        try {
            urlReader = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public URLConnection getConnection() throws IOException {
        return urlReader.openConnection();
    }

    public List<List<String>> readFile() {
        List<List<String>> allData = new LinkedList<>();
        InputStreamReader input = null;
        try {
            input = new InputStreamReader(getConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert input != null;
        BufferedReader bufferedReader = new BufferedReader(input);
        String line = null;
        try {
            bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert line != null;
            allData.add(new LinkedList<>(Arrays.asList(line.split(","))));
        }
        return allData;
    }
}
