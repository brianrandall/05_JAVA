import java.util.HashMap;

public class MapOfHash {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("freebird", "im a freebird");
        trackList.put("freebird 2", "im also a freebird");
        trackList.put("freebird 3", "doodoodoo bird doodoo");
        trackList.put("freebird 4", "pizza tomato potato");

        String song = trackList.get("freebird");
            System.out.println(song);

        System.out.println("");    


        // print keys : values

        for (String key : trackList.keySet()) {
            System.out.println(key + " : " + trackList.get(key));
        }
    } 
}
