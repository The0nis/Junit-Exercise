package pt.up.fe.model;

/**
 * Race in Tolkien's Lord of the Rings.
 */
public enum Race {

  HOBBIT("Hobbit", false, Alignment.GOOD),

  MAIA("Maia", true, Alignment.GOOD),

  MAN("Man", false, Alignment.NEUTRAL),

  ELF("Elf", true, Alignment.GOOD),

  DWARF("Dwarf", false, Alignment.GOOD),

  ORC("Orc", false, Alignment.EVIL);

  private final String name;

  private final boolean immortal;

  private Alignment alignment;

  private Race(String name, boolean immortal, Alignment alignment) {
    this.name = name;
    this.immortal = immortal;
    this.alignment = alignment;
  }

  public String getName() {
    return this.name;
  }

  public boolean isImmortal() {
    return this.immortal;
  }

  public Alignment getAlignment() {
    return this.alignment;
  }

  @Override
  public String toString() {
    return "Race [name=" + this.name + ", immortal=" + this.immortal + "]";
  }
}
