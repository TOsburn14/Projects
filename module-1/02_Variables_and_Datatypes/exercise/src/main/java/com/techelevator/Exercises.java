package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int racconsInTheWoods = 3;
		int racconsWentHome = 2;
		int raccoonsThatAreLeft = racconsInTheWoods - racconsWentHome;

        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int differenceBetweenFlowersAndBees = numberOfFlowers - numberOfBees;

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int lonelyPigeon = 1;
		int friendlyPigeon = 1;
		int bestFriendPigeon = lonelyPigeon + friendlyPigeon;

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int owlsSittingOnTheFence = 3;
		int owlsThatJoinedOnTheFence = 2;
		int totalOwlsChillingOnTheFence = owlsSittingOnTheFence + owlsThatJoinedOnTheFence;


        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beaversWorkingOnTheirDam = 2;
		int beaversThatWentForASwim = 1;
		int beaversStillHardAtWork = beaversWorkingOnTheirDam - beaversThatWentForASwim;

        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansSittingOnATree = 2;
		int toucansWhoWantToSitOnATree = 1;
		int toucansWhoAreNowBestFriendsSittingOnATree = toucansSittingOnATree + toucansWhoWantToSitOnATree;

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrelsInATree = 4;
		int howManyNutsAreOnTheTree = 2;
		int differenceBetweenSquirrelsAndNuts = squirrelsInATree - howManyNutsAreOnTheTree;

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double valueOfQuarter = .25;
		double valueOfDime = .10;
		double valueOfTwoNickels = .10;
		double mrsHiltNetWorth = valueOfDime + valueOfQuarter + valueOfTwoNickels;

        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int brierMuffins = 18;
		int macAdamsMuffins = 20;
		int flanneryMuffins = 17;
		int totalFirstGradeMuffins = brierMuffins + macAdamsMuffins + flanneryMuffins;

        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double costOfYoyo = .24;
		double costOfWhistle = .14;
		double totalMoneyWasted = costOfWhistle + costOfYoyo;

        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int totalLargeMarshmallows = 8;
		int totalMiniMarshmallows = 10;
		int totalMarshmallows = totalLargeMarshmallows + totalMiniMarshmallows;

        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int hiltSnowAmount = 29;
		int schoolSnowAmount = 17;
		int differenceInSnowAmount = hiltSnowAmount - schoolSnowAmount;

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */
		double hiltNetWorth = 10;
		double costOfToyTruck = 3;
		double costOfPencilCase = 2.50;
		double hiltNewNetWorth = hiltNetWorth - costOfToyTruck - costOfPencilCase;

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int joshMarbleAmount = 16;
		int marblesLost = 7;
		int marblesInCollection = joshMarbleAmount - marblesLost;

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int currentSeaShells = 19;
		int seaShellsNeeded = 25;
		int differenceOfSeaShellAmounts = seaShellsNeeded - currentSeaShells;


        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloonAmounts = 17;
		int totalRedBalloons = 8;
		int totalGreenBalloons = totalBalloonAmounts - totalRedBalloons;


        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int booksOnShelf = 38;
		int booksBeingPlacedOnShelves = 10;
		int newAmountOfBooksOnShelf = booksOnShelf + booksBeingPlacedOnShelves;

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int totalLegsOnBee = 6;
		int totalBeesInTheHive = 8;
		int totalLegsInTheHive = totalLegsOnBee * totalBeesInTheHive;

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double costOfIceCreamCone = .99;
		double totalIceCreamsConesBought = 2;
		double moneySpentOnIceCreamCones = costOfIceCreamCone * totalIceCreamsConesBought;

        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int totalRocksNeeded = 125;
		int totalRocksAvailable = 64;
		int differenceInRocks = totalRocksNeeded - totalRocksAvailable;

        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int hiltMarbleAmount = 38;
		int marblesMisplaced = 15;
		int newMarbleAmount = hiltMarbleAmount - marblesMisplaced;

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int hiltConcertDistanceInMiles = 78;
		int milesTraveledTillPitStop = 32;
		int distanceLeftInMilesAfterStop = hiltConcertDistanceInMiles - milesTraveledTillPitStop;

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int minutesSpentShovelingSnowInMorning = 90;
		int minutesSpentShovelingSnowInEvening = 45;
		int totalMinutesSpentShovelingSnow = minutesSpentShovelingSnowInMorning + minutesSpentShovelingSnowInEvening;

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		double hotDogsBought = 6;
		double costOfHotDog = .50;
		double totalSpentOnHotDogs = hotDogsBought * costOfHotDog;

        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int costOfPencilInCents = 7;
		int hiltPocketMoneyInCents = 50;
		int totalPencilsCost = hiltPocketMoneyInCents / costOfPencilInCents;


        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterfliesSeen = 33;
		int totalOrangeButterflies = 20;
		int totalRedButterflies = totalButterfliesSeen - totalOrangeButterflies;

        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double moneyGaveToClerk = 1.00;
		double costOfCandyBar = .54;
		double amountOfChangeReceived = moneyGaveToClerk - costOfCandyBar;

        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int currentTreesInBackYard = 13;
		int treesToBePlanted = 12;
		int treesGoingToBeInBackYard = currentTreesInBackYard + treesToBePlanted;

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int hoursInADay = 24;
		int daysUntilGrandmaShowsUp = 2;
		int hoursUntilGrandmaShowsUp = hoursInADay * daysUntilGrandmaShowsUp;

        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int amountOfCousins = 4;
		int amountOfGumGivenToEachCousin = 5;
		int amountOfGumNeeded = amountOfCousins * amountOfGumGivenToEachCousin;

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double moneyDanHasInDollars = 3.0;
		double costOfCandyInDollars = 1.0;
		double danNewMoneyAmount = moneyDanHasInDollars - costOfCandyInDollars;

        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsOnLake = 5;
		int amountOfPeoplePerBoat = 3;
		int totalAmountOfPeopleOnBoats = boatsOnLake * amountOfPeoplePerBoat;

        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellenLegoCount = 380;
		int legosLost = 57;
		int newLegoCount = ellenLegoCount - legosLost;

        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int totalMuffinsNeeded = 83;
		int muffinsBaked = 35;
		int muffinsNeededToBeBaked = totalMuffinsNeeded - muffinsBaked;

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayonAmount = 1400;
		int lucyCrayonAmount = 290;
		int differenceInCrayonAmount = willyCrayonAmount - lucyCrayonAmount;

        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage = 10;
		int totalPagesOfStickers = 22;
		int totalAmountOfStickers = stickersPerPage * totalPagesOfStickers;

        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double totalCupcakesAvailable = 100.0;
		double totalChildren = 8.0;
		double cupcakesPerChild = totalCupcakesAvailable / totalChildren;

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */
		int gingerbreadCookiesMade = 47;
		int cookiesHeldPerJar = 6;
		int cookiesNotPlacedInJar = gingerbreadCookiesMade % cookiesHeldPerJar;

        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int croissantsMade = 59;
		int neighborsGivenCroissants = 8;
		int croissantsLeftForMarian = croissantsMade % neighborsGivenCroissants;

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int totalOatmealCookies = 276;
		int amountOfCookiesPerTray = 12;
		int traysNeededInTotal = totalOatmealCookies / amountOfCookiesPerTray;

        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalPretzelsMade = 480;
		int pretzelsPerServing = 12;
		int amountOfServingsMade = totalPretzelsMade / pretzelsPerServing;

        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int cupcakesTaken = 51;
		int cupcakesPerBox = 3;
		int boxesGivenAway = cupcakesTaken / cupcakesPerBox;

        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrotsMadeForBreakfast = 74;
		int peopleEatingBreakfast = 12;
		int amountOfCarrotsLeftOver = carrotsMadeForBreakfast % peopleEatingBreakfast;

        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int totalTeddyBears = 98;
		int amountOfTeddyBearsShelvesCanFit = 7;
		int totalShelvesFilled = totalTeddyBears / amountOfTeddyBearsShelvesCanFit;

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int totalAmountOfPictures = 480;
		int maximumAmountOfPicturesAlbumHolds = 20;
		int albumsNeeded = totalAmountOfPictures / maximumAmountOfPicturesAlbumHolds;

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int totalAmountOfTradingCards = 94;
		int maximumBoxCanHold = 8;
		int totalBoxesFilled = totalAmountOfTradingCards / maximumBoxCanHold;
		int cardsLeftInLastBox = totalAmountOfTradingCards % maximumBoxCanHold;

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalAmountOfBooks = 210;
		int totalShelvesAvailable = 10;
		int amountOfBooksPlacedPerShelf = totalAmountOfBooks / totalShelvesAvailable;

        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double croissantsBaked = 17;
		double guestsPresent = 7;
		double amountOfCroissantsServedPerGuest = croissantsBaked / guestsPresent;

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
		double billRoomNumber = 5;
		double billRoomPaintTime = 2.15;
		double billRoomRate = billRoomNumber / billRoomPaintTime;
		double jillRoomNumber = 5;
		double jillRoomPaintTime = 1.90;
		double jillRoomRate = jillRoomNumber / jillRoomPaintTime;
		double combinedRoomRate = jillRoomRate + billRoomRate;
		double totalRoomsToPaint = 5;
		double totalRateToPaintRoom = totalRoomsToPaint / combinedRoomRate;
		double totalTimeNeededToPaintRoom = totalRoomsToPaint * totalRateToPaintRoom;

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */


	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		int distanceBetweenCities = 800;
		int currentAmountTraveled = 537;
		int percentageTraveled = distanceBetweenCities / currentAmountTraveled;
	}

}
