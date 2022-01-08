package ac.scythe.util;

import ac.scythe.app.Game;
import ac.scythe.struct.destination;
import ac.scythe.struct.item;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import static ac.scythe.app.Game.Player;
import static ac.scythe.util.Data.destinations;

public class Command {
    public static void onCommand() throws IOException, InterruptedException {
        String command = Game.reader.readLine();
        switch(command.toLowerCase(Locale.ROOT)) {
            case "help":
                Output.clearWrite("The following commands are available:\n- Help\n- Move\n- Search\n- Inventory");
                Game.reader.readLine();
                break;
            case "move":
                onMovement();
                break;
            case "search":
                Output.write("Search Ran");
                break;
            case "pickup":
                Output.write("Pickup Ran");
                break;
            case "inventory":
                onInventory();
                break;
            default:
                Output.clearWrite("That is not a recognised command, the following commands are available:\n- Help\n- Move\n- Search\n- Inventory");
        }
    }

    private static void onMovement() throws IOException, InterruptedException {
        boolean waitingForInput = true;
        while(waitingForInput) {
            Output.clearWrite("Would you like to move forward or head back");
            String direction = Game.reader.readLine();
            switch (direction.toLowerCase(Locale.ROOT)) {
                case "forwards":
                case "forward":
                    Player.setDestination(Player.getDestination() + 1);
                    destination current = destinations.get(Player.getDestination());
                    Output.clearWrite(current.getDescription());
                    waitingForInput = false;
                    break;
                case "back":
                case "backwards":
                case "backward":
                    Player.setDestination(Player.getDestination() - 1);
                    destination currentLocation = destinations.get(Player.getDestination());
                    Output.clearWrite(currentLocation.getDescription());
                    waitingForInput = false;
                default:
                    Output.clearWrite("Error: Invalid Input");
                    Thread.sleep(5000);
            }
        }
    }

    private static void onInventory() {
        Map<String, item> inventory = Player.getInventory();
        System.out.println(inventory);
        if(inventory == null || inventory.size() == 0) { Output.clearWrite(("{player}'s Current Inventory is Empty").replace("{player}", Player.getName())); return; }
        Output.clearWrite(("{player}'s Current Inventory is -").replace("{player}", Player.getName()));
        inventory.forEach((k, i) -> Output.write(("\n- {item}").replace("{item}", i.getName())));
    }
};


