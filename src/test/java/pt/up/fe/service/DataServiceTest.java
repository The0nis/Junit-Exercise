package pt.up.fe.service;

import static pt.up.fe.model.Race.HOBBIT;
import static pt.up.fe.model.Race.MAIA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import pt.up.fe.model.Movie;
import pt.up.fe.model.Race;
import pt.up.fe.model.Ring;
import pt.up.fe.model.TolkienCharacter;
import pt.up.fe.service.DataService;

class DataServiceTest {

  private DataService dataService;

  @BeforeEach
  public void setup() {
    this.dataService = new DataService();
  }

  @Test
  public void ensureThatInitializationOfTolkeinCharactorsWorks() {
    TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
    assertEquals(33, frodo.getAge(), "Frodo should be 33");
    assertEquals("Frodo", frodo.getName(), "Frodos character has wrong name");
    assertNotEquals("Frodon", frodo.getName(), "Frodos character has wrong name");
  }

  @Test
  public void ensureFellowShipCharacterAccessByNameReturnsNullForUnknownCharacter() {
    TolkienCharacter fellowshipCharacter = this.dataService.getFellowshipCharacter("Lars");
    assertNull(fellowshipCharacter);
  }

  @Test
  public void ensureFellowShipCharacterAccessByNameWorksGivenCorrectNameIsGiven() {
    TolkienCharacter fellowshipCharacter = this.dataService.getFellowshipCharacter("Frodo");
    assertNotNull(fellowshipCharacter);
  }

  @Test
  public void ensureThatEqualsWorksForCharaters() {
    Object jake = new TolkienCharacter("Jake", 43, HOBBIT);
    Object sameJake = jake;
    Object jakeClone = new TolkienCharacter("Jake", 12, HOBBIT);
    assertEquals(jake, sameJake);
    assertNotEquals(jake, jakeClone);
  }

  @Test
  public void checkInheritance() {
    TolkienCharacter tolkienCharacter = this.dataService.getFellowship().get(0);
    assertFalse(Movie.class.isAssignableFrom(tolkienCharacter.getClass()));
    assertTrue(TolkienCharacter.class.isAssignableFrom(tolkienCharacter.getClass()));
  }

  @Test
  public void ensureThatFrodoAndGandalfArePartOfTheFellowsip() {
    List<TolkienCharacter> fellowship = this.dataService.getFellowship();
    TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
    TolkienCharacter gandalf = new TolkienCharacter("Gandalf", 2020, MAIA);
    assertTrue(fellowship.contains(frodo));
    assertTrue(fellowship.contains(gandalf));
  }

  @Test
  public void ensureThatOneRingBearerIsPartOfTheFellowship() {
    List<TolkienCharacter> fellowship = this.dataService.getFellowship();
    Map<Ring, TolkienCharacter> ringBearers = this.dataService.getRingBearers();
    assertTrue(ringBearers.values().stream().anyMatch(ringBearer -> fellowship.contains(ringBearer)));
  }

  @RepeatedTest(1000)
  @Tag("slow")
  @DisplayName("Ensure that we can call getFellowShip multiple times")
  public void ensureThatWeCanRetrieveFellowshipMultipleTimes() {
    this.dataService = new DataService();
    assertNotNull(dataService.getFellowship());
  }

  @Test
  public void ensureOrdering() {
    // ensure that the order of the fellowship is:
    // frodo, sam, merry,pippin, gandalf,legolas,gimli,aragorn,boromir
    List<TolkienCharacter> fellowship = this.dataService.getFellowship();
    assertEquals(this.dataService.getFellowshipCharacter("Frodo"), fellowship.get(0));
    assertEquals(this.dataService.getFellowshipCharacter("Sam"), fellowship.get(1));
    assertEquals(this.dataService.getFellowshipCharacter("Merry"), fellowship.get(2));
    assertEquals(this.dataService.getFellowshipCharacter("Pippin"), fellowship.get(3));
    assertEquals(this.dataService.getFellowshipCharacter("Gandalf"), fellowship.get(4));
    assertEquals(this.dataService.getFellowshipCharacter("Legolas"), fellowship.get(5));
    assertEquals(this.dataService.getFellowshipCharacter("Gimli"), fellowship.get(6));
    assertEquals(this.dataService.getFellowshipCharacter("Aragorn"), fellowship.get(7));
    assertEquals(this.dataService.getFellowshipCharacter("Boromir"), fellowship.get(8));
  }

  @Test
  public void ensureAge() {
    List<TolkienCharacter> fellowship = this.dataService.getFellowship();
    // test to ensure that all hobbits and men are younger than 100 years
    // also ensure that the elfs, dwars the maia are all older than 100 years

    assertTrue(fellowship.stream()
      .filter(fellow -> fellow.getRace().equals(HOBBIT) || fellow.getRace().equals(Race.MAN))
      .allMatch(fellow -> fellow.getAge() < 100));

    assertTrue(fellowship
      .stream().filter(fellow -> fellow.getRace().equals(Race.ELF)
        || fellow.getRace().equals(Race.DWARF) || fellow.getRace().equals(Race.MAIA))
      .allMatch(fellow -> fellow.getAge() > 100));
  }

  @Test
  public void ensureThatFellowsStayASmallGroup() {
    List<TolkienCharacter> fellowship = this.dataService.getFellowship();
    assertThrows(IndexOutOfBoundsException.class, () -> fellowship.get(20));
  }

  @Test
  public void ensureServiceDoesNotRunToLong() {
    // TODO Write a test to ensure that update does not run longer than 3 seconds
    // Tip: Use the assertTimeout assert statement.
    fail("not yet implemented");
  }
}
