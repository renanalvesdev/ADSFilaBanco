package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Table
{
	private final SimpleDoubleProperty rNumeroCliente;
	private final SimpleDoubleProperty rTempoDesdeUltimaChegada;
	private final SimpleDoubleProperty rTempoDeChegadaNoRelogio;
	private final SimpleDoubleProperty rTempoDeServico;
	private final SimpleDoubleProperty rTempoDeInicioDoServico;
	private final SimpleDoubleProperty rTempoDoClienteNaFila;
	private final SimpleDoubleProperty rTempoFinalDoAtendimentoNoRelogio;
	private final SimpleDoubleProperty rTempoDoClienteNoBanco;
	private final SimpleDoubleProperty rTempoLivreDoCaixaNoBanco;
	
	public Table(double numeroCliente, double tempoDesdeUltimaChegada, double tempoDeChegadaNoRelogio, double tempoDeServico,
			double tempoDeInicioDoServico, double tempoDoClienteNaFila, double tempoFinalDoAtendimentoNoRelogio, double tempoDoClienteNoBanco, double tempoLivreDoCaixaNoBanco)
	{
		this.rNumeroCliente = new SimpleDoubleProperty(numeroCliente);
		this.rTempoDesdeUltimaChegada = new SimpleDoubleProperty(tempoDesdeUltimaChegada);
		this.rTempoDeChegadaNoRelogio = new SimpleDoubleProperty(tempoDeChegadaNoRelogio);
		this.rTempoDeServico = new SimpleDoubleProperty(tempoDeServico);
		this.rTempoDeInicioDoServico = new SimpleDoubleProperty(tempoDeInicioDoServico);
		this.rTempoDoClienteNaFila = new SimpleDoubleProperty(tempoDoClienteNaFila);
		this.rTempoDoClienteNoBanco = new SimpleDoubleProperty(tempoDoClienteNoBanco);
		this.rTempoFinalDoAtendimentoNoRelogio= new SimpleDoubleProperty(tempoFinalDoAtendimentoNoRelogio);
		this.rTempoLivreDoCaixaNoBanco= new SimpleDoubleProperty(tempoLivreDoCaixaNoBanco);
		
	}

	public Double getRNumeroCliente()
	{
		return rNumeroCliente.get();
	
	}

	public void setRNumeroCliente(Double d)
	{
		rNumeroCliente.set(d);
	}
	
	public Double getRTempoDesdeUltimaChegada()
	{
		return rTempoDesdeUltimaChegada.get();
	}
	
	public void setRTempoDesdeUltimaChegada(Double d)
	{
		rTempoDesdeUltimaChegada.set(d);
	}
	
	public Double getRTempoDeChegadaNoRelogio()
	{
		return rTempoDeChegadaNoRelogio.get();
	}
	
	public void setRTempoDeChegadaNoRelogio(Double d)
	{
		rTempoDeChegadaNoRelogio.set(d);
	}
	
	public Double getRTempoDeServico()
	{
		return rTempoDeServico.get();
	}
	
	public void setRTempoDeServico(Double d)
	{
		rTempoDeServico.set(d);
	}
	
	public Double getRTempoDeInicioDoServico()
	{
		return rTempoDeInicioDoServico.get();
	}
	
	public void setRTempoDeInicioDoServico(Double d)
	{
		rTempoDeInicioDoServico.set(d);
	}
	
	public Double getRTempoDoClienteNaFila()
	{
		return rTempoDoClienteNaFila.get();
	}
	
	public void setRTempoDoClienteNaFila(Double d)
	{
		rTempoDoClienteNaFila.set(d);
	}
	
	public Double getRTempoDoClienteNoBanco()
	{
		return rTempoDoClienteNoBanco.get();
	}
	
	public void setRTempoDoClienteNoBanco(Double d)
	{
		rTempoDoClienteNoBanco.set(d);
	}
	
	public Double getRTempoFinalDoAtendimentoNoRelogio()
	{
		return rTempoFinalDoAtendimentoNoRelogio.get();
	}
	
	public void setRTempoFinalDoAtendimentoNoRelogio(Double d)
	{
		rTempoFinalDoAtendimentoNoRelogio.set(d);
	}
	
	public Double getRTempoLivreDoCaixaNoBanco()
	{
		return rTempoLivreDoCaixaNoBanco.get();
	}
	
	public void setRTempoLivreDoCaixaNoBanco(Double d)
	{
		rTempoLivreDoCaixaNoBanco.set(d);
	}
}
