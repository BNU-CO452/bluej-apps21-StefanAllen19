package ac.scythe.util;

import ac.scythe.app.Game;
import ac.scythe.struct.destination;
import ac.scythe.struct.item;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static ac.scythe.app.Game.Player;
import static ac.scythe.util.Data.destinations;

public class Command {
    public static void onCommand() throws IOException, InterruptedException {
        if(Player.getDestination() == 7) {
            onFinish();
        }
        String command = Game.reader.readLine();
        switch(command.toLowerCase(Locale.ROOT)) {
            case "help":
                Output.clearWrite("The following commands are available:\n- Help\n- Move\n- Search\n- Inventory\n- Pickup \n- Search");
                Game.reader.readLine();
                break;
            case "move":
                onMovement();
                break;
            case "search":
                onSearch();
                break;
            case "pickup":
                onPickup();
                break;
            case "inventory":
                onInventory();
                break;
            case "inspect":
                onInspect();
                break;
            case "score":
                Output.clearWrite(("{player}'s Current Score: ").replace("{player}", Player.getName()) + (Player.inventory.size() * 50) + " Points");
                break;
            default:
                Output.clearWrite("That is not a recognised command, the following commands are available:\n- Help\n- Move\n- Search\n- Inventory\n- Pickup \n- Search");
        }
    }

    private static void onMovement() throws IOException, InterruptedException {
        AtomicBoolean waitingForInput = new AtomicBoolean(true);
        while(waitingForInput.get()) {
            Output.clearWrite("Would you like to move forward or head back");
            String direction = Game.reader.readLine();
            switch (direction.toLowerCase(Locale.ROOT)) {
                case "forwards":
                case "forward":
                    if(Player.getDestination() + 1  == 7 && !Player.getInventory().containsKey("rusty key")) {
                        Output.clearWrite("You Are Missing The Door Key.\nGo back and find it!");
                        Thread.sleep(5000);
                        waitingForInput.set(false);
                        break;
                    }
                    Player.setDestination(Player.getDestination() + 1);
                    destination current = destinations.get(Player.getDestination());
                    Output.clearWrite(current.getDescription());
                    waitingForInput.set(false);
                    break;
                case "back":
                case "backwards":
                case "backward":
                    if(Player.getDestination() - 1 > 0) {
                        Output.clearWrite("You are unable to go in that direction.");
                    }
                    Player.setDestination(Player.getDestination() - 1);
                    destination currentLocation = destinations.get(Player.getDestination());
                    Output.clearWrite(currentLocation.getDescription());
                    waitingForInput.set(false);
                    break;
                default:
                    Output.clearWrite("Error: Invalid Input");
                    Thread.sleep(5000);
            }
        }
    }

    private static void onInventory() {
        Map<String, item> inventory = Player.getInventory();
        if(inventory == null || inventory.size() == 0) { Output.clearWrite(("{player}'s Current Inventory is Empty").replace("{player}", Player.getName())); return; }
        Output.clearWrite(("{player}'s Current Inventory is -").replace("{player}", Player.getName()));
        inventory.forEach((k, i) -> Output.write(("\n- {item}").replace("{item}", i.getName())));
    }

    private static void onSearch() {
        if(destinations.get(Player.getDestination()).getItems().size() == 0) {
            Output.clearWrite("You find nothing in this room");
            return;
        }

        Output.clearWrite(("You find the following items -"));
        destinations.get(Player.getDestination()).getItems().forEach((k, i) -> {
            Output.write(("\n- {item}").replace("{item}", i.getName()));
        });
    }

    private static void onPickup() throws IOException {
        HashMap<String, item> items = destinations.get(Player.getDestination()).getItems();
        Output.clearWrite("Which Item Would you like to pick up?");
        String itemName = Game.reader.readLine();
        if(!items.containsKey(itemName.toLowerCase())) Output.clearWrite("No Item Found With That Name!");
        try {
            item Item = destinations.get(Player.getDestination()).getItems().get(itemName.toLowerCase());
            Player.addItem(Item);
            Output.clearWrite(("You have picked up {item}.").replace("{item}", Item.getName()));
            destinations.get(Player.getDestination()).removeItem(Item);

        } catch (Exception e) {}
    }

    private static void onFinish() {
        Player.setScore(Player.getInventory().size() * 50);

        if(Player.getScore() > 200 && Player.getInventory().containsKey("heavy coat")) {
            Output.clearWrite("You Win!\nYou see a Bugatti La Voiture Noire outside, you unlock the door and as you start the car you see the predator jump in front of the car.\nYou speed forward and crash into him driving away and towards safety the end.");
        }
        else if(!Player.getInventory().containsKey("heavy coat")) {
            Output.clearWrite("You Lose!\nYou see a Bugatti La Voiture Noire outside, you run to the door and as you try to open it, you feel your joints start to stiffen.\nYou wished that you had brought a heavy coat to shield you from the cold.");
        }
        else {
            Output.clearWrite("You Lose!\nYou see a Bugatti La Voiture Noire outside, you run to the door and as you try to open it, the predator appears behind you.\nIts grabs you dragging you back into the building, you were never heard from ever again.");
        }

        System.exit(0);
    }

    private static void onInspect() throws IOException {

        Output.clearWrite("Which Item would you like to inspect?");
        String itemName = Game.reader.readLine();
        if(!Player.getInventory().containsKey(itemName.toLowerCase())) Output.clearWrite("No Item Found With That Name!");

        try {
            item Item = Player.getInventory().get(itemName.toLowerCase());
            Output.clearWrite(("You have inspected {item}.\n\nStats:\nDamage: {damage}\nWarmth: {warmth}\nProtection: {protection}\nLight: {light}\n").replace("{item}", Item.getName()).replace("damage", Item.getStats().getDamage().toString()).replace("{warmth}", Item.getStats().getWarmth().toString()).replace("{protection}", Item.getStats().getProtection().toString()).replace("{light}", Item.getStats().getLight().toString()));
        } catch (Exception e) {}
    }
};


