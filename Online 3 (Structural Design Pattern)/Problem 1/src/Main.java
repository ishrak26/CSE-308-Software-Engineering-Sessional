import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EnglishSpeech englishSpeech = new EnglishSpeech();
        BanglaSpeech banglaSpeech = new BanglaSpeech();
        Speech banglaSpeechAdapter = new BanglaSpeechAdapter(banglaSpeech);
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your speech: ");
            String inp = scn.nextLine();
            if (banglaSpeech.checkBangla(inp)) {
                translate(banglaSpeechAdapter, inp);
            }
            else {
                translate(englishSpeech, inp);
            }
        }
    }

    public static void translate(Speech speech, String text) {
        System.out.println(speech.getText(text));
    }
}