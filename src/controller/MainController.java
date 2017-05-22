package controller;

import java.awt.Desktop.Action;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.Observable;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Table;

public class MainController implements Initializable

{
	// definição das colunas.
			// definindo numero de linhas e colunas
			static final int TOTAL_DE_OPERACOES = 9;
			static final int TOTAL_DE_CLIENTES = 20; //teste

			// descrição das colunas
			static int NUMERO_CLIENTE = 0;
			static final int TEMPO_DESDE_ULTIMA_CHEGADA = 1;
			static final int TEMPO_CHEGADA_NO_RELOGIO = 2;
			static final int TEMPO_DE_SERVICO = 3;
			static final int TEMPO_DE_INICIO_DE_SERVICO = 4;
			static final int TEMPO_DO_CLIENTE_NA_FILA = 5;
			static final int TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO = 6;
			static final int TEMPO_DO_CLIENTE_NO_BANCO = 7;
			static final int TEMPO_LIVRE_DO_CAIXA_NO_BANCO = 8; 
	

	// Definindo a tabela
	@FXML
	TableView<Table> tableID;

	@FXML
	TableColumn<Table, Double>  numeroCliente; // 1- iNumeroCliente;
	@FXML
	TableColumn<Table, Double> tempoDesdeUltimaChegada; // 2 -iTempoDesdeUltimaChegada; //
	@FXML
	TableColumn<Table, Double> tempoDeChegadaNoRelogio;//  3 - iTempoDeChegadaNoRelogio; 
	@FXML
	TableColumn<Table, Double> tempoDeServico; // 4 - iTempoDeServico
	@FXML
	TableColumn<Table, Double>  tempoDeInicioDoServico;// 5 - iTempoDeInicioDoServico;
	@FXML
	TableColumn<Table, Double> tempoDoClienteNaFila ;// 6 -iTempoDoClienteNaFila; // 
	@FXML
	TableColumn<Table, Double> tempoFinalDoAtendimentoNoRelogio ;//7 - iTempoFinalDoAtendimentoNoRelogio; // 
	@FXML
	TableColumn<Table, Double> tempoDoClienteNoBanco; // 8 -  iTempoDoClienteNoBanco;
	
	@FXML
	TableColumn<Table, Double> tempoLivreDoCaixaNoBanco; // 8 -  iTempoDoClienteNoBanco;

	// Definindo as variaveis
	private double iNumber = 1.0;
	double[][] matrizDaSimulacao = new double[TOTAL_DE_CLIENTES][TOTAL_DE_OPERACOES];
	// criando os dados da tabela
	

	public void linhasEmTabela ()
	{
	
	}
	
	
	//final ObservableList<Table> data = FXCollections.observableArrayList();

	/*
	 * for (double[] row : ) { data.add(FXCollections.observableArrayList(row));
	 * }
	 */
	final ObservableList<Table> data = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int item = 1;
		
