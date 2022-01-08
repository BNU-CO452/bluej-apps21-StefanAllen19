package ac.scythe.app;

import ac.scythe.struct.destination;
import ac.scythe.struct.item;
import ac.scythe.struct.player;
import ac.scythe.struct.stats;
import ac.scythe.util.Logo;
import ac.scythe.util.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static ac.scythe.util.Command.onCommand;
import static ac.scythe.util.Data.destinations;

public class Game {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static boolean running = true;
    public static player Player;

    public void start() throws IOException, InterruptedException {
        startingDestinations();
        startingItems();

        Output.clearWrite("Please input your what you would like to call your character.");
        String name = reader.readLine();
        Player = new player(name);

        Output.clearWrite(("Welcome {player} to the deadly game of Predator you must find a way out of Bucks New University.\nFind all the hidden clues and don't get caught. Good Luck {player}").replace("{player}", Player.getName()));
        Player.addItem("torch");
        while(running) {
            onCommand();
        }
    }

    private void startingDestinations() {
        destinations.put(0, new destination("Classroom", 0, "jdijdijdidj"));
        destinations.put(1, new destination("Hall way", 1, "0kdpokwpokd"));
        destinations.put(2, new destination("Study Area", 2, "dkspskpsokps"));
        destinations.put(3, new destination("Staircase", 3, "i8jdijdioajoiaj"));
        destinations.put(4, new destination("Library", 4, "oidkkdokdkpd"));
        destinations.put(5, new destination("Hall way", 5, "0odopkdpokdpdk"));
        destinations.put(6, new destination("Ground Floor", 6, "kdokdokdpkdpodkpodk"));
        destinations.put(7, new destination("Outside", 7, "djodksiojij"));

    }

    private void startingItems() {
        HashMap<String, item> items = new HashMap<>();
        items.put("Torch", new item("Torch", "", "Classroom", new stats(0, 0, 0, 10, 100, true, false)));
        items.put("Foam Battle Axe", new item("Foam Battle Axe", "", "Classroom", new stats(5, 0, 0, 0, 0, false, true)));
        Objects.requireNonNull(destinations.get(0)).setItems(items);
        System.out.print(destinations.get(0).getItems());
        items.clear();

        items.put("Pen", new item("Pen", "", "Hallway", new stats(0, 0, 0, 0, 50, true, false)));
        Objects.requireNonNull(destinations.get(1)).setItems(items);
        items.clear();

        items.put("Coat", new item("Coat", "", "Study Area", new stats(0, 15, 5, 0, 0, false, false)));
        items.put("Notepad", new item("Notepad", "For feelings", "Study Area", new stats(0, 0, 0, 0, 0, false, false)));
        Objects.requireNonNull(destinations.get(2)).setItems(items);
        items.clear();

        items.put("Diary", new item("Diary", "", "Libary", new stats(0, 0, 0, 0, 0, false, false)));
        items.put("Dojigiri Katana", new item("Dojigiri Katana", "Dojigiri is known as one of the five best katana ‘Tenka-goken 天下五剣’.　The name ‘Dojigiri’ comes from the legend of a notorious ogre ‘Shutendoji 酒呑童子’; this katana is said to be the one which killed the ogre in the end.", "Libary", new stats(15, 0, 0, 0, 0, false, false)));
        Objects.requireNonNull(destinations.get(4)).setItems(items);
        items.clear();

        items.put("Rusty Key", new item("Rusty Key", "Old Rusty Key", "Hallway", new stats(0, 0, 0, 0, 0, false, false)));
        items.put("Heavy Coat", new item("Heavy Coat", "A Heavy Winter Coat", "Hallway", new stats(0, 25, 12, 0, 0, false, false)));
        Objects.requireNonNull(destinations.get(5)).setItems(items);

        items.put("Bugatti La Voiture Noire", new item("Bugatti La Voiture Noire", "With a price tag of $18.7 million after taxes, the one-off Bugatti La Voiture Noire is officially the priciest new car ever.", "Outside", new stats(100, 100, 100, 100, 100, true, true)));
        Objects.requireNonNull(destinations.get(7)).setItems(items);
        items.clear();
    }
}