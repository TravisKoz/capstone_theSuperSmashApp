package edu.cvtc.myapplication;

import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;

import edu.cvtc.myapplication.SuperSmashDatabaseContract.BattleNoteEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.FighterEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.TrackerEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.ItemEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.AssistTrophyEntry;
import edu.cvtc.myapplication.SuperSmashDatabaseContract.PokemonEntry;

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
        insertFighter("Richter", "Castlevania", "Axe",
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


    // Method that inserts a single item into the database
    public void insertItem(String name, String category, String description) {
        ContentValues values = new ContentValues();
        values.put(ItemEntry.COLUMN_NAME, name);
        values.put(ItemEntry.COLUMN_CATEGORY, category);
        values.put(ItemEntry.COLUMN_DESCRIPTION, description);
        long newRowId = mDb.insert(ItemEntry.TABLE_NAME, null, values);
    }

    // Method used to populate our database with initial Item data.
    public void insertItems() {
        //               ----------------- Carrying Items ----------------------
        // Barrel
        insertItem("Barrel", "Carrying",
                "Break this to make a collection of items appear. If it's knocked on its side, it will roll around.");
        // Capsule
        insertItem("Capsule", "Carrying",
                "Break this to reveal the contents, or throw it at enemies to deal some damage.");
        // Crate
        insertItem("Crate", "Carrying",
                "Break it to reveal a bunch of random items. Or throw it at opponents!");
        // Grass
        insertItem("Grass", "Carrying",
                "Pluck this from the ground and some kind of item will appear.");
        // Party Ball
        insertItem("Party Ball", "Carrying",
                "This ball will float up into the air, play a little tune, then release a bunch of items.");
        // Rolling Crate
        insertItem("Rolling Crate", "Carrying",
                "It may look like a regular old box, but it isn't. It has wheels!");


        //               ----------------- Battering Items ----------------------
        // Beam Sword
        insertItem("Beam Sword", "Battering",
                "Attack with a beam sword. The stronger the attack, the longer the beam gets!");
        // Death's Scythe
        insertItem("Death's Scythe", "Battering",
                "A tilt or smash attack with this brutal weapon will KO opponents who have high damage.");
        // Fire Bar
        insertItem("Fire Bar", "Battering",
                "This weapon has a long reach, but it'll get shorter the more hits you land with it.");
        // Golden Hammer
        insertItem("Golden Hammer", "Battering",
                "Attack quickly over and over and over. Press jump repeatedly to float through the air, too!");
        // Hammer
        insertItem("Hammer", "Battering",
                "Once you start, you just can't stop swinging this item, even if the hammer's head pops off. Oops!");
        // Home-Run Bat
        insertItem("Home-Run Bat", "Battering",
                "Use a side smash to send a foe flying for the fences. It's tricky to land, but it has lots of attack power!");
        // Killing Edge
        insertItem("Killing Edge", "Battering",
                "If you attack when the sword glows, the damage and launch power will be doubled.");
        // Lip's Stick
        insertItem("Lip's Stick", "Battering",
                "Attacking with this makes an energy-sapping flower bloom on your opponent's head!");
        // Ore Club
        insertItem("Ore Club", "Battering",
                "Swing this to perform an incredibly strong attack. Side smash attacks will create a whirlwind effect.");
        // Star Rod
        insertItem("Star Rod", "Battering",
                "Side smash attacks and side tilt attacks will make this item fire star-shaped projectiles.");


        //               ----------------- Combining Items ----------------------
        // Daybreak Parts
        insertItem("Daybreak Parts", "Combining",
                "Construct this huge weapon by collecting its three parts, then use its powerful beam attack!");
         // Dragoon Parts
        insertItem("Dragoon Parts", "Combining",
                "Collect all three parts to assemble the Dragoon, and then unleash a powerful attack!");


        //               ----------------- Effect Items ----------------------
        // Special Flag
        insertItem("Special Flag", "Effect",
                "Hold this high and gain +1 KO (in a time battle) or +1 stock (in a stock battle).");
        // Super Launch Star
        insertItem("Super Launch Star", "Effect",
                "Throw it to create a star-shaped gate which will launch fighters that enter it.");


        //               ----------------- Exploding Items ----------------------
        // Blast Box
        insertItem("Blast Box", "Exploding",
                "Watch outーif you do too much damage to this, it'll go BOOM! It'll blow up instantly if ignited, too!");
        // Bomber
        insertItem("Bomber", "Exploding",
                "Hold it high to set it off. Enemies caught in the blast will take a ton of damage.");
        // Fake Smash Ball
        insertItem("Fake Smash Ball", "Exploding",
                "This may look like a Smash Ball, but breaking it will cause it to explode in an X shape.");


        //               ----------------- Gear Items ----------------------
        // Back Shield
        insertItem("Back Shield", "Gear",
                "Pick this up and your back will be protected from attacks. A high amount of damage will destroy it.");
        // Franklin Badge
        insertItem("Franklin Badge", "Gear",
                "If you wear this, it reflects all projectile attacks from your foes.");
        // Rocket Belt
        insertItem("Rocket Belt", "Gear",
                "While wearing this, hold up or hold the jump button to fly straight up in the air. You'll refuel automatically on the ground.");
        // Screw Attack
        insertItem("Screw Attack", "Gear",
                "Pick this up, and you'll be able to do Screw Attacks when you jump.");
        // Super Leaf
        insertItem("Super Leaf", "Gear",
                "Hold up or hold the jump button while wearing this to hover with the help of a very fuzzy tail!");


        //               ----------------- Helping Items ----------------------
        // Assist Trophy
        insertItem("Assist Trophy", "Helping",
                "Call on different characters to help you fight! Some assist trophies can be KO'd, though...");
        // Master Ball
        insertItem("Master Ball", "Helping",
                "Summon a Mythical or Legendary Pokémon! Much more valuable than a regular Poké Ball.");
        // Poké Ball
        insertItem("Poke Ball", "Helping",
                "Summon a random Pokémon to team up with you against your foes!");


        //               ----------------- Punching Items ----------------------
        // Sandbag
        insertItem("Sandbag", "Punching",
                "Hit Sandbag to make items fall out! The more you hit it, the easier it will be to launch.");


        //               ----------------- Recovery Items ----------------------
        // Fairy Bottle
        insertItem("Fairy Bottle", "Recovery",
                "This item will only heal a fighter who has taken more than 100% damage. Don't throw it at a badly injured enemy!");
        // Food
        insertItem("Food", "Recovery",
                "Eat some to heal a little damage! Different foods will heal for different amounts.");
        // Healing Field
        insertItem("Healing Field", "Recovery",
                "This item will create a healing field on the ground. Stand on it to slowly heal.");
        // Healing Sprout
        insertItem("Healing Sprout", "Recovery",
                "This item will slowly heal whomever it is stuck to. It can be transferred to another fighter through contact.");
        // Heart Container
        insertItem("Heart Container", "Recovery",
                "This removes 100% damage from your counter! Grab it before your foes get to it!");
        // Maxim Tomato
        insertItem("Maxim Tomato", "Recovery",
                "A tomato with a big M on it. When eaten, it will remove 50% damage from your counter.");


        //               ----------------- Transforming Items ----------------------
        // Bullet Bill
        insertItem("Bullet Bill", "Transforming",
                "Use this to turn into a Bullet Bill and charge in a straight lineーright through anyone in the way!");
        // Bunny Hood
        insertItem("Bunny Hood", "Transforming",
                "Put this on to boost your speed and jumps greatly. \"What long ears it has! Will the power of the wild spring forth?\"");
        // Lightning Bolt
        insertItem("Lightning Bolt", "Transforming",
                "Grab this to make the other fighters shrinkーunless it backfires and shrinks you!");
        // Metal Box
        insertItem("Metal Box", "Transforming",
                "Turns you into metal. Light attacks won't make you flinch, and you'll be tough to launchーbut you'll fall faster.");
        // Poison Mushroom
        insertItem("Poison Mushroom", "Transforming",
                "Running into one of these mushrooms shrinks you, making you less powerful and easier to launch.");
        // Super Mushroom
        insertItem("Super Mushroom", "Transforming",
                "Touching this will make you giant, increasing your attack power and making you tough to launch.");
        // Super Star
        insertItem("Super Star", "Transforming",
                "If you touch one of these, you'll be invincible for 10 seconds. Woot!");
        // Superspicy Curry
        insertItem("Superspicy Curry", "Transforming",
                "A spiciness out of this world! You'll constantly breathe fire from your mouth!");
        // Timer
        insertItem("Timer", "Transforming",
                "This item slows down everyone except the player who collects it...except when it backfires, of course.");
        // Warp Star
        insertItem("Warp Star", "Transforming",
                "Sends you shooting up, then back down for a devastating attack. Aim your landing with left or right and adjust the timing with up or down.");


        //               ----------------- Shooting Items ----------------------
        // Banana Gun
        insertItem("Banana Gun", "Shooting",
                "The insides of the banana become a powerful bullet. After one shot, this item becomes a Banana Peel. Of course.");
        // Drill
        insertItem("Drill", "Shooting",
                "Fire this to send a drill bit shooting across the stage, pushing enemies out and away. You can then throw the base!");
        // Fire Flower
        insertItem("Fire Flower", "Shooting",
                "Hold this out and bathe your foes in flame. The fire doesn't last forever, though, so don't waste it.");
        // Gust Bellows
        insertItem("Gust Bellows", "Shooting",
                "Blow enemies away with this item. It's great for ruining someone's recovery, but it's easily blocked by shields.");
        // Rage Blaster
        insertItem("Rage Blaster", "Shooting",
                "This item grows stronger if the user has taken lots of damage. A great way to make a comeback!");
        // Ramblin' Evil Mushroom
        insertItem("Ramblin' Evil Mushroom", "Shooting",
                "Opponents hit with enough of these spores will grow a mushroom, reversing their left and right controls.");
        // Ray Gun
        insertItem("Ray Gun", "Shooting",
                "Fires a fast-moving shot that can knock enemies backward and into the air. Land multiple blows to really break their spirit.");
        // Staff
        insertItem("Staff", "Shooting",
                "This weapon fires a laser that deals more damage if the target is farther away.");
        // Steel Diver
        insertItem("Steel Diver", "Shooting",
                "Give the torpedo a second and it'll shoot off at high speed. Quick, subtle, destructive.");
        // Super Scope
        insertItem("Super Scope", "Shooting",
                "Fire rapidly by pressing the button quickly, or hold the button to charge up! The fully charged shot is powerful!");


        //               ----------------- Throwing Items ----------------------
        // Banana Peel
        insertItem("Banana Peel", "Throwing",
                "A classic comedy staple: if you step on one of these, you'll fall on your rump. It never gets old!");
        // Beastball
        insertItem("Beastball", "Throwing",
                "Throw it, and it will disappear in the air then reappear near an opponent, covered in flames.");
        // Beehive
        insertItem("Beehive", "Throwing",
                "A swarm of bees will emerge, mobbing a fighter and dealing damage to them bit by bit.");
        // Beetle
        insertItem("Beetle", "Throwing",
                "Throw it toward an enemy and, if it hits, it'll grab on and drag them upward. The higher their damage, the harder it is to break free!");
        // Black Hole
        insertItem("Black Hole", "Throwing",
                "Throw it to create a black hole that will draw in fighters and items.");
        // Bob-omb
        insertItem("Bob-omb", "Throwing",
                "Despite its size, this bomb packs a serious punch. Left alone, it tends to get bored and wanders off...");
        // Bombchu
        insertItem("Bombchu", "Throwing",
                "This little zippy bomb crawls on floors, walls, and ceilings. It'll go off if it hits someone or the fuse runs out.");
        // Boomerang
        insertItem("Boomerang", "Throwing",
                "When thrown, this object eventually comes back to the thrower. Catch it to boost its power!");
        // Boss Galaga
        insertItem("Boss Galaga", "Throwing",
                "This zippy item will try and capture opponents with a tractor beam and then carry them into space.");
        // Bumper
        insertItem("Bumper", "Throwing",
                "A bumper can be placed in the air or on the ground. Anyone who touches it will be bounced like a pinball.");
        // Cucco
        insertItem("Cucco", "Throwing",
                "Cuccos will wander around the stage, minding their own business. If you're heartless enough to attack one, you deserve what you get.");
        // Deku Nut
        insertItem("Deku Nut", "Throwing",
                "This little nut explodes on impact, dazing fighters on the ground and launching those who are airborne.");
        // Freezie
        insertItem("Freezie", "Throwing",
                "An item that slowly slides on the ground. If thrown, anyone hit by it will be frozen in ice for a time.");
        // Gooey Bomb
        insertItem("Gooey Bomb", "Throwing",
                "This bomb goes off shortly after sticking to something. If that something is you, brush the bomb onto someone else! Fast!");
        // Green Shell
        insertItem("Green Shell", "Throwing",
                "Attack or throw the Green Shell to send it sliding across the ground!");
        // Hocotate Bomb
        insertItem("Hocotate Bomb", "Throwing",
                "This spaceship-turned-bomb will soar skyward, returning a short time later to blow up on its launch site.");
        // Hothead
        insertItem("Hothead", "Throwing",
                "A fireball that grows when attacked. It will move around the stage, growing bigger from fire or electric attacks.");
        // Killer Eye
        insertItem("Killer Eye", "Throwing",
                "A stationary cannon that shoots out damaging beams. You can change its direction by hitting it.");
        // Motion-Sensor Bomb
        insertItem("Motion-Sensor Bomb", "Throwing",
                "Once placed on the battlefield, this small bomb will go off the moment anyone gets too close.");
        // Mr. Saturn
        insertItem("Mr. Saturn", "Throwing",
                "Throwing Mr. Saturn won't deal much damage, but he'll annihilate any shield he hits.");
        // Pitfall
        insertItem("Pitfall", "Throwing",
                "This creates a hidden pitfall, trapping anyone who steps on it in the ground, unable to move.");
        // POW Block
        insertItem("POW Block", "Throwing",
                "Hit it or throw it to launch everyone on the ground into the air. It only has three uses, so POW wisely!");
        // Smart Bomb
        insertItem("Smart Bomb", "Throwing",
                "A bomb that creates a massive explosion, hurting anyone caught in the blast. Unless it's a dud. Then nothing happens.");
        // Smoke Ball
        insertItem("Smoke Ball", "Throwing",
                "After being thrown, this item will roll around on the ground or stick to opponents. The smoke makes it hard to see the battle.");
        // Soccer Ball
        insertItem("Soccer Ball", "Throwing",
                "Give it a good kick, and watch the ball burst into flames! You can't pick it up, thoughーthat's a foul.");
        // Spiny Shell
        insertItem("Spiny Shell", "Throwing",
                "If you throw this, it'll seek out the player with the highest score (that isn't you), then slam down and explode on them!");
        // Unira
        insertItem("Unira", "Throwing",
                "It will reveal its dangerous spikes after being placed. It sticks to walls, too!");
        // X Bomb
        insertItem("X Bomb", "Throwing",
                "The blast from this bomb will go in four directions. It can go vertically and horizontally, or diagonally.");
    }

    // Method that inserts a single pokemon into the database
    public void insertPokemon(String name, String description, String ball) {
        ContentValues values = new ContentValues();
        values.put(PokemonEntry.COLUMN_NAME, name);
        values.put(PokemonEntry.COLUMN_DESCRIPTION, description);
        values.put(PokemonEntry.COLUMN_BALL, ball);
        long newRowId = mDb.insert(PokemonEntry.TABLE_NAME, null, values);
    }

    // Method used to populate our database with initial pokemon data.
    public void insertPokemon() {
        //               ----------------- Poke ball ----------------------
        // Abomasnow
        insertPokemon("Abomasnow", "Causes a blizzard and freezes opponents. Sometimes it also punches while charging toward fighters.", "Poke ball");
        // Abra
        insertPokemon("Abra", "Teleports opponents to different locations on the stage.", "Poke ball");
        // Alolan Exeggutor
        insertPokemon("Alolan Exeggutor", "Uses its large body to get in the way of fighters.", "Poke ball");
        // Alolan Raichu
        insertPokemon("Alolan Raichu", "Rides its own tail in a surfing attack, dealing electric damage to anyone who gets hit.", "Poke ball");
        // Alolan Vulpix
        insertPokemon("Alolan Vulpix", "Breathes out an icy blast that freezes opposing fighters.", "Poke ball");
        // Bellossom
        insertPokemon("Bellossom", "Unleashes a sweet scent that makes nearby opponents fall asleep.", "Poke ball");
        // Bewear
        insertPokemon("Bewear", "Deals a devastating uppercut to any foe that gets too close.", "Poke ball");
        // Chespin
        insertPokemon("Chespin", "Sends out bursts of exploding seeds in the area around itself.", "Poke ball");
        // Dedenne
        insertPokemon("Dedenne", "Generates a four-spoked electricity field around itself, which then spins around.", "Poke ball");
        // Ditto
        insertPokemon("Ditto", "Transforms into the fighter who threw the Poké Ball, and then attacks enemies. That fighter also gets any KOs it pulls off.", "Poke ball");
        // Eevee
        insertPokemon("Eevee", "Tackles nearby opponents with its adorable body.", "Poke ball");
        // Electrode
        insertPokemon("Electrode", "Explodes after a short time. It can be thrown before blowing up!", "Poke ball");
        // Fennekin
        insertPokemon("Fennekin", "Shoots fireballs and creates a pillar of flame that can hit multiple times.", "Poke ball");
        // Fletchling
        insertPokemon("Fletchling", "Pecks at opponents with its surprisingly painful beak.", "Poke ball");
        // Gardevoir
        insertPokemon("Gardevoir", "Engulfs itself in a shiny aura and reflects enemy projectiles.", "Poke ball");
        // Gogoat
        insertPokemon("Gogoat", "Runs around the stage and launches opponents it hits. Fighters can also hitch a ride on Gogoat!", "Poke ball");
        // Inkay
        insertPokemon("Inkay", "Trips nearby opponents that are on the ground. It does nothing to airbone enemies, though.", "Poke ball");
        // Meowth
        insertPokemon("Meowth", "Throws tons of coins out in front of itself, hurting enemies.", "Poke ball");
        // Metagross
        insertPokemon("Metagross", "Buries opponents in the ground and then causes an earthquake to launch them.", "Poke ball");
        // Mimikyu
        insertPokemon("Mimikyu", "Drags the opponent into its body. If the affected fighter has taken significant damage, the attack can be an instant KO.", "Poke ball");
        // Oshawott
        insertPokemon("Oshawott", "Surfs on a wave and tries to drag opponents off the stage.", "Poke ball");
         // Pyukumuku
        insertPokemon("Pyukumuku", "Punches opponents who step on it, and whoever summoned it can throw it.", "Poke ball");
        // Scizor
        insertPokemon("Scizor", "Dashes into the air toward opponents, slashing at them with steel claws.", "Poke ball");
        // Snivy
        insertPokemon("Snivy", "Waves its tail and fires crescent-shaped shots at enemies.", "Poke ball");
        // Snorlax
        insertPokemon("Snorlax", "Jumps up high and then comes back down in the same spot larger than before.", "Poke ball");
        // Spewpa
        insertPokemon("Spewpa", "Releases a powder that stuns, if hit. If not hit, Spewpa releases absolutely nothing.", "Poke ball");
        // Staryu
        insertPokemon("Staryu", "Seeks out a target for a few seconds, then launches a barrage of stars.", "Poke ball");
        // Swirlix
        insertPokemon("Swirlix", "Shrouds itself in smoke and slows down nearby opponents.", "Poke ball");
        // Togedemaru
        insertPokemon("Togedemaru", "Calls down a lightning bolt on itself in order to shoot out sparks from its body.", "Poke ball");
        // Togepi
        insertPokemon("Togepi", "Calls forth one of a variety of attacks with a wave of its hand. Which will it be this time?", "Poke ball");
        // Vulpix
        insertPokemon("Vulpix", "Shoots out fireballs that create a pillar of fire where they land.", "Poke ball");



        //               ----------------- Poke ball & Master ball ----------------------
        // Arceus
        insertPokemon("Arceus", "Sends any airbone opponents crashing into the ground. Players on the ground are unaffected, but amused.", "Poke ball & Master ball");
        // Darkrai
        insertPokemon("Darkrai", "Uses its Dark Void to send affected opponents into a deep sleep.", "Poke ball & Master ball");
        // Deoxys
        insertPokemon("Deoxys", "Fires a powerful beam downward. Anyone that touches the beam takes some serious damage.", "Poke ball & Master ball");
        // Entei
        insertPokemon("Entei", "Summons a fiery tornado that forces any fighters caught in it up to the top of the screen.", "Poke ball & Master ball");
        // Genesect
        insertPokemon("Genesect", "Shoots distant opponents with laser attacks.", "Poke ball & Master ball");
        // Giratina
        insertPokemon("Giratina", "Catches fighters in a powerful, damaging tornado.", "Poke ball & Master ball");
        // Goldeen
        insertPokemon("Goldeen", "Flops around. That's all. It's a fish out of waterーwhat do you expect?", "Poke ball & Master ball");
        // Keldeo
        insertPokemon("Keldeo", "Uses the sacred power of its horn to slash opponents.", "Poke ball & Master ball");
        // Kyogre
        insertPokemon("Kyogre", "Washes away enemy fighters with bursts of water.", "Poke ball & Master ball");
        // Kyurem
        insertPokemon("Kyurem", "Creates a close-range blizzard that freezes nearby enemies.", "Poke ball & Master ball");
        // Latias & Latios
        insertPokemon("Latias & Latios", "Fly back and forth across the stage, damaging and attempting to launch anyone they hit.", "Poke ball & Master ball");
        // Lugia
        insertPokemon("Lugia", "Creates great gusts of wind from a distance.", "Poke ball & Master ball");
        // Lunala
        insertPokemon("Lunala", "Enters its Full Moon phase and shoots a powerful ray from a distance.", "Poke ball & Master ball");
        // Marshadow
        insertPokemon("Marshadow", "Leaps from an opponent's shadow and lets loose with a powerful punch.", "Poke ball & Master ball");
        // Meloetta
        insertPokemon("Meloetta", "Sends waves of sound that bounce around the stage.", "Poke ball & Master ball");
        // Mew
        insertPokemon("Mew", "Nothing happens except a realization that you're quite lucky to have seen one.", "Poke ball & Master ball");
        // Moltres
        insertPokemon("Moltres", "Flies upward into the sky. Any opponent that touches it will take serious damage.", "Poke ball & Master ball");
        // Palkia
        insertPokemon("Palkia", "Tears through space, flipping the stage.", "Poke ball & Master ball");
        // Solgaleo
        insertPokemon("Solgaleo", "Enters its Radiant Sun phase and will charge at enemies, engulfed in flames.", "Poke ball & Master ball");
        // Suicune
        insertPokemon("Suicune", "Uses Aurora Beam to freeze enemy fighters.", "Poke ball & Master ball");
        // Tapu Koko
        insertPokemon("Tapu Koko", "Creates an electric field that stuns opponents. It also shoots out electricity.", "Poke ball & Master ball");
        // Victini
        insertPokemon("Victini", "Generously gives the fighter who threw its Poké Ball a Final Smash.", "Poke ball & Master ball");
        // Xerneas
        insertPokemon("Xerneas", "Turns the user gold and greatly enhances their launching power for a time.", "Poke ball & Master ball");
        // Zoroark
        insertPokemon("Zoroark", "Throws a grounded opponent into the air and then slashes them with its claws.", "Poke ball & Master ball");
    }

    // Method that inserts a single fighter into the database.
    private void insertAssistTrophy(String name, String description) {
        ContentValues values = new ContentValues();
        values.put(AssistTrophyEntry.COLUMN_NAME, name);
        values.put(AssistTrophyEntry.COLUMN_DESCRIPTION, description);

        long newRowId = mDb.insert(AssistTrophyEntry.TABLE_NAME, null, values);
    }

    // Method used to populate our database with initial Tracker data.
    public void insertAssistTrophies() {

        // Akira
        insertAssistTrophy("Akira",
                "Akira Yuki is one of the main characters of the Virtua Fighter series. A master of the Hakkyoku-ken (Eight-Way Fist) style, his appearance in Super Smash Bros. Ultimate is patterned after the original game in the series, with a low polygon count giving him a \"blocky\" look.\n\n" +
                "When summoned, Akira will run toward an opponent and attack them with moves like a forward palm strike and an elbow strike, as well as his signature moves like the Tetsuzanko (a body check) and the Renkantai (a double kick). He can also auto-guard. Before leaving the battlefield, he salutes the opponent and says his catch phrase, 「十年早いんだよ！」 (Jū'nen hayai'n da yo!, \"You are ten years too early!\"");

        // Alucard
        insertAssistTrophy("Alucard",
                "Alucard is the son of Dracula who appears from the Castlevania series. A dhampir (son of Dracula with a human woman), Alucard opposes his father's crusade against humanity, having been taught by his mother, in her dying breath, not to hold grudges against humans. Having helped vampire hunter Trevor Belmont defeat Dracula once, Alucard awakens again, sensing a strange evil energy coming from his father's abode, and uncovers a plot to resurrect him.\n\n" +
                "Alucard's appearance and moves take inspiration from his role as the protagonist in Castlevania: Symphony of the Night: he attacks using the Crissaegrim (also known as the Valmanway), transforms into a bat, and uses Mist Form to evade opponents' attacks.");

        // Andross
        insertAssistTrophy("Andross",
                "Andross, the main villain from the Star Fox series appears from the Assist Trophy, and, floating in the background of a stage, inhales and spits forth a flurry of harmful polygons that damage characters. His appearance and attack are based on his depiction in the original SNES Star Fox.");

        // Arcade Bunny
        insertAssistTrophy("Arcade Bunny",
                "The Arcade Bunny is the host of the Nintendo 3DS game Nintendo Badge Arcade. After he is summoned, the crane from the original game appears at the top and begins to move left and right, dropping down periodically in an attempt to drag an opponent up, while the Arcade Bunny stands in the background. It can only do this three times, as indicated by the number on the crane which decreases by one after it descends. Once it is depleted, the Arcade Bunny and crane disappear.");

        // Ashley
        insertAssistTrophy("Ashley",
                "Ashley creates a purple cloud when summoned, which causes opponents caught in it to move slower and take continuous damage, healing items to inflict damage, and other random effects.");

        // Black Knight
        insertAssistTrophy("Black Knight",
                "The Black Knight is a recurring antagonist in Fire Emblem: Path of Radiance. The second-in-command to the Mad King Ashnard, this mysterious knight was the man responsible for murdering Ike's father, Greil, for which Ike embarks on a quest of vengeance parallel to the liberation of Tellius.\n\n" +
                "When summoned, the Black Knight will walk slowly across the stage, striking any fighter that crosses his path. His attacks have a high launching potential, and he is immune to flinching when attacked.");

        // Bomberman
        insertAssistTrophy("Bomberman",
                "The main protagonist of the eponymous Bomberman series, Bomberman lays bombs on the stage, which explode in a cross formation and may cause chain reactions, similar to the original games.");

        // Burrowing Snagret
        insertAssistTrophy("Burrowing Snagret",
                "An enemy originally from Pikmin, the Burrowing Snagret is a reptilian creature with a bird-like head and a long beak which tunnels underground, only putting its head out to pick out prey.\n\n" +
                        "When summoned, it repeatedly lunges at opponents from one spot, damaging them. It also occasionally burrows underground and reappears in a different location. It takes its appearance from Pikmin 3, and is the first Assist Trophy from the Pikmin series.\n");

        // Chain Chomp
        insertAssistTrophy("Chain Chomp",
                "Chain Chomp attacks players by lunging at them, akin to its mainstream Mario appearances.");

        // Chef Kawasaki
        insertAssistTrophy("Chef Kawasaki",
                "Chef Kawasaki is a recurring enemy throughout Kirby Super Star and Kirby Star Allies (he can sometimes be an ally in the latter game), although he appears in a few other Kirby games as well. Defeating and inhaling him will give Kirby the Cook ability.\n\n" +
                "When summoned, Chef Kawasaki extends his ladle and traps anyone it hits into a boiling pot, then begins to stir and season the pot for a brief period of time. After that, multiple food items and any opponents inside the pot are launched out. Chef Kawasaki then produces another plate of food. The attack functions similar to Kirby's Final Smash in Super Smash Bros. Brawl.");

        // Color TV-Game 15
        insertAssistTrophy("Color TV-Game 15",
                "The Color TV-Game 15 was the second model in Nintendo's Japan-only line of Color TV-Game dedicated consoles, some of the earliest video game products released by the company. Released in 1977, the Color TV-Game 15 features two controllers and fifteen variations of \"Light Tennis\".\n\n" +
                "When summoned as an Assist Trophy, the two paddles appear on both sides of the screen as a game starts. The two paddles proceed to hit the ball back and forth, the ball damaging any opponents in its path that it hits. Players can also attack the ball to send it in a different direction. A score is kept above, though it does not impact the match; clapping can also be heard each time a point is scored. In Super Smash Bros. Ultimate, the background changes color when the paddles appear.");

        // Devil
        insertAssistTrophy("Devil",
                "The Devil is the main antagonist of the Nintendo Entertainment System game, Devil World, released only in Japan and Europe.\n\n" +
                "When summoned, the Devil will first appear as a bat and fly to the top of the screen. Once at the top, the Devil assumes his true form and begins pointing in one of the cardinal directions, causing the camera, which is otherwise fixed in place during this time, to move in the direction he points. As a result of this, the blast zones of the stages change continuously until the Devil disappears.");

        // Dillon
        insertAssistTrophy("Dillon",
                "Dillon is an armadillo ranger and the titular main protagonist from the Dillon's Rolling Western series. His job is to defend villages from being raided by creatures called Grocks.\n\n" +
                "After being summoned as an Assist Trophy, he charges up a rolling attack similar to Sonic's Spin Dash and leaps forward, striking any opponents in his path. After doing this a few times, he charges up a more powerful attack that sends him flying off the stage before disappearing.");

        // Dr. Kawashima
        insertAssistTrophy("Dr. Kawashima",
                "Dr. Ryuta Kawashima (Japanese: 川島 隆太) is a Japanese neuroscientist and host of the Brain Age series. In the series, he is represented by a polygonal version of his own face, similar to Andross.\n\n" +
                "When summoned, Dr. Kawashima immediately disappears, but causes numbers to fly across the screen. If two numbers collide, they add into a larger number, and if the two numbers equal 10 or greater, they explode. The explosion is bigger and lasts longer (similar to that of a Smart Bomb) if the numbers equal exactly 10. Players can also attack the numbers to knock them away. In Super Smash Bros. Ultimate, the white, gridded background from the Brain Age games replaces the stage's background when Dr. Kawashima is summoned.");

        // Dr. Wright
        insertAssistTrophy("Dr. Wright",
                "Dr. Wright, the player's assistant from the SNES version of SimCity, appears and attacks opponents by using his pointer stick to pull a skyscraper from the ground, sending them flying upwards. The attack is executed right in front of Dr. Wright and the vertical range is very high, so fighters should run away immediately after he is released. There is a one-in-ten chance that Dr. Wright will summon a particularly large skyscraper for even more range and power.");

        // Flies & Hand
        insertAssistTrophy("Flies & Hand",
                "The flies and the hand holding the flyswatter from the Gnat Attack minigame present in Mario Paint. When summoned, the Hand will move about the screen, attempting to swat the flies buzzing about at random. While the flies cannot harm the fighters, the flyswatter can.");

        // Ghirahim
        insertAssistTrophy("Ghirahim",
                "Ghirahim is one of the primary antagonists in The Legend of Zelda: Skyward Sword, who sought to revive his master, the Demon King Demise, who once razed the land that lay below Skyloft. In order to do so, he intends to offer Zelda as a sacrifice.\n\n" +
                "He attacks primarily through his sword and by throwing projectile diamonds when jumping. He constantly moves around while attacking and, if he falls off the stage, teleports to the edge. If enough damage is dealt to him, he will stagger before disappearing; otherwise, he will simply go away after a period of time.");

        // Ghosts
        insertAssistTrophy("Ghosts",
                "Blinky, Inky, Pinky, and Clyde appear as an Assist Trophy, taking their appearance from the original Pac-Man arcade game. All four randomly appear on the stage and attack opponents in a similar fashion to their original appearances. After a while, they speed up before leaving the screen. In Super Smash Bros. Ultimate, the stage's background turns navy to replicate the dark background from the original Pac-Man when the ghosts appear.");

        // Gray Fox
        insertAssistTrophy("Gray Fox",
                "Gray Fox from the Metal Gear series was originally an operative for the United States Army special forces unit FOXHOUND called Frank Jaeger, before he was subjected to gene experimentation and placed inside an exoskeleton and became a mercenary. Although he fought against Solid Snake and Big Boss several times, he secretly helped them before his death during the Shadow Moses Incident in 2005.\n\n" +
                "When summoned, he runs and jumps across the screen toward other fighters, slashing them multiple times with his katana. He can deflect projectiles, and is unique among Assist Trophies in that he will return from above should he fall off the stage");

        // Guile
        insertAssistTrophy("Guile",
                "Guile is a character from the Street Fighter series. A U.S. Air Force major, Guile holds an intense grudge against M. Bison, the head of Shadaloo, who was responsible for the murder of his best friend Charlie Nash during an operation. He usually works together with other characters like Chun-Li and Cammy, who also have scores to settle with Bison, to bring him down\n\n" +
                        "When summoned, Guile stays in one spot, crouched. If a character approaches him, he will attack them with the Flash Kick. If he is attacked from a distance, he will block. He may also fire off his Sonic Boom projectile");

        // Hammer Bro
        insertAssistTrophy("Hammer Bro",
                "A Hammer Bro appears on the stage and throws hammers at opponents. It can jump up and throw them in midair and it can also throw hammers while on the ground.");

        // Isaac
        insertAssistTrophy("Isaac",
                "saac is the main character of the Golden Sun series. He is a Venus Adept who has the power to use psychic energy revolving around either the manipulation of the ground and nature or simple non-combat abilities such as moving objects.\n\n +" +
                        "When he appears, Isaac summons a giant hand (a utility ability called Move) and sends it to the end of the stage, pushing any opponents along with it. He does this three times before disappearing. The hand does not do any direct damage; its only purpose is to send opponents off of the stage. In Super Smash Bros. Ultimate, however, the hand is also able to attack opponents by slamming into the ground with the Pound move. Isaac can also use Lift to summon a pair of hands to grab an opponent and carry them off-screen.");

        // Jeff
        insertAssistTrophy("Jeff",
                "Jeff Andonuts is one of the main heroes in EarthBound and the son of the scientist Dr. Andonuts. In EarthBound, whereas the rest of Ness's party can utilize PSI attacks, Jeff's attacks use guns and other gadgets, such as various types of bottle rockets and stat-altering devices.\n\n" +
                "As an Assist Trophy, he prepares and launches a set of five bottle rockets, which shoot into the air, homing in on enemies in unpredictable trajectories. There will always be four small bottle rockets followed by a big bottle rocket at the end, but there is a one-in-five chance that he will summon a second wave of rockets before disappearing.");

        // Kapp'n
        insertAssistTrophy("Kapp'n",
                "Kapp'n is a character from the Animal Crossing series. Usually depicted as a sailor and speaking with a stereotypical pirate accent, he has driven a number of different vehicles throughout the series, either driving the player to the town where they will be living or ferrying them to the island where multiplayer modes take place.\n\n" +
                "After being summoned, Kapp'n enters his bus and drives it across the stage. If it runs into any opponents, they are automatically put on the bus and are carried off as Kapp'n drives off-screen. If Kapp'n drives off without picking up any fighter, he will respawn at the center of the screen until his summoning time runs out.");

        // Klaptrap
        insertAssistTrophy("Klaptrap",
                "As the Klaptrap walks along the stage, if an opponent is caught in its path, it latches onto them and bites them repeatedly.\n\n" +
                        "Knuckle Joe is a recurring enemy in the Kirby series. He first appeared in Kirby Super Star, where he grants Kirby the Fighter ability when inhaled and has appeared in numerous games since, still granting Kirby the Fighter ability when inhaled.\n\n" +
                        "When summoned as an Assist Trophy, Knuckle Joe hops to the nearest opponent and deliver a flurry of Vulcan Jabs. He performs this one more time before finishing off the opponent with either a Rising Break or Smash Punch, both signature moves of the Fighter ability from the Kirby series, then disappears. In Super Smash Bros. for Nintendo 3DS / Wii U and Super Smash Bros. Ultimate, his attacks are weaker, though he can perform two Rising Breaks or Smash Punches before disappearing rather than one like in Super Smash Bros. Brawl.");

        // Knuckles
        insertAssistTrophy("Knuckles",
                "Knuckles runs around the stage and uses Homing Attacks similar to Sonic's, and occasionally burrows underground and re-emerges at a different location.");

        // Krystal
        insertAssistTrophy("Krystal",
                "Krystal is a character from the Star Fox series who first appears in Star Fox Adventures. A native from the destroyed planet of Cerinia, she was rescued by Fox after being imprisoned during her quest to find the Krazoa Spirits and stop General Scales, the one responsible for the destruction of her homeworld. When the situation is resolved, Krystal joins the Star Fox team in gratitude.\n\n" +
                "As an Assist Trophy, she uses her staff to cast ice spells as well as to swing at opponents at close range.");

        // Lyn
        insertAssistTrophy("Lyn",
                "Lyn, full name Lyndis, is from the GBA Fire Emblem game. Having grown up in a camp of hunters, she finds out she is the granddaughter of the Marquess of Caelin and the next in the line of succession for the throne of her homeland, and sets out to claim her birthright while evading the schemes of her great-uncle Lundgren, who had her grandfather poisoned in a plan to seize the throne for himself.\n\n" +
                "When she appears, she charges for an attack. She then teleports to an enemy (usually whoever's closest to her) and slashes at them using her signature weapon, the Mani Katti, launching them far. This attack is very powerful and difficult to avoid, capable of hitting enemies that are in the air and even certain characters in their Final Smashes. In games following Super Smash Bros. Brawl, she is able to be damaged. If enough damage is done to her before she attacks, she disappears; otherwise, she simply disappears after attacking.");

        // Metroid
        insertAssistTrophy("Metroid",
                "Metroids are the titular species of parasitic aliens from the Metroid series. They were created by the Chozo to combat the X parasites, though they eventually grew out of hand, and are now supposedly extinct thanks to the efforts of Samus Aran.\n\n" +
                        "When released, the Metroid floats around the stage, latching onto any players it encounters and sucking their health away, similar to what they do in the original games. In Super Smash Bros. for Nintendo 3DS, Metroids also appear as Smash Run enemies.");

        // Midna
        insertAssistTrophy("Midna",
                "Midna is a Twili and a central character appearing in The Legend of Zelda: Twilight Princess. Originally the titular Twilight Princess and ruler of the Twilight Realm, she was overthrown by Zant and transformed into an imp form by him. Afterward, she leaves the realm to collect the Fused Shadows to defeat him.\n\n" +
                "As an Assist Trophy, she attacks by grabbing fighters with her hair and throwing them. If no opponents are near her, she teleports to their location.");

        // Moon
        insertAssistTrophy("Moon",
                "The moon from The Legend of Zelda: Majora's Mask appears in the background and slowly approaches the stage (similar to its role in the original game), burning up as it does so. Once it crashes into the stage, the surrounding fire deals repeated fire damage on opponents before disappearing in a white flash.\n\n");

        // Nightmare
        insertAssistTrophy("Nightmare",
                "Nightmare (also referred to as Nightmare Wizard) is a major antagonist in the Kirby series, appearing as the final boss of both Kirby's Adventure and its remake, Kirby: Nightmare in Dream Land. In both games, Nightmare tried to plunge the realm of Dream Land into darkness, but was defeated by the combined forces of King Dedede and Kirby wielding the power of the Star Rod.\n\n" +
                "As an Assist Trophy, he takes on his Kirby: Nightmare in Dream Land appearance. When summoned, Nightmare first appears in his Power Orb form before flying to the top of the screen. After a few seconds, he immediately appears and enlarges himself in the background of the stage while cackling and shrouding the stage in darkness. During this time, the entire screen is black, confusing both players and CPU opponents. Several seconds later, the darkness slowly fades away, along with Nightmare.");

        // Nikki
        insertAssistTrophy("Nikki" ,
                "Nikki is a character who first appeared in the form of a Mii as the host of Swapnote. When summoned, she appears at the bottom-left corner of the screen and sketches three different objects, which are drawn on the stage itself and may damage fighters. Some of Nikki's drawings include a Bullet Bill, which flies away and attacks opponents, and a fire-breathing dinosaur.");

        // Nintendog
        insertAssistTrophy("Nintendog",
        "A Nintendog from the Nintendogs games briefly appears on the battleground before coming up to the screen and blocking the players' views, causing a great distraction. In Super Smash Bros. Ultimate, it is a Toy Poodle.\n\n");

        // Phosphora
        insertAssistTrophy("Phosphora",
                "Phosphora (full title Lightning Flash Phosphora) is a character from Kid Icarus: Uprising. She specializes in lightning-based attacks and is one of the commanders in the Forces of Nature, alongside Arlon the Serene and led by Viridi. She fights Pit in Chapter 14 and later becomes an ally of him, along with the Forces of Nature.\n\n" +
                "When summoned as an Assist Trophy, she attacks all her opponents with lightning attacks. She either creates three small balls of electricity, one giant sphere of electricity, or three quick strikes of lightning. Attacking Phosphora does not defeat her, but it makes her flinch temporarily. Every time she is hit, she moves away from the stage, making it harder for her to hit. Phosphora's attacks can be absorbed or reflected.");

        // Prince of Sable
        insertAssistTrophy("Prince of Sable",
                "The Prince of Sablé is the unnamed main protagonist of the Japan-exclusive Kaeru no Tame ni Kane wa Naru (literally \"The Frog for Whom the Bell Tolls\"), released on the Game Boy.\n\n" +
                "He attacks players by transforming into a frog and hopping around, then transforming into a snake and slithering across the ground. If he encounters any opponents, he traps them in a smoke cloud and continuously attacks them, similar to battles in his game of origin; other players can also be caught in this. Afterward, he transforms back into his human form.");

        // Rathalos
        insertAssistTrophy("Rathalos",
                "When Rathalos is summoned, he flies above the stage and attacks by spitting large fireballs, and emits a loud roar that stuns opponents. He also appears as a boss in the World of Light and Classic Mode.");

        // Riki
        insertAssistTrophy("Riki",
                "Riki is one of the seven playable characters in Xenoblade Chronicles. He is a Nopon regarded as the \"Heropon\" of Frontier Village, but this is mostly so that he can repay all of his debts. Though he acts immature, he is still a loyal member of Shulk's group as they fight against the Mechon.\n\n" +
                "After being summoned as an Assist Trophy, he uses a variety of his Battle Arts: Happy Happy increases the attack and launching power of all fighters, Freezinate temporarily freezes nearby opponents (dealing minor damage as well), Yoink! brings all items closer to him, Bedtime temporarily puts nearby enemies to sleep, You Can Do It slightly heals all fighters, and Roly Poly trips all grounded opponents. Riki also makes an appearance alongside Dunban in Shulk's Final Smash, Chain Attack.");

        // Rodin
        insertAssistTrophy("Rodin",
                "Rodin, from the Bayonetta series, is the mysterious bartender of the \"Gates of Hell\" pub, who is also Bayonetta's arms supplier. When summoned, he moves around the stage and summons giant versions of his fists when attacking, similar to Bayonetta's Wicked Weave attacks. He can also attack using his version of Bayonetta's After Burner Kick. Before disappearing, he leaves an item behind.");

        // Samurai Goroh
        insertAssistTrophy("Samurai Goroh",
                "Samurai Goroh is a pilot from the F-Zero series. He is a bounty hunter who has a rivalry with Captain Falcon. As an Assist Trophy, he appears and slashes away at the fighters with his katana. He can jump while slashing horizontally.");

        // Shadow
        insertAssistTrophy("Shadow",
                "Shadow uses Chaos Control to slow down all opposing fighters. In Super Smash Bros. Ultimate, he freezes opponents in place before he disappears.");

        // Sheriff
        insertAssistTrophy("Sheriff",
                "The sheriff is the protagonist of an arcade game also called Sheriff. Designed after a typical Western sheriff, he goes after a group of bandits that have kidnapped Betty. In the upright arcade cabinet's bezel, he is named Mr. Jack. He is also known as the gunman (ガンマン) in the Japanese instructions. He is the first playable human character in any Nintendo video game.\n\n" +
                        "When spawned as an Assist Trophy, he walks around the screen and shoots bullets towards other enemies (though he sometimes fires in a haphazard direction), emulating his attacks from Sheriff. If enough damage is dealt to him, he displays his \"injured\" sprite from Sheriff before disappearing; otherwise, he disappears after enough time has passed.");

        // Shovel Knight
        insertAssistTrophy("Shovel Knight",
                "Shovel Knight is the protagonist of his eponymous game, and also the first indie game character to appear in physical form and as an Assist Trophy in the Super Smash Bros. series. As his name implies, he fights with a shovel, and treks across the land in order to save his beloved Shield Knight and defeat the evil Enchantress and her Order of No Quarter.\n\n" +
                "Shovel Knight uses similar moves from the original game, digging rocks out of the ground with his shovel and aiming it downward while in mid-air to bounce on opponents, damaging them. The shovel may also damage opponents as he is digging the ground. Occasionally when digging, an item appears out of the ground.");

        // Skull Kid
        insertAssistTrophy("Skull Kid",
                "Skull Kid is a major antagonist in The Legend of Zelda: Majora's Mask, being possessed by the titular mask and calling the moon to crash down on Termina in three days if not stopped.\n\n" +
                "When summoned as an Assist Trophy, he emits a dark aura that either reverses the stage or flips it upside down, both of which reverse the controls.");

        // Spring Man
        insertAssistTrophy("Spring Man",
                "Spring Man is one of the fighters from ARMS. He is an enthusiastic 20-year-old youngster who dreams of winning the ARMS Grand Prix and, as his name implies, not only are his arms spring-propelled, he also has an entire spring theme around him (such as his hairstyle, fittingly coiled in the shape of a spring).\n\n" +
                "When summoned, Spring Man will attack by punching from a distance, but if the opponent gets too close, he will unleash ARMS Rush, a barrage of punches capable of launching them away.");

        // Squid Sisters
        insertAssistTrophy("Squid Sisters",
                "The Squid Sisters, Callie and Marie, appear on a small stage and perform \"Ink Me Up\" or \"Calamari Inkantation.\" As they do so, the camera slowly zooms in on them, limiting the amount of space to fight and making it easier for players to be KO'd.");

        // Starfy
        insertAssistTrophy("Starfy",
                "Starfy (also known as Stafy) from The Legendary Starfy series performs his spin attack on an opponent if he has the chance. However, fighters can easily attack him and send him flying.");

        // Starman
        insertAssistTrophy("Starman",
                "Starmen are an alien race that serve Giygas in EarthBound Beginnings and EarthBound. In EarthBound, Starmen teleport before being engaged in battle and attack by firing beams.\n\n" +
                "Starmen are an alien race that serve Giygas in EarthBound Beginnings and EarthBound. In EarthBound, Starmen teleport before being engaged in battle and attack by firing beams.\n" +
                        "Once summoned as an Assist Trophy, the Starman proceeds to teleport around the stage. After it teleports, the Starman stops in its place, glows, and attacks using either PK Beam γ or PK Beam Ω. Getting hit by one of these attacks causes moderate damage and the player is momentarily stunned. The beams act like energy projectiles, so they can be absorbed or reflected. If the opponents cause enough damage to the Starman while it's still active, the Starman is defeated, displaying both the \"SMAAAASH!\" text and sound effect from EarthBound before disappearing prematurely.");

        // Sukapon
        insertAssistTrophy("Sukapon",
                "A robot and the main character of the Japan-only Famicom game Joy Mech Fight, Sukapon is a comedian robot designed by Dr. L. Emon, but repurposed as a combat robot in order to stop Dr. Walnuts from taking over the world with seven other robots stolen from Emon.\n\n" +
                "Sukapon moves around the stage and throws parts of its body at opponents, and can even pick them up and throw them into the air.");

        // Takamaru
        insertAssistTrophy("Takamaru",
                "Takamaru is the protagonist of The Mysterious Murasame Castle. Like in his original game, he attacks by quickly slashing with his katana and by throwing shurikens in the four cardinal directions. He constantly moves around while attacking and jumps back to the stage's edge if he starts to fall to a pit. If enough damage is dealt to him, he becomes staggered before disappearing; otherwise, he simply goes away after a period of time.");

        // Thwomp
        insertAssistTrophy("Thwomp",
                "When summoned, the Thwomp stays high up on the screen and comes crashing down on top of any character that passes underneath it.");

        // Tiki
        insertAssistTrophy("Tiki",
                "Tiki is a character from the Fire Emblem series. The last of the divine dragonkin of Archanea, she originally fought alongside Marth in his quest to reclaim the throne of Archanea, then a thousand years later she was encountered by Chrom, whom she guided in the role of an oracle." +
                "Tiki's appearance as an Assist Trophy comes from Fire Emblem Awakening. When summoned, Tiki assumes her dragon form, flies just outside the arena and unleashes a massive fire breath capable of launching anyone caught in it.");

        // Vince
        insertAssistTrophy("Vince",
                "Vince is the art teacher from the Art Academy games. When summoned, he brings up his easel and starts painting objects such as busts and tomatoes, which manifest themselves over any fighters other than the one or the team that summoned him, damaging them and hampering their visibility in a similar way to a Smoke Ball.\n\n" +
                "Despite his Training Mode description not saying so like for other Assist Trophies, Vince cannot be defeated.");

        // Waluigi
        insertAssistTrophy("Waluigi",
                "Waluigi chases after a selected foe, kicks them onto the ground and finally, he does one final power kick or hits the player with his racket.");

        // Wily Capsule
        insertAssistTrophy("Wily Capsule",
                "The Wily Capsule is Dr. Wily's personal escape pod, and usually his last resort in his battles against Mega Man. The model seen in Super Smash Bros. Ultimate comes from Mega Man 7.\n\n" +
                "When summoned, Dr. Wily will fire red and blue energy balls from the capsule, which will home in on the nearest fighter. If the capsule is destroyed, Dr. Wily will fall to the ground and enter his supplication pose.");

        // Yuri Kozukata
        insertAssistTrophy("Yuri Kozukata",
                "Yuri Kozukata is one of the protagonists of Koei Tecmo's Wii U game Fatal Frame: Maiden of Black Water. A descendant of the shrine maidens of Mt. Hikami, psychics who had the ability to guide spirits to a peaceful afterlife, Yuri has the power of repelling the eponymous Black Water, an evil presence which torments spirits and causes them to curse the living.\n\n" +
                "When Yuri is summoned, she stays in the background as the reticle of her Camera Obscura moves throughout the screen, and any character photographed with it is momentarily paralyzed and afflicted with darkness. She takes a total of three photographs before leaving the stage.");

        // Zero
        insertAssistTrophy("Zero",
                "One of the protagonists of the Mega Man X series, Zero is a Maverick Hunter, member of an elite force designated to hunt down and destroy Mavericks, robots that have turned against humankind.\n\n" +
                "When summoned, Zero slashes opponents directly with his sword, the Z-Saber, and also uses it to fire beams from a distance. After he is done, he shouts, \"Back to base!\" and disappears.");
    }

}