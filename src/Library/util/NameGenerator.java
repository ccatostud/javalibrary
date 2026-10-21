package Library.util;

import java.util.Random;

public class NameGenerator {
    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }

    String[] firstNames = {
            "Anna", "Erik", "Maria", "Johan", "Emma", "Karl", "Sara", "Anders", "Elin", "Lars",
            "Sofia", "Magnus", "Johanna", "Peter", "Maja", "Daniel", "Linda", "Fredrik", "Ida", "Henrik",
            "Karin", "Martin", "Malin", "Niklas", "Ebba", "Robert", "Camilla", "Marcus", "Amanda", "Thomas",
            "Lisa", "Patrik", "Helena", "Andreas", "Nina", "Mikael", "Julia", "Simon", "Caroline", "Jonas",
            "Alice", "Oskar", "Matilda", "Viktor", "Louise", "Alexander", "Emelie", "David", "Isabelle", "Anton",
            "Olivia", "William", "Ella", "Lucas", "Clara", "Hugo", "Felicia", "Elias", "Wilma", "Axel",
            "Nora", "Noah", "Alva", "Leo", "Agnes", "Arvid", "Stella", "Isak", "Saga", "Vincent",
            "Linn", "Theo", "Tove", "Filip", "Astrid", "Benjamin", "Selma", "Jonathan", "Moa", "Sebastian",
            "Elsa", "Samuel", "Nova", "Gabriel", "Freja", "Adam", "Lea", "Oliver", "Molly", "Jacob",
            "Tuva", "Kevin", "Vera", "Albin", "Signe", "Emil", "Ronja", "Max", "Liv", "Joel"
    };
    String[] lastNames = {
            "Andersson", "Johansson", "Karlsson", "Nilsson", "Eriksson", "Larsson", "Olsson", "Persson", "Svensson", "Gustafsson",
            "Pettersson", "Jonsson", "Jansson", "Hansson", "Bengtsson", "Jönsson", "Lindberg", "Jakobsson", "Magnusson", "Olofsson",
            "Lindström", "Lindqvist", "Lindgren", "Axelsson", "Berg", "Bergström", "Lundberg", "Lundgren", "Lundqvist", "Mattsson",
            "Björk", "Sandberg", "Holm", "Norberg", "Nyström", "Ekström", "Sjöberg", "Forsberg", "Wallin", "Engström",
            "Hedlund", "Eklund", "Dahlberg", "Sundberg", "Hellström", "Blom", "Ström", "Åberg", "Haglund", "Wikström",
            "Borg", "Bäckström", "Danielsson", "Edlund", "Fransson", "Hallberg", "Isaksson", "Kjellberg", "Lagerström", "Månsson",
            "Nordström", "Palm", "Rosén", "Samuelsson", "Törnqvist", "Westberg", "Åkesson", "Öberg", "Ahlström", "Bolin",
            "Carlberg", "Dahl", "Edberg", "Falk", "Granberg", "Hammar", "Ingvarsson", "Krantz", "Lindahl", "Malmberg",
            "Nordin", "Ottosson", "Rask", "Sjöström", "Tengberg", "Ullman", "Vallin", "Westerlund", "Åström", "Öhman",
            "Berglund", "Ekberg", "Forslund", "Holmberg", "Lindholm", "Nordlund", "Rydberg", "Sundqvist", "Wallberg", "Östlund"
    };
    String[] authors = {
            "Astrid Lindgren", "August Strindberg", "Selma Lagerlöf", "Henning Mankell", "Stieg Larsson",
            "Camilla Läckberg", "Fredrik Backman", "Jonas Gardell", "Karin Boye", "Hjalmar Söderberg",
            "George Orwell", "Jane Austen", "Charles Dickens", "Mark Twain", "Ernest Hemingway",
            "F. Scott Fitzgerald", "Virginia Woolf", "Leo Tolstoy", "Fyodor Dostoevsky", "Franz Kafka",
            "J.R.R. Tolkien", "C.S. Lewis", "J.K. Rowling", "Stephen King", "Agatha Christie",
            "Arthur Conan Doyle", "Isaac Asimov", "Philip K. Dick", "Ray Bradbury", "George R.R. Martin",
            "Douglas Adams", "Terry Pratchett", "Neil Gaiman", "Ursula K. Le Guin", "Frank Herbert",
            "Margaret Atwood", "Aldous Huxley", "Mary Shelley", "Bram Stoker", "Oscar Wilde",
            "Victor Hugo", "Alexandre Dumas", "Jules Verne", "H.G. Wells", "Herman Melville",
            "Jack London", "John Steinbeck", "Harper Lee", "Truman Capote", "Kurt Vonnegut",
            "Joseph Heller", "Anthony Burgess", "Cormac McCarthy", "Kazuo Ishiguro", "Salman Rushdie",
            "Gabriel García Márquez", "Mario Vargas Llosa", "Jorge Luis Borges", "Paulo Coelho", "Umberto Eco",
            "Haruki Murakami", "Yukio Mishima", "Kenzaburō Ōe", "Banana Yoshimoto", "Yasunari Kawabata",
            "Chimamanda Ngozi Adichie", "Toni Morrison", "Maya Angelou", "James Baldwin", "Richard Wright",
            "Donna Tartt", "Ian McEwan", "Julian Barnes", "Martin Amis", "Zadie Smith",
            "John le Carré", "Ken Follett", "Michael Crichton", "Dan Brown", "John Grisham",
            "Lee Child", "Tom Clancy", "Patricia Highsmith", "Gillian Flynn", "Paula Hawkins",
            "Jo Nesbø", "Karin Fossum", "Arnaldur Indriðason", "Jussi Adler-Olsen", "Åsa Larsson",
            "Maj Sjöwall", "Per Wahlöö", "Liza Marklund", "Jan Guillou", "Arne Dahl",
            "Tove Jansson", "Pär Lagerkvist", "Vilhelm Moberg", "Kerstin Ekman", "Per Anders Fogelström"
    };
    String[] bookTitles = {
            "The Silent Forest", "Beyond the Horizon", "Echoes of Winter", "The Last Harbour", "A Thousand Roads",
            "Shadows at Dawn", "The Glass Kingdom", "Before the Storm", "The Forgotten City", "River of Stars",
            "The Long Night", "House of Ashes", "The Northern Lights", "The Broken Compass", "Whispers in Stone",
            "The Final Letter", "A Distant Shore", "The Hidden Garden", "The Paper Crown", "The Black River",
            "The Empty Room", "Under Crimson Skies", "The Seventh Door", "A Map of Silence", "The Winter Road",
            "The Last Passenger", "The Iron Orchard", "The Blue Lantern", "The Secret Bridge", "The Golden Hour",
            "Beneath the Ice", "The Lost Season", "The Red Tower", "A World Between Us", "The Silent Lake",
            "The Midnight Train", "The Forgotten Road", "The Ivory Gate", "Across the Valley", "The Falling Sky",
            "The Last Summer", "A City of Rain", "The Green House", "The Shadow Line", "The Burning Shore",
            "The Silver Tree", "The Long Way Home", "The Empty Throne", "A Field of Stars", "The Hidden Path",
            "The Darkened Sea", "The Broken Clock", "The White Mountain", "A Song for Winter", "The Final Voyage",
            "The Old Observatory", "The Quiet War", "The Stone Garden", "The Red House", "The Sleeping City",
            "The Lost Journal", "The Northern Road", "The Secret Island", "A Crown of Dust", "The Empty Station",
            "The Glass River", "The Last Lighthouse", "The Silent Guest", "The Forgotten Name", "The Blue Forest",
            "The Winter Palace", "The Crimson Road", "The Distant Bell", "The Iron Gate", "The Shadow Garden",
            "The Final Crossing", "The Golden Valley", "The Hidden Room", "The Broken Tower", "The Silver Road",
            "The Long Autumn", "The Silent Mountain", "The Black Orchard", "A House by the Sea", "The Forgotten Train",
            "The White River", "The Last Garden", "The Secret Window", "The Falling Leaves", "The Dark Harbour",
            "The Red Lantern", "The Winter Garden", "The Blue Door", "The Empty Valley", "The Golden River",
            "The Silent Road", "The Lost Horizon", "The Last Chronicle", "The Hidden Shore", "The Northern Star"
    };

    public String generateRandomClassification() {
        String[] classifications = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        return classifications[(int) (Math.random() * classifications.length)];
    }

    public String[] generateRandomPersonName() {
        String firstName = firstNames[(int) (Math.random() * firstNames.length)];
        String lastName = lastNames[(int) (Math.random() * lastNames.length)];
        return new String[]{firstName,lastName};
    }

    public String generateRandomBookTitle() {
        return bookTitles[(int) (Math.random() * bookTitles.length)];
    }

    public String generateRandomAuthor() {
        return authors[(int) (Math.random() * authors.length)];
    }
}
