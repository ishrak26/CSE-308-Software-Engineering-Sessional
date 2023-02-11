public interface Composite extends Component {
    public void getHierarchy();
    public void addComponent(Component component);
    public void removeComponent(Component component);
    public int getComponentCount();
}
