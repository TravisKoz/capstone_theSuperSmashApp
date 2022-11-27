package edu.cvtc.myapplication;

import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.FighterEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.TrackerEntry;

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

    // Method that inserts a single fighter into the database.
    private void insertBattleNote(String heading, String body) {
        ContentValues values = new ContentValues();
        values.put(BattleNoteEntry.COLUMN_HEADING, heading);
        values.put(BattleNoteEntry.COLUMN_BODY, body);

        long newRowId = mDb.insert(BattleNoteEntry.TABLE_NAME, null, values);
    }

    // Method used to populate our database with initial TRACKER data.
    public void insertBattleNotes() {
        insertBattleNote("Note 1", "My Message");
        insertBattleNote("Note 2", "Another Message");
    }

    // Method that inserts a single fighter into the database.
    private void insertTracker(String fighter, int wins, int losses) {
        ContentValues values = new ContentValues();
        values.put(TrackerEntry.COLUMN_FIGHTER, fighter);
        values.put(TrackerEntry.COLUMN_WINS, wins);
        values.put(TrackerEntry.COLUMN_LOSSES, losses);

        long newRowId = mDb.insert(TrackerEntry.TABLE_NAME, null, values);
    }

    // Method used to populate our database with initial Tracker data.
    public void insertTrackers() {
        insertTracker("Mario", 0, 0);
        insertTracker("Donkey Kong", 0, 0);
        insertTracker("Mario", 0, 0);
        insertTracker("Link", 0, 0);
        insertTracker("Samus", 0, 0);
        insertTracker("Dark Samus", 0, 0);
        insertTracker("Yoshi", 0, 0);
        insertTracker("Kirby", 0, 0);
        insertTracker("Fox", 0, 0);
        insertTracker("Pikachu", 0, 0);
        insertTracker("Luigi", 0, 0);
        insertTracker("Ness", 0, 0);
        insertTracker("Captain Falcon", 0, 0);
        insertTracker("Jigglypuff", 0, 0);
        insertTracker("Peach", 0, 0);
        insertTracker("Daisy", 0, 0);
        insertTracker("Bowser", 0, 0);
        insertTracker("Ice Climbers", 0, 0);
        insertTracker("Sheik", 0, 0);
        insertTracker("Pikachu", 0, 0);
        insertTracker("Zelda", 0, 0);
        insertTracker("Dr. Mario", 0, 0);
        insertTracker("Pichu", 0, 0);
        insertTracker("Falco", 0, 0);
        insertTracker("Marth", 0, 0);
        insertTracker("Lucina", 0, 0);
        insertTracker("Young Link", 0, 0);
        insertTracker("Ganondorf", 0, 0);
        insertTracker("Mewtwo", 0, 0);
        insertTracker("Roy", 0, 0);
        insertTracker("Chrom", 0, 0);
        insertTracker("Mr. Game & Watch", 0, 0);
        insertTracker("Meta Knight", 0, 0);
        insertTracker("Pit", 0, 0);
        insertTracker("Dark Pit", 0, 0);
        insertTracker("Zero Suit Samus", 0, 0);
        insertTracker("Wario", 0, 0);
        insertTracker("Snake", 0, 0);
        insertTracker("Snake", 0, 0);
        insertTracker("Ike", 0, 0);
        insertTracker("Diddy Kong", 0, 0);
        insertTracker("Lucas", 0, 0);
        insertTracker("Sonic", 0, 0);
        insertTracker("King Dedede", 0, 0);
        insertTracker("Olimar", 0, 0);
        insertTracker("Lucario", 0, 0);
        insertTracker("R.O.B.", 0, 0);
        insertTracker("Toon Link", 0, 0);
        insertTracker("Wolf", 0, 0);
        insertTracker("Villager", 0, 0);
        insertTracker("Mega Man", 0, 0);
        insertTracker("Wii Fit Trainer", 0, 0);
        insertTracker("Rosalina & Luma", 0, 0);
        insertTracker("Little Mac", 0, 0);
        insertTracker("Greninja", 0, 0);
        insertTracker("Palutena", 0, 0);
        insertTracker("PAC-MAN", 0, 0);
        insertTracker("Robin", 0, 0);
        insertTracker("Shulk", 0, 0);
        insertTracker("Bowser Jr.", 0, 0);
        insertTracker("Duck Hunt", 0, 0);
        insertTracker("Ryu", 0, 0);
        insertTracker("Ken", 0, 0);
        insertTracker("Cloud", 0, 0);
        insertTracker("Corrin", 0, 0);
        insertTracker("Bayonetta", 0, 0);
        insertTracker("Inkling", 0, 0);
        insertTracker("Ridley", 0, 0);
        insertTracker("Simon", 0, 0);
        insertTracker("Richter", 0, 0);
        insertTracker("King K. Rool", 0, 0);
        insertTracker("Isabelle", 0, 0);
        insertTracker("Incineroar", 0, 0);
        insertTracker("Piranha Plant", 0, 0);
        insertTracker("Joker", 0, 0);
        insertTracker("Hero", 0, 0);
        insertTracker("Banjo & Kazooie", 0, 0);
        insertTracker("Terry", 0, 0);
        insertTracker("Byleth", 0, 0);
        insertTracker("Min Min", 0, 0);
        insertTracker("Pokemon Trainer", 0, 0);
        insertTracker("Steve", 0, 0);
        insertTracker("Sephiroth", 0, 0);
        insertTracker("Pyra & Mythra", 0, 0);
        insertTracker("Kazuya", 0, 0);
        insertTracker("Sora", 0, 0);
    }

    // Method that inserts a single fighter into the database
    private void insertFighter(String name, String franchise, String specialNeutral,
                               String specialSide, String specialDown,
                               String specialUp, String neutralDescription, String sideDescription,
                               String downDescription, String upDescription,
                               String finalSmash, String finalSmashDescription,
                               String category, String archetype) {
        ContentValues values = new ContentValues();
        values.put(FighterEntry.COLUMN_NAME, name);
        values.put(FighterEntry.COLUMN_FRANCHISE, franchise);
        values.put(FighterEntry.COLUMN_SPECIAL_NEUTRAL, specialNeutral);
        values.put(FighterEntry.COLUMN_SPECIAL_SIDE, specialSide);
        values.put(FighterEntry.COLUMN_SPECIAL_DOWN, specialDown);
        values.put(FighterEntry.COLUMN_SPECIAL_UP, specialUp);
        values.put(FighterEntry.COLUMN_NEUTRAL_DESCRIPTION, neutralDescription);
        values.put(FighterEntry.COLUMN_SIDE_DESCRIPTION, sideDescription);
        values.put(FighterEntry.COLUMN_DOWN_DESCRIPTION, downDescription);
        values.put(FighterEntry.COLUMN_UP_DESCRIPTION, upDescription);
        values.put(FighterEntry.COLUMN_UP_DESCRIPTION, upDescription);
        values.put(FighterEntry.COLUMN_UP_DESCRIPTION, upDescription);
        values.put(FighterEntry.COLUMN_FINAL_SMASH, finalSmash);
        values.put(FighterEntry.COLUMN_FINAL_DESCRIPTION, finalSmashDescription);
        values.put(FighterEntry.COLUMN_CATEGORY, category);
        values.put(FighterEntry.COLUMN_ARCHETYPE, archetype);

        long newRowId = mDb.insert(FighterEntry.TABLE_NAME, null, values);
    }

    // Method used to populate our database with initial Fighters data.
    public void insertFighters() {
        // Mario
        insertFighter("Mario", "Super Mario", "Fireball",
                "Cape", "Super Jump Punch", "F.L.U.D.D",
                "Throws a fireball that bounces along the ground.",
                "Whips out a cape to spin opponents around and reflect projectiles.",
                "Blasts opponents with water. Can charge and aim at an angle.",
                "Hits repeatedly with a rising punch.",
                "Mario Finale",
                "Mario unleashes a devastating torrent of fire in the direction he is facing. The attack covers a wide range and travels far, so it’s best to fire this after you jump.",
                "Hybrid", "Balanced");

        // Donkey Kong
        insertFighter("Donkey Kong", "Donkey Kong", "Giant Punch",
                "Headbutt", "Hand Slap", "Spinning Kong",
                "Charges up a punch that can keep charging after dodging or shielding.",
                "Buries opponents when they’re hit on the ground. Can’t be interrupted by weaker attacks.",
                "Sends out shock waves by slapping the ground, sending foes into the air. Has a meteor effect when airborne.",
                "Spins with a whirlwind of punches. Can shift left or right while airborne and forward while grounded.",
                "Jungle Rush",
                "Donkey Kong pummels opponents with a flurry of punches before launching them with a finishing uppercut. If the first hit doesn't make contact, the whole attack fails, so make sure to get that hit in.",
                "Close-range", "Grappler");

        // Link
        insertFighter("Link", "The Legend of Zelda", "Bow and Arrows",
                "Boomerang", "Remote Bomb", "Spin Attack",
                "Shoots an arrow—two at once if one is picked up off the ground. Can be charged by holding the button.",
                "Throws a boomerang diagonally. The control stick can be flicked for extra power and distance.",
                "Creates a remote bomb with the Sheikah Slate. Down special again detonates it.",
                "Strikes opponents while spinning. Acts as a jump if used in midair.",
                "Ancient Bow and Arrow",
                "Link shoots an Ancient Arrow that flies straight ahead. If the arrow hits an opponent or the terrain, it explodes. You can only hit one fighter, but the explosion also launches nearby opponents.",
                "Long-range", "Zoner");

        // Samus
        insertFighter("Samus", "Metroid", "Charge Shot",
                "Missile", "Bomb", "Screw Attack",
                "Charges up a projectile while on the ground or in midair. Can keep the charge after dodging or shielding.",
                "Launches a homing missile. Flicking rather than tilting the control stick launches a Super Missile.",
                "Drops a bomb in Morph Ball form. Flies upwards if hit by the explosion.",
                "Hits opponents several times while spinning up into the air.",
                "Zero Laser",
                "Samus unleashes a massive, long-range beam. You can angle the beam up and down while firing. Fighters are drawn to the center, and the attack repeatedly hits any foes caught in its blast.",
                "Long-range", "Zoner");

        // Dark Samus
        insertFighter("Dark Samus", "Metroid", "Charge Shot",
                "Missile", "Bomb", "Screw Attack",
                "Charges up a projectile while on the ground or in midair. Can keep the charge after dodging or shielding.",
                "Launches a homing missile. Flicking rather than tilting the control stick launches a Super Missile.",
                "Drops a bomb in Morph Ball form. Flies upwards if hit by the explosion.",
                "Hits opponents several times while spinning up into the air.",
                "Phazon Laser",
                "Dark Samus unleashes a massive, long-range beam. You can angle the beam up and down while firing. Fighters are drawn to the center, and the attack repeatedly hits any foes caught in its blast.",
                "Long-range", "Zoner");

        // Yoshi
        insertFighter("Yoshi", "Yoshi", "Egg Lay",
                "Egg Roll", "Egg Bomb", "Screw Throw",
                "Grabs the opponent with a tongue attack, swallows them, and traps them in an egg.",
                "Turns into an egg and rolls into enemies. Can jump once while in the egg.",
                "Jumps up quickly and slams into the ground, shooting stars out left and right.",
                "Lobs an egg. Can set the angle of the throw with directional inputs.",
                "Stampede!",
                "Yoshi knocks down opponents with a tackle. Then, Yoshis of various colors appear and send the opponent flying! The first tackle can affect up to three opponents, but be sure not to KO yourself if you miss everyone.",
                "Close-range", "Balanced");

        // Kirby
        insertFighter("Kirby", "Kirby", "Inhale",
                "Hammer Flip", "Stone", "Final Cutter",
                "Inhales opponents. Can then copy opponent's ability or spit them out as a star.",
                "Delivers a powerful hammer attack that can launch foes. Dangerous when fully charged.",
                "Turns into a heavy object and plummets downward, taking no damage while transformed.",
                "Jumps high into the air, striking on the way up and on the way down. Creates a shock wave when landing.",
                "Ultra Sword",
                "Kirby swings a sword that's waaaaay bigger than he is. Make sure the first swing connects with an opponent, or nothing else happens!",
                "Close-range", "Balanced");

        // Fox
        insertFighter("Fox", "Star Fox", "Blaster",
                "Fox Illusion", "Reflector", "Fire Fox",
                "Fires lasers that deal damage but don't knock opponents back. Pressing repeatedly fires rapidly.",
                "Dashes at high speed through opponents. Vulnerable to opponents shielding against the attack.",
                "Shields and reflects projectiles, upping their speed and power.",
                "Rockets skyward while engulfed in flames. Can change the direction while charging.",
                "Team Star Fox",
                "Fox uses a targeting reticle to lock on to any opponents right in front of him. If he acquires a target, the Star Fox team shows up and unleashes a formation attack.",
                "Close-range", "Rushdown");

        // Pikachu
        insertFighter("Pikachu", "Pokemon", "Thunder Jolt",
                "Skull Bash", "Thunder", "Quick Attack",
                "Sends a ball of electricity bouncing along the stage.",
                "Charges up a flying headbutt.",
                "Calls down a lightning strike that deals more damage to opponents if the bolt hits Pikachu.",
                "Attacks quickly in any direction. Can change direction midmove to move a second time.",
                "Volt Tackle",
                "Pikachu turns into a ball of electricity that darts all over the stage. If an opponent gets caught in this attack, they'll be constantly hit. Finally, Pikachu unleashes a powerful spark with high launch power.",
                "Hybrid", "Balanced");

        // Luigi
        insertFighter("Luigi", "Super Mario", "Fireball",
                "Green Missile", "Luigi Cyclone", "Super Jump Punch",
                "Throws a fireball straight ahead that bounces if it hits a wall or the ground.",
                "Charges up a diving attack that can explode with unexpected power.",
                "Spins at high speed, catching opponents in the attack. Repeated presses cause him to float and move a bit.",
                "Punches up into the air with the strongest blows at the start of the attack.",
                "Poltergust G-00",
                "Luigi vacuums enemies with hurricane-force suction. Enemies caught by this attack are damaged and fired diagonally upward, potentially soaring right off the screen! If you suck up an item, it becomes a projectile.",
                "Hybrid", "Balanced");

        // Ness
        insertFighter("Ness", "EarthBound", "PK Flash",
                "PK Fire", "PSI Magnet", "PK Thunder",
                "Blasts opponents with electrical energy after reaching full charge. Can be used before full charge for a weaker attack.",
                "Shoots light out straight ahead or diagonally while airborne. Bursts into a pillar of flame if it hits someone.",
                "Absorbs energy-based projectiles and weak explosions to heal damage.",
                "Fires a steerable ball of lighting. Sends Ness flying if he hits himself.",
                "PK Starstorm",
                "With the help of Kumatora and Boney, Lucas calls down a shower of meteors that damage any foes they hit. The meteors fall faster as time passes. The meteors' trajectory can be adjusted slightly with left or right input.",
                "Hybrid", "Balanced");


        // Captain Falcon
        insertFighter("Captain Falcon", "F-Zero", "Falcon Punch",
                "Raptor Boost", "Falcon Kick", "Falcon Dive",
                "Powers up for a moment then strikes with a flaming punch. Can change direction while charging.",
                "Charges forward and hits foes with an uppercut. Can be used in midair to meteor foes downward.",
                "Slides forward with a flaming kick while on the ground and a diagonal kick in the air.",
                "Jumps up to grab foes then explodes to send them flying.",
                "Blue Falcon",
                "The Blue Falcon races directly in front of the Captain, striking opponents and launching them to a race track where he can run them down.",
                "Close-range", "Rushdown");

        // Jigglypuff
        insertFighter("Jigglypuff", "Pokemon", "Rollout",
                "Pound", "Rest", "Sing",
                "Charges up a rolling attack that can reach incredible speeds. Can change direction while rolling.",
                "Steps forward and slaps opponents so hard they fly straight into the air.",
                "Takes a well-earned nap that unleashes hidden power when touching a foe.",
                "Sings a soothing song that makes nearby opponents extremely drowsy.",
                "Puff Up",
                "Jigglypuff puffs itself up until it takes over the majority of the stage, then it rapidly deflates, launching nearby opponents. It's super effective on small stages.",
                "Close-range", "Grappler");

        // Peach
        insertFighter("Peach", "Super Mario", "Toad",
                "Peach Bomber", "Vegetable", "Peach Parasol",
                "Uses Toad as a shield, spreading spores if he gets hit.",
                "Jumps sideways and delivers a powerful hip bash.",
                "Plucks a veggie while on the ground. The veggie's power depends on its mood.",
                "Jumps high into the air and opens her parasol. Keeping it open allows her to slowly float downward.",
                "Peach Blossom",
                "Giant peaches descend from above, and nearby fighters fall asleep. The closer a fighter is to Peach, the longer they stay snoozing, giving Peach plenty of time to launch foes or recover health by eating the giant peaches.",
                "Hybrid", "Balanced");

        // Daisy
        insertFighter("Daisy", "Super Mario", "Toad",
                "Daisy Bomber", "Vegetable", "Daisy Parasol",
                "Uses Toad as a shield, spreading spores if he gets hit.",
                "Creates daisies and delivers a hip bash. Missing leaves her wide open.",
                "Plucks a veggie while on the ground. The veggie's power depends on its mood.",
                "Jumps high into the air and opens her parasol. Keeping it open allows her to slowly float downward.",
                "Daisy Blossom",
                "Giant daisies float down from above, and nearby fighters fall asleep. The closer a fighter is to Daisy, the longer they stay snoozing, giving Daisy plenty of time to launch foes or recover health by smelling the daisies.",
                "Hybrid", "Balanced");

        // Bowser
        insertFighter("Bowser", "Super Mario", "Fire Breath",
                "Flying Slam", "Bowser Bomb", "Whirling Fortress",
                "Breathes fire. The range decreases if used too much. The angle can be controlled a little bit.",
                "Grabs an opponent, jumps into the air, and then slams them to the ground.",
                "Butt-stomps enemies. On the ground, he can lift opponents with his horns.",
                "Ducks inside his shell and spins. Can be moved sideways while spinning.",
                "Giga Bowser Punch",
                "Bowser transforms into the gigantic Giga Bowser. Aim carefully and unleash a ferocious punch. If an opponent has already taken a lot of damage when they're hit, they are KO'd instantly.",
                "Close-range", "Grappler");

        // Ice Climbers
        insertFighter("Ice Climbers", "Ice Climbers", "Ice Shot",
                "Squall Hammer", "Blizzard", "Belay",
                "Create ice chunks and hit them with hammers. The chunks slide on the ground and bounce off walls.",
                "Twirl with their hammers extended. Directional input can move them left and right.",
                "Unleash an icy flurry that may freeze foes. On an already frozen foe, this prolongs their freeze.",
                "Nana pulls on the rope that Popo throws, and the two work together to jump up high.",
                "Iceberg",
                "A huge iceberg emerges in the center of the stage. Opponents are hit each time they touch it. You can control the iceberg with left or right inputs. You also move as normal, so be wary of self-destructing.",
                "Hybrid", "Balanced");

        // Sheik
        insertFighter("Sheik", "The Legend of Zelda", "Needle Storm",
                "Burst Grenade", "Bouncing Fish", "Vanish",
                "Throws needles forward on the ground or diagonally downward in the air. Throw more needles if charged longer.",
                "Throws a stealthy grenade that pulls opponents in before exploding.",
                "Flips through the air and strikes foes with her heel. If the kick lands, she bounces back.",
                "Throws a bomb to the ground and warps in any direction. Deals some damage.",
                "Sheikah Dance",
                "Sheik charges forward and strikes an opponent in her path. Upon being hit, the opponent is surrounded by darkness, and Sheik unleashes multiple quick attacks. The final attack can strike other opponents as well.",
                "Hybrid", "Rushdown");

        // Zelda
        insertFighter("Zelda", "The Legend of Zelda", "Nayru's Love",
                "Din's Fire", "Phantom Slash", "Farore's Wind",
                "Envelops herself in a crystal that deals damage and reflects projectiles.",
                "Fires magic that explodes after a time or when the button is released.",
                "Assembles a phantom, then sends it charging forward. The timing of the button press determines its attack.",
                "Teleports herself in any direction. Deals damage when disappearing and reappearing.",
                "Triforce of Wisdom",
                "Zelda uses the Triforce of Wisdom against an opponent, damaging and launching them. If the opponent has 100% damage or more, they are sealed away (and KO'd) instead of being launched.",
                "Long-range", "Zoner");

        // Dr. Mario
        insertFighter("Dr. Mario", "Super Mario", "Megavitamins",
                "Super Sheet", "Dr. Tornado", "Super Jump Punch",
                "Throws a vitamin capsule that bounces off the ground.",
                "Reflects projectiles with a sheet. Has a shorter reach but a wider vertical range than Mario's.",
                "Spins rapidly. He can move sideways while spinning and even rise, with repeated button presses!",
                "Hits repeatedly with a rising punch that, while lacking coins, is extra powerful at the start of the jump.",
                "Doctor Finale",
                "Dr. Mario lets loose a pair of giant vitamin capsules that spirals through the air, pushing opponents away. The attack covers a wide area and travels far, so it's best to unleash this after jumping.",
                "Hybrid", "Balanced");

        // Pichu
        insertFighter("Pichu", "Pokemon", "Thunder Jolt",
                "Skull Bash", "Thunder", "Agility",
                "Sends a ball of electricity bouncing across the stage. The ball is faster than Pikachu's!",
                "Charges up a flying headbutt that when fully charged does more damage than Pikachu's.",
                "Calls down thunder from above to hurt nearby opponents. However, Pichu also takes a small amount of damage.",
                "Moves at high speed! The direction can be changed once, and it travels a bit farther than Pikachu's.",
                "Volt Tackle,",
                "Pichu turns into a ball of electricity that darts around at high speed. If an opponent gets caught in this attack, they'll be constantly hit. Pichu also takes damage from this attack.",
                "Close-range", "Rushdown");

        // Falco
        insertFighter("Falco", "Star Fox", "Blaster",
                "Falco Phantasm", "Reflector", "Firebird",
                "Fires Blaster shots less rapidly than Fox, but his makes enemies flinch.",
                "Dashes forward with incredible speed. Hit an airborne opponent to meteor them downward.",
                "Kicks out an energy shield that reflects projectiles and deals damage.",
                "Wraps himself in flame, and dashes through the air in the direction the control stick is titled.",
                "Team Star Fox",
                "Falco uses a targeting reticle to lock on to any opponents right in front of him. If he acquires a target, a team of Arwings shows up and fires at will.",
                "Close-range", "Rushdown");

        // Marth
        insertFighter("Marth", "Fire Emblem", "Shield Breaker",
                "Dancing Blade", "Counter", "Dolphin Slash",
                "Stabs with such powerful force that at max charge, he can destroy a shield in one hit!",
                "Slashes opponents up to four times, with repeated button presses. Tilting up and down can change each attack.",
                "Prepares for an attack and strikes back if hit. The power depends on the enemy's attack.",
                "Strikes upward as he rises into the air. Deals the most damage at the start.",
                "Critical Hit",
                "Marth dashes forward and strikes. If the attack connects, it has the potential to be a one-hit KO. Marth dashes forward a long distance, so there's a risk that you can self-destruct, but you can press the button again to stop.",
                "Close-range", "Spacing");

        // Lucina
        insertFighter("Lucina", "Fire Emblem", "Shield Breaker",
                "Dancing Blade", "Counter", "Dolphin Slash",
                "Stabs with such precision that her fully charged attack can destroy a shield.",
                "Slashes opponents up to four times, with repeated button presses. Tilting up and down can change each attack.",
                "Prepares for an attack and strikes back if hit. The power depends on the enemy's attack.",
                "Strikes upward as she rises into the air. Deals the most damage at the start.",
                "Critical Hit",
                "Lucina dashes forward and strikes. If the attack connects, it has the potential to be a one-hit KO. Lucina dashes forward a long distance, so there's a risk that you can self-destruct, but you can press the button again to stop.",
                "Close-range", "Spacing");

        // Young Link
        insertFighter("Young Link", "The Legend of Zelda", "Fire Arrow",
                "Boomerang", "Bomb", "Spin Attack",
                "Fires an arrow. The longer the button is held, the stronger the shot.",
                "Throws a boomerang. He can even throw it diagonally. A flick of the stick can change the power and distance.",
                "Pulls out a throwable bomb that explodes on impact or when the fuse runs out.",
                "Spins with his blade outstretched. Can be charged if used on the ground, and acts as a jump if used midair.",
                "Triforce Slash",
                "Young Link dashes forward to seal an opponent in the Triforce. He then strikes them repeatedly before launching them. The initial strike must hit in order for Young Link to begin his sealing combo.",
                "Hybrid", "Balanced");

        // Ganondorf
        insertFighter("Ganondorf", "The Legend of Zelda", "Warlock Punch",
                "Flame Choke", "Wizard's Foot", "Dark Dive",
                "Channels dark energy into a devastating punch. Difficult to interrupt.",
                "Rushes forward to grab an enemy. Grabbed enemies are thrown straight down.",
                "Propels forward with a kick charged by dark power. In the air, he plunges diagonally downward.",
                "Leaps upward and grabs opponents, electrocuting and launching them. It cannot be blocked by a shield.",
                "Ganon, The Demon King",
                "Ganondorf transforms into a boar-like beast, stuns nearby opponents with his gigantic blades, and then charges forward with full force to the edge of the stage. This move can hit all opponents in Ganondorf's line of attack.",
                "Close-range", "Grappler");

        // Mewtwo
        insertFighter("Mewtwo", "Pokemon", "Shadow Ball",
                "Confusion", "Disable", "Teleport",
                "Fires an energy projectile. Charging it for longer increases its damage and launch power.",
                "Uses psychic energy to topple an opponent in front. It can also reflect projectiles.",
                "Makes eye contact with an enemy to stun them. Ineffective when airborne or not facing an opponent.",
                "Warps instantly to another location. Directional input determines the destination.",
                "Psystrike",
                "Mewtwo Mega Evolves into Mega Mewtwo Y and fires a projectile that freezes and launches every foe it hits. This move travels through landscapes and opponents, making it easy to hit multiple opponents.",
                "Hybrid", "Balanced");

        // Roy
        insertFighter("Roy", "Fire Emblem", "Flare Blade",
                "Double-Edge Dance", "Counter", "Blazer",
                "Slashes downward with a flaming sword so powerfully that he can even damage himself.",
                "Slashes opponents up to four times, with repeated button presses. Tilting up or down can change each attack.",
                "Readies himself and turns aside any attack, sending it back against his foe, with greater force.",
                "Jumps into the air with a slash wrapped in flames. The jump angle can be altered.",
                "Critical Hit",
                "Roy swings his blade around to catch enemies, and then brings the sword down to finish them off in a blast of fire. The initial swing not only hits opponents in front of Roy, but also those behind him.",
                "Close-range", "Rushdown");

        // Chrom
        insertFighter("Chrom", "Fire Emblem", "Flare Blade",
                "Double-Edge Dance", "Counter", "Soaring Slash",
                "Swings his sword to the ground with such force that even he is not spared damage when fully charged.",
                "Slashes opponents up to four times, with repeated button presses. Tilting up or down can change each attack.",
                "Adopts a stance and counterattacks with greater force than the received attack.",
                "Jumps upward and then slashes down while twirling. Drops straight down and launches opponents on the ground.",
                "Awakening Aether",
                "Chrom quickly charges forward, slashes upward, then swings his blade diagonally to launch opponents upward. If the first hit misses, the move doesn't activate. If it hits, the move can hit multiple opponents.",
                "Close-range", "Rushdown");

        // Mr. Game & Watch
        insertFighter("Mr. Game & Watch", "Game & Watch", "Chef",
                "Judge", "Oil Panic", "Fire",
                "Flings inedible food from a frying pan. Up to five things can be flung with repeated button presses.",
                "Swings his hammer. The power changes depending on the number displayed.",
                "Collects projectiles in a bucket, or reflects projectiles he cannot collect. Tosses oil when the bucket is full!",
                "Launches into the air and opens a parachute, allowing him to glide down.",
                "Octopus",
                "Mr. Game & Watch turns into a giant octopus, grabbing anyone he touches and dragging them off-screen. Button inputs control his four tentacles, which stretch and shrink. The octopus can also be moved up and down with the stick.",
                "Hybrid", "Balanced");

        // Meta Knight
        insertFighter("Meta Knight", "Kirby", "Mach Tornado",
                "Drill Rush", "Dimensional Cape", "Shuttle Loop",
                "Twirls and hits enemies to launch them. Repeated button presses can change the direction or cause him to float.",
                "Spins into opponents with his sword. The angle can be changed a bit.",
                "Vanishes, teleports in any direction, and then attacks reappearing.",
                "Flies into the air, strikes, then strikes again after a loop. Enemies hit by this move are launched upward.",
                "Darkness Illusion",
                "Meta Knight raises his sword, emitting a blast of electricity. If he hits an opponent, he multiplies himself to attack and launch the opponent. If no one is hit, the move won't do anything.",
                "Close-range", "Rushdown");


        // Pit
        insertFighter("Pit", "Kid Icarus", "Palutena Bow",
                "Upperdash Arm", "Guardian Orbitars", "Power of Flight",
                "Fires a guidable arrow. While charging, the bow can be aimed straight up.",
                "Dashes forward and uppercuts opponents. Can deflect projectiles.",
                "Shields his front and back and reflects projectiles, but he's vulnerable from above.",
                "Flies high through the air. The flight angle can be changed while charging.",
                "Lightning Chariot",
                "Pit boards the Lightning Chariot and targets opponents with a targeting reticle before charging forward and launching any opponents he hits.",
                "Hybrid", "Balanced");

        // Dark Pit
        insertFighter("Dark Pit", "Kid Icarus", "Silver Bow",
                "Electroshock Arm", "Guardian Orbitars", "Power of Flight",
                "Fires an arrow of darkness. Stronger than Pit's arrows, but they don't curve as much.",
                "Charges forward with a weapon that launches foes diagonally upward.",
                "Shields his front and back and reflects projectiles, but he's vulnerable from above.",
                "Soars on shining black wings in any upward direction.",
                "Dark Pitt Staff",
                "Dark Pit uses his staff to launch opponents with a high-speed horizontal blast that goes straight through obstacles. It can hit multiple foes in a row, but only the first feels its full force.",
                "Hybrid", "Balanced");

        // Zero Suit Samus
        insertFighter("Zero Suit Samus", "Metroid", "Paralyzer",
                "Plasma Whip", "Flip Jump", "Boost Kick",
                "Fires an energy blast that stuns enemies. A max charge increases range, power, and stun duration.",
                "Attacks foes with an energy whip. Can also be used to grab on to edges.",
                "Flips through the air and buries opponents into the ground if she lands on them.",
                "Raises into the air, striking multiple times, and then finishes with a spinning kick.",
                "Zero Laser",
                "Zero Suit Samus leaps to her Gunship and, donning her Power Suit, takes aim using a targeting reticle. Once fired, the laser hits consecutively and deals major damage. It finishes with one last energy blast that launches opponents.",
                "Close-range", "Rushdown");

        // Wario
        insertFighter("Wario", "Wario", "Chomp",
                "Wario Bike", "Wario Waft", "Corkscrew",
                "Eats enemies, projectiles, and items with a big, toothy bite.",
                "Rides around on a bike and crashes into enemies. Takes some time to recharge.",
                "Releases noxious gas from his rear end. It, uh ...\"charges\" automatically.",
                "Jumps while spinning, hitting opponents multiple times.",
                "Wario-Man",
                "Wario wolfs down garlic and delivers a headbutt. Any foes hit by the headbutt are forced to deal with multiple Wario-Men's striking fists of justice. Finally, Wario-Man launches the foes with carefully stored flatulence. After transforming into Wario Man, he splits himself into copies that attack all at once. The final fart isn't affected by the charge of his down-special fart.",
                "Close-range", "Balanced");

        // Snake
        insertFighter("Snake", "Metal Gear", "Hand Grenade",
                "Remote Missile", "C4", "Cypher",
                "Throws a grenade that detonates after a short time. Holding the button can delay the grenade toss.",
                "Shoots a missile that flies forward. The direction can be adjusted while it flies.",
                "Plants an explosive on the ground or directly on an opponent. Using down special again sets it off.",
                "Grabs on to a Cypher and flies up into the air to avoid attacks. Pressing down causes Snake to let go.",
                "Covering Fire",
                "Snake calls for reinforcements, and then uses a targeting reticle to lock on to foes up to five times. Missiles are launched at the targets. If you don't lock on anyone, the missiles fly toward the reticle's last location.",
                "Long-range", "Zoner");

        // Ike
        insertFighter("Ike", "Fire Emblem", "Eruption",
                "Quick Draw", "Counter", "Aether",
                "Plunges his sword into the ground, triggering a fiery burst. Suffers damage by his own hand when fully charged.",
                "Lunges forward and slashes at any foe in his path. Can be charged.",
                "Blocks and counters an attack. The strength of the opponent's strike decides the strength of the counter.",
                "Throws his sword upward, jumps to grab it, and then swings it on the way down.",
                "Great Aether",
                "Ike knocks his foes into the air and then strikes them repeatedly. Finally, he slams them down to the ground with a single powerful blow. The first strike lacks reach, but it can hit multiple opponents.",
                "Close-range", "Spacing");

        // Diddy Kong
        insertFighter("Diddy Kong", "Donkey Kong", "Peanut Popgun",
                "Monkey Flip", "Banana Peel", "Rocketbarrel Boost",
                "Fires peanuts, shell and all. If charged for too long, it'll blow up in his face!",
                "Leaps forward and grabs whomever he contacts. A second button press causes him to kick.",
                "Throws a banana peel behind himself to trip foes. Only one peel can exist at a time.",
                "Rockets through the air and tackles opponents. Can be charged for extra distance.",
                "Hyper Rocketbarrel",
                "Diddy Kong multiplies himself and flies around the stage. He sometimes targets an opponent and charges at them. At the end of the attack, Diddy Kong charges at the opponent he damaged the most to launch them.",
                "Hybrid", "Rushdown");

        // Lucas
        insertFighter("Lucas", "EarthBound", "PK Freeze",
                "PK Fire", "PSI Magnet", "PK Thunder",
                "Launches a projectile that freezes enemies. The projectile's path can be controlled.",
                "Fires light that explodes when it hits, erupting into a column of flame that launches enemies.",
                "Absorbs energy-based projectiles and weak explosions. Activates faster and heals more than Ness's.",
                "Fires a steerable ball of lighting. Sends Lucas flying if he hits himself.",
                "PK Starstorm",
                "With the help of Kumatora and Boney, Lucas calls down a shower of meteors that damage any foes they hit. The meteors fall faster as time passes. The meteors' trajectory can be adjusted slightly with left or right input.",
                "Hybrid", "Balanced");

        // Sonic
        insertFighter("Sonic", "Sonic", "Homing Attack",
                "Spin Dash", "Spin Charge", "Spring Jump",
                "Leaps into the air, then homes in on the nearest fighter if one is close enough.",
                "Rolls forward at high speed. Can be charged, redirected, and linked to other attacks.",
                "Dashes forward rapidly. Can be powered up by repeatedly pressing the special-move button.",
                "Creates a spring and leaps up high. The spring sticks around if used on the ground.",
                "Super Sonic",
                "Sonic uses the Chaos Emeralds to turn into Super Sonic and then dashes left and right, crossing through the stage at supersonic speed. You can adjust the angle at which Sonic moves through the air slightly up or down.",
                "Close-range", "Rushdown");

        // King Dedede
        insertFighter("King Dedede", "Kirby", "Inhale",
                "Gordo Throw", "Jet Hammer", "Super Dedede Jump",
                "Inhales opponents and spits them out as stars.",
                "Throws a Gordo. The Gordo can be hit back if attacked by an opponent with the right timing.",
                "Charges up his hammer for a mighty blow. Can move while charging but takes damage if charged too long.",
                "Jumps up high and then crashes downward. Can be canceled by tilting up.",
                "Dede-Rush",
                "Dedede slams an opponent into a chain-link cage with his hammer before unleashing missiles. He then transforms into Masked Dedede and launches the opponent. If you miss the first swing, the move doesn't activate.",
                "Hybrid", "Balanced");

        // Olimar
        insertFighter("Olimar", "Pikmin", "Pikmin Pluck",
                "Pikmin Throw", "Pikmin Order", "Winged Pikmin",
                "Plucks a maximum of three Pikmin in this order: red, yellow, blue, white, purple.",
                "Throws Pikmin. Most Pikmin stick to opponents, but Purple Pikmin slam them.",
                "Blows his whistle to recall Pikmin and change their order.",
                "Summons Winged Pikmin to fly him around. Less effective if laden with Pikmin.",
                "End of Day",
                "Olimar boards a ship and flies off, leaving his foes at the mercy of the indigenous creatures. The ship's return can be controlled with left and right. Upon landing, it explodes and launches nearby foes.",
                "Long-range", "Zoner");

        // Lucario
        insertFighter("Lucario", "Pokemon", "Aura Sphere",
                "Force Palm", "Double Team", "Extreme Speed",
                "Charges a ball of energy that can damage foes even while powering up. Pressing again launches it.",
                "Unleashes concentrated energy with a powerful punch. Grabs enemies if they're close enough.",
                "Prepares for an incoming attack, and counterattacks with a sliding kick if struck.",
                "Dashes through the air and attacks at the end. Can swerve midflight with directional input.",
                "Aura Storm",
                "Lucario Mega evolves into Mega Lucario and jumps straight up. Then Lucario fires Aura straight down. The angle of the Aura can be adjusted left or right. Aim for opponents to deal the most damage you can.",
                "Hybrid", "Balanced");

        // R.O.B.
        insertFighter("R.O.B.", "R.O.B.", "Robo Beam",
                "Arm Rotor", "Gyro", "Robo Burner",
                "Fires a laser beam, but only when the LED on its head is flashing. It can bounce off the floor.",
                "Hops forward with an arm-spinning attack. Can also reflect projectiles.",
                "Fires a spinning top. Only one can be on the stage at a time. Can be charged.",
                "Flies into the air or hovers with its thrusters. Can also attack while airborne.",
                "Guided Robo Beam",
                "R.O.B. automatically lock on to multiple opponents, then fires homing lasers at them. Finish the attack by shooting a giant beam that hits multiple targets. The angle of the beam can be adjusted up or down.",
                "Hybrid", "Balanced");

        // Toon Link
        insertFighter("Toon Link", "The Legend of Zelda", "Hero's Box",
                "Boomerang", "Bomb", "Spin Attack",
                "Fires an arrow from his bow. It can be charged up for more power and range.",
                "Deals damage on its way out and on its way back. Can be thrown diagonally.",
                "Pulls out a throwable bomb. It'll explode after a while or when it hits something.",
                "Spins with his sword. Can hit opponents more than once and can be charged.",
                "Triforce Slash",
                "Toon Link charges forward and traps his foes in the Triforce. Then Toon Link strikes at foes repeatedly and launches them. Time the initial attack well, because missing the first slash leaves Toon Link hanging.",
                "Hybrid", "Balanced");

        // Wolf
        insertFighter("Wolf", "Star Fox", "Blaster",
                "Wolf Flash", "Reflector", "Fire Wolf",
                "Fires his Blaster quickly, or attacks close opponents with the claw-like blade on the Blaster.",
                "Jumps upward diagonally and attacks nearby opponents. Has a meteor effect against airborne enemies if timed right.",
                "Reflects projectiles with a shield. Takes longer than the version Fox uses, but it has greater power.",
                "Unleashes a jump kick that hits multiple times. Directional input can change the direction of the jump.",
                "Team Star Wolf",
                "Wolf displays a targeting reticle in front of himself, which can lock on to opponents. If Wolf catches an opponent in the attack his team shows up and aids him firing on the target.",
                "Close-range", "Rushdown");

        // Villager
        insertFighter("Villager", "Animal Crossing", "Pocket",
                "Lloid Rocket", "Timber", "Balloon Trip",
                "Pockets an item or projectile to use later. A second button press takes it back out.",
                "Fires Lloid forward like a rocket. Lloid can be ridden if the button is held.",
                "Plants a seed, waters it, and chops the tree down. Each step has a different effect on foes.",
                "Dons a balloon hat and flies around. Great maneuverability, but the balloons can be popped.",
                "Dream Home",
                "Tom Nook and his gang rush in to build a totally affordable and reliable house for you. Then the house explodes, sending nearby opponents flying.",
                "Long-range", "Zoner");

        // Mega Man
        insertFighter("Mega Man", "Mega Man", "Metal Blade",
                "Crash Bomber", "Leaf Shield", "Rush Coil",
                "Throws Metal Man's spinning saw, which goes through foes. The direction it travels can be chosen.",
                "Fires Crash Man's bomb, which attaches to any opponent in its path and explodes.",
                "Fires Wood Man's leaves, which can be used to protect himself if the button is held.",
                "Summons his faithful dog, Rush, to propel him to new heights.",
                "Mega Legends",
                "Mega Man fires a Black Hole Bomb forward and draws in opponents. Anyone pulled in faces several generations of Mega Man, as well as Proto Man and Bass, who all fire their Busters in unison.",
                "Long-range", "Zoner");

        // Wii Fit Trainer
        insertFighter("Wii Fit Trainer", "Wii Fit", "Sun Salutation",
                "Header", "Deep Breathing", "Super Hoop",
                "Charges a ball of energy. A second button press launches it. Heals slightly when fully charged.",
                "Heads a soccer ball at opponents. A second button press heads the soccer ball early.",
                "Inhales deeply. Can heal, boost movement, and increase launch power with good timing.",
                "Gyrates into the air, striking opponents. Floating is possible with rapid button presses.",
                "Wii Fit",
                "Wii Fit Trainer sends an army of yoga pose silhouettes flying out. These silhouettes grow in size and push foes away, even off the stage! Foes that are close when this move begins may be hit multiple times in a row.",
                "Long-range", "Zoner");

        // Rosalina & Luma
        insertFighter("Rosalina & Luma", "Super Mario", "Luma Shot",
                "Star Bits", "Gravitational Pull", "Launch Star",
                "Flings Luma forward. A second button press calls Luma back. Can be charged.",
                "Commands Luma to fire three Star Bits forward. Works at any range.",
                "Draws items and projectiles safely toward her. While being drawn in, they can damage foes.",
                "Flies into the air at an angle. The angle can be adjusted with left or right directional input.",
                "Grand Star",
                "A Grand Star shoots out stars while also pulling in opponents that are hit. In the end, the Grand Star explodes. Rosalina and Luma can freely move around during the Final Smash, giving them a chance to land extra attacks.",
                "Hybrid", "Balanced");

        // Little Mac
        insertFighter("Little Mac", "Punch-Out!!", "Straight Lunge",
                "Jolt Haymaker", "Slip Counter", "Rising Uppercut",
                "Blasts forward with a powerful punch. One button press begins the charge and a second unleashes the strike.",
                "Waits for his opponent to attack, and then counters with an uppercut.",
                "Leaps forward, dodging low attacks and delivering a punch. A second press unleashes the punch early.",
                "Punches upward while twisting into the air. Hits opponents multiple times.",
                "Giga Mac Rush",
                "Little Mac transforms into Giga Mac and charges forward. If he strikes an opponent, he unleashes a flurry of punches, finishing with a powerful uppercut. If the initial blow misses, he transforms back into Little Mac.",
                "Close-range", "Rushdown");

        // Greninja
        insertFighter("Greninja", "Pokemon", "Water Shuriken",
                "Shadow Sneak", "Substitute", "Hydro Pump",
                "Fires a shuriken of water straight ahead. Charging it up makes the shuriken grow!",
                "Sends a shadow along the ground. When the button's released, it warps to that point and strikes!",
                "Evades an incoming enemy attack by summoning a substitute and then counterattacking.",
                "Fires a powerful water jet, propelling itself in whichever direction the stick is tilted.",
                "Secret Ninja Attack",
                "Greninja uses Mat Block to flip foes into the air before striking them repeatedly and smacking them back down to the ground. The Mat Block doesn't have much range, so make use of Greninja's speed to get in close to opponents.",
                "Close-range", "Rushdown");

        // Palutena
        insertFighter("Palutena", "Kid Icarus", "Autoreticle",
                "Explosive Flame", "Counter/Reflect Barrier", "Warp",
                "Fires energy blasts from her staff directly at opponents in front of her.",
                "Sets off an explosion a distance away. The stick can be flicked to make it go even farther.",
                "Counters physical attacks and reflects projectiles.",
                "Teleports in any direction. Can't attack or be attacked while warping.",
                "Black Hole Laser",
                "Palutena creates a black hole to pull in foes before unleashing a wide laser beam to damage and launch them. The beam deals more damage to fighters caught in the black hole.",
                "Hybrid", "Balanced");


        // PAC-MAN
        insertFighter("PAC-MAN", "PAC-MAN", "Bonus Fruit",
                "Power Pellet", "Fire Hydrant", "Pac-Jump",
                "Summons a variety of fruit to throw at his foes. Some of it seems a little less edible, though...",
                "Summons a row of Pac-Dots ending in a Power Pellet, and sends himself on a retro dash.",
                "Summons a fire hydrant that shoots powerful jets of water, pushing nearby fighters.",
                "Bounces high into the air with a trampoline that sticks around for a little while.",
                "Super Pac-Man",
                "PAC-MAN grows giant and moves across the screen at high speed. You can adjust the direction a bit with each crossing. The landscape doesn't affect this giant PAC-MAN, and foes he chomps are launched.",
                "Hybrid", "Balanced");

        // Robin
        insertFighter("Robin", "Fire Emblem", "Thunder",
                "Arcfire", "Nosferatu", "Elwind",
                "Unleashes lightning magic that can be charged to cast Elthunder, Arcthunder, and Thoron.",
                "Casts a spell to throw a ball of fire. When it hits, it triggers a pillar of flame.",
                "Conjures a dark curse that steals the life force of enemies.",
                "Casts wind magic downward, dealing damage and boosting into the air twice.",
                "Pair Up",
                "Chrom dashes forward, and if he lands a hit, Robin joins him for a combination of attacks and launches the foe. After the attack, the Levin Sword and each tome are fully charged. Make sure to hit a foe with the initial dash.",
                "Long-range", "Zoner");

        // Shulk
        insertFighter("Shulk", "Xenoblade Chronicles", "Monado Arts",
                "Back Slash", "Vision", "Air Slash",
                "Switches Arts—each has a different advantage. Can be switched by holding or pressing repeatedly.",
                "Leaps forward and delivers a powerful slash. Deals massive damage to an enemy attacked from behind.",
                "Evades an incoming enemy attack and delivers a swift counterattack.",
                "Lifts enemies into the air with a rising slash. Can be followed up with a midair strike.",
                "Chain Attack",
                "Shulk unleashes a bright circle of light in front of him and calls upon his friends to help unleash a combo attack that deals damage to anyone caught in the light. The damage done depends on which of the Monado Arts is active.",
                "Close-range", "Spacing");

        // Bowser Jr.
        insertFighter("Bowser Jr.", "Super Mario", "Clown Cannon",
                "Clown Kart Dash", "Mechakoopa", "Abandon Ship",
                "Fires a slow, heavy cannonball. Can be charged to boost the cannonball's speed and power.",
                "Transforms the Junior Clown Car into a kart that speeds forward. Changing directions spins the kart.",
                "Deploys a Mechakoopa that explodes if thrown, attacked, or just left alone.",
                "Ejects from the Junior Clown Car just before it explodes. He can attack while he falls.",
                "Shadow Mario Paint",
                "Bowser Jr. becomes Shadow Mario in order to deal damage by painting a giant X on the screen. He is able to move during his Final Smash, allowing him to pull off follow-up attacks on his opponents.",
                "Hybrid", "Zoner");

        // Duck Hunt
        insertFighter("Duck Hunt", "Duck Hunt", "Trick Shot",
                "Clay Shooting", "Wild Gunman", "Duck Jump",
                "Kicks an explosive can. Additional button presses shoot it, bouncing it forward and boosting its power.",
                "Tosses a clay pigeon, which breaks apart into damaging shards when shot. A second button press shoots.",
                "Calls one of five gunmen who each have a different style. They can be defeated.",
                "Flies into the air with nostalgic flapping sound. Can attack or dodge after a short time.",
                "NES Zapper Posse",
                "A flock of ducks flies by, and any opponents hit by them are set up for five gunmen to fire at. If the ducks don't hit anyone, nothing at all happens.",
                "Long-range", "Zoner");

        // Ryu
        insertFighter("Ryu", "Street Fighter", "Hadoken",
                "Tatsumaki Senpukyaku", "Focus Attack", "Shoryuken",
                "Fires an energy wave from his palms. Holding down the button increases its speed and power.",
                "Whirls with powerful kicks that move him forward for as long as the button is held.",
                "Focuses, allowing himself to soak up one attack. The longer the charge, the longer the enemy is stunned.",
                "Jumps with a powerful uppercut, which is strongest at the start. Power and speed increased if held.",
                "Shin Shoryuken / Shinku Hadoken",
                "Ryu unleashes a Shinku Hadoken that penetrates through the stage, allowing it to hit multiple opponents and deal serious damage. If Ryu is close to an enemy, he uses a Shin Shoryuken uppercut attack instead.",
                "Close-range", "Rushdown");

        // Ken
        insertFighter("Ken", "Street Fighter", "Hadoken",
                "Tatsumaki Senpukyaku", "Focus Attack", "Flaming Shoryuken",
                "Fires an energy wave from his palms. Holding down the button increases its speed and power.",
                "Whirls with powerful kicks that move him forward. Hits opponents multiple times unlike Ryu's.",
                "Focuses, allowing himself to soak up one attack. If charged to the max the enemy's shield won't help them.",
                "Ascends with a flaming uppercut when holding the button. Has more attack and horizontal-launch power than Ryu's.",
                "Shippu Jinraikyaku / Shinryuken",
                "Ken twirls and rises up with a Shinryuken, dealing damage to foes and tossing them into the air. If a foe is close to Ken, the attack becomes a Shippu Jinraikyaku, instead unleashing a flurry of kicks.",
                "Close-range", "Rushdown");

        // Cloud
        insertFighter("Cloud", "Final Fantasy", "Blade Beam",
                "Cross Clash", "Limit Charge / Finishing Touch", "Climhazzard",
                "Slashes the air to send out a shock wave. During Limit Break, the wave can hit multiple enemies.",
                "Executes an attack that can be expanded into the full combo with two follow-up button presses.",
                "Charges up the Limit Gauge. The Limit Break version launches opponents upward.",
                "Thrusts his sword and then jumps into the air. Plunges with a high-speed cut if pressed again.",
                "Omnislash / Omnislash Ver. 5",
                "Cloud dashes forward and strikes foes. He then dashes upward and unleashes a flurry of swift slashes, finishing with a powerful blow that launches foes downward. Use it when the battle gets heated and try to hit several enemies.",
                "Close-range", "Spacing");

        // Corrin
        insertFighter("Corrin", "Fire Emblem", "Dragon Fang Shot",
                "Dragon Lunge", "Counter Surge", "Dragon Ascent",
                "Shoots a paralyzing projectile from Corrin's dragon arm, which bites any close enemies. Can be charged up.",
                "Leaps forward and skewers enemies or surfaces. A follow-up button press vaults Corrin forward with a kick.",
                "Awaits an attack and punishes it by turning into a dragon, launching enemies with jets of water.",
                "Flies into the air, dealing damage while climbing. The direction can be controlled somewhat.",
                "Torrential Roar",
                "Corrin creates two columns of light, one on each side. If the columns hit a foe, Corrin transforms into a dragon and unleashes a maelstrom that damages and launches. This move is great at hitting foes above you.",
                "Hybrid", "Spacing");

        // Bayonetta
        insertFighter("Bayonetta", "Bayonetta", "Bullet Climax",
                "Heel Slide / After Burner Kick", "Witch Time", "Witch Twist",
                "Quickly fires a volley from two guns. Can be charged for more power and extended by tapping the button.",
                "Slides across the ground (or diagonally in the air) with a speedy kick. Another kick is possible if it connects midair.",
                "Avoids an enemy attack and slows down time. The effect is reduced with repeated use.",
                "Spins up into the air like a cyclone. A second twist is possible if combined with a midair jump.",
                "Infernal Climax",
                "Bayonetta enters Witch Time and attacks foes to fill up her magic gauge. If she fills the gauge, she summons the demon Gomorrah, who attacks up to three opponents. Keep pressing the button to increase Gomorrah's damage.",
                "Close-range", "Rushdown");

        // Inkling
        insertFighter("Inkling", "Splatoon", "Splattershot",
                "Splat Roller", "Splat Bomb", "Super Jump",
                "Shoots a stream of ink. Tilting up or down adjusts the angle of the attacks.",
                "Pushes the Splat Roller, burying any opponents hit by it. Tilting left or right changes the direction.",
                "Throws a Splat Bomb, which explodes when it hits or after time passes. Holding the button tosses it farther.",
                "Transforms into a squid and jumps straight up. Tilting left or right can change the angle a little.",
                "Killer Wail",
                "The Inkling sets up the Killer Wail, which fires a sonic blast. The beam damages and launches anyone caught in its path. The angle can be adjusted up or down. You can also move away from the beam and attack on your own.",
                "Hybrid", "Rushdown");

        // Ridley
        insertFighter("Ridley", "Metroid", "Plasma Breath",
                "Space Pirate Rush", "Skewer", "Wing Blitz",
                "Spits out balls of plasma in a curve. Can be charged to shoot a stream of plasma balls.",
                "Smashes an opponent into the ground then drags them along. Tilting up or pressing attack throws them forward.",
                "Stabs forward with the sharp end of its tail. With the right positioning, this can be a debilitating blow!",
                "Charges up and rises into the air with force. The path can be adjusted with directional input.",
                "Plasma Scream",
                "Ridley tackles foes, hurling them onto Samus's Gunship. He then fires a devastating plasma blast at them. This move can hit up to two opponents, and anyone hit who has 100% or more damage is instantly KO'd.",
                "Close-range", "Grappler");

        // Simon
        insertFighter("Simon", "Castlevania", "Axe",
                "Cross", "Holy Water", "Uppercut",
                "Throws an axe that curves and passes through obstacles. Tilting left or right while it arcs changes the distance.",
                "Throws a cross like a boomerang. The power and distance changes if the control stick is flicked.",
                "Throws a bottle of holy water diagonally downward. Pillars of fire erupt from where it lands.",
                "Performs an uppercut while rising up high. Lands multiple blows if it hits the moment he leaves the ground.",
                "Grand Cross",
                "Simon traps nearby opponents in a coffin and repeatedly attacks them with crosses made of holy light. You can hit multiple opponents at the same time, so try to activate the move when opponents are clustered together.",
                "Long-range", "Zoner");

        // Richter
        insertFighter("Ritcher", "Castlevania", "Axe",
                "Cross", "Holy Water", "Uppercut",
                "Throws an axe that curves and passes through obstacles. Tilting left or right while it arcs changes the distance.",
                "Throws a cross like a boomerang. The power and distance changes if the control stick is flicked.",
                "Throws a bottle of holy water diagonally downward. Pillars of fire erupt from where it lands.",
                "Performs an uppercut while rising up high. Lands multiple blows if it hits the moment he leaves the ground.",
                "Grand Cross",
                "Richter traps nearby opponents in a coffin and repeatedly attacks them with crosses made of holy light. You can hit multiple opponents at the same time, so try to activate the move when opponents are clustered together.",
                "Long-range", "Zoner");

        // King K. Rool
        insertFighter("King K. Rool", "Donkey Kong", "Blunderbuss",
                "Crownerang", "Gut Check", "Propellerpack",
                "Fires an iron ball from his gun. The button can be held to suck the iron ball (or opponents) back in.",
                "Throws his crown like it's a boomerang. Can't be thrown again until it is picked up.",
                "Counterattacks with his belly. Can reflect projectiles, but it doesn't protect from behind.",
                "Rises up into the air wearing a propeller, damaging any opponents caught in the attack.",
                "Blast-o-Matic",
                "King K. Rool charges forward. He then fires the Blast-o-Matic from his fortress, striking any fighters he hit with his first attack. This blast completely destroys Donkey Kong Island, dealing serious damage and launching fighters.",
                "Long-range", "Zoner");

        // Isabelle
        insertFighter("Isabelle", "Animal Crossing", "Pocket",
                "Fishing Rod", "Lloid Trap", "Balloon Trip",
                "Pockets an item or projectile to use later. Pressing the button again takes it back out.",
                "Hooks an opponent and throws them forward. Tilting up or down throws the opponent in that direction.",
                "Buries Lloid in the ground. If touched by a foe, it rises up, dealing constant damage, and then explodes.",
                "Flies around with balloons. Great maneuverability, but the balloons can be popped.",
                "Dream Town Hall",
                "Tom Nook and his gang show up to build a Town Hall. The move traps opponents, and then Town Hall explodes, launching those caught in the blast. If no one is caught in the initial attack nothing happens.",
                "Long-range", "Zoner");


        // Incineroar
        insertFighter("Incineroar", "Pokemon", "Darkest Lariat",
                "Alolan Whip", "Revenge", "Cross Chop",
                "Twirls like a tornado with arms spread wide. Tilting left or right can move the attack.",
                "Bounces foes off the ropes. The type of follow-up attack depends on the timing of the button press.",
                "Increases attack power by taking hits from opponents. The power is relative to the damage taken.",
                "Jumps into the air, then dives down diagonally. Causes an explosion when landing that hits nearby opponents.",
                "Max Malicious Moonsault",
                "Incineroar grabs an opponent while engulfed in flames. It then repeatedly attacks the foe before slamming them back into a ring. Only one fighter can be grabbed, but the final blast deals damage to anyone nearby.",
                "Close-range", "Grappler");

        // Piranha Plant
        insertFighter("Piranha Plant", "Super Mario", "Ptooie",
                "Poison Breath", "Long-Stem Strike", "Piranhacopter",
                "Spits a spiked ball. Hold the button to keep the spiked ball in the air, and blow it left or right with the stick.",
                "Spits a slow-moving poison mist. The longer it's charged, the more damage and range it has.",
                "Withdraws into the pot and then pops out to bite opponents. The longer it's charged, the more range it has.",
                "Spins leaves to fly. Can be moved left or right. Does damage if it makes contact.",
                "Petey Piranha",
                "Piranha Plant summons a giant Petey Piranha that moves left and right while swinging cages. Fighters hit by a cage will be trapped. In the end, Petey Piranha throws the cages downward, launching the fighters trapped inside.",
                "Long-range", "Zoner");

        // Joker
        insertFighter("Joker", "Persona", "Gun / Gun Special",
                "Eiha / Eigaon", "Rebel's Guard / Tetrakarn / Makarakarn", "Grappling Hook / Wings of Rebellion",
                "Fires a gun forward. While Arsene is active, the power and number of shots that can be fired increases.",
                "Unleashes a bolt that explodes and deals continuous damage. While Arsène is active, the speed and power increases.",
                "Braces for an attack. If hit, charges the Rebellion Gauge. Press and hold to charge. While Arsene is active, counterattacks.",
                "Throws a grappling hook to grab edges and opponents. While Arsene is active, flies upward using Arsene's wings.",
                "All-Out Attack",
                "Joker dashes forward to strike. You can reverse directions while moving. If it hits, the Phantom Thieves will execute an All-Out Attack on up to four opponents. KOs instantly if damage is high enough.",
                "Hybrid", "Zoner");

        // Hero
        insertFighter("Hero", "Dragon Quest", "Frizz/Fizzle/Kafrizz",
                "Zap/Zapple/Kazap", "Command Selection", "Woosh/Swoosh/Kaswoosh",
                "Unleashes fireballs that grow stronger the longer you charge them. You can store the charge by shielding while charging.",
                "Unleashes lightning from your sword. It grows stronger when charged, but the charge cannot be stored.",
                "Opens a command window that you can choose a command from. You can cancel the window by jumping or shielding.",
                "Summons a tornado to lift you upward. The wind will cut through surrounding enemies. You can rise up higher when charged.",
                "Gigaslash",
                "The hero swings his sword forward. If it hits an opponent, the hero calls upon the power of past protagonists. This attack can hit up to three fighters and will launch them all at the end of the move.",
                "Long-range", "Balanced");

        // Banjo & Kazooie
        insertFighter("Banjo & Kazooie", "Banjo-Kazooie", "Egg Firing / Breegull Blaster",
                "Wonderwing", "Rear Egg", "Shock Spring Jump",
                "Fires an egg from Kazooie's mouth. Press and hold the button to shoot while moving around.",
                "Uses a golden feather to become invincible and charge forward. Used feathers will not be replenished until you are KO'd.",
                "Shoots a grenade egg diagonally upward in the direction Kazooie isn't facing. Make sure to face away from your target.",
                "Jumps high into the air using a Shock Spring Pad. You can freely move and attack after jumping.",
                "The Mighty Jinjonator",
                "Banjo and Kazooie summon a statue from the ground. If it hits an opponent, the mighty Jinjonator will awaken and unleash high-speed strikes alongside other Jinjos to launch the opponent.",
                "Hybrid", "Balanced");

        // Terry
        insertFighter("Terry", "Fatal Fury", "Power Wave",
                "Burning Knuckle", "Power Dunk", "Rising Tackle",
                "Punch down and send a shock wave along the ground. The range of the shock wave is shorter in the air.",
                "Forward tilt special: Charge forward, fist extended. Backward tilt special: Jump forward with a downward heel kick.",
                "Knock opponents into the air with a knee strike, then follow up with a diagonal downward punch.",
                "Strike against airborne threats by rising up feet first. Tilt the stick left or right to move slightly.",
                "Triple Wolf",
                "A powerful triple combo that starts with Triple Geyser, continues with Power Dunk, and ends with Buster Wolf. Triple Geyser can damage multiple opponents, but only the first opponent it hits suffers the full combo.",
                "Close-range", "Rushdown");


        // Byleth
        insertFighter("Byleth", "Fire Emblem", "Failnaught",
                "Areadbhar", "Aymr", "Sword of the Creator",
                "Draw and hold the bow for a set amount of time to fire an arrow. Hold the button to charge a powerful shot with greater range.",
                "Slash forward in an arc. Flicking the stick as you activate this move will cause you to slash upward and move forward.",
                "Charge up the axe, then swing down with great force. The move leaves you vulnerable, but it's a devastating blow if it connects.",
                "Stretch the sword outward, jumping upward if it hits an opponent. You can use this attack to recover or dangle if you hit an edge.",
                "Progenitor God Ruptured Heaven",
                "Stretch out the sword, attacking in front of you. If it hits an opponent, Sothis will lend you her strength, allowing you to unleash a powerful attack with the Sword of the Creator. This attack can hit up to three opponents.",
                "Hybrid", "Spacing");

        // Min Min
        insertFighter("Min Min", "ARMS", "Punch",
                "Punch", "ARMS Change", "ARMS JUMP / ARM HOOK",
                "The attack button controls the left ARM, and the special-move button controls the right. Flick the stick to the side and press a button to make it a smash attack. You can also hold the button on the ground to charge up!",
                "The attack button controls the left ARM, and the special-move button controls the right. Flick the stick to the side and press a button to make it a smash attack. You can also hold the button on the ground to charge up!",
                "The right ARM will cycle, in order, through Ramram, Megawatt, and Dragon.",
                "On the ground, the ARMS boost the jump. In the air, the ARMS extend upward to attack or to grab on to an edge.",
                "ARMS Rush",
                "One opponent will be caught up in an attack from the left ARM as it transforms into Dragon, and from numerous ARMS fighters who swoop in to deal damage and send the opponent flying.",
                "Long-range", "Balanced");

        // Ivysaur
        insertFighter("Ivysaur", "Pokemon", "Bullet Seed",
                "Razor Leaf", "Pokemon Change", "Vine Whip",
                "Rapidly fires seeds from the bud. The button can be held to make the attack last longer.",
                "Fires leaves that cut into opponents. The attacks keep going after hitting and have a long range.",
                "Switches to Charizard. Immune to damage initially, but become vulnerable if used repeatedly.",
                "Attacks with vines like they're whips. The vines can also grab on to edges.",
                "Triple Finish",
                "Squirtle, Ivysaur, and Charizard perform a synchronized combo attack. The attack hits a wide range in front of the trio and deals damage to opponents caught in it, pushing them away.",
                "Hybrid", "Balanced");


        // Charizard
        insertFighter("Charizard", "Pokemon", "Flamethrower",
                "Flare Blitz", "Pokemon Change", "Fly",
                "Attacks opponents by shooting fire. The direction of the fire can be changed with the control stick.",
                "Charges forward, engulfed in flame, and explodes. It's so powerful, even Charizard takes damage!",
                "Switches to Squirtle. Immune to damage initially, but become vulnerable if used repeatedly.",
                "Spirals into the sky. Can hit opponents multiple times while soaring upward.",
                "Triple Finish",
                "Squirtle, Ivysaur, and Charizard perform a synchronized combo attack. The attack hits a wide range in front of the trio and deals damage to opponents caught in it, pushing them away.",
                "Hybrid", "Balanced");

        // Squirtle
        insertFighter("Squirtle", "Pokemon", "Water Gun",
                "Withdraw", "Pokemon Change", "Waterfall",
                "Spits water out at opponents. The more it has been charged, the more power it has to push opponents.",
                "Hides in its shell and then tackles. Attacks can bounce this attack back, but won't hurt.",
                "Switches to Ivysaur. Immune to damage initially, but become vulnerable if used repeatedly.",
                "Rides a torrent of water, hitting opponents. Tilting left and right can adjust the rising angle.",
                "Triple Finish",
                "Squirtle, Ivysaur, and Charizard perform a synchronized combo attack. The attack hits a wide range in front of the trio and deals damage to opponents caught in it, pushing them away.",
                "Hybrid", "Balanced");

        // Steve
        insertFighter("Steve", "Minecraft", "Mine / Craft / Create Block",
                "Minecart", "TNT", "Elytra",
                "Collect materials from the ground by mining the floor. Craft tools while at the crafting table or place blocks while in the air.",
                "An iron minecart will travel along the rails. Powered rails can be placed with the right materials. If empty, the minecart will carry an enemy away.",
                "Use several materials to create an explosive block. Hold the special-move button and left or right to use redstone and place a plate that can set off the block.",
                "Equip an elytra, accelerate with a firework rocket, and glide through the air. Adjust the trajectory by inputting up and down.",
                "House of Boom",
                "Create a big piston that strikes out to one side. The piston can hit multiple opponents, but only one will be launched into a dark room that then explodes.",
                "Hybrid", "Balanced");

        // Sephiroth
        insertFighter("Sephiroth", "Final Fantasy", "Flare/Megaflare/Gigaflare",
                "Shadow Flare", "Scintilla", "Blade Dash / Octaslash",
                "Hold the button down to charge; release to launch a fireball. Charging longer reduces the range but increases the explosion size.",
                "Release a small burst of energy. If an opponent is hit, the energy will move around them for a short time and then detonate.",
                "Create a barrier of light in front of you. After some time passes or the barrier is struck, it will change into a Scintilla attack.",
                "Input a direction with the stick, and you'll slash in that direction. Hold down the attack button to strike eight times in a row.",
                "Supernova",
                "Swing the sword forward in a wide range. If it hits an opponent, Safer Sephiroth will appear and deal massive damage with a supernova explosion that can also sometimes inflict status effects. The first swing can hit up to three opponents.",
                "Hybrid", "Spacing");

        // Pyra
        insertFighter("Pyra", "Xenoblade Chronicles", "Flame Nova",
                "Blazing End", "Swap to Mythra", "Prominence Revolt",
                "Launch nearby opponents with a sword that revolves around you. Hold down the button to increase the power of the sword and the number of times it orbits you.",
                "Throw the sword forward and spin it at a new location. Flick the stick to throw it even farther.",
                "Swap to Mythra in the middle of the battle. Mythra is faster but less powerful.",
                "Leap into the air and then drop quickly, stabbing downward. Upon landing, a pillar of fire will appear in front of you.",
                "Burning Sword",
                "Rex can hit multiple opponents with a huge pillar of fire, launching them away. This Final Smash deals less damage than Mythra's, but it has higher launch power and can more easily KO opponents.",
                "Hybrid", "Rushdown");

        // Mythra
        insertFighter("Mythra", "Xenoblade Chronicles", "Lightning Buster",
                "Photon Edge", "Swap to Pyra", "Ray of Punishment / Chroma Dust",
                "Repeatedly attack diagonally with slashing blows. Hold down the button to charge up power, but be aware that the charge can't be held.",
                "Charge forward and jump at high speed, slashing five times. This is an effective way to recover after being launched off the stage.",
                "Swap to Pyra in the middle of the battle. Pyra is slower but more powerful.",
                "Jump with an overhead slash, and then follow up with a blast of light diagonally downward. Scatter the blast by pressing the button again before it fires.",
                "Sacred Arrow",
                "Rain down arrows from above at the opponent Rex strikes. This Final Smash has less launch power than Pyra's, but it deals high continuous damage in a wide area.",
                "Hybrid", "Rushdown");

        // Kazuya
        insertFighter("Kazuya", "Tekken", "Devil Baster",
                "Devil Fist", "Heaven's Door", "Devil Wings",
                "On the ground, unleash a powerful beam forward. In the air, the beam will angle downward. It has a long range that can hit up to three fighters.",
                "A charged punch that will pass through the opponent it hits. If the beginning of the attack hits, it will immobilize the opponent.",
                "Grab the opponent in front of you and rise upward, then slam them to the ground. This attack ignores an opponent's shield.",
                "Grow devil wings and rise upward. You can move slightly to the left or right. While you are rising, you can attack opponents with the claws on the wings.",
                "Final Blaster",
                "Unleash a long-ranged beam from the forehead. If the beam hits an opponent, more beams from the wings and chest will be unleashed, covering a wide range and damaging any foes they hit.",
                "Close-range", "Rushdown");

        // Sora
        insertFighter("Sora", "Kingdom Hearts", "Magic",
                "Sonic Blade", "Counterattack", "Aerial Sweep",
                "Each time you unleash Firaga/Thundaga/Blizzaga, the magic used next will change.",
                "Deflect direct attacks from opponents, briefly staggering them before launching a counterattack. Projectiles won't affect you if countered.",
                "You can enter up to two inputs while charging forward. Directional inputs send you that way, while the special-move button sends you toward opponents.",
                "Rise up into the air while twirling. Move slightly left or right by inputting either direction. You can use a side special at the end of this move too!",
                "Sealing the Keyhole",
                "Hit opponents with a beam and launch them toward a Keyhole. Up to three opponents can be affected by the Keyhole, and if their damage is high enough, they'll be instantly KO'd.",
                "Hybrid", "Balanced");
    }
}
