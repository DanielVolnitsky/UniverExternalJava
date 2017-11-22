package tasks.task4_16_11_2017.helpers;

import org.json.JSONException;
import org.json.JSONObject;
import tasks.task4_16_11_2017.entities.LocationInfo;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Класс предназначен для чтения файла типа .json
 */
public class JsonReader {
    String url;

    public JsonReader(String url) {
        this.url = url;
    }

    /*Возвращает объект JsonReader с готовым для чтения URL*/
    public static JsonReader getDarkSkyJsonWithUrl(LocationInfo locInfo) throws IllegalAccessException {
        return new JsonReader(DarkSkyUrlMaker.getUrl(locInfo));
    }

    public JSONObject getJsonText() {
        JSONObject json = null;
        BufferedReader bufferReader;
        String jsonText;
        try (InputStream inputStream = new URL(url).openStream()) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF8"));
            bufferReader = new BufferedReader(inputStreamReader);
            jsonText = readAll(bufferReader);
            try {
                json = new JSONObject(jsonText);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int ch;
        while ((ch = reader.read()) != -1) {
            stringBuilder.append((char) ch);
        }
        return stringBuilder.toString();
    }
}