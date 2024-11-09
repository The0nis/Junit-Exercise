package pt.up.fe.service;

import static pt.up.fe.model.Race.DWARF;
import static pt.up.fe.model.Race.ELF;
import static pt.up.fe.model.Race.HOBBIT;
import static pt.up.fe.model.Race.MAIA;
import static pt.up.fe.model.Race.MAN;
import static pt.up.fe.model.Race.ORC;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.up.fe.model.Movie;
import pt.up.fe.model.Ring;
import pt.up.fe.model.TolkienCharacter;

public class DataService {

  private static final String ERROR_MESSAGE_EXAMPLE_FOR_ASSERTION = "{} assertion : {}\n";

  /**
   * Some of the Lord of the Rings characters
   */
  private final TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);

  private final TolkienCharacter sam = new TolkienCharacter("Sam", 38, HOBBIT);

  private final TolkienCharacter merry = new TolkienCharacter("Merry", 36, HOBBIT);

  private final TolkienCharacter pippin = new TolkienCharacter("Pippin", 28, HOBBIT);

  private final TolkienCharacter gandalf = new TolkienCharacter("Gandalf", 2020, MAIA);

  private final TolkienCharacter gimli = new TolkienCharacter("Gimli", 139, DWARF);

  private final TolkienCharacter legolas = new TolkienCharacter("Legolas", 1000, ELF);

  private final TolkienCharacter aragorn = new TolkienCharacter("Aragorn", 87, MAN);

  private final TolkienCharacter boromir = new TolkienCharacter("Boromir", 37, MAN);

  private final TolkienCharacter sauron = new TolkienCharacter("Sauron", 50000, MAIA);

  private final TolkienCharacter galadriel = new TolkienCharacter("Galadriel", 3000, ELF);

  private final TolkienCharacter elrond = new TolkienCharacter("Elrond", 3000, ELF);

  private final TolkienCharacter guruk = new TolkienCharacter("Guruk", 20, ORC);

  private final Movie theFellowshipOfTheRing = new Movie("the fellowship of the Ring", new Date(), "178 min");

  private final Movie theTwoTowers = new Movie("the two Towers", new Date(), "179 min");

  private final Movie theReturnOfTheKing = new Movie("the Return of the King", new Date(), "201 min");

  public List<TolkienCharacter> getFellowship() {
    final List<TolkienCharacter> fellowshipOfTheRing = new ArrayList<TolkienCharacter>();
    fellowshipOfTheRing.add(this.frodo);
    fellowshipOfTheRing.add(this.sam);
    fellowshipOfTheRing.add(this.merry);
    fellowshipOfTheRing.add(this.pippin);
    fellowshipOfTheRing.add(this.gandalf);
    fellowshipOfTheRing.add(this.legolas);
    fellowshipOfTheRing.add(this.gimli);
    fellowshipOfTheRing.add(this.aragorn);
    fellowshipOfTheRing.add(this.boromir);
    return fellowshipOfTheRing;
  }

  public List<TolkienCharacter> getOrcsWithHobbitPrisoners() {
    final List<TolkienCharacter> orcsWithHobbitPrisoners = new ArrayList<TolkienCharacter>();
    orcsWithHobbitPrisoners.add(this.guruk);
    orcsWithHobbitPrisoners.add(this.merry);
    orcsWithHobbitPrisoners.add(this.pippin);
    return orcsWithHobbitPrisoners;
  }

  public TolkienCharacter getFellowshipCharacter(String name) {
    List<TolkienCharacter> list = this.getFellowship();
    return list.stream().filter(s -> s.getName().equals(name)).findFirst().orElseGet(() -> null);
  }

  public Map<Ring, TolkienCharacter> getRingBearers() {
    Map<Ring, TolkienCharacter> ringBearers = new HashMap<Ring, TolkienCharacter>();
    ringBearers.put(Ring.nenya, this.galadriel);
    ringBearers.put(Ring.narya, this.gandalf);
    ringBearers.put(Ring.vilya, this.elrond);
    ringBearers.put(Ring.oneRing, this.frodo);
    return ringBearers;
  }

  // Long running dummy method
  public boolean update() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return true;
  }
}
