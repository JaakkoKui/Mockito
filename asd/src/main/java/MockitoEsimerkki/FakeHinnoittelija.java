package MockitoEsimerkki;

public class FakeHinnoittelija implements IHinnoittelija {
	private float alennus;

	public FakeHinnoittelija(float alennus) {
		this.alennus = alennus;
	}

	public float getAlennusProsentti(Asiakas asiakas, Tuote tuote) {
		return alennus;
	}

	public void aloita() {
		// TODO Auto-generated method stub
		
	}

	public void lopeta() {
		// TODO Auto-generated method stub
		
	}

	public float getsAlennusProsentti(Asiakas asiakas, Tuote tuote) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setAlennusProsentti(Asiakas asiakas, float prosentti) {
		// TODO Auto-generated method stub
		
	}
}