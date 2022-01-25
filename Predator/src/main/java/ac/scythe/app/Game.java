package ac.scythe.app;

import ac.scythe.struct.destination;
import ac.scythe.struct.item;
import ac.scythe.struct.player;
import ac.scythe.struct.stats;
import ac.scythe.util.Command;
import ac.scythe.util.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;

import static ac.scythe.util.Command.onCommand;
import static ac.scythe.util.Data.destinations;

public class Game {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static boolean running = true;
    public static player Player;

    public void start() throws IOException, InterruptedException {
        startingDestinations();


        Output.clearWrite("Please input your what you would like to call your character.");
        String name = reader.readLine();
        Player = new player(name);
        startingItems();

        Output.clearWrite(("Welcome {player} to the deadly game of Predator you must find a way out of Bucks New University.\nTo win you need to find warm clothing and enough items to survive.\nFind all the hidden clues and don't get caught. Good Luck {player}").replace("{player}", Player.getName()));
        while(running) {
            onCommand();
        }
    }

    private void startingDestinations() {
        destinations.put(0, new destination("Classroom", 0, "A dark classroom that is cold and empty."));
        destinations.put(1, new destination("Hall way", 1, "The long dark echoing hallway."));
        destinations.put(2, new destination("Study Area", 2, "A shadowy dank cold room"));
        destinations.put(3, new destination("Staircase", 3, "A cold echoy staircase"));
        destinations.put(4, new destination("Library", 4, "A large open spaced library with fogged windows"));
        destinations.put(5, new destination("Hall way", 5, "Another empty damp hallway"));
        destinations.put(6, new destination("Ground Floor", 6, "A cold dark ground floor with the ceiling dripping and misted windows."));
        destinations.put(7, new destination("Outside", 7, "A cold foggy empty area that is freezing only a car is there."));

    }

    private void startingItems() throws IOException {
        destinations.get(0).addItem(new item("Torch", "Rusted Light Torch", "Classroom", new stats(0, 0, 0, 10, 100, true, false)));
        destinations.get(0).addItem(new item("Foam Battle Axe", "Kids Foam Battle Axe", "Classroom", new stats(5, 0, 0, 0, 0, false, true)));
        System.out.print(destinations.get(0).getItems());
        Game.reader.readLine();

        destinations.get(1).addItem(new item("Pen", "Old School Pen", "Hallway", new stats(0, 0, 0, 0, 50, true, false)));

        destinations.get(2).addItem(new item("Coat", "Rain Coat", "Study Area", new stats(0, 15, 5, 0, 0, false, false)));
        destinations.get(2).addItem(new item("Notepad", "For feelings", "Study Area", new stats(0, 0, 0, 0, 0, false, false)));


        destinations.get(4).addItem(new item("Diary", "Old Persons Diary", "Libary", new stats(0, 0, 0, 0, 0, false, false)));
        destinations.get(4).addItem(new item("Dojigiri Katana", "Dojigiri is known as one of the five best katana ‘Tenka-goken 天下五剣’.　The name ‘Dojigiri’ comes from the legend of a notorious ogre ‘Shutendoji 酒呑童子’; this katana is said to be the one which killed the ogre in the end.", "Libary", new stats(15, 0, 0, 0, 0, false, false)));

        destinations.get(5).addItem(new item("Rusty Key", "Old Rusty Key", "Hallway", new stats(0, 0, 0, 0, 0, false, false)));
        destinations.get(5).addItem(new item("Heavy Coat", "A Heavy Winter Coat", "Hallway", new stats(0, 25, 12, 0, 0, false, false)));

        destinations.get(7).addItem(new item("Bugatti La Voiture Noire", "With a price tag of $18.7 million after taxes, the one-off Bugatti La Voiture Noire is officially the priciest new car ever.", "Outside", new stats(100, 100, 100, 100, 100, true, true)));
    }
}