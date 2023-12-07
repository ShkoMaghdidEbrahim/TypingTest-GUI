import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.*;

public class TypingTest {
    
    public TypingTest() {
        /*
        Flatlaf is a library that changes the theme of Swing components, themes such as:
        Flatlaf Light
        Flatlaf Dark
        Flatlaf Dracula
        */
        FlatNightOwlContrastIJTheme.install(new FlatNightOwlContrastIJTheme());
        //Make Swing components Round
        UIManager.put("Button.arc", 10);
        UIManager.put("ProgressBar.arc", 5);
        UIManager.put("Component.arc", 10);
        //Text sample to be re-formatted
        String[] Easy = new String[]{"the", "of", "and", "a", "to", "in", "is", "you", "that", "it", "he", "was", "for", "on", "are", "as", "with", "his", "they", "I", "at", "be", "this", "have", "from", "or", "one", "had", "by", "word", "but", "not", "what", "all", "were", "we", "when", "your", "can", "said", "there", "use", "an", "each", "which", "she", "do", "how", "their", "if", "will", "up", "other", "about", "out", "many", "then", "them", "these", "so", "some", "her", "would", "make", "like", "him", "into", "time", "has", "look", "two", "more", "write", "go", "see", "number", "no", "way", "could", "people", "my", "than", "first", "water", "been", "call", "who", "oil", "its", "now", "find", "long", "down", "day", "did", "get", "come", "made", "may", "part"};
        String[] Medium = new String[]{"accommodate", "accommodated", "accommodates", "accommodating", "accommodatingly", "accommodation", "accommodationism", "accommodationist", "accommodations", "accommodative", "accompanied", "accompanies", "accompaniment", "accompaniments", "accompanist", "accompanists", "accompany", "accompanying", "accompanyist", "accompanyists", "accomplice", "accomplices", "accomplish", "accomplished", "accomplisher", "accomplishes", "accomplishing", "accomplishment", "accomplishments", "accord", "accordance", "accordant", "accorded", "according", "accordingly", "accordion", "accordionist", "accordionists", "muscatels", "muscats", "muscid", "muscle", "musclebound", "muscled", "muscleman", "musclemen", "muscles", "muscling", "muscly", "muscovado", "muscular", "muscularity", "hijacked", "hijacker", "hijackers", "hijacking", "hijackings", "hijacks", "hike", "hiked", "hiker", "hikers", "hikes", "hiking", "hila", "hilarious", "hilariously", "hilariousness", "hilarity", "hill", "hillbillies", "keyboarders", "keyboarding", "keyboardist", "keyboardists", "keyboards", "keycard", "keyed", "keyhole", "keyholes", "keying", "keynote", "keynoted", "keynoter", "keynoters", "keynotes", "keynoting", "keypad", "keypads", "keypunch", "keypunched", "keypuncher", "keypunchers", "keypunches", "keypunching", "keyring", "keys", "keystone", "keystones", "outguessing", "outgun", "outgunned", "outgunning", "outguns", "out-haul", "outhit", "outhits", "outhitting", "outhouse", "outhouses", "outing", "outings", "outlaid", "out-land", "outlander", "outlanders", "outlandish", "outlandishly", "outlandishness", "outlands", "outlast", "outlasted", "outlasting", "outlasts", "outlaw", "outlawed", "outlawing", "outlawries", "beeps", "beer", "beerier", "beeriest", "beermat", "beermats", "beers", "beery", "bees", "bees-tings", "beeswax", "bowing", "beet", "beetle", "beetled", "beetles", "beetling", "beetroot", "beetroots", "beets", "beeves", "beer", "befall", "befallen", "befalling", "befalls", "befell", "befit", "befits", "befitted", "befitting", "befittingly", "befog", "befogged", "muscularly", "musculature", "muse", "mused", "musicology", "muster", "muses", "musette", "musettes", "museum", "museums", "mush", "mushed", "musher", "mushers", "mushes", "mushier", "mushiest", "mushiness", "mushing", "mushroom", "mushroomed", "revivalism", "revivalist", "revivalist", "revivalists", "revivals", "revive", "revived", "reviver", "revives", "revivification", "revivified", "revivifies", "revivify", "revivifying", "reviving", "reminiscence", "revocable", "revocation", "revocations", "revelatory", "voice", "revoke", "revoked", "revoker", "revokers", "revokes", "revoking", "revolt", "revolted", "revolted", "revolting", "revoltingly", "revolts", "revolute", "revolution", "revolutionaries", "revolutionary", "revolution", "revolutionist", "revolutionists", "revolutions", "revolvable", "revolve", "revolved", "revolver", "revolvers", "workweeks", "workman", "world", "worldlier", "worldliest", "worldliness", "worldliness", "worldly", "worlds", "worldview", "worldviews", "worldwide", "worm", "wormed", "wormhole", "wormholes", "wormier", "wormiest", "worthiness", "worming", "worms", "worm-seed", "saprophytes", "hypertrophic", "kerosene", "sclerosis", "xerox", "xeroxed", "xeroxes", "xeroxing", "xi", "magisterium", "subxiphoid", "xis", "xu", "xylem", "xylene", "xylene", "sliding", "holograph", "holography", "reload", "xy lol", "axolotls", "coprophagous", "xylophone", "xylophones", "xylophonist", "xylophonists", "dichotomous", "lobotomy", "oyster", "yeast", "yeastier", "yeastiest", "yeasts", "yeasty", "yegg", "yeggs", "yield", "yell", "yelled", "yelling", "yellow", "yellow bird", "yellow-birds", "yellowed", "yellower", "yellowest", "yellowhammer", "yellowhammers", "yellowing", "yellowish", "yellowness", "yellowness", "yellows", "yellow tail", "eline", "Tibet", "cloudiness", "invidiousness", "zig", "ziggurat", "zips", "zigzag", "zigzagged", "zigzagged", "zigzagging", "zigzags", "zilch", "zillion", "zillions", "zinc", "zinc-ate", "coniferous", "zincked", "zincking", "iconographic", "iconography", "zincs", "zine", "zines", "zinfandel", "zing", "roaring", "desegregated", "desegregates", "desegregating", "desegregation", "desegregationist", "deselect", "deselected", "deselecting", "deselection", "deselects", "desert", "deserted", "deserter", "deserters", "desertification", "deserting", "desertion", "desertions", "deserts", "deserve", "deserved", "deservedly", "deserves", "deserving", "deserving", "des-ex", "folktale", "folktales", "folkway", "folkways", "follicle", "follicles", "follicular", "follicular", "follies", "follow", "followed", "follower", "followers", "following", "followings", "follows", "folly", "foment", "fomentation", "fomented", "fomented", "fomenters", "fomenting", "foments"};
        String[] Hard = new String[]{"A,", "I.", "His,", "That?", "He.", "Was?", "For.", "On,", "Are,", "With,", "They!", "Be;", "At.", "One.", "Have.", "This,", "From,", "By;", "Hot!", "Word,", "But:", "What,", "Some.", "Is.", "It,", "You!", "Or.", "Had;", "The,", "Of!", "To.", "And,", "A:", "In.", "We;", "Can,", "Out?", "Other?", "Were!", "Which,", "Do.", "Their?", "Time.", "If.", "Will.", "How,", "Said,", "An,", "Each,", "Tell,", "Does.", "Set.", "Three.", "Want;", "Air?", "Well!", "Also,", "Play,", "Small,", "End,", "Put?", "Home;", "Read,", "Hand;", "Port.", "Large.", "Spell,", "Add,", "Even.", "Land.", "Here?", "Must,", "Big.", "High,", "Such.", "Follow!", "Act!", "Why.", "Ask,", "Men,", "Change,", "Went,", "Light,", "Kind,", "Off,", "Need,", "House,", "Picture?", "Try,", "Us,", "Again,", "Animal,", "Point,", "Mother.", "World,", "Near,", "Build.", "Self.", "Earth,", "Father,", "Any.", "New,", "Work.", "Part,", "Take;", "Get,", "Place.", "Made,", "Live,", "Where.", "After,", "Back:", "Little,", "Only,", "Round,", "Man.", "Year?", "Came;", "Show;", "Every,", "Good!", "Me;", "Give,", "Our,", "Under.", "Name,", "Very!", "Through.", "Just.", "Form.", "Sentence,", "Great,", "Think.", "Say,", "Help!", "Low,", "Line!", "Differ,", "Turn,", "Cause,", "Much.", "Mean.", "Before,", "Move,", "Right;", "Boy?", "Old,", "Too;", "Same?", "She;", "All!", "There,", "When,", "Up,", "Use,", "Your,", "Way,", "About,", "Many,", "Then,", "Them,", "Write!", "Would.", "Like,", "So,", "These!", "Her,", "Long,", "Make;", "Thing,", "See;", "Him,", "Two:", "Has.", "Look,", "More,", "Day,", "Could,", "Go!", "Come,", "Did,", "Number.", "Sound.", "No,", "Most,", "People,", "My,", "Over,", "Know,", "Water,", "Than?", "Call!", "First.", "Who,", "May.", "Down,", "Side?", "Been,", "Now?", "Find.", "Head,", "Stand,", "Own,", "Page,", "Should,", "Country?", "Found.", "Answer.", "School.", "Grow.", "Study?", "Still,", "Learn!", "Plant,", "Cover,", "Food.", "Sun,", "Four;", "Between!", "State,", "Keep,", "Eye.", "Never,", "Last,", "Let,", "Thought?", "City,", "Tree;", "Cross,", "Farm?", "Hard,", "Start;", "Might,", "Story,", "Saw,", "Far,", "Sea!", "Draw,", "Left,", "Late,", "Run,", "Don’t!", "While!", "Press,", "Close,", "Night!", "Real!", "Life.", "Few,", "North,", "Book,", "Carry,", "Took,", "Science,", "Eat,", "Room.", "Friend!", "Began?", "Idea!", "Fish,", "Mountain,", "Stop,", "Once,", "Base,", "Hear.", "Horse?", "Cut,", "Sure:", "Watch,", "Color:", "Face,", "Wood?", "Main,", "Open,", "Seem,", "Together!", "Next,", "White,", "Children,", "Begin,", "Got!", "Walk,", "Example?", "Ease,", "Paper,", "Group,", "Always,", "Music!", "Those,", "Both,", "Mark,", "Often,", "Letter,", "Until.", "Mile?", "River!", "Car?", "Feet,", "Care,", "Second,", "Enough,", "Plain,", "Girl.", "Usual.", "Young?", "Ready,", "Above,", "Ever.", "Red?", "List:", "Though,", "Feel.", "Talk,", "Bird;", "Soon,", "Body.", "Dog,", "Family,", "Direct,", "Pose,", "Leave,", "Song.", "Measure,", "Door.", "Product;", "Black,", "Short,", "Numeral,", "Class,", "Wind;", "Question,", "Happen.", "Complete,", "Ship,", "Area,", "Half,", "Rock!", "Order!", "Fire.", "South,", "Problem;", "Piece.", "Told,", "Knew.", "Pass.", "Since,", "Top?", "Whole,", "King,", "Street,", "Inch;", "Multiply,", "Nothing.", "Course,", "Stay.", "Wheel,", "Full.", "Force,", "Blue,", "Object,", "Decide,", "Surface.", "Deep!", "Moon,", "Island,", "Foot.", "System,", "Busy,", "Test,", "Record,", "Boat,", "Common.", "Gold.", "Possible.", "Plane,", "Stead?", "Dry,", "Wonder.", "Laugh!", "Thousand.", "Ago?", "Ran,", "Check,", "Game,", "Shape;", "Equate,", "Hot,", "Miss,", "Brought,", "Heat,", "Snow!", "Tire,", "Bring,", "Yes,", "Distant?", "Fill?", "East?", "Paint!", "Language.", "Among,", "Unit.", "Power,", "Town:", "Fine,", "Certain,", "Fly,", "Fall.", "Lead!", "Cry,", "Dark.", "Machine,", "Note?", "Wait.", "Plan.", "Figure,", "Star,", "Box,", "Noun.", "Field?", "Rest,", "Correct,", "Able:", "Pound;", "Done,", "Beauty!", "Drive?", "Stood,", "Contain.", "Front.", "Teach,", "Week,", "Final;", "Gave.", "Green,", "Oh.", "Quick,", "Develop,", "Ocean,", "Warm,", "Free,", "Minute,", "Strong:", "Special,", "Mind,", "Behind,", "Clear,", "Tail.", "Produce,", "Fact;", "Space!", "Heard,", "Best,", "Hour,", "Better,", "True,", "During.", "Hundred,", "Five,", "Remember.", "Step,", "Early!", "Hold.", "West:", "Ground?", "Interest:", "Reach,", "Fast;", "Verb.", "Sing.", "Listen,", "Six,", "Table,", "Travel,", "Less.", "Morning,", "Ten,", "Simple,", "Several,", "Vowel.", "Toward,", "War!", "Lay,", "Against?", "Pattern.", "Slow?", "Center,", "Love,", "Person.", "Money.", "Serve,", "Appear.", "Road!", "Map,", "Rain,", "Rule;", "Govern.", "Pull,", "Cold,", "Notice,", "Voice,", "Energy,", "Hunt,", "Probable,", "Bed?", "Brother;", "Egg,", "Ride,", "Cell.", "Believe,", "Perhaps,", "Pick,", "Sudden,", "Count!", "Square;", "Reason.", "Length:", "Represent.", "Art?", "Subject!", "Region,", "Size,", "Vary.", "Settle.", "Speak.", "Weight.", "General,", "Ice.", "Matter,", "Circle,", "Pair,", "Include.", "Divide,", "Syllable.", "Felt,", "Grand,", "Ball.", "Yet!", "Wave,", "Drop,", "Heart,", "Am,", "Present,", "Heavy,", "Dance,", "Engine,", "Position,", "Arm,", "Wide.", "Sail,", "Material.", "Fraction,", "Forest,", "Sit?", "Race,", "Window!", "Store!", "Summer.", "Train.", "Sleep,", "Prove,", "Lone.", "Leg,", "Exercise?", "Wall,", "Catch.", "Mount?", "Wish,", "Sky.", "Board,", "Joy;", "Winter!", "Sat,", "Written,", "Wild.", "Instrument.", "Kept.", "Glass,", "Grass,", "Cow.", "Job,", "Edge.", "Sign.", "Visit,", "Past.", "Soft:", "Fun?", "Bright.", "Gas:", "Weather,", "Month,", "Million:", "Bear,", "Finish.", "Happy,", "Hope,", "Flower;", "Clothe,", "Strange,", "Gone,", "Trade.", "Melody,", "Trip!", "Office,", "Receive!", "Row.", "Mouth.", "Exact,", "Symbol,", "Die.", "Least:", "Trouble,", "Shout,", "Except.", "Wrote?", "Seed,", "Tone.", "Join:", "Suggest?", "Clean,", "Break.", "Lady,", "Yard,", "Rise,", "Bad,", "Blow.", "Oil,", "Blood,", "Touch.", "Grew,", "Cent.", "Mix,", "Team.", "Wire?", "Cost;", "Lost;", "Brown,", "Wear,", "Garden!", "Equal.", "Sent,", "Choose.", "Fell,", "Fit.", "Flow,", "Fair,", "Bank,", "Collect,", "Save.", "Control,", "Decimal.", "Ear:", "Else,", "Quite,", "Broke,", "Case,", "Middle,", "Kill;", "Son!", "Lake.", "Moment,", "Scale,", "Loud.", "Spring.", "Observe,", "Child,", "Straight,", "Consonant,", "Nation.", "Dictionary:", "Milk,", "Speed.", "Method;", "Organ,", "Pay,", "Age,", "Section.", "Dress.", "Cloud.", "Surprise!", "Quiet;", "Stone,", "Tiny.", "Climb!", "Cool,", "Design.", "Poor.", "Lot;", "Experiment.", "Bottom,", "Key,", "Iron,", "Single,", "Stick,", "Flat,", "Twenty,", "Skin.", "Smile,", "Crease!", "Hole.", "Jump,", "Baby!", "Eight,", "Village,", "Meet,", "Root.", "Buy,", "Raise,", "Solve;", "Metal?", "Whether?", "Push!", "Seven,", "Paragraph.", "Third,", "Shall,", "Held;", "Hair,", "Describe,", "Cook,", "Floor,", "Either,", "Result,", "Burn!", "Hill,", "Safe,", "Cat,", "Century,", "Consider,", "Type,", "Law.", "Bit,", "Coast,", "Copy.", "Phrase,", "Silent,", "Tall?", "Sand,", "Soil,", "Roll.", "Temperature,", "Finger!", "Industry.", "Value,", "Fight,", "Lie,", "Beat,", "Excite,", "Natural:", "View,", "Sense,", "Capital,", "Won’t,", "Chair.", "Danger,", "Fruit,", "Rich.", "Thick,", "Soldier:", "Process?", "Operate?", "Practice,", "Separate,", "Difficult.", "Doctor,", "Please.", "Protect,", "Noon,", "Crop,", "Modern.", "Element,", "Hit,", "Student.", "Corner,", "Party,", "Supply,", "Whose.", "Locate,", "Ring,", "Character,", "Insect,", "Caught,", "Period!", "Indicate,", "Radio,", "Spoke,", "Atom,", "Human,", "History.", "Effect.", "Electric.", "Expect!", "Bone.", "Rail,", "Imagine.", "Provide,", "Agree:", "Thus,", "Gentle?", "Woman,", "Captain,", "Guess,", "Necessary.", "Sharp,", "Wing:", "Create,", "Neighbor,", "Wash,", "Bat.", "Rather,", "Crowd,", "Corn?", "Compare,", "Poem,", "String,", "Bell!", "Depend,", "Meat.", "Rub,", "Tube,", "Famous:", "Dollar,", "Stream,", "Fear,", "Sight.", "Thin,", "Triangle,", "Planet,", "Hurry.", "Chief?", "Colony.", "Clock.", "Mine,", "Tie.", "Enter,", "Major,", "Fresh,", "Search;", "Send,", "Yellow,", "Gun.", "Allow.", "Print,", "Dead:", "Spot,", "Desert.", "Suit.", "Current.", "Lift,", "Rose,", "Arrive,", "Master!", "Track,", "Parent,", "Shore.", "Division,", "Sheet,", "Substance,", "Favor.", "Connect,", "Post.", "Spend;", "Chord,", "Fat,", "Glad,", "Original.", "Share,", "Station!", "Dad,", "Bread.", "Charge.", "Proper.", "Bar,", "Offer,", "Segment:", "Slave,", "Duck?", "Instant,", "Market.", "Degree.", "Populate,", "Chick!", "Dear,", "Enemy,", "Reply.", "Drink,", "Occur.", "Support.", "Speech?", "Nature.", "Range?", "Steam,", "Motion.", "Path,", "Liquid.", "Log.", "Meant,", "Quotient?", "Teeth,", "Shell,", "Neck,", "Oxygen.", "Sugar,", "Death,", "Pretty.", "Skill.", "Women,", "Season,", "Solution,", "Magnet!", "Silver.", "Thank,", "Branch,", "Match,", "Suffix,", "Especially.", "Fig,", "Afraid,", "Huge.", "Sister,", "Steel,", "Discuss,", "Forward.", "Similar.", "Guide.", "Experience:", "Score,", "Apple:", "Bought,", "Led.", "Pitch,", "Coat.", "Mass,", "Card,", "Band?", "Rope,", "Slip,", "Win,", "Dream,", "Evening:", "Condition,", "Feed,", "Tool:", "Total.", "Basic!", "Smell,", "Valley?", "Nor,", "Double:", "Seat,", "Continue!", "Block,", "Chart?", "Hat.", "Sell,", "Success?", "Company.", "Subtract,", "Event.", "Particular?", "Deal,", "Swim,", "Term,", "Opposite.", "Wife?", "Shoe,", "Shoulder.", "Spread?", "Arrange,", "Camp,", "Invent;", "Cotton;", "Born?", "Determine,", "Quart,", "Nine,", "Truck.", "Noise,", "Level,", "Chance,", "Gather,", "Shop,", "Stretch,", "Throw:", "Shine?", "Property,", "Column,", "Molecule!", "Select,", "Wrong,", "Gray,", "Repeat,", "Require,", "Broad,", "Prepare,", "Salt,", "Nose?", "Plural!", "Anger.", "Claim.", "Continent."};
        //The array that will be formatted and used for highlighting and many others
        String[] Text = new String[Hard.length];
        //Default will be Easy - you can change later after running
        String textFormated;
        textFormated = textFormatter(Easy, Text);
        
        //Initializing the sound player
        File[] soundFiles = new File[5];
        soundFiles[0] = new File("Sounds/starting.wav");
        soundFiles[1] = new File("Sounds/typingCorrectSound.wav");
        soundFiles[2] = new File("Sounds/typingErrorSound.wav");
        soundFiles[3] = new File("Sounds/winning.wav");
        soundFiles[4] = new File("Sounds/typingSound.wav");
        AudioInputStream[] inputStream = new AudioInputStream[5];
        Clip[] player = new Clip[5];
        for (int i = 0; i < soundFiles.length; i++) {
            try {
                inputStream[i] = AudioSystem.getAudioInputStream(soundFiles[i]);
            }
            catch (UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
            try {
                player[i] = AudioSystem.getClip();
                player[i].open(inputStream[i]);
            }
            catch (LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        }
        
        //Recalling all the methods
        JFrame frame = frame(icon);
        JPanel panelText = panelText(frame);
        
        JTextArea output = output(panelText, textFormated);
        JTextArea input = input(panelText);
        
        JLabel labelEverything = labelEverything(panelText);
        
        Highlighter gray = gray(output);
        Highlighter.HighlightPainter painterGray = painterGray();
        
        JButton start = start(panelText);
        JButton reset = reset(panelText, restart, restartAnimated);
        JButton OK = OK(panelText);
        
        JRadioButton thirtySec = thirtySec(panelText);
        JRadioButton sixtySec = sixtySec(panelText);
        group(thirtySec, sixtySec);
        
        JProgressBar progressBar = timeProgress(panelText);
        JComboBox<String> difficulty = difficulty(panelText);
        //All the Action and Key Listeners
        {
            input.addKeyListener(new KeyListener() {
                /*
                adding a functionality so every word you type when you press the spacebar
                it deletes that word from the Area that shows the words you have to type
                */
                
                //Number of times the Space is pressed(decrements when backspace is pressed)
                int timesPressed = 1;
                
                //Code to be executed on every key press
                public void keyPressed(KeyEvent e) {
                    //set the cursor to be limited to only editing the last index
                    //so mistakenly putting the cursor somewhere else doesn't ruin your current test
                    //(you will have to use backspace or ctrl+backspace to correct a mistake)
                    input.setCaretPosition(input.getText().length());
                    //Creating a new array that will hold the previous words except the one you typed
                    String[] newText = new String[Text.length];
                    //If the spacebar(32) is pressed do this:
                    if (e.getKeyCode() == 32 && timesPressed > 0 && timesPressed <= Text.length) {
                        String[] inputWords = input.getText().split(" ");
                        StringJoiner joinerSpace = new StringJoiner(" ");
                        output.setText("");
                        //Copy from the old array except the word you just typed
                        if (newText.length - timesPressed >= 0) {
                            System.arraycopy(Text, timesPressed, newText, 0, newText.length - timesPressed);
                        }
                        timesPressed++;
                        //Re-format the new array(the one not containing the last word)
                        for (String value : newText) {
                            if (value != null) {
                                joinerSpace.add(value);
                            }
                        }
                        String textPress = joinerSpace.toString();
                        //Set the text of the Text Area to the new text
                        output.setText(textPress);
                        /*
                        change the color of the text to green or red and play a sound
                        based on whether your last word was correct or not
                        */
                        if (inputWords.length >= 1) {
                            //changing the color
                            Color correctOrIncorrectColor = Objects.equals(inputWords[inputWords.length - 1], Text[inputWords.length - 1]) ? Color.green : Color.red;
                            input.setForeground(correctOrIncorrectColor);
                            //Playing the sound
                            Clip correctOrIncorrectSound = Objects.equals(inputWords[inputWords.length - 1], Text[inputWords.length - 1]) ? player[1] : player[2];
                            correctOrIncorrectSound.start();
                        }
                        //Highlight the new word that you have to type
                        if (timesPressed <= Text.length) {
                            try {
                                gray.addHighlight(0, Text[timesPressed - 1].length(), painterGray);
                            }
                            catch (BadLocationException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    //All the above but for the backspace(8) in reverse
                    if (e.getKeyCode() == 8 && timesPressed > 1 && timesPressed <= Text.length + 1 && input.getText().charAt(input.getText().length() - 1) == ' ') {
                        timesPressed--;
                        StringJoiner joinerSpace = new StringJoiner(" ");
                        output.setText("");
                        if (newText.length - timesPressed - 1 >= 0) {
                            System.arraycopy(Text, timesPressed - 1, newText, 0, newText.length - timesPressed - 1);
                        }
                        
                        for (String value : newText) {
                            if (value != null) {
                                joinerSpace.add(value);
                            }
                        }
                        String textPress = joinerSpace.toString();
                        output.setText(textPress);
                        try {
                            gray.addHighlight(0, Text[timesPressed - 1].length(), painterGray);
                        }
                        catch (BadLocationException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                
                //Code to be executed when the key is released
                public void keyReleased(KeyEvent e) {
                    //change back the text color to white
                    input.setForeground(Color.white);
                    //Stop the audio on button release
                    if (player[1].getFramePosition() == player[1].getFrameLength() || player[2].getFramePosition() == player[2].getFrameLength() || player[4].getFramePosition() == player[4].getFrameLength()) {
                        player[1].stop();
                        player[2].stop();
                        //Bring the audio to the beginning for the next time
                        player[1].setFramePosition(0);
                        player[2].setFramePosition(0);
                    }
                    player[4].stop();
                    player[4].setFramePosition(0);
                }
                
                //Code to be executed when button is pressed and released
                public void keyTyped(KeyEvent e) {
                    player[4].start();
                }
                
            });
            
            start.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player[0].start();
                    started = true;
                    //Highlight the first word to be typed - the others will be Highlighted after the press of space
                    try {
                        gray.addHighlight(0, Text[0].length(), painterGray);
                    }
                    catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }
                    
                    difficulty.setEnabled(false);
                    start.setVisible(false);
                    input.setVisible(true);
                    input.setEditable(true);
                    thirtySec.setEnabled(false);
                    sixtySec.setEnabled(false);
                    //the input Text Area requests focus, so you can start typing immediately
                    input.requestFocus();
                    //start the timer
                    startTimer(input, labelEverything, Text, OK, reset, output, player, progressBar, difficulty, panelText);
                }
            });
            
            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Cancel the timer if it was started
                    if (timer != null && started) {
                        timer.cancel();
                    }
                    //Change back the timer to start again from 60 on command
                    DEFAULT_STOP_TIME = 60;
                    stopTime = DEFAULT_STOP_TIME;
                    //Set current frame visible upon the creation of the next one after re-calling main method
                    Main.frameX = frame.getX();
                    Main.frameY = frame.getY();
                    frame.dispose();
                    
                    //Recalling main method(simply a restart)
                    new TypingTest();
                }
            });
            OK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frameX = frame.getX();
                    Main.frameY = frame.getY();
                    frame.dispose();
                    new TypingTest();
                }
            });
            
