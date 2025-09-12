import java.io.FileWriter;


public class DndCharGen
{

    public static void main(String[] args) throws java.io.IOException
    {




        String userName = System.getProperty("user.name");
        // For Windows:
        //String filePath = "C:\\Users\\" + userName + "\\Desktop\\characters.txt";

        // For Mac/Linux:
        String filePath = "/Users/" + userName + "/Desktop/dndCharacters.txt";
        FileWriter writer = new FileWriter(filePath);


        for (int i = 1; i < 4; i++)
        {
            String charName = readLine(); //readLine; a custom function I added to act like codeHS

            int STR = rollDice();
            int DEX = rollDice();
            int CHR = rollDice();
            int CON = rollDice();
            int WIS = rollDice();
            int INT = rollDice();


            System.out.println("\n--- Character " + i + " name: " + charName + " ---"); //Displays everything in the console
            System.out.println("Strength: " + STR);
            System.out.println("Dexterity: " + DEX);
            System.out.println("Charisma: " + CHR);
            System.out.println("Constitution: " + CON);
            System.out.println("Wisdom: " + WIS);
            System.out.println("Intelligence: " + INT);
            System.out.println("----------------------------------------------");


            writer.write("\n--- Character " + i + " name: " + charName + " ---\n"); //Writes to the actual file
            writer.write("STR: " + STR + "\n");
            writer.write("DEX: " + DEX + "\n");
            writer.write("CHR: " + CHR + "\n");
            writer.write("CON: " + CON + "\n");
            writer.write("WIS: " + WIS + "\n");
            writer.write("INT: " + INT + "\n");
            writer.write("----------------------------------------------\n");

        }
        writer.close();
    }

    static int rollDice()
    {
        return (int) ((Math.random() * ((18 - 3) + 1)) + 3); // Rolls 3–18
    }

    // This method mimics CodeHS readLine("prompt") to make it easier for me.
    static String readLine() throws java.io.IOException
    {
        System.out.print("Enter your character's name: "); // show the prompt
        String input = "";
        int c;
        while ((c = System.in.read()) != '\n' && c != -1) // read characters until Enter
        {
            if (c != '\r') // ignore carriage return (Windows)
                input += (char) c; // add char to input string
        }
        return input;
    }
}
