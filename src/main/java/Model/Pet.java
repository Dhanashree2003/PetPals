package Model;

public class Pet {
    private int petID;
    private String name;
    private int age;
    private String breed;
    private boolean available;

    public Pet() {}

    public Pet(int petID, String name, int age, String breed, boolean available) {
        this.petID = petID;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.available = available;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Pet [ID=" + petID + ", Name=" + name + ", Age=" + age +
               ", Breed=" + breed + ", Available=" + available + "]";
    }
}


// Dog Class

class Dog extends Pet {
    private String dogBreed;

    public Dog() {}

    public Dog(int petID, String name, int age, String breed, boolean available, String dogBreed) {
        super(petID, name, age, breed, available);
        this.dogBreed = dogBreed;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    @Override
    public String toString() {
        return super.toString() + ", DogBreed=" + dogBreed;
    }
}


// Cat Class

class Cat extends Pet {
    private String catColor;

    public Cat() {}

    public Cat(int petID, String name, int age, String breed, boolean available, String catColor) {
        super(petID, name, age, breed, available);
        this.catColor = catColor;
    }

    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String catColor) {
        this.catColor = catColor;
    }

    @Override
    public String toString() {
        return super.toString() + ", CatColor=" + catColor;
    }
}
