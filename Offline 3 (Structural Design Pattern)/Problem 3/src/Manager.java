import java.util.HashSet;
import java.util.Set;

public class Manager extends Personnel implements Composite {
    private String name;
    private Set<Component> developers;
    private String currentProject;

    public Manager(String name, String currentProject) {
        this.name = name;
        developers = new HashSet<>();
        role = "Project Manager";
        this.currentProject = currentProject;
    }

    @Override
    public void getDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Role: " + getRole());
        System.out.println("Current Project: " + getCurrentProject());
        System.out.println("Number of Supervisees: " + getComponentCount());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getHierarchy() {
        System.out.println("\t- " + getName() + " (" + getCurrentProject() + ")");
        for (Component developer : developers) {
            System.out.println("\t\t- " + developer.getName());
        }
    }

    @Override
    public void addComponent(Component component) {
        boolean ret = developers.add(component);
        if (!ret) {
            System.out.println("Unable to add Developer " + component.getName() + ". A Developer " +
                    "named " + component.getName() + " already exists under the Project Manager " + getName());
        }
    }

    @Override
    public void removeComponent(Component component) {
        boolean ret = developers.remove(component);
        if (!ret) {
            System.out.println("Unable to remove Developer " + component.getName() + ". No Developer " +
                    "named " + component.getName() + " exists under the Project Manager " + getName());
        }
    }

    @Override
    public int getComponentCount() {
        return developers.size();
    }

    @Override
    public String getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(String currentProject) {
        this.currentProject = currentProject;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void remove() {
        for (Component developer: developers) {
            developer.remove();
        }
        System.out.println("Project Manager " + getName() + " has been removed successfully.");
    }
}
