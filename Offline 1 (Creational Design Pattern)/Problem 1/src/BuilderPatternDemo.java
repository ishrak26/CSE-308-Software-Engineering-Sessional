import java.util.Scanner;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Director director = new Director();
        Scanner scn = new Scanner(System.in);
        Builder builder = null;
        do {
            System.out.println("What type of PC do you want to build?");
            System.out.println("1. AMD Ryzen Gaming PC");
            System.out.println("2. Intel 11th Generation Core i5 PC");
            System.out.println("3. Intel 11th Generation Core i7 PC");
            System.out.println("4. Intel 11th Generation Core i9 PC");
            String input = scn.nextLine();
            if (input.equalsIgnoreCase("1")) {
                builder = director.buildPC("gaming");
            }
            else if (input.equalsIgnoreCase("2")) {
                builder = director.buildPC("Corei5");
            }
            else if (input.equalsIgnoreCase("3")) {
                builder = director.buildPC("Corei7");
            }
            else if (input.equalsIgnoreCase("4")) {
                builder = director.buildPC("Corei9");
            }
            PC pc = builder.getPC();
            System.out.println("Currently you have the following configuration:");
            pc.print();
            System.out.println("What type of RAM do you want to add to your PC?");
            System.out.println("1. 8 GB DDR4 RAM, 2666 MHz");
            System.out.println("2. 8 GB DDR4 RAM, 3200 MHz");
            input = scn.nextLine();
            if (input.equalsIgnoreCase("1")) {
                builder.addRAM(new DDR4_2666());
            }
            else if (input.equalsIgnoreCase("2")) {
                builder.addRAM(new DDR4_3200());
            }
            System.out.println("Currently you have the following configuration:");
            pc.print();
        } while (true);

    }
}
