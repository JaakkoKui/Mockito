package MockitoEsimerkki;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class TilaustenKäsittelyTest {

	private TilaustenKäsittely käsittelijä = mock(TilaustenKäsittely.class);
	private IHinnoittelija hinnoittelijaMock = mock(IHinnoittelija.class);

	
	
	
	
	@Test
	public void testKäsittelyHintaAlle100() {
		// Arrange
		Asiakas asiakas = new Asiakas(500);
		Tuote tuote = new Tuote("Testituote", 50);
		Tilaus tilaus = new Tilaus(asiakas, tuote);
		IHinnoittelija hinnoittelijaMock = mock(IHinnoittelija.class);
		when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote)).thenReturn(0f);
		TilaustenKäsittely käsittelijä = new TilaustenKäsittely(hinnoittelijaMock);

		// Act
		käsittelijä.käsittele(tilaus);

		// Assert
		verify(hinnoittelijaMock).aloita();
		verify(hinnoittelijaMock).lopeta();
		assertEquals(450f, asiakas.getSaldo(), 0.001f);
	}
	@Test
	public void testKäsittelyHintaYliTaiYhtäSuuriKuin100() {
		// Arrange
		Asiakas asiakas = new Asiakas(500);
		Tuote tuote = new Tuote("Testituote", 150);
		Tilaus tilaus = new Tilaus(asiakas, tuote);
		IHinnoittelija hinnoittelijaMock = mock(IHinnoittelija.class);
		when(hinnoittelijaMock.getAlennusProsentti(asiakas, tuote)).thenReturn(20f);
		TilaustenKäsittely käsittelijä = new TilaustenKäsittely(hinnoittelijaMock);

		// Act
		käsittelijä.käsittele(tilaus);

		// Assert
		verify(hinnoittelijaMock).aloita();
		verify(hinnoittelijaMock).lopeta();
		assertEquals(380f, asiakas.getSaldo(), 0.001f);
	}
}