public class Developer extends Personnel implements Component  {
    private String name;
    private Personnel manager;
    private Composite parent;

    public Developer(String name, Personnel manager, Composite parent) {
        this.name = name;
        this.manager = manager;
        role = "Developer";
        this.parent = parent;
    }

    @Override
    public void getDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Role: " + getRole());
        System.out.println("Current Project: " + getCurrentProject());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public String getCurrentProject() {
        return manager.getCurrentProject();
    }

    @Override
    public void remove() {
        System.out.println("Developer " + getName() + " has been removed successfully.");
        parent.removeComponent(this);
    }
}
