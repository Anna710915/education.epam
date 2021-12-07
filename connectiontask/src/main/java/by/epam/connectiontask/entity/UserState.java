package by.epam.connectiontask.entity;

public enum UserState {
    NEW(1), ACTIVE(2), INACTIVE(3), BLOCKED(4), UNBLOCKED(5);
    private long stateId;

    UserState (long id){
        stateId = id;
    }

    public long getStateId(){
        return stateId;
    }
}
