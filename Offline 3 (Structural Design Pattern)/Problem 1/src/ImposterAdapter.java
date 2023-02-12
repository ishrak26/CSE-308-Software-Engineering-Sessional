public class ImposterAdapter implements Passenger {
    private Imposter imposter;

    public ImposterAdapter(Imposter imposter) {
        this.imposter = imposter;
    }

    @Override
    public void maintainSpaceship() {
        imposter.damageSpaceship();
    }
}
