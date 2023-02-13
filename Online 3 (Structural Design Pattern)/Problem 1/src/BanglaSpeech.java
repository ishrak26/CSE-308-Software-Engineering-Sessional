import java.util.HashMap;

public class BanglaSpeech {
    HashMap<String, String> translation;

    public BanglaSpeech() {
        translation = new HashMap<>();
        init_Map();
    }

    public boolean checkBangla(String text) {
        String speech = text.substring(1, text.length()-1);
        String[] result = speech.split(" ");
        for (String s : result) {
            if (translation.containsKey(s)) {
                return true;
            }
        }
        return false;
    }

    private void init_Map() {
        translation.put("ami", "i");
        translation.put("amra", "we");
        translation.put("bhat", "rice");
        translation.put("roti", "bread");
        translation.put("khai", "eat");
        translation.put("banai", "prepare");
    }

    public String translateSpeech(String speech) {
        speech = speech.substring(1, speech.length()-1);
        String[] result = speech.split(" ");
        String tmp = result[result.length-1];
        result[result.length-1] = result[result.length-2];
        result[result.length-2] = tmp;
        String newSpeech = new String();
        for (String s : result) {
            newSpeech += " " + translation.get(s.toLowerCase());
        }
        return newSpeech;
    }
}
