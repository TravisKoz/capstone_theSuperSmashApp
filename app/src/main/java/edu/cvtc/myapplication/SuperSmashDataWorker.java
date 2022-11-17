package edu.cvtc.myapplication;

import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.FighterEntry;

// The class helps create our database. This class will
// establish a connection to our database and insert
// our default data into our tables.
public class SuperSmashDataWorker {
    // Member Attributes
    private SQLiteDatabase mDb;

    // Constructor
    public SuperSmashDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    private void insertBattleNote(String heading, String body) {
        ContentValues values = new ContentValues();
        values.put(BattleNoteEntry.COLUMN_HEADING, heading);
        values.put(BattleNoteEntry.COLUMN_BODY, body);

        long newRowId = mDb.insert(BattleNoteEntry.TABLE_NAME, null, values);
    }

    // Method used to populate our database with initial Battle Notes data.
    public void insertBattleNotes() {
        insertBattleNote("Note 1", "My Message");
        insertBattleNote("Note 2", "My Message");
    }

    private void insertFighter(String name, String franchise, String specialNeutral,
                               String specialSide, String specialDown,
                               String specialUp) {
        ContentValues values = new ContentValues();
        values.put(FighterEntry.COLUMN_NAME, name);
        values.put(FighterEntry.COLUMN_FRANCHISE, franchise);
        values.put(FighterEntry.COLUMN_SPECIAL_NEUTRAL, specialNeutral);
        values.put(FighterEntry.COLUMN_SPECIAL_SIDE, specialSide);
        values.put(FighterEntry.COLUMN_SPECIAL_DOWN, specialDown);
        values.put(FighterEntry.COLUMN_SPECIAL_UP, specialUp);

        long newRowId = mDb.insert(FighterEntry.TABLE_NAME, null, values);
    }

