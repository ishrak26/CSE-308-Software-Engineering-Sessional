public class Director {
    private Builder builder;

    public Builder buildPC(String pctype) {
        if (pctype.equalsIgnoreCase("GAMING")) {
            builder = new GamingPCBuilder();
        }
        else if (pctype.equalsIgnoreCase("COREi5")) {
            builder = new Corei5PCBuilder();
        }
        else if (pctype.equalsIgnoreCase("COREi7")) {
            builder = new Corei7PCBuilder();
        }
        else if (pctype.equalsIgnoreCase("COREi9")) {
            builder = new Corei9PCBuilder();
        }
        else {
            return null;
        }

        builder.addProcessor();
        builder.addCooler();
        builder.addDVDDrive();
        return builder;
    }

}
