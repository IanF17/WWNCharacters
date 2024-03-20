import java.lang.Math;

public class CombatManager extends WWNCharacters {
    public static String fightSimple(WWNCharacters C1, WWNCharacters C2){
        int c1Tot = C1.getStrength() + C1.getWisdom() + C1.getCharisma() + C1.getConstitution() + C1.getDexterity() +
                C1.getIntelligence();
        int c2Tot = C2.getStrength() + C2.getWisdom() + C2.getCharisma() + C2.getConstitution() + C2.getDexterity() +
                C2.getIntelligence();
        System.out.println(C1.getName() + "'s HP: " + c1Tot);
        System.out.println(C2.getName() + "'s HP: " + c2Tot);

        if(c1Tot > c2Tot) {
            return "The winner is: " + C1.getName();
        }
        else if(c1Tot < c2Tot) {
            return "The winner is: " + C2.getName();
        }
        else {
            return "Draw";
        }
    }

    public static String fightModerate(WWNCharacters C1, WWNCharacters C2){
        String[] terrains = new String[]{"underwater", "icelands", "space", "methlab", "darkness", "volcano"};

        // CALCULATE RAW HP
        int c1Tot = C1.getStrength() + C1.getWisdom() + C1.getCharisma() + C1.getConstitution() + C1.getDexterity() +
                C1.getIntelligence();
        int c2Tot = C2.getStrength() + C2.getWisdom() + C2.getCharisma() + C2.getConstitution() + C2.getDexterity() +
                C2.getIntelligence();
        System.out.println(C1.getName() + "'s raw HP: " + c1Tot);
        System.out.println(C2.getName() + "'s raw HP: " + c2Tot);

        // RANDOMLY SELECT TWO TERRAINS
        int randNum1 = (int)(Math.random() * 6);
        String terrain1 = terrains[randNum1];
        int randNum2;
        do {
            randNum2 = (int) (Math.random() * 6);
        } while(randNum2 == randNum1);
        String terrain2 = terrains[randNum2];

        System.out.println(C1.getName() + " chose the terrain: " + terrain1);
        System.out.println(C2.getName() + " chose the terrain: " + terrain2);

        //NEGATE ATTRIBUTES OF THE TERRAINS CHOSEN
        if(terrain1.equals("underwater") || terrain2.equals("underwater")){
            c1Tot -= C1.getStrength();
            c2Tot -= C2.getStrength();
        }
        if(terrain1.equals("icelands") || terrain2.equals("icelands")){
            c1Tot -= C1.getDexterity();
            c2Tot -= C2.getDexterity();
        }
        if(terrain1.equals("space") || terrain2.equals("space")){
            c1Tot -= C1.getConstitution();
            c2Tot -= C2.getConstitution();
        }
        if(terrain1.equals("methlab") || terrain2.equals("methlab")){
            c1Tot -= C1.getIntelligence();
            c2Tot -= C2.getIntelligence();
        }
        if(terrain1.equals("darkness") || terrain2.equals("darkness")){
            c1Tot -= C1.getWisdom();
            c2Tot -= C2.getWisdom();
        }
        if(terrain1.equals("volcano") || terrain2.equals("volcano")){
            c1Tot -= C1.getCharisma();
            c2Tot -= C2.getCharisma();
        }

        // PRINT FINAL HP AND WINNER
        System.out.println(C1.getName() + "'s final HP: " + c1Tot);
        System.out.println(C2.getName() + "'s final HP: " + c2Tot);

        if(c1Tot > c2Tot) {
            return "The winner is: " + C1.getName();
        }
        else if(c1Tot < c2Tot) {
            return "The winner is: " + C2.getName();
        }
        else {
            return "Draw";
        }

    }

    public static String fightComplex(WWNCharacters C1, WWNCharacters C2){

        int c1Shield = 0;
        int c2Shield = 0;

        // RAW SCORES

        int c1Hp = C1.getStrength() + C1.getWisdom() + C1.getCharisma() + C1.getConstitution() + C1.getDexterity() +
                C1.getIntelligence();
        int c2Hp = C2.getStrength() + C2.getWisdom() + C2.getCharisma() + C2.getConstitution() + C2.getDexterity() +
                C2.getIntelligence();
        double c1Ap = c1Hp/6.0;
        double c2Ap = c2Hp/6.0;

        System.out.println(C1.getName() + String.format("'s raw AP: %.1f", c1Ap));
        System.out.println(C1.getName() + "'s raw HP: " + c1Hp);
        System.out.println(C2.getName() + String.format("'s raw AP: %.1f", c2Ap));
        System.out.println(C2.getName() + "'s raw HP: " + c2Hp);

        System.out.println();

        // TERRAINS

        String[] terrains = new String[]{"underwater", "icelands", "space", "methlab", "darkness", "volcano"};

        int randNum1 = (int)(Math.random() * 6);
        String terrain1 = terrains[randNum1];
        int randNum2;
        do {
            randNum2 = (int) (Math.random() * 6);
        } while(randNum2 == randNum1);
        String terrain2 = terrains[randNum2];

        System.out.println(C1.getName() + " chose the terrain: " + terrain1);
        System.out.println(C2.getName() + " chose the terrain: " + terrain2);


        // PLAYER 1 SKILL BONUSES


        int c1strength = C1.getStrength()/7;
        if((terrain1.equals("underwater") || terrain2.equals("underwater")) && c1strength != 0) {
            c1Hp += (c1strength * 2);
            System.out.println(C1.getName() + ": +" + c1strength*2 +  " HP");
        } else if (c1strength != 0){
            c1Hp += c1strength;
            System.out.println(C1.getName() + ": +" + c1strength +  " HP");
        }

        int c1dex = C1.getDexterity()/7;
        if((terrain1.equals("icelands") || terrain2.equals("icelands")) && c1dex != 0) {
            c1Ap += (c1dex * 2);
            System.out.println(C1.getName() + ": +" + c1dex*2 +  " AP");
        } else if(c1dex != 0){
            c1Ap += c1dex;
            System.out.println(C1.getName() + ": +" + c1dex +  " AP");
        }

        int c1con = C1.getConstitution()/7;
        if((terrain1.equals("space") || terrain2.equals("space")) && c1con != 0) {
            c1Shield += (c1con * 2);
            System.out.println(C1.getName() + ": +" + c1con*2 +  " shield");
        } else if (c1con != 0){
            c1Shield += c1con;
            System.out.println(C1.getName() + ": +" + c1con +  " shield");
        }

        int c1intel = C2.getIntelligence()/7;
        if((terrain1.equals("methlab") || terrain2.equals("methlab")) && c1intel != 0) {
            c1Ap -= (c1intel * 2);
            System.out.println(C1.getName() + ": -" + c1intel*2 +  " AP");
        } else if (c1intel != 0){
            c1Ap += c1intel;
            System.out.println(C1.getName() + ": -" + c1intel +  " AP");
        }

        if(C2.getWisdom() > 7 && C2.getWisdom() < 14 && c1Shield > 0) {
            c1Shield -= 1;
            System.out.println(C1.getName() + ": -1 shield");
        }
        else if(C2.getWisdom() > 13 && c1Shield > 1) {
            c1Shield -= 2;
            System.out.println(C1.getName() + ": -2 shield");
        }
        else if(C2.getWisdom() > 13 && c1Shield == 1) {
            c1Shield -= 1;
            System.out.println(C1.getName() + ": -2 shield");
        }

        int c1wis = C1.getWisdom()/7;
        if((terrain1.equals("darkness") || terrain2.equals("darkness")) && c1wis != 0) {
            C1.setCharisma(C1.getCharisma() + (c1wis*2));
            System.out.println(C1.getName() + ": +" + c1wis*2 +  " charisma");
        } else if (c1wis != 0){
            C1.setCharisma(C1.getCharisma() + c1wis);
            System.out.println(C1.getName() + ": +" + c1wis +  " charisma");
        }

        // PLAYER 2 SKILL BONUSES

        int c2strength = C2.getStrength()/7;
        if((terrain1.equals("underwater") || terrain2.equals("underwater")) && c2strength != 0) {
            c2Hp += (c2strength * 2);
            System.out.println(C2.getName() + ": +" + c2strength*2 +  " HP");
        } else if (c2strength != 0){
            c2Hp += c2strength;
            System.out.println(C2.getName() + ": +" + c2strength +  " HP");
        }

        int c2dex = C2.getDexterity()/7;
        if((terrain1.equals("icelands") || terrain2.equals("icelands")) && c2dex != 0) {
            c2Ap += (c2dex * 2);
            System.out.println(C2.getName() + ": +" + c2dex*2 +  " AP");
        } else if(c2dex != 0){
            c2Ap += c2dex;
            System.out.println(C2.getName() + ": +" + c2dex +  " AP");
        }

        int c2con = C2.getConstitution()/7;
        if((terrain1.equals("space") || terrain2.equals("space")) && c2con != 0) {
            c2Shield += (c2con * 2);
            System.out.println(C2.getName() + ": +" + c2con*2 +  " shield");
        } else if (c2con != 0){
            c2Shield += c2con;
            System.out.println(C2.getName() + ": +" + c2con +  " shield");
        }

        int c2intel = C1.getIntelligence()/7;
        if((terrain1.equals("methlab") || terrain2.equals("methlab")) && c2intel != 0) {
            c2Ap -= (c2intel * 2);
            System.out.println(C2.getName() + ": -" + c2intel*2 +  " AP");
        } else if (c2intel != 0){
            c2Ap += c2intel;
            System.out.println(C2.getName() + ": -" + c2intel +  " AP");
        }

        if(C1.getWisdom() > 7 && C1.getWisdom() < 14 && c2Shield > 0) {
            c2Shield -= 1;
            System.out.println(C2.getName() + ": -1 shield");
        }
        else if(C1.getWisdom() > 13 && c2Shield > 1) {
            c2Shield -= 2;
            System.out.println(C2.getName() + ": -2 shield");
        }
        else if(C1.getWisdom() > 13 && c2Shield == 1) {
            c2Shield -= 1;
            System.out.println(C2.getName() + ": -2 shield");
        }

        int c2wis = C2.getWisdom()/7;
        if((terrain1.equals("darkness") || terrain2.equals("darkness")) && c2wis != 0) {
            C2.setCharisma(C2.getCharisma() + (c2wis*2));
            System.out.println(C2.getName() + ": +" + c2wis*2 +  " charisma");
        } else if (c2wis != 0){
            C2.setCharisma(C2.getCharisma() + c2wis);
            System.out.println(C2.getName() + ": +" + c2wis +  " charisma");
        }

        // TURN SELECTION

        int turn;
        if(C1.getCharisma() > C2.getCharisma()){
            turn = 0;
            System.out.println(C1.getName() + " has a greater charisma score. They go first.");
        }
        else if(C1.getCharisma() < C2.getCharisma()){
            turn = 1;
            System.out.println(C2.getName() + " has a greater charisma score. They go first.");
        }
        else{
            turn = (int)(Math.random() * 2);
            if(turn < 1) {
                System.out.println("Both player's charisma scores are equal. Random draw selected " + C1.getName() + " to go first");
            }
            else{
                System.out.println("Both player's charisma scores are equal. Random draw selected " + C2.getName() + " to go first");
            }
        }

        // FINAL SCORE

        System.out.println();

        System.out.println(C1.getName() + String.format("'s final AP: %.1f", c1Ap));
        System.out.println(C1.getName() + "'s final HP: " + c1Hp);
        System.out.println(C1.getName() + "'s final shield: " + c1Shield);
        System.out.println(C2.getName() + String.format("'s final AP: %.1f", c2Ap));
        System.out.println(C2.getName() + "'s final HP: " + c2Hp);
        System.out.println(C2.getName() + "'s final shield: " + c2Shield);

        System.out.println();

        // RETURN THE WINNER

        if(turn == 0) {
            do{
                c2Hp -= (c1Ap - c2Shield);
                if(c2Hp <= 0) {
                    break;
                }
                c1Hp -= (c2Ap - c1Shield);
            }
            while(c1Hp > 0 && c2Hp > 0);
            if(c1Hp <= 0) {
                return "The winner is: " + C2.getName();
            }
            else{
                return "The winner is: " + C1.getName();
            }
        }
        else if(turn == 1) {
            do{
                c1Hp -= (c2Ap - c1Shield);
                if(c1Hp <= 0) {
                    break;
                }
                c2Hp -= (c1Ap - c2Shield);
            }
            while(c1Hp > 0 && c2Hp > 0);
            if(c1Hp <= 0) {
                return "The winner is: " + C2.getName();
            }
            else {
                return "The winner is: " + C1.getName();
            }
        }
        else {
            return "Winner is inconclusive.";
        }
    }
}
