package by.epam.connectiontask.entity;

public enum UserRole {
    ADMIN(1), CLIENT(2);
    private long roleId;

    UserRole(long id){
        roleId = id;
    }

    public long getRoleId(){
        return roleId;
    }
}
