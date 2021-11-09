package by.epam.taskfourth.composite;

public enum TypeComponent {
    TEXT("\n"),
    PARAGRAPH("\n"),
    SENTENCE(""),
    LEXEME(" "),
    WORD(""),
    SYMBOL(""),
    PUNCT("");
    private String delimiter;

    TypeComponent(String delimiter){
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
