public class EnglishSpeech implements Speech {
    @Override
    public String getText(String text) {
        return text.substring(1, text.length()-1);
    }
}