            thirtySec.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Cancel the timer if it was started
                    if (timer != null && started) {
                        timer.cancel();
                    }
                    //Set the timer to start decrementing from 30
                    DEFAULT_STOP_TIME = 30;
                    stopTime = DEFAULT_STOP_TIME;
                    timerDenominator = 0.3;
                }
            });
            sixtySec.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Cancel the timer if it was started
                    if (timer != null && started) {
                        timer.cancel();
                    }
                    //Set the timer to start decrementing from 60
                    DEFAULT_STOP_TIME = 60;
                    stopTime = DEFAULT_STOP_TIME;
                    timerDenominator = 0.6;
                }
            });
            
            
            difficulty.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selected = String.valueOf(difficulty.getSelectedItem());
                    
                    switch (selected) {
                        case "Easy" -> {
                            String easy = textFormatter(Easy, Text);
                            output.setText(easy);
                        }
                        case "Med" -> {
                            String medium = textFormatter(Medium, Text);
                            output.setText(medium);
                        }
                        case "Hard" -> {
                            String hard = textFormatter(Hard, Text);
                            output.setText(hard);
                        }
                    }
                }
            });
        }
        
        //Giving the frame visibility
        frame.setVisible(true);
    }
    
    
    //Initializing the icon for the frame(You need a file called LOGO.ico in /src/ folder)
    public static ImageIcon icon = new ImageIcon("images/LOGO.ico");
    public static ImageIcon restart = new ImageIcon("images/restart.png");
    public static ImageIcon restartAnimated = new ImageIcon("images/restartAnimated.gif");
    
    //Methods
    static JFrame frame(ImageIcon icon) {
        //initializing and setting up the frame
        JFrame frame = new JFrame("Typing Test                                                                                                            OneAboveAll");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 330);
        frame.setLocation(Main.frameX, Main.frameY);
        frame.setResizable(false);
        //setting the icon up
        frame.setIconImage(icon.getImage());
        return frame;
    }
    
    static JPanel panelText(JFrame frame) {
        //Initializing and setting up the panel
        JPanel panelText = new JPanel();
        panelText.setSize(new Dimension(600, 330));
        panelText.setLocation(0, 0);
        /*
        Making the layout null
        So we can move the GUI components freely rather than pre-defined layouts
        */
        panelText.setLayout(null);
        frame.add(panelText);
        return panelText;
    }
    
    static String textFormatter(String[] TextSample, String[] Text) {
        //Emptying the array first
        Arrays.fill(Text, "");
        //Formatting the array into a string with a space " " between each index
        for (int m = 0; m < TextSample.length; m++) {
            Text[m] = TextSample[(int) (Math.random() * TextSample.length)];
        }
        StringJoiner joiner = new StringJoiner(" ");
        for (String value : Text) {
            joiner.add(value);
        }
        return joiner.toString();
    }
    
    static JTextArea output(JPanel panelText, String textFormatted) {
        //Initializing and setting up the Text Area that gives you the words to type
        JTextArea output = new JTextArea();
        output.setBounds(10, 5, 480, 75);
        output.setMargin(new Insets(4, 4, 2, 2));
        output.setFont(new Font("Serif", Font.PLAIN, 26));
        output.setAutoscrolls(true);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setBackground(new Color(1, 14, 26));
        output.setText(textFormatted);
        output.setEditable(false);
        output.setFocusable(false);
        output.setForeground(Color.white);
        panelText.add(output);
        return output;
    }
    
    static JTextArea input(JPanel panelText) {
        //Initializing the Text Area that you type in
        JTextArea input = new JTextArea();
        input.setBounds(11, 100, 565, 180);
        //setting up how far the text be from its boundaries(Margins)
        input.setMargin(new Insets(2, 4, 2, 2));
        input.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        input.setEditable(false);
        input.setVisible(false);
        input.setLineWrap(true);
        input.setWrapStyleWord(true);
        input.setForeground(Color.white);
        input.setFont(new Font("Serif", Font.PLAIN, 22));
        input.setEditable(false);
        panelText.add(input);
        return input;
    }
    
    static JLabel labelEverything(JPanel panelText) {
        /*
        Initializing and setting up the label that tells you:
        Your speed, accuracy, and the total of correct characters typed
        */
        JLabel labelEverything = new JLabel();
        labelEverything.setEnabled(false);
        labelEverything.setFocusable(false);
        labelEverything.setVisible(false);
        labelEverything.setForeground(Color.white);
        panelText.add(labelEverything);
        return labelEverything;
    }
    
    static Highlighter gray(JTextArea output) {
        //Highlighter that colors the background of the text that has to be typed - this is just initialization
        return output.getHighlighter();
    }
    
    static Highlighter.HighlightPainter painterGray() {
        /*
        Initializing the painter that uses the Highlighter called gray
        and choosing a color for it(dark blue)
        */
        return new DefaultHighlighter.DefaultHighlightPainter(new Color(0x7D57C1));
    }
    
    static JButton start(JPanel panelText) {
        ImageIcon starting = new ImageIcon("images/start.png");
        ImageIcon startingAnimated = new ImageIcon("images/startAnimated.gif");
        //Initializing the start button(it does what it says) - this is just initialization
        JButton start = new JButton(starting);
        start.setBounds(10, 100, 565, 180);
        start.setFont(new Font("Segoe UI", Font.BOLD, 36));
        start.setText("START!");
        start.setToolTipText("Or you can press Enter or Spacebar");
        start.setForeground(Color.white);
        start.setRolloverIcon(startingAnimated);
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startingAnimated.getImage().flush();
            }
        });
        //Grabbing focus right after launch, so it can be pressed with Enter or the Spacebar rather than just a mouse click
        start.grabFocus();
        panelText.add(start);
        return start;
    }
    
    static JButton reset(JPanel panelText, ImageIcon restart, ImageIcon restartAnimated) {
        //Initializing and setting up the reset button(it does what it says)
        JButton reset = new JButton(restart);
        reset.setBounds(495, 5, 40, 48);
        reset.setRolloverEnabled(true);
        reset.setRolloverIcon(restartAnimated);
        reset.setToolTipText("Restart timer and start \nwith a new set of words");
        reset.setForeground(Color.white);
        reset.setFocusable(false);
        panelText.add(reset);
        
        return reset;
    }
    
    static JButton OK(JPanel panelText) {
        //Initializing and setting up the button you press after you finish the test
        JButton OK = new JButton();
        OK.setBounds((panelText.getWidth() / 2) - 60, 250, 100, 30);
        OK.setFont(new Font("Segoe UI", Font.BOLD, 14));
        OK.setText("OK");
        OK.setForeground(Color.white);
        OK.setVisible(false);
        OK.setFocusable(true);
        panelText.add(OK);
        return OK;
    }
    
    static JRadioButton thirtySec(JPanel panelText) {
        //Initializing the RadioButton that changes the test time to 30s - this is just initialization
        JRadioButton thirtySec = new JRadioButton();
        thirtySec.setText("30");
        thirtySec.setBounds(535, 25, 78, 30);
        thirtySec.setEnabled(true);
        thirtySec.setFocusable(false);
        panelText.add(thirtySec);
        return thirtySec;
    }
    
    static JRadioButton sixtySec(JPanel panelText) {
        //Initializing the RadioButton that changes the test time to 60s - this is just initialization
        JRadioButton sixtySec = new JRadioButton();
        sixtySec.setText("60");
        sixtySec.setBounds(535, 0, 78, 30);
        sixtySec.setFocusable(false);
        sixtySec.setEnabled(true);
        panelText.add(sixtySec);
        return sixtySec;
    }
    
    static void group(JRadioButton thirtySec, JRadioButton sixtySec) {
        //Grouping the two RadioButtons sixtySec and thirtySec so only one can be on at a time
        ButtonGroup group = new ButtonGroup();
        group.add(sixtySec);
        group.add(thirtySec);
        //Setting the default selected RadioButton
        group.setSelected(sixtySec.getModel(), true);
    }
    
    static JProgressBar timeProgress(JPanel panelText) {
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(100);
        progressBar.setBounds(10, 85, 565, 10);
        progressBar.setForeground(new Color(0x7D57C1));
        progressBar.setBackground(new Color(0x084D80));
        progressBar.setEnabled(true);
        progressBar.setFocusable(false);
        panelText.add(progressBar);
        
        return progressBar;
    }
    
    static JComboBox<String> difficulty(JPanel panelText) {
        String[] difficultyNames = {"Easy", "Med", "Hard"};
        JComboBox<String> difficulty = new JComboBox<>(difficultyNames);
        difficulty.setBounds(495, 55, 78, 25);
        difficulty.setForeground(Color.white);
        difficulty.setFocusable(false);
        
        panelText.add(difficulty);
        return difficulty;
    }
    
    //Timer to be decremented each 1000 milliseconds(delay between timer iterations)
    static final int DECREMENT_TIME = 1000;
    //The time to decrement from(in Seconds) each 1000ms
    static int DEFAULT_STOP_TIME = 60;
    static int stopTime = DEFAULT_STOP_TIME;
    static Timer timer;
    static boolean started = false;
    //60s = 0.6, 30s = 0.3
    static double timerDenominator = 0.6;
    
    private static void startTimer(JTextArea input, JLabel labelEverything, String[] Text, JButton OK, JButton reset, JTextArea output, Clip[] player, JProgressBar progressBar, JComboBox<String> difficulty, JPanel panelText) {
        //Initializing the down-counter timer
        timer = new Timer();
        DecimalFormat formatter = new DecimalFormat();
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        formatter.setPositiveSuffix("%");
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //Below code will run after the timer starts
                progressBar.setValue((int) (stopTime / timerDenominator));
                //if the timer reaches Zero do this:
                if (stopTime <= 0) {
                    timer.cancel();
                    started = false;
                    player[3].start();
                    input.setVisible(false);
                    /*
                    Calculating the Words Per Minute by getting the number of typed words
                    and extracting the correct ones only then dividing it by the time spent in Minutes
                    */
                    int timeSpent = DEFAULT_STOP_TIME - stopTime;
                    String[] words = input.getText().split(" ");
                    //Calculating number of correct characters typed for accuracy
                    double correctLength = 0;
                    for (int i = 0; i < words.length; i++) {
                        /*
                        If you type the word correctly but add anything after
                        only the other character will be counted wrong not the whole word
                        example: welcomer, correct: welcome, wrong: r, number of wrong characters: 1
                        */
                        if (words[i].length() > Text[i].length()) {
                            correctLength -= words[i].length() - Text[i].length() - 1;
                        }
                        for (int j = 0; j < Text[i].length(); j++) {
                            //try this
                            try {
                                char yourChar = words[i].charAt(j);
                                char correctChar = Text[i].charAt(j);
                                if (yourChar == correctChar) {
                                    correctLength++;
                                }
                            }
                            /*
                            If word is uncompleted calculate number of characters left
                            and subtract it from number of correct characters
                            so, if you left a word uncompleted and time runs out
                            it will be considered wrong
                            */
                            catch (StringIndexOutOfBoundsException e) {
                                if (correctLength > words[i].length()) {
                                    correctLength -= Text[i].length() - words[i].length();
                                }
                                break;
                            }
                        }
                    }
                    double minute = timeSpent / 60.0;
                    //Calculating for WPM and WPM - Error
                    String wPM = "0";
                    if (words.length > 1) {
                        wPM = String.valueOf(Math.round(words.length / minute));//Words Per Minute
                    }
                    //Accuracy based on individual characters
                    String accuracy = formatter.format((correctLength / input.getText().replaceAll(" ", "").length() * 100));
                    //WPM - ERROR (raw wpm * accuracy)
                    String wPM_Error = String.valueOf(Math.round(Double.parseDouble(wPM) * (correctLength / input.getText().replaceAll(" ", "").length())));
                    /*
                    setting up the label that to show the results, such as speed and accuracy
                    Css is used to lessen the code complexity and time
                    other methods require three labels since JLabel doesn't support multiline
                    */
                    labelEverything.setVisible(true);
                    labelEverything.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    labelEverything.setText("<html>" + "<div text-align:center>" + "<h1{font-size:100px;}>" + "Your speed was: " + wPM_Error + " WPM" + "<br/>" +
                            
                            "<h2{font-size:50px;}>" + "ACCURACY: " + accuracy + " | " + " CORRECT CHARS: " + (int) correctLength + "/" + input.getText().replaceAll(" ", "").length() + "<br/>" +
                            
                            "<h3{font-size:25px;}>" + "RAW WPM: " + wPM + "<br/>" + "</div>" + "</html>");
                    labelEverything.setSize(labelEverything.getPreferredSize());
                    labelEverything.setLocation((panelText.getWidth() / 2) - (labelEverything.getWidth() / 2), 95);
                    //Making the OK button visible while hiding the reset and resizing the output Text Area
                    OK.setVisible(true);
                    OK.grabFocus();
                    output.setBounds(10, 5, 565, 75);
                    reset.setVisible(false);
                    input.setText("");
                    /*
                    Creating(if not already) and writing the results you get each time to a file on the desktop
                    It automatically finds the desktop(works only on Windows)
                    If you're on Mac or Linux you have to specify the path
                    */
                    File results = new File(System.getProperty("user.home") + "/Desktop" + "\\results.txt");
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    try {
                        FileWriter resultWriter = new FileWriter(results, true);
                        resultWriter.write(wPM_Error + "WPM-ACR : Accuracy: " + accuracy + " : " + DEFAULT_STOP_TIME + "S Test" + " : Username: " + Main.username + " : Difficulty: " + difficulty.getSelectedItem() + " : Date: " + dateFormat.format(LocalDateTime.now()) + "\n");
                        resultWriter.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    //Resetting the timer to start again on command
                    stopTime = DEFAULT_STOP_TIME;
                    return;
                }
                //Decrementing the stopTime for each second(1000 Millisecond)
                stopTime--;
            }
        }, 0, DECREMENT_TIME);
    }
}