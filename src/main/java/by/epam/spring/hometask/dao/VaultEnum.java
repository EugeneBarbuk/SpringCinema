package by.epam.spring.hometask.dao;

public enum VaultEnum {
    MYSQL("MySql"),
    REPOSITORY("repository");

    private final String name;

    VaultEnum(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
