import java.util.HashSet;
import java.util.Set;

public class Company implements Composite {
    private String name;
    private Set<Composite> managers;

    public Company(String name) {
        this.name = name;
        managers = new HashSet<>();
    }

    @Override
    public void getDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Number of Project Managers: " + getComponentCount());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getHierarchy() {
        System.out.println("- " + getName());
        for (Composite manager : managers) {
            manager.getHierarchy();
        }
    }

    @Override
    public void addComponent(Component component) {
        if (component instanceof Composite) {
            boolean ret = managers.add((Composite) component);
            if (!ret) {
                System.out.println("Unable to add Project Manager " + component.getName() + ". A Project " +
                        "Manager named " + component.getName() + " already exists in the Software Company " + getName());
            }
        }
        else {
            System.out.println("Unable to add Project Manager " + component.getName() + ". " +
                    component.getName() + " is not a Project Manager.");
        }
    }

    @Override
    public void removeComponent(Component component) {
        boolean ret = managers.remove(component);
        if (!ret) {
            System.out.println("Unable to remove Project Manager " + component.getName() + ". No Project " +
                    "Manager named " + component.getName() + " exists in the Software Company " + getName());
        }
    }

    @Override
    public int getComponentCount() { // total number of running projects
        return managers.size();
    }

    @Override
    public void remove() {
        for (Composite manager : managers) {
            manager.remove();
        }
        System.out.println("Software Company " + getName() + " has been removed successfully.");
    }
}
