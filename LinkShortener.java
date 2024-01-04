

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkShortener {
    private static final String BASE_URL = "http://short.url/";
    private static final int SHORT_CODE_LENGTH = 6;
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Map<String, String> shortToLongUrlMap = new HashMap<>();
    private Map<String, String> longToShortUrlMap = new HashMap<>();

    public String shortenUrl(String longUrl) {
        if (longToShortUrlMap.containsKey(longUrl)) {
            return longToShortUrlMap.get(longUrl);
        }

        String shortCode = generateShortCode();
        String shortUrl = BASE_URL + shortCode;

        while (shortToLongUrlMap.containsKey(shortCode)) {
            shortCode = generateShortCode();
            shortUrl = BASE_URL + shortCode;
        }

        shortToLongUrlMap.put(shortCode, longUrl);
        longToShortUrlMap.put(longUrl, shortUrl);

        return shortUrl;
    }

    public String expandUrl(String shortUrl) {
        String shortCode = shortUrl.substring(BASE_URL.length());
        return shortToLongUrlMap.getOrDefault(shortCode, "URL not found");
    }

    private String generateShortCode() {
        Random random = new Random();
        StringBuilder shortCode = new StringBuilder();

        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            shortCode.append(CHARACTERS.charAt(index));
        }

        return shortCode.toString();
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();

        
//        String longUrl = "https://www.example.com";
        String longUrl ="http://chart.apis.google.com/chart?chs=500x500&chma=0,0,100,100&cht=p&chco=FF0000%2CFFFF00%7CFF8000%2C00FF00%7C00FF00%2C0000FF&chd=t%3A122%2C42%2C17%2C10%2C8%2C7%2C7%2C7%2C7%2C6%2C6%2C6%2C6%2C5%2C5&chl=122%7C42%7C17%7C10%7C8%7C7%7C7%7C7%7C7%7C6%7C6%7C6%7C6%7C5%7C5&chdl=android%7Cjava%7Cstack-trace%7Cbroadcastreceiver%7Candroid-ndk%7Cuser-agent%7Candroid-webview%7Cwebview%7Cbackground%7Cmultithreading%7Candroid-source%7Csms%7Cadb%7Csollections%7Cactivity|Chart";

        String shortUrl = linkShortener.shortenUrl(longUrl);
        System.out.println("Shortened URL: " + shortUrl);

        String expandedUrl = linkShortener.expandUrl(shortUrl);
        System.out.println("Expanded URL: " + expandedUrl);
    }
}
