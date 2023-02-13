public class BanglaSpeechAdapter implements Speech {
    private BanglaSpeech banglaSpeech;

    public BanglaSpeechAdapter(BanglaSpeech banglaSpeech) {
        this.banglaSpeech = banglaSpeech;
    }

    @Override
    public String getText(String text) {
        text = banglaSpeech.translateSpeech(text);
        return text;
    }
}
