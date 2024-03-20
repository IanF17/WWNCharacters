import java.lang.Math;
public class WWNCharacters {

    private String name;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private String backstory;

    public WWNCharacters() {
    }

    public WWNCharacters(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String backstory) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.backstory = backstory;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getName(){
        return name;
    }

    public void setStrength(int newStrength){
        this.strength = newStrength;
    }

    public int getStrength(){
        return strength;
    }

    public void setDexterity(int newDexterity){
        this.dexterity = newDexterity;
    }

    public int getDexterity(){
        return dexterity;
    }
    public void setConstitution(int newConstitution){
        this.constitution = newConstitution;
    }

    public int getConstitution(){
        return constitution;
    }
    public void setIntelligence(int newIntelligence){
        this.intelligence = newIntelligence;
    }
    public int getIntelligence(){
        return intelligence;
    }
    public void setWisdom(int newWisdom){
        this.wisdom = newWisdom;
    }
    public int getWisdom(){
        return wisdom;
    }
    public void setCharisma(int newCharisma){
        this.charisma = newCharisma;
    }
    public int getCharisma(){
        return charisma;
    }
    public void setBackstory(String newBackstory){
        this.backstory = newBackstory;
    }
    public String getBackstory(){
        return backstory;
    }


    public static void main (String args[]) {
        WWNCharacters Jonn = new WWNCharacters("Jonn", 16, 4, 11, 8, 10, 14,
                "Growing up on a farm, Jonn learned the value of a hard days work. He woke up early at the " +
                        "crack of dawn to milk the cows. It wasn't hard work, but work that needed to be done. Jonn " +
                        "didn't attend school because of the farm, but loved what he did.");

        WWNCharacters Alice = new WWNCharacters("Alice", 9, 13, 3, 17, 12, 8,
                "Alice is a scholar who has always had a passion for physically and mentally stimulating " +
                        "challenge. Although she is not strong and light, she is a fast runner and reader. She enjoys " +
                        "working with others and fighting in hand to hand combat.");

        // TEST
        System.out.println(CombatManager.fightSimple(Jonn, Alice));
        System.out.println("--------------------------");
        System.out.println(CombatManager.fightModerate(Jonn, Alice));
        System.out.println("--------------------------");
        System.out.println(CombatManager.fightComplex(Jonn, Alice));
        System.out.println("--------------------------");

    }
}