		//final ObservableList<Table> data = FXCollections.observableArrayList();
		//CONTRUINDO A MATRIZ 
		
		
		/*ObservableList<Table> data = FXCollections.observableArrayList(
				new Table(iNumber++,2.0,3.0,4.0,5.0,6.0,7.0,8.0)
				
				
				);*/
		
		
		numeroCliente.setCellValueFactory(new PropertyValueFactory<Table, Double>("rNumeroCliente"));
		tempoDesdeUltimaChegada.setCellValueFactory(new PropertyValueFactory<Table, Double>("rTempoDesdeUltimaChegada"));
		tempoDeChegadaNoRelogio.setCellValueFactory(new PropertyValueFactory<Table, Double>("rTempoDeChegadaNoRelogio"));
		tempoDeServico.setCellValueFactory(new PropertyValueFactory<Table, Double>("rTempoDeServico"));
		tempoDeInicioDoServico.setCellValueFactory(new PropertyValueFactory<Table, Double>("rTempoDeInicioDoServico"));
		tempoDoClienteNaFila.setCellValueFactory(new PropertyValueFactory<Table, Double>("rTempoDoClienteNaFila"));
		tempoFinalDoAtendimentoNoRelogio.setCellValueFactory(new PropertyValueFactory<Table, Double>("rTempoFinalDoAtendimentoNoRelogio"));
		tempoDoClienteNoBanco.setCellValueFactory(new PropertyValueFactory<Table, Double>("rTempoDoClienteNoBanco"));
		tempoLivreDoCaixaNoBanco.setCellValueFactory(new PropertyValueFactory<Table, Double>("rTempoLivreDoCaixaNoBanco"));
		tableID.setItems(data);

	}
	
	public void geraTabelaA(ActionEvent event)
	{
		tableID.getItems().clear();
		constroiMatriz(1);
	}
	
	public void geraTabelaB(ActionEvent event)
	{
		tableID.getItems().clear();
		constroiMatriz(2);
	}

	public void constroiMatriz(int item)
	{
		for(int i = 0;i<TOTAL_DE_CLIENTES;i++)
		{
			int aux = i;

			for (int j = 0; j < TOTAL_DE_OPERACOES; j++) 
			{
				int aux2 = j;

				if (j == NUMERO_CLIENTE) 
				{
					this.matrizDaSimulacao[i][NUMERO_CLIENTE] = aux + 1;
					System.out.println(this.matrizDaSimulacao[i][NUMERO_CLIENTE]);
				}

				if (j == TEMPO_DESDE_ULTIMA_CHEGADA)
					if (item == 1)
					{
						this.matrizDaSimulacao[i][TEMPO_DESDE_ULTIMA_CHEGADA] = tempoDesdeUltimaChegada();
						System.out.println("AQUI: " + this.matrizDaSimulacao[i][TEMPO_DESDE_ULTIMA_CHEGADA]);
					}

					else

						this.matrizDaSimulacao[i][TEMPO_DESDE_ULTIMA_CHEGADA] = tempoDesdeUltimaChegadaMonteCarlo();

				if (j == TEMPO_CHEGADA_NO_RELOGIO) 
				{
					// se for a primeira coluna, tempo de chegada é igual a tempo
					// desde ultima chegada
					if (i == 0)
						this.matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO] = this.matrizDaSimulacao[i][TEMPO_DESDE_ULTIMA_CHEGADA];
					else
						this.matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO] = this.matrizDaSimulacao[i - 1][TEMPO_CHEGADA_NO_RELOGIO]
								+ this.matrizDaSimulacao[i][TEMPO_DESDE_ULTIMA_CHEGADA];
				}

				if (j == TEMPO_DE_SERVICO)
				{
					if (item == 1)
						this.matrizDaSimulacao[i][TEMPO_DE_SERVICO] = tempoDeServico();
					else
						this.matrizDaSimulacao[i][TEMPO_DE_SERVICO] = tempoDeServicoMonteCarlo();
				}

				if (j == TEMPO_DE_INICIO_DE_SERVICO) 
				{
					if (i == 0) 
					{
						this.matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO] = this.matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO];
					} else if (this.matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO] >= this.matrizDaSimulacao[i- 1][TEMPO_CHEGADA_NO_RELOGIO] + this.matrizDaSimulacao[i - 1][TEMPO_DE_SERVICO]
							+ this.matrizDaSimulacao[i - 1][TEMPO_DO_CLIENTE_NA_FILA])
						this.matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO] = this.matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO];
					else
						this.matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO] = this.matrizDaSimulacao[i	- 1][TEMPO_CHEGADA_NO_RELOGIO] + this.matrizDaSimulacao[i - 1][TEMPO_DE_SERVICO]
								+ this.matrizDaSimulacao[i - 1][TEMPO_DO_CLIENTE_NA_FILA];

				}

				if (j == TEMPO_DO_CLIENTE_NA_FILA) 
				{
					this.matrizDaSimulacao[i][TEMPO_DO_CLIENTE_NA_FILA] = this.matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO]- this.matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO];
				}

				if (j == TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO) 
				{
					this.matrizDaSimulacao[i][TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO] = this.matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO]+ this.matrizDaSimulacao[i][TEMPO_DE_SERVICO];

				}

				if (j == TEMPO_DO_CLIENTE_NO_BANCO)
				{
					this.matrizDaSimulacao[i][TEMPO_DO_CLIENTE_NO_BANCO] =this.matrizDaSimulacao[i][TEMPO_DE_SERVICO]+ this.matrizDaSimulacao[i][TEMPO_DO_CLIENTE_NA_FILA];
				}
				
				if(j == TEMPO_LIVRE_DO_CAIXA_NO_BANCO)
				{
					if(i == 0)
					{
						this.matrizDaSimulacao[i][TEMPO_LIVRE_DO_CAIXA_NO_BANCO] = this.matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO];
					}
					
					else 
					{
						if(this.matrizDaSimulacao[i-1][TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO] > this.matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO] )
							this.matrizDaSimulacao[i][TEMPO_LIVRE_DO_CAIXA_NO_BANCO] = 0;
						else
							this.matrizDaSimulacao[i][TEMPO_LIVRE_DO_CAIXA_NO_BANCO] = this.matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO] - this.matrizDaSimulacao[i-1][TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO];
					}
						
				}
			}
			Table entrada = new Table(matrizDaSimulacao[i][NUMERO_CLIENTE],matrizDaSimulacao[i][TEMPO_DESDE_ULTIMA_CHEGADA]
					,matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO],matrizDaSimulacao[i][TEMPO_DE_SERVICO],
					matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO],matrizDaSimulacao[i][TEMPO_DO_CLIENTE_NA_FILA],
					matrizDaSimulacao[i][TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO],matrizDaSimulacao[i][TEMPO_DO_CLIENTE_NO_BANCO],
					matrizDaSimulacao[i][TEMPO_LIVRE_DO_CAIXA_NO_BANCO]);
			
			data.add(entrada);
			
		}	
	}
	
	public double tempoDesdeUltimaChegada()
	{
		Random myRandom = new Random();
		final int tempoDesdeUltimaChegada = myRandom.nextInt(100);

		if (tempoDesdeUltimaChegada > 60) 
		{
			return 12;
		}

		else if (tempoDesdeUltimaChegada > 25)
		{
			return 10;
		} 
		
		else 
		{
			return 14;
		}
	}
	
	public double tempoDesdeUltimaChegadaMonteCarlo() {
		double numeroAleatorioentreZeroEum = Math.random();
		System.out.println(numeroAleatorioentreZeroEum);
		if (numeroAleatorioentreZeroEum >= 0.01 && numeroAleatorioentreZeroEum <= 0.35)
			return 2.5;

		else if (numeroAleatorioentreZeroEum >= 0.36 && numeroAleatorioentreZeroEum <= 0.54)
			return 7.5;

		else if (numeroAleatorioentreZeroEum >= 0.55 && numeroAleatorioentreZeroEum <= 0.73)
			return 12.5;

		else if (numeroAleatorioentreZeroEum >= 0.74 && numeroAleatorioentreZeroEum <= 0.86)
			return 17.5;

		else if (numeroAleatorioentreZeroEum >= 0.87 && numeroAleatorioentreZeroEum <= 0.89)
			return 22.5;

		else if (numeroAleatorioentreZeroEum >= 0.90 && numeroAleatorioentreZeroEum <= 0.96)
			return 27.5;

		else if (numeroAleatorioentreZeroEum >= 0.97 && numeroAleatorioentreZeroEum < 0.98)
			return 32.5;

		else if (numeroAleatorioentreZeroEum >= 0.98 && numeroAleatorioentreZeroEum <= 0.99)
			return 37.5;

		else
			return 42.5;

	}
	

	public double tempoDeServico() {
		Random myRandom = new Random();
		final int tempoServico = myRandom.nextInt(100);

		if (tempoServico > 50) {
			return 10;
		}

		else if (tempoServico > 20) {
			return 9;
		}

		else {
			return 11;
		}

	}

	// Item B)
	public double tempoDeServicoMonteCarlo() {
		double numeroAleatorioentreZeroEum = Math.random();
		if (numeroAleatorioentreZeroEum >= 0.01 && numeroAleatorioentreZeroEum <= 0.06)
			return 9.725;

		else if (numeroAleatorioentreZeroEum >= 0.07 && numeroAleatorioentreZeroEum <= 0.11)
			return 9.825;

		else if (numeroAleatorioentreZeroEum >= 0.12 && numeroAleatorioentreZeroEum <= 0.34)
			return 10.375;

		else if (numeroAleatorioentreZeroEum >= 0.35 && numeroAleatorioentreZeroEum <= 0.54)
			return 10.925;

		else if (numeroAleatorioentreZeroEum >= 0.55 && numeroAleatorioentreZeroEum <= 0.75)
			return 11.475;

		else if (numeroAleatorioentreZeroEum >= 0.76 && numeroAleatorioentreZeroEum <= 0.87)
			return 12.025;

		else if (numeroAleatorioentreZeroEum >= 0.88 && numeroAleatorioentreZeroEum < 0.96)
			return 12.575;

		else if (numeroAleatorioentreZeroEum >= 0.96 && numeroAleatorioentreZeroEum <= 0.97)
			return 13.125;

		else if (numeroAleatorioentreZeroEum >= 0.98 && numeroAleatorioentreZeroEum <= 0.99)
			return 13.675;

		else
			return 14.225;
	}

	/*public double[][] getMatrizDaSimulacao() {
		return matrizDaSimulacao;
	}

	public void setMatrizDaSimulacao(double[][] matrizDaSimulacao) {
		this.matrizDaSimulacao = matrizDaSimulacao;
	}*/
}
