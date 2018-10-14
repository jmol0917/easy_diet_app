package comp5216.sydney.edu.au.lchf_diet;

public class User {
    private int age;
    private int weight;
    private int height;
    private int targetWeight;
    private int targetDuration;
    private String pal;   //Physical Activity Level (PAL)
    private String dietChoice;
    private String gender;

    public User(int age, int weight, int height, int targetWeight, int targetDuration, String pal, String dietChoice, String gender) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.targetWeight = targetWeight;
        this.targetDuration = targetDuration;
        this.pal = pal;
        this.dietChoice = dietChoice;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(int targetWeight) {
        this.targetWeight = targetWeight;
    }

    public int getTargetDuration() {
        return targetDuration;
    }

    public void setTargetDuration(int targetDuration) {
        this.targetDuration = targetDuration;
    }

    public String getPal() {
        return pal;
    }

    public void setPal(String pal) {
        this.pal = pal;
    }

    public String getDietChoice() {
        return dietChoice;
    }

    public void setDietChoice(String dietChoice) {
        this.dietChoice = dietChoice;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
