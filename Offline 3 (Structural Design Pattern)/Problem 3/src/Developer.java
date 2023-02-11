public class Developer extends Personnel implements Component  {
    private String name;
    private Personnel manager;

    public Developer(String name, Personnel manager) {
        this.name = name;
        this.manager = manager;
        role = "Developer";
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
    }
}
