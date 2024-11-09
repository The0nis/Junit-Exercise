package pt.up.fe.model;

import java.util.Date;

public class Movie {

  private String title;

  private Date releaseDate;

  @SuppressWarnings("unused")
  private String duration;

  public Movie(String title, Date releaseDate, String duration) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.duration = duration;
  }

  public String getTitle() {
    return this.title;
  }

  public Date getReleaseDate() {
    return this.releaseDate;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.releaseDate == null) ? 0 : this.releaseDate.hashCode());
    result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
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

    Movie other = (Movie) obj;
    if (this.releaseDate == null) {
      if (other.releaseDate != null) {
        return false;
      }
    } else if (!this.releaseDate.equals(other.releaseDate)) {
      return false;
    }
    if (this.title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!this.title.equals(other.title)) {
      return false;
    }

    return true;
  }
}
