package controle;

public class ControleRemoto implements Controlador {
	
	private int volume;
	private boolean ligado;
	private boolean tocando;
	
	public ControleRemoto() {
		
		this.volume = 50;
		this.ligado = false;
		this.tocando = false;
			
	}
	
	private int getVolume() {
		return this.volume;
	}
	private void setVolume(int vl) {
		this.volume = vl;
	}
	
	private boolean getLigado() {
		return this.ligado;
	}
	private void setLigado(boolean lg) {
		this.ligado = lg;
	}
	
	private boolean getTocando() {
		return this.tocando;
	}
	private void setTocando(boolean tc) {
		this.tocando = tc;
	}

	@Override
	public void ligar() {
		this.setLigado(true);
	}

	@Override
	public void desligar() {
		this.setLigado(false);
	}

	@Override
	public void abrirMenu() {
		System.out.println("----- MENU ----");
		System.out.println("Est� ligado? "+this.getLigado());
		System.out.println("Est� tocando? "+this.getTocando());
		System.out.print("Volume: "+this.getVolume());
		for(int i = 0; i <=this.getVolume(); i+=10) {
			System.out.print(" |");
		}
		System.out.println("");
	}

	@Override
	public void fecharMenu() {
		System.out.println("Fechando Menu...");
	}

	@Override
	public void maisVolume() {
		if(this.getLigado()) {
			this.setVolume(this.getVolume()+5);
		}
		else {
			System.out.println("Imposs�vel aumentar volume");
		}
	}

	@Override
	public void menosVolume() {
		if(this.getLigado()) {
			this.setVolume(this.getVolume()-5);
		}
		else {
			System.out.println("Imposs�vel diminuir volume");
		}
	}

	@Override
	public void ligarMudo() {
		if(this.getLigado() && this.getVolume() > 0) {
			this.setVolume(0);
		}
	}

	@Override
	public void desligarMudo() {
		if(this.getLigado() && this.getVolume() == 0)
			this.setVolume(50);
	}

	@Override
	public void play() {
		if(this.getLigado() && !(this.getTocando())) {
			this.setTocando(true);
		}
		else {
			System.out.println("N�o consegui reproduzir");
		}
	}

	@Override
	public void pause() {
		if(this.getLigado() && (this.getTocando())) {
			this.setTocando(false);
		}
		else {
			System.out.println("N�o consegui pausar");
		}
	}
}
