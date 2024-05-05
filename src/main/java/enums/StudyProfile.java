package enums;

public enum StudyProfile {
    PHYSICS("Физика"),
    MATHEMATICS("Математика"),
    BIOLOGY("Биология"),
    GEOGRAPHY("География"),
    LINGUISTICS("Лингвистика");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}
