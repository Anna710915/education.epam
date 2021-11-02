package by.epam.taskfourth.composite;

public enum TypeComponent {
    DELIMITER_TAB("\t"),
    DELIMITER_SPACE(" "),
    DELIMITER_NOT("");
    private String delimiter;
    TypeComponent(String delimiter){
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
