package sistemaDeIngressos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShowTest {
  private Show show;

  @BeforeEach
  void setup() {
    show = new Show(true, "Kendrick Lamar", 1000.00, 2000.00);
  }
}
