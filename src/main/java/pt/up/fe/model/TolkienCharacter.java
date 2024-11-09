package pt.up.fe.model;

public class TolkienCharacter {

  private String name;

  private int age;

  private Race race;

  public TolkienCharacter(String name, int age, Race race) {
    this.name = name;
    this.age = age;
    this.race = race;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public Race getRace() {
    return this.race;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    if (this.age < 0) {
      throw new IllegalArgumentException("Age is not allowed to be smaller than zero");
    }
    this.age = age;
  }

  public void setRace(Race race) {
    this.race = race;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.age;
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.race == null) ? 0 : this.race.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }

    TolkienCharacter other = (TolkienCharacter) obj;
    if (this.age != other.age) return false;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.race == null) {
      if (other.race != null) {
        return false;
      }
    } else if (!this.race.equals(other.race)) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return this.name + " " + this.age + " years old " + this.race.getName();
  }
}
