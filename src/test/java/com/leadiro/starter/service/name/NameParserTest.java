package com.leadiro.starter.service.name;

import com.leadiro.starter.service.name.dto.Name;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class NameParserTest {

  private final NameParser name = new NameParser();

  private final Name expected = Name.builder().first("Leadiro").last("User").build();
  private final Name unableToParse =
      Name.builder().first("Leadiro").last("Unable to parse this invalid value").build();

  @Test
  public void simple() {
    assertEquals("Leadiro User", expected, name.parse("Leadiro User"));
    assertEquals("User, Leadiro", expected, name.parse("User, Leadiro"));
    assertEquals("leadiro     User", expected, name.parse(" leadiro     User "));
  }

  @Test
  public void surname() {
    Name surname = expected;
    surname.setLast("Del User");
    assertEquals("Leadiro John Del User", surname, name.parse("Leadiro John Del User"));
  }

  @Test
  public void remove() {
    assertEquals("Csar Leadiro User", expected, name.parse("Csar Leadiro User"));
    assertEquals("Dr Leadiro User", expected, name.parse("Dr Leadiro User"));
    assertEquals("D.R. Leadiro User", expected, name.parse("D.R. Leadiro User"));
    assertEquals("Rev. Leadiro User", expected, name.parse("Rev. Leadiro User"));
    assertEquals("Leadiro (John) User", expected, name.parse("Leadiro (John) User"));
    assertEquals("Leadiro \"Rambo\" User", expected, name.parse("Leadiro \"Rambo\" User"));
    assertEquals("Leadiro 'Rambo' User", expected, name.parse("Leadiro 'Rambo' User"));
    assertEquals(
        "Leadiro User a.k.a The Terminator",
        expected,
        name.parse("Leadiro User a.k.a The Terminator"));
    assertEquals("Leadiro User M.B.A.", expected, name.parse("Leadiro User M.BA."));
    assertEquals("Leadiro J. R. User", expected, name.parse("Leadiro J. R. User"));
    assertEquals("Leadiro User, Bsc", expected, name.parse("Leadiro User, Bsc"));
    assertEquals("Leadiro User - Bsc", expected, name.parse("Leadiro User - Bsc"));
    assertEquals("Leadiro User | Bsc", expected, name.parse("Leadiro User | Bsc"));
    assertEquals("~~~ Leadiro User ~~~", expected, name.parse("~~~ Leadiro User ~~~"));
    assertEquals(
        "Leadiro User Certified Professional",
        expected,
        name.parse("Leadiro User Certified Professional"));
    assertEquals("Leadiro User 99", expected, name.parse("Leadiro User 99"));
  }

  @Test
  public void replace() {
    assertEquals("Leadiro User II.", expected, name.parse("Leadiro User II."));
    assertEquals("Leadiro User Jr.", expected, name.parse("Leadiro User Jr."));
  }

  @Test
  public void suffix() {
    assertEquals("Leadiro User Dip Ed", expected, name.parse("Leadiro User Dip Ed"));
    assertEquals("Leadiro User DipEd", expected, name.parse("Leadiro User DipEd"));
    assertEquals(
        "Leadiro R User MSc MPH DRes/PhD", expected, name.parse("Leadiro R User MSc MPH DRes/PhD"));
    assertEquals("Leadiro User Phd", expected, name.parse("Leadiro User Phd"));
    assertEquals("Leadiro User MacA", expected, name.parse("Leadiro User MacA"));
    assertEquals("Leadiro User assoc prof", expected, name.parse("Leadiro User assoc prof"));
  }

  @Test
  public void badNames() {
    assertEquals(unableToParse.getLast(), name.parse("Harendra 8866605136").getLast());
    assertEquals(unableToParse.getLast(), name.parse(".. ..").getLast());
    assertEquals(unableToParse.getLast(), name.parse("*N* *O*").getLast());
    assertEquals(expected, name.parse("~~~ Leadiro User ~~~"));
    assertEquals(expected, name.parse("~~~ Leadiro J User ~~~"));
  }

  @Test
  public void capitalisation() {
    Name hemant = Name.builder().first("Hemant").last("Ahirkar").build();
    Name de = Name.builder().first("Hemant").last("deAhirkar").build();

    assertEquals("HEMANT AHIRKAR", hemant, name.parse("HEMANT AHIRKAR"));
    assertEquals("hemant ahirkar", hemant, name.parse("hemant ahirkar"));
    assertEquals("Hemant deAhirkar", de, name.parse("Hemant deAhirkar"));
  }

  @Test
  public void nonAlpha() {
    Name hemant = Name.builder().first("Hemant").last("Ahirkar").build();
    assertEquals(hemant, name.parse("'HEMANT AHIRKAR'"));
    assertEquals(hemant, name.parse("-hemant ahirkar"));
  }

  @Test
  public void invalid() {
    assertEquals(unableToParse.getLast(), name.parse("'Leadiro").getLast());
    assertEquals(unableToParse.getLast(), name.parse("'Leadir O'").getLast());
    assertEquals(unableToParse.getLast(), name.parse("'L Eadiro'").getLast());
    assertEquals(unableToParse.getLast(), name.parse("'L. E. Adiro'").getLast());
  }
}
