import java.util.*;
import java.io.*;

/*
 * @title Solution for Frisco FirstBytes 2017 - Problem F
 * @author Team 'LEFT OUR BRAINS AT HOME' from Plano West Senior High
 */

public class F {
    static String[] gpa = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-"};
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("F.txt"));
        int times = in.nextInt();
        in.nextLine();
        ArrayList<String> gpaList = new ArrayList<>();
        for (String s: gpa)
            gpaList.add(s);
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 1 ; i <= times ; i++) {
            String info = in.nextLine();
            long id = Long.parseLong(info.substring(info.length() - 10, info.length()));
            int gpaIndex = gpaList.indexOf(info.substring(info.length() - 13, info.length() - 10).trim());
            String name = info.substring(0, info.length() - 13).trim();
            people.add(new Person(name, id, gpaIndex));
        }
        Collections.sort(people);
        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}

class Person implements Comparable<Person> {
    String name;
    long id;
    int gpaIndex;

    public Person(String name, long id, int gpaIndex) {
        this.name = name;
        this.id = id;
        this.gpaIndex = gpaIndex;
    }

    public int compareTo(Person other) {
        long diff = name.compareTo(other.name);
        if (diff == 0) {
            diff = gpaIndex - other.gpaIndex;
            if (diff == 0) {
                diff = id - other.id;
            }
        }
        if (diff > 0)
            return 1;
        if (diff == 0)
            return 0;
        return -1;
    }

    public String toString() {
        return String.format("%-40s", name) + " " + String.format("%-2s", F.gpa[gpaIndex]) + " " + id;
    }
}