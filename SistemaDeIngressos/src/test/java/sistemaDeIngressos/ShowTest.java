package sistemaDeIngressos;

import org.junit.jupiter.api.BeforeEach;

import sistemaDeIngressos.models.Show;

public class ShowTest {
  private Show show;

  @BeforeEach
  void setup() {
    show = new Show(true, "Kendrick Lamar", 1000.00, 2000.00);
  }
}
