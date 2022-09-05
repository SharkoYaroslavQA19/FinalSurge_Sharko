package enums;

public enum FeelingWhileTraining {
    GREAT("Great"),
    GOOD("Good"),
    NORMAL("Normal"),
    POOR("Poor"),
    TERRIBLE("Terrible");

    private final String name;

    public String getName() {
        return name;
    }

    FeelingWhileTraining(String name) {
        this.name=name;
    }
    public static FeelingWhileTraining fromString(String feeling) {
        for (FeelingWhileTraining feelings : FeelingWhileTraining.values()) {
            if (feelings.getName().equals(feeling)) {
                return feelings;
            }
        }
        return null;
    }
}