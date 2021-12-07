package by.epam.connectiontask.entity;

public class Section extends CustomEntity{
    private long sectionId;
    private String sectionName;

    public Section(){}

    public Section(long sectionId, String sectionName) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        if (sectionId != section.sectionId) return false;
        return sectionName.equals(section.sectionName);
    }

    @Override
    public int hashCode() {
        int result = (int) (sectionId ^ (sectionId >>> 32));
        result = 31 * result + sectionName.hashCode();
        return result;
    }
}
