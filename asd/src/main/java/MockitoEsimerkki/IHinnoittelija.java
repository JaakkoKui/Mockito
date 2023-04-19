package MockitoEsimerkki;

public interface IHinnoittelija {
	public abstract float getAlennusProsentti(Asiakas asiakas, Tuote tuote);

	void aloita();

	void lopeta();

	float getsAlennusProsentti(Asiakas asiakas, Tuote tuote);

	void setAlennusProsentti(Asiakas asiakas, float prosentti);
}
