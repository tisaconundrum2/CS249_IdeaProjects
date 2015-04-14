package com.company;

public class Nick_sApp {

    public static void main(String[] args) {
	    // write your code here
        Daemons daemons = new Daemons();

        daemons.insertDaemon("Poisoned Sake", 3843, 3843, 29);
        daemons.insertDaemon("Barbetta", 1323, 1143, 9);
        daemons.insertDaemon("Arch-Demon", 2150, 1740, 20);
        daemons.insertDaemon("Pearce", 1774, 1484, 16);
        daemons.insertDaemon("Rat Clan Boss", 2038, 1582, 13);
        daemons.insertDaemon("Rat Clan Henchman", 879, 780, 7);
        daemons.insertDaemon("Qing Long", 1550, 1792, 12);
        daemons.insertDaemon("White Angel", 1865, 2442, 10);
        daemons.insertDaemon("Lulu", 2664, 2664, 22);
        daemons.insertDaemon("Lilith", 1313, 1216, 12);
        daemons.insertDaemon("Kaede", 554, 444, 3);
        daemons.insertDaemon("Kotestu", 1214, 926, 6);
        daemons.insertDaemon("Blue Angel",721, 791,8);
        daemons.insertDaemon("Pipe Fox", 1169, 1296, 6);
        daemons.insertDaemon("Wind Weasel",831,662,6);
        daemons.insertDaemon("Tengu", 1756, 1620, 14);
        daemons.insertDaemon("Aboro", 600, 646, 5);
        daemons.insertDaemon("Pillow Phantom", 684, 741, 5);
        daemons.insertDaemon("Dartz", 1108,885,8);
        daemons.insertDaemon("Ferris", 997, 1356, 9);
        daemons.insertDaemon("Harpy", 928, 928, 9);
        daemons.insertDaemon("Furinkazan Motto", 3843, 3843, 29);
        daemons.insertDaemon("Susumu", 1320, 946, 9);
        daemons.insertDaemon("Snowball", 2562, 1720, 16);

        daemons.getOptimizedAtk(60);
        daemons.getOptimizedDef(60);

    }
}
