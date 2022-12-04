public abstract class GraphicsCard implements Component {
    public abstract int getStorage();

    @Override
    public String getName() {
        return "Graphics Card";
    }
}
