import java.util.Scanner;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Director director = new Director();
        Scanner scn = new Scanner(System.in);
        Builder builder = null;

        int flag = 0;
        do {
            System.out.println("Press 'O' to open an order, 'E' to exit");
            String input = scn.nextLine();
            if (input.equalsIgnoreCase("O")) {
                flag = 1;
            }
            else if (input.equalsIgnoreCase("E")) {
                flag = 0;
            }
            else {
                System.out.println("Invalid command");
                continue;
            }

            if (flag == 0) break;

                int flag2 = 0;
                do {
                    System.out.println("What type of PC do you want to build?");
                    System.out.println("1. AMD Ryzen Gaming PC");
                    System.out.println("2. Intel 11th Generation Core i5 PC");
                    System.out.println("3. Intel 11th Generation Core i7 PC");
                    System.out.println("4. Intel 11th Generation Core i9 PC");
                    System.out.println("Press 'E' to cancel and exit");
                    input = scn.nextLine();
                    if (input.equalsIgnoreCase("1")) {
                        builder = director.buildPC("gaming");
                        flag2 = 1;
                    }
                    else if (input.equalsIgnoreCase("2")) {
                        builder = director.buildPC("Corei5");
                        flag2 = 1;
                    }
                    else if (input.equalsIgnoreCase("3")) {
                        builder = director.buildPC("Corei7");
                        flag2 = 1;
                    }
                    else if (input.equalsIgnoreCase("4")) {
                        builder = director.buildPC("Corei9");
                        flag2 = 1;
                    }
                    else if (input.equalsIgnoreCase("E")) {
                        flag = 0;
                        break;
                    }
                    else if (input.equalsIgnoreCase("O")) {
                        System.out.println("Sorry, an order is already under process");
                        flag = 0;

                    }
                    else {
                        System.out.println("Invalid command\n");
                        flag2 = 0;
                    }
                } while (flag2 == 0);

                if (flag == 0) break;


                PC pc = builder.getPC();
                System.out.println("Currently you have the following configuration:");
                pc.print();

                do {
                    System.out.println("What type of RAM do you want to add to your PC?");
                    System.out.println("1. 8 GB DDR4 RAM, 2666 MHz");
                    System.out.println("2. 8 GB DDR4 RAM, 3200 MHz");
                    System.out.println("Press 'C' if you do not want to add RAM");
                    input = scn.nextLine();
                    if (input.equalsIgnoreCase("1")) {
                        builder.addRAM(new DDR4_2666());
                        System.out.println("RAM added");
                        flag2 = 0;
                    }
                    else if (input.equalsIgnoreCase("2")) {
                        builder.addRAM(new DDR4_3200());
                        System.out.println("RAM added");
                        flag2 = 0;
                    }
                    else if (input.equalsIgnoreCase("C")) {
                        flag2 = 1;
                    }
                    else if (input.equalsIgnoreCase("O")) {
                        System.out.println("Sorry, an order is already under process");
                        flag = 0;

                    }
                    else {
                        System.out.println("Invalid command\n");
                        flag2 = 0;
                    }
                } while (flag2 == 0);

                System.out.println("Currently you have the following configuration:");
                pc.print();

                do {
                    System.out.println("What type of Graphics Card do you want to add to your PC?");
                    System.out.println("1. 2 GB");
                    System.out.println("2. 4 GB");
                    System.out.println("Press 'C' if you do not want to add Graphics Card");
                    input = scn.nextLine();
                    if (input.equalsIgnoreCase("1")) {
                        builder.addGraphicsCard(new Graphics_2());
                        System.out.println("Graphics Card added");
                        flag2 = 0;
                    }
                    else if (input.equalsIgnoreCase("2")) {
                        builder.addGraphicsCard(new Graphics_4());
                        System.out.println("Graphics card added");
                        flag2 = 0;
                    }
                    else if (input.equalsIgnoreCase("C")) {
                        flag2 = 1;
                    }
                    else if (input.equalsIgnoreCase("O")) {
                        System.out.println("Sorry, an order is already under process");
                        flag = 0;

                    }
                    else {
                        System.out.println("Invalid command\n");
                        flag2 = 0;
                    }
                } while (flag2 == 0);

                System.out.println("Congratulations! You have bought the following PC:");
                pc.print();

        } while (flag == 1);

    }
}
