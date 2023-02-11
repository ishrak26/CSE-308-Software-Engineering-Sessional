import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        HashMap<String, Component> developers = new HashMap<>();
        HashMap<String, Composite> managers = new HashMap<>();
        HashMap<String, Composite> companies = new HashMap<>();
        while (true) {
            System.out.println("1. Create a new component");
            System.out.println("2. View details of an existing component");
            System.out.println("3. View hierarchy of Software Company/Project Manager");
            System.out.println("4. Remove an existing component");
            System.out.println("5. Exit");
            int inp = scn.nextInt();
            scn.nextLine();
            if (inp == 1) {
                while (true) {
                    System.out.println("What type of component do you want to create?");
                    System.out.println("1. Software Company");
                    System.out.println("2. Project Manager");
                    System.out.println("3. Developer");
                    System.out.println("4. Cancel");
                    inp = scn.nextInt();
                    scn.nextLine();
                    if (inp < 1 || inp > 4) {
                        System.out.println("Invalid input! Try again.");
                    } else if (inp == 4) {
                        break;
                    } else {
                        if (inp == 1) {
                            System.out.println("Enter the name of the Software Company: ");
                            String name = scn.nextLine();
                            if (companies.containsKey(name)) {
                                System.out.println("Unable to create Software Company " + name + ". A Software Company" +
                                        " already exists with this name.");
                                companies.get(name).getDetails();
                            } else {
                                companies.put(name, new Company(name));
                                System.out.println("Software Company " + name + " created successfully.");
                            }
                        } else if (inp == 2) {
                            if (companies.isEmpty()) {
                                System.out.println("You have to create a Software Company first!");
                            } else {
                                System.out.println("Enter the name of the Project Manager: ");
                                String name = scn.nextLine();

                                if (managers.containsKey(name)) {
                                    System.out.println("Unable to create Project Manager " + name + ". A Project Manager" +
                                            " already exists with this name.");
                                    managers.get(name).getDetails();
                                } else {
                                    while (true) {
                                        System.out.println("Which company do you want to assign to this Project Manager?");
                                        System.out.println("Current Software Companies: ");
                                        displayCompanies(companies);
                                        System.out.println("Enter Software Company name: ");
                                        String companyName = scn.nextLine();
                                        if (companies.containsKey(companyName)) {
                                            System.out.println("Enter the project name for this Project Manager: ");
                                            String projectName = scn.nextLine();
                                            managers.put(name, new Manager(name, projectName));
                                            companies.get(companyName).addComponent(managers.get(name));
                                            System.out.println("Project Manager " + name + " created successfully.");
                                            break;
                                        } else {
                                            System.out.println("No Software Company named " + companyName + " exists.");
                                        }
                                    }
                                }
                            }
                        } else {
                            if (managers.isEmpty()) {
                                System.out.println("You have to create a Project Manager first!");
                            } else {
                                System.out.println("Enter the name of the Developer: ");
                                String name = scn.nextLine();

                                if (developers.containsKey(name)) {
                                    System.out.println("Unable to create Developer " + name + ". A Developer" +
                                            " already exists with this name.");
                                    developers.get(name).getDetails();
                                } else {
                                    while (true) {
                                        System.out.println("Which Project Manager do you want to assign to this Developer?");
                                        System.out.println("Current Project Managers: ");
                                        displayManagers(managers);
                                        System.out.println("Enter Project Manager name: ");
                                        String managerName = scn.nextLine();
                                        if (managers.containsKey(managerName)) {
                                            developers.put(name, new Developer(name, (Personnel) managers.get(managerName)));
                                            managers.get(managerName).addComponent(developers.get(name));
                                            System.out.println("Developer " + name + " created successfully.");
                                            break;
                                        } else {
                                            System.out.println("No Project Manager named " + managerName + " exists.");
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            } else if (inp == 2) {
                // view details
                while (true) {
                    System.out.println("What type of component do you want to see details of?");
                    System.out.println("1. Software Company");
                    System.out.println("2. Project Manager");
                    System.out.println("3. Developer");
                    System.out.println("4. Cancel");
                    inp = scn.nextInt();
                    scn.nextLine();
                    if (inp == 1) {
                        displayCompanies(companies);
                        System.out.println("Enter the name of the Software Company: ");
                        String name = scn.nextLine();
                        if (companies.containsKey(name)) {
                            companies.get(name).getDetails();
                        } else {
                            System.out.println("No Software Company with the name " + name + " exists.");
                        }
                    } else if (inp == 2) {
                        displayManagers(managers);
                        System.out.println("Enter the name of the Project Manager: ");
                        String name = scn.nextLine();
                        if (managers.containsKey(name)) {
                            managers.get(name).getDetails();
                        } else {
                            System.out.println("No Project Manager with the name " + name + " exists.");
                        }
                    } else if (inp == 3) {
                        displayDevelopers(developers);
                        System.out.println("Enter the name of the Developer: ");
                        String name = scn.nextLine();
                        if (developers.containsKey(name)) {
                            developers.get(name).getDetails();
                        } else {
                            System.out.println("No Developer with the name " + name + " exists.");
                        }
                    } else if (inp != 4) {
                        System.out.println("Invalid input! Try again.");
                        continue;
                    }
                    break;
                }
            } else if (inp == 3) {
                // view hierarchy
                while (true) {
                    System.out.println("Choose the type you want to see the hierarchy of?");
                    System.out.println("1. Software Company");
                    System.out.println("2. Project Manager");
                    System.out.println("3. Cancel");
                    inp = scn.nextInt();
                    scn.nextLine();
                    if (inp == 1) {
                        displayCompanies(companies);
                        System.out.println("Enter the name of the Software Company: ");
                        String name = scn.nextLine();
                        if (companies.containsKey(name)) {
                            companies.get(name).getHierarchy();
                        } else {
                            System.out.println("No Software Company with the name " + name + " exists.");
                        }
                    } else if (inp == 2) {
                        displayManagers(managers);
                        System.out.println("Enter the name of the Project Manager: ");
                        String name = scn.nextLine();
                        if (managers.containsKey(name)) {
                            managers.get(name).getHierarchy();
                        } else {
                            System.out.println("No Project Manager with the name " + name + " exists.");
                        }
                    } else if (inp != 3) {
                        System.out.println("Invalid input! Try again.");
                        continue;
                    }
                    break;
                }
            } else if (inp == 4) {
                while (true) {
                    System.out.println("What type of component do you want to remove?");
                    System.out.println("1. Software Company");
                    System.out.println("2. Project Manager");
                    System.out.println("3. Developer");
                    System.out.println("4. Cancel");
                    inp = scn.nextInt();
                    scn.nextLine();
                    if (inp == 1) {
                        displayCompanies(companies);
                        System.out.println("Enter the name of the Software Company: ");
                        String name = scn.nextLine();
                        if (companies.containsKey(name)) {
                            companies.get(name).remove();
                            companies.remove(name);
                        } else {
                            System.out.println("No Software Company with the name " + name + " exists.");
                        }
                    } else if (inp == 2) {
                        displayManagers(managers);
                        System.out.println("Enter the name of the Project Manager: ");
                        String name = scn.nextLine();
                        if (managers.containsKey(name)) {
                            managers.get(name).remove();
                            managers.remove(name);
                        } else {
                            System.out.println("No Project Manager with the name " + name + " exists.");
                        }
                    } else if (inp == 3) {
                        displayDevelopers(developers);
                        System.out.println("Enter the name of the Developer: ");
                        String name = scn.nextLine();
                        if (developers.containsKey(name)) {
                            developers.get(name).remove();
                            developers.remove(name);
                        } else {
                            System.out.println("No Developer with the name " + name + " exists.");
                        }
                    } else if (inp != 4) {
                        System.out.println("Invalid input! Try again.");
                        continue;
                    }
                    break;
                }
            } else if (inp == 5) {
                break;
            } else {
                System.out.println("Invalid input! Try again.");
            }
        }
    }

    public static void displayCompanies(HashMap<String, Composite> companies) {
        for (String company : companies.keySet()) {
            System.out.println(company + " ");
        }
    }

    public static void displayManagers(HashMap<String, Composite> managers) {
        for (String manager : managers.keySet()) {
            System.out.println(manager + " ");
        }
    }

    public static void displayDevelopers(HashMap<String, Component> developers) {
        for (String developer : developers.keySet()) {
            System.out.println(developer + " ");
        }
    }
}