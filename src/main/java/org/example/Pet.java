package org.example;

public class Pet
{
    private String petName;
    private String petCategory;

    public Pet(String name, String category)
    {
        petName = name;
        petCategory = category;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetCategory() {
        return petCategory;
    }

    public void setPetCategory(String petCategory) {
        this.petCategory = petCategory;
    }
}
