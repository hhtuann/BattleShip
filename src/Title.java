public class Title {
    private static final String ANSI_CYAN = "\033[36m";
    private static final String ANSI_RESET = "\033[0m";

    public static void gameWelcome() {
        ClearTerminal.clear(2000);
        System.out.println(ANSI_CYAN + ">>============================================================================<<");
        System.out.println("||     ____     _   _____  _____  _      _____   ____   _   _  ___  ____      ||");
        System.out.println("||    | __ )   / \\ |_   _||_   _|| |    | ____| / ___| | | | ||_ _||  _ \\     ||");
        System.out.println("||    |  _ \\  / _ \\  | |    | |  | |    |  _|   \\___ \\ | |_| | | | | |_) |    ||");
        System.out.println("||    | |_) |/ ___ \\ | |    | |  | |___ | |___   ___) ||  _  | | | |  __/     ||");
        System.out.println("||    |____//_/   \\_\\|_|    |_|  |_____||_____| |____/ |_| |_||___||_|        ||");
        System.out.println("||                                                                            ||");
        System.out.println(">>============================================================================<<" + ANSI_RESET);
        System.out.println();
    }

    public static void gameSetup(int player) {
        ClearTerminal.clear(2000);
        if (player == 1) {
            System.out.println(ANSI_CYAN + ">>=============================================================<<");
            System.out.println("||     ____     _        ____   _____  _____  _   _  ____      ||");
            System.out.println("||    |  _ \\   / |      / ___| | ____||_   _|| | | ||  _ \\     ||");
            System.out.println("||    | |_) | /  |      \\___ \\ |  _|    | |  | | | || |_) |    ||");
            System.out.println("||    |  __/  _| |_      ___) || |___   | |  | |_| ||  __/     ||");
            System.out.println("||    |_|    |_____|    |____/ |_____|  |_|   \\___/ |_|        ||");
            System.out.println("||                                                             ||");
            System.out.println(">>=============================================================<<" + ANSI_RESET);
            System.out.println();
        } else if (player == 2) {
            System.out.println(ANSI_CYAN + ">>=============================================================<<");
            System.out.println("||     ____   ____       ____   _____  _____  _   _  ____      ||");
            System.out.println("||    |  _ \\ |___ \\     / ___| | ____||_   _|| | | ||  _ \\     ||");
            System.out.println("||    | |_) |  __) |    \\___ \\ |  _|    | |  | | | || |_) |    ||");
            System.out.println("||    |  __/  / __/      ___) || |___   | |  | |_| ||  __/     ||");
            System.out.println("||    |_|    |_____|    |____/ |_____|  |_|   \\___/ |_|        ||");
            System.out.println("||                                                             ||");
            System.out.println(">>=============================================================<<" + ANSI_RESET);
            System.out.println();
        }
    }

    public static void gameTurn(int player) {
        ClearTerminal.clear(2000);
        if (player == 1) {
            System.out.println(ANSI_CYAN + ">>=============================================================<<");
            System.out.println("||         ____     _       _____  _   _  ____   _   _         ||");
            System.out.println("||        |  _ \\   / |     |_   _|| | | ||  _ \\ | \\ | |        ||");
            System.out.println("||        | |_) | /  |       | |  | | | || |_) ||  \\| |        ||");
            System.out.println("||        |  __/  _| |_      | |  | |_| ||  _ < | |\\  |        ||");
            System.out.println("||        |_|    |_____|     |_|   \\___/ |_| \\_\\|_| \\_|        ||");
            System.out.println("||                                                             ||");
            System.out.println(">>=============================================================<<" + ANSI_RESET);
            System.out.println();
        } else if (player == 2) {
            System.out.println(ANSI_CYAN + ">>=============================================================<<");
            System.out.println("||         ____   ____      _____  _   _  ____   _   _         ||");
            System.out.println("||        |  _ \\ |___ \\    |_   _|| | | ||  _ \\ | \\ | |        ||");
            System.out.println("||        | |_) |  __) |     | |  | | | || |_) ||  \\| |        ||");
            System.out.println("||        |  __/  / __/      | |  | |_| ||  _ < | |\\  |        ||");
            System.out.println("||        |_|    |_____|     |_|   \\___/ |_| \\_\\|_| \\_|        ||");
            System.out.println("||                                                             ||");
            System.out.println(">>=============================================================<<" + ANSI_RESET);
            System.out.println();
        }
    }

    public static void gameOver() {
        ClearTerminal.clear(2000);
        System.out.println(ANSI_CYAN + ">>======================================================================<<");
        System.out.println("||     ____     _     __  __  _____       ___ __     __ _____  ____     ||");
        System.out.println("||    / ___|   / \\   |  \\/  || ____|     / _ \\\\ \\   / /| ____||  _ \\    ||");
        System.out.println("||   | |  _   / _ \\  | |\\/| ||  _|      | | | |\\ \\ / / |  _|  | |_) |   ||");
        System.out.println("||   | |_| | / ___ \\ | |  | || |___     | |_| | \\ V /  | |___ |  _ <    ||");
        System.out.println("||    \\____|/_/   \\_\\|_|  |_||_____|     \\___/   \\_/   |_____||_| \\_\\   ||");
        System.out.println("||                                                                      ||");
        System.out.println(">>======================================================================<<" + ANSI_RESET);
        System.out.println();
    }

    public static void gameChangeTurn() {
        ClearTerminal.clear(2000);
        System.out.println(ANSI_CYAN + ">>=============================================================================<<");
        System.out.println("||    ____  _   _     _     _   _   ____  _____   _____  _   _  ____   _   _   ||");
        System.out.println("||   / ___|| | | |   / \\   | \\ | | / ___|| ____| |_   _|| | | ||  _ \\ | \\ | |  ||");
        System.out.println("||  | |    | |_| |  / _ \\  |  \\| || |  _ |  _|     | |  | | | || |_) ||  \\| |  ||");
        System.out.println("||  | |___ |  _  | / ___ \\ | |\\  || |_| || |___    | |  | |_| ||  _ < | |\\  |  ||");
        System.out.println("||   \\____||_| |_|/_/   \\_\\|_| \\_| \\____||_____|   |_|   \\___/ |_| \\_\\|_| \\_|  ||");
        System.out.println("||                                                                             ||");
        System.out.println(">>=============================================================================<<" + ANSI_RESET);
        System.out.println();
    }

    public static void gameWiner(int player) {
        ClearTerminal.clear(2000);
        if (player == 1) {
            System.out.println(ANSI_CYAN + ">>====================================================<<");
            System.out.println("||      ____     _       __        __ ___  _   _      ||");
            System.out.println("||     |  _ \\   / |      \\ \\      / /|_ _|| \\ | |     ||");
            System.out.println("||     | |_) | /  |       \\ \\ /\\ / /  | | |  \\| |     ||");
            System.out.println("||     |  __/  _| |_       \\ V  V /   | | | |\\  |     ||");
            System.out.println("||     |_|    |_____|       \\_/\\_/   |___||_| \\_|     ||");
            System.out.println("||                                                    ||");
            System.out.println(">>====================================================<<" + ANSI_RESET);
            System.out.println();
        } else if (player == 2) {
            System.out.println(ANSI_CYAN + ">>====================================================<<");
            System.out.println("||      ____   ____      __        __ ___  _   _      ||");
            System.out.println("||     |  _ \\ |___ \\     \\ \\      / /|_ _|| \\ | |     ||");
            System.out.println("||     | |_) |  __) |     \\ \\ /\\ / /  | | |  \\| |     ||");
            System.out.println("||     |  __/  / __/       \\ V  V /   | | | |\\  |     ||");
            System.out.println("||     |_|    |_____|       \\_/\\_/   |___||_| \\_|     ||");
            System.out.println("||                                                    ||");
            System.out.println(">>====================================================<<" + ANSI_RESET);
            System.out.println();
        }
    }
}
