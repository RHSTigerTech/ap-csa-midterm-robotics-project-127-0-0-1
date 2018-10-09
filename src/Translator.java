
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class Translator {

    // here is some stuff from the web
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    // i won't take credit for this.
    // basically you input a url and it gives back the json output
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    // this method will use above functions to translate text
    // input src and dest are the 2 character language codes, txt is any string to be translated
    public static String translate(String src, String dest, String txt) throws JSONException, IOException {

        // build request url from input
        String url = "https://us-central1-universalchat-site.cloudfunctions.net/midterm-translator?src="+src+"&dest="+dest+"&txt="+URLEncoder.encode(txt, "UTF-8");

        // submit request to url and store output
        JSONObject output = readJsonFromUrl(url);

        // return the translated text
        return output.get("translated").toString();

    }
}