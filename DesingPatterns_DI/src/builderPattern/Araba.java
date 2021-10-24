package builderPattern;

public class Araba {

	private int yas;
	private boolean klima;
	private boolean ekran;
	private boolean abs;

	private Araba(Builder builder) {
		this.yas = builder.yas;
		this.klima = builder.klima;
		this.ekran = builder.ekran;
		this.abs = builder.abs;
	}

	public static class Builder {

		private int yas;
		private boolean klima = false;
		private boolean ekran = false;
		private boolean abs = false;

		public Builder(int yas) {
			this.yas = yas;
		}

		public Builder klima(boolean b) {
			klima = b;
			return this;
		}

		public Builder ekran(boolean b) {
			ekran = b;
			return this;
		}

		public Builder abs(boolean b) {
			abs = b;
			return this;
		}

		public Araba build() {
			return new Araba(this);
		}

	}

	@Override
	public String toString() {
		return "Araba [yas=" + yas + ", klima=" + klima + ", ekran=" + ekran + ", abs=" + abs + "]";
	}
	
	

}