    // Method used to populate our database with initial Fighters data.
    public void insertFighters() {
        // Mario
        insertFighter("Mario", "Super Mario", "Fireball",
                "Cape", "Super Jump Punch", "F.L.U.D.D");

        // Donkey Kong
        insertFighter("Donkey Kong", "Donkey Kong","Giant Punch",
                "Headbutt", "Hand Slap", "Spinning Kong");

        // Link
        insertFighter("Link", "The Legend of Zelda", "Bow and Arrows",
                "Boomerang", "Remote Bomb", "Spin Attack");

        // Samus
        insertFighter("Samus", "Metroid", "Charge Shot",
                "Missile", "Bomb", "Screw Attack");

        // Dark Samus
        insertFighter("Dark Samus", "Metroid", "Charge Shot",
                "Missile", "Bomb", "Screw Attack");

        // Yoshi
        insertFighter("Yoshi", "Yoshi", "Egg Lay",
                "Egg Roll", "Egg Bomb", "Screw Throw");

        // Kirby
        insertFighter("Kirby", "Kirby", "Inhale",
                "Hammer Flip", "Stone", "Final Cutter");

        // Fox
        insertFighter("Fox", "Star Fox", "Blaster",
                "Fox Illusion", "Reflector", "Fire Fox");

        // Pikachu
        insertFighter("Pikachu", "Pokemon", "Thunder Jolt",
                "Skull Bash", "Thunder", "Quick Attack");

        // Luigi
        insertFighter("Luigi", "Super Mario", "Fireball",
                "Green Missile", "Luigi Cyclone", "Super Jump Punch");

        // Captain Falcon
        insertFighter("Captain Falcon", "F-Zero", "Falcon Punch",
                "Raptor Boost", "Falcon Kick", "Falcon Dive");

        // Jigglypuff
        insertFighter("Jigglypuff", "Pokemon", "Rollout",
                "Pound", "Rest", "Sing");

        // Peach
        insertFighter("Peach", "Super Mario", "Toad",
                "Peach Bomber", "Vegetable", "Peach Parasol");

        // Daisy
        insertFighter("Daisy", "Super Mario", "Toad",
                "Daisy Bomber", "Vegetable", "Daisy Parasol");

        // Bowser
        insertFighter("Bowser", "Super Mario", "Fire Breath",
                "Flying Slam", "Bowser Bomb", "Whirling Fortress");

        // Ice Climbers
        insertFighter("Ice Climbers", "Ice Climbers", "Ice Shot",
                "Squall Hammer", "Blizzard", "Belay");

        // Sheik
        insertFighter("Sheik", "The Legend of Zelda", "Needle Storm",
                "Burst Grenade", "Bouncing Fish", "Vanish");

        // Zelda
        insertFighter("Zelda", "The Legend of Zelda", "Nayru's Love",
                "Din's Fire", "Phantom Slash", "Farore's Wind");

        // Dr. Mario
        insertFighter("Dr. Mario", "Super Mario", "Megavitamins",
                "Super Sheet", "Dr. Tornado", "Super Jump Punch");

        // Pichu
        insertFighter("Pichu", "Pokemon", "Thunder Jolt",
                "Skull Bash", "Thunder", "Agility");
        // Falco
        insertFighter("Falco", "Star Fox", "Blaster",
                "Falco Phantasm", "Reflector", "Firebird");

        // Marth
        insertFighter("Marth", "Fire Emblem", "Shield Breaker",
                "Dancing Blade", "Counter", "Dolphin Slash");

        // Marth
        insertFighter("Lucina", "Fire Emblem", "Shield Breaker",
                "Dancing Blade", "Counter", "Dolphin Slash");

        // Young Link
        insertFighter("Young Link", "The Legend of Zelda", "Fire Arrow",
                "Boomerang", "Bomb", "Spin Attack");

        // Ganondorf
        insertFighter("Ganondorf" , "The Legend of Zelda", "Warlock Punch",
                "Flame Choke", "Wizard's Foot", "Dark Dive");

        // Mewtwo
        insertFighter("Mewtwo" , "Pokemon", "Shadow Ball",
                "Confusion", "Disable", "Teleport");

        // Roy
        insertFighter("Roy" , "Fire Emblem", "Flare Blade",
                "Double-Edge Dance", "Counter", "Blazer");

        // Chrome
        insertFighter("Chrome" , "Fire Emblem", "Flare Blade",
                "Double-Edge Dance", "Counter", "Soaring Slash");

        // Mr. Game & Watch
        insertFighter("Mr. Game & Watch" , "Game & Watch", "Chef",
                "Judge", "Oil Panic", "Fire");

        // Meta Knight
        insertFighter("Meta Knight" , "Kirby", "Mach Tornado",
                "Drill Rush", "Dimensional Cape", "Shuttle Loop");

        // Pit
        insertFighter("Pit" , "Kid Icarus", "Palutena Bow",
                "Upperdash Arm", "Guardian Orbitars", "Power of Flight");

        // Dark Pit
        insertFighter("Dark Pit" , "Kid Icarus", "Silver Bow",
                "Electroshock Arm", "Guardian Orbitars", "Power of Flight");

        // Zero Suit Samus
        insertFighter("Zero Suit Samus" , "Metroid", "Paralyzer",
                "Plasma Whip", "Flip Jump", "Boost Kick");

        // Wario
        insertFighter("Wario" , "Wario", "Chomp",
                "Wario Bike", "Wario Waft", "Corkscrew");

        // Snake
        insertFighter("Snake" , "Metal Gear", "Hand Grenade",
                "Remote Missile", "C4", "Cypher");

        // Ike
        insertFighter("Ike" , "Fire Emblem", "Eruption",
                "Quick Draw", "Counter", "Aether");


        // Diddy Kong
        insertFighter("Diddy Kong" , "Donkey Kong", "Peanut Popgun",
                "Monkey Flip", "Banana Peel", "Rocketbarrel Boost");

        // Lucas
        insertFighter("Lucas" , "EarthBound", "PK Freeze",
                "PK Fire", "PSI Magnet", "PK Thunder");

        // Sonic
        insertFighter("Sonic" , "Sonic", "Homing Attack",
                "Spin Dash", "Spin Charge", "Spring Jump");

        // King Dedede
        insertFighter("King Dedede" , "Kirby", "Inhale",
                "Gordo Throw", "Jet Hammer", "Super Dedede Jump");

        // Olimar
        insertFighter("Olimar" , "Pikmin", "Pikmin Pluck",
                "Pikmin Throw", "Pikmin Order", "Winged Pikmin");

        // Lucario
        insertFighter("Lucario" , "Pokemon", "Aura Sphere",
                "Force Palm", "Double Team", "Extreme Speed");

        // R.O.B.
        insertFighter("R.O.B." , "R.O.B.", "Robo Beam",
                "Arm Rotor", "Gyro", "Robo Burner");

        // Toon Link
        insertFighter("Toon Link" , "The Legend of Zelda", "Hero's Box",
                "Boomerang", "Bomb", "Spin Attack");

        // Wolf
        insertFighter("Wolf" , "Star Fox", "Blaster",
                "Wolf Flash", "Reflector", "Fire Wolf");

        // Villager
        insertFighter("Villager" , "Animal Crossing", "Pocket",
                "Lloid Rocket", "Timber", "Balloon Trip");

        // Mega Man
        insertFighter("Mega Man" , "Mega Man", "Metal Blade",
                "Crash Bomber", "Leaf Shield", "Rush Coil");

        // Wii Fit Trainer
        insertFighter("Wii Fit Trainer" , "Wii Fit", "Sun Salutation",
                "Header", "Deep Breathing", "Super Hoop");

        // Rosalina & Luma
        insertFighter("Rosalina & Luma" , "Super Mario", "Luma Shot",
                "Star Bits", "Gravitational Pull", "Launch Star");

        // Little Mac
        insertFighter("Little Mac" , "Punch-Out!!", "Straight Lunge",
                "Jolt Haymaker", "Slip Counter", "Rising Uppercut");


        // Greninja
        insertFighter("Greninja" , "Pokemon", "Water Shuriken",
                "Shadow Sneak", "Substitute", "Hydro Pump");

        // Palutena
        insertFighter("Palutena" , "Kid Icarus", "Autoreticle",
                "Explosive Flame", "Counter/Reflect Barrier", "Warp");


        // PAC-MAN
        insertFighter("PAC-MAN" , "PAC-MAN", "Bonus Fruit",
                "Power Pellet", "Fire Hydrant", "Pac-Jump");

        // Robin
        insertFighter("Robin" , "Fire Emblem", "Thunder",
                "Arcfire", "Nosferatu", "Elwind");

        // Shulk
        insertFighter("Shulk" , "Xenoblade Chronicles", "Monado Arts",
                "Back Slash", "Vision", "Air Slash");

        // Bowser Jr.
        insertFighter("Bowser Jr." , "Super Mario", "Clown Cannon",
                "Clown Kart Dash", "Mechakoopa", "Abandon Ship");

        // Duck Hunt
        insertFighter("Duck Hunt" , "Duck Hunt", "Trick Shot",
                "Clay Shooting", "Wild Gunman", "Duck Jump");

        // Ryu
        insertFighter("Ryu" , "Street Fighter", "Hadoken",
                "Tatsumaki Senpukyaku", "Focus Attack", "Shoryuken");

        // Ken
        insertFighter("Ken" , "Street Fighter", "Hadoken",
                "Tatsumaki Senpukyaku", "Focus Attack", "Flaming Shoryuken");

        // Cloud
        insertFighter("Cloud" , "Final Fantasy", "Blade Beam",
                "Cross Clash", "Limit Charge / Finishing Touch", "Climhazzard");

        // Corrin
        insertFighter("Corrin" , "Fire Emblem", "Dragon Fang Shot",
                "Dragon Lunge", "Counter Surge", "Dragon Ascent");

        // Bayonetta
        insertFighter("Bayonetta" , "Bayonetta", "Bullet Climax",
                "Heel Slide / After Burner Kick", "Witch Time", "Witch Twist");

        // Inkling
        insertFighter("Inkling" , "Splatoon", "Splattershot",
                "Splat Roller", "Splat Bomb", "Super Jump");

        // Ridley
        insertFighter("Ridley" , "Metroid", "Plasma Breath",
                "Space Pirate Rush", "Skewer", "Wing Blitz");

        // Simon
        insertFighter("Simon" , "Castlevania", "Axe",
                "Cross", "Holy Water", "Uppercut");

        // Richter
        insertFighter("Ritcher" , "Castlevania", "Axe",
                "Cross", "Holy Water", "Uppercut");

        // King K. Rool
        insertFighter("King K. Rool" , "Donkey Kong", "Blunderbuss",
                "Crownerang", "Gut Check", "Propellerpack");

        // Isabelle
        insertFighter("Isabelle" , "Animal Crossing", "Pocket",
                "Fishing Rod", "Lloid Trap", "Balloon Trip");


        // Incineroar
        insertFighter("Incineroar", "Pokemon", "Darkest Lariat",
                "Alolan Whip", "Revenge", "Cross Chop");

        // Piranha Plant
        insertFighter("Piranha Plant", "Super Mario", "Ptooie",
                "Poison Breath", "Long-Stem Strike", "Piranhacopter");

        // Joker
        insertFighter("Joker", "Persona", "Gun / Gun Special",
                "Eiha / Eigaon", "Rebel's Guard / Tetrakarn / Makarakarn", "Grappling Hook / Wings of Rebellion");


        // Hero
        insertFighter("Hero", "Dragon Quest", "Frizz/Fizzle/Kafrizz",
                "Zap/Zapple/Kazap", "Command Selection", "Woosh/Swoosh/Kaswoosh");

        // Banjo & Kazooie
        insertFighter("Banjo & Kazooie", "Banjo-Kazooie", "Egg Firing / Breegull Blaster",
                "Wonderwing", "Rear Egg", "Shock Spring Jump");

        // Terry
        insertFighter("Terry", "Fatal Fury", "Power Wave",
                "Burning Knuckle", "Power Dunk", "Rising Tackle");


        // Byleth
        insertFighter("Byleth", "Fire Emblem", "Failnaught",
                "Areadbhar", "Aymr", "Sword of the Creator");

        // Min Min
        insertFighter("Min Min", "ARMS", "Punch",
                "Punch", "ARMS Change", "ARMS JUMP / ARM HOOK");

        // Ivysaur
        insertFighter("Ivysaur", "Pokemon", "Bullet Seed",
                "Razor Leaf", "Pokemon Change", "Vine Whip");


        // Charizard
        insertFighter("Charizard", "Pokemon", "Flamethrower",
                "Flare Blitz", "Pokemon Change", "Fly");

        // Squirtle
        insertFighter("Squirtle", "Pokemon", "Water Gun",
                "Withdraw", "Pokemon Change", "Waterfall");

        // Steve
        insertFighter("Steve", "Minecraft", "Mine / Craft / Create Block",
                "Minecart", "TNT", "Elytra");

        // Sephiroth
        insertFighter("Sephiroth", "Final Fantasy", "Flare/Megaflare/Gigaflare",
                "Shadow Flare", "Scintilla", "Blade Dash / Octaslash");

        // Pyra
        insertFighter("Prya", "Xenoblade Chronicles", "Flame Nova",
                "Blazing End", "Swap to Mythra", "Prominence Revolt");

        // Mythra
        insertFighter("Mythra", "Xenoblade Chronicles", "Lightning Buster",
                "Photon Edge", "Swap to Pyra", "Ray of Punishment / Chroma Dust");

        // Kazuya
        insertFighter("Kazuya", "Tekken", "Devil Baster",
                "Devil Fist", "Heaven's Door", "Devil Wings");

        // Sora
        insertFighter("Sora", "Kingdom Hearts", "Magic",
                "Sonic Blade", "Counterattack", "Aerial Sweep");

    }
}
