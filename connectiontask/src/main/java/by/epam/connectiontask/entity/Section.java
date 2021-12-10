package by.epam.connectiontask.entity;

public enum Section {
    PIZZA("pizza"), SUSHI("sushi");
    String section;

    Section(String section){
        this.section = section;
    }

    public String getSection(){
        return section;
    }
}
