package workshop;

public class ItemCarrinho {
	private int codigo;
	private Livro livro;
	private double valor;
	private int qtd=1;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	@Override
	public boolean equals(Object obj){
		ItemCarrinho item = (ItemCarrinho) obj;
		if(item.getLivro().getCodigo()==this.getLivro().getCodigo()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public double getValor(){
		return livro.getPreco()*qtd;
	}
	public void setValor(int valor){
		this.valor = valor;
	}

}
