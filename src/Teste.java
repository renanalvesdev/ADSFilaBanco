import java.util.Random;

public class Teste

{

	// definição das colunas.
	// definindo numero de linhas e colunas
	static final int TOTAL_DE_OPERACOES = 8;
	static final int TOTAL_DE_CLIENTES = 20;

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

	public static void main(String[] args) 
			
			{
				
				 Teste testeMatriz = new Teste();
				 
				 double[][] matrizDaSimulacao = new double[TOTAL_DE_CLIENTES][TOTAL_DE_OPERACOES];
				 
				 int selectItem = 1;
				 //inicializando elementos da matriz como 0
				matrizDaSimulacao =  testeMatriz.inicializaMatriz(matrizDaSimulacao);
				
				//gerando resultados das colunas (operações) em cada linha.
				for(int i = 0; i < TOTAL_DE_CLIENTES; i++)
				{
					int aux = i;
					
					for(int j = 0; j < TOTAL_DE_OPERACOES; j++ )
					{
						int aux2 = j;
						
						if(j == NUMERO_CLIENTE)
						{
							matrizDaSimulacao[i][NUMERO_CLIENTE] = aux++;
							System.out.println(matrizDaSimulacao[i][NUMERO_CLIENTE]);
						}
							
						
						if(j == TEMPO_DESDE_ULTIMA_CHEGADA)
							matrizDaSimulacao[i][TEMPO_DESDE_ULTIMA_CHEGADA] = testeMatriz.tempoDesdeUltimaChegada();
						
						if(j == TEMPO_CHEGADA_NO_RELOGIO)
						{
							//se for a primeira coluna, tempo de chegada é igual a tempo desde ultima chegada
							if(i == 0)
								matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO] = matrizDaSimulacao[i][TEMPO_DESDE_ULTIMA_CHEGADA];
							else
								matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO] = matrizDaSimulacao[i-1][TEMPO_CHEGADA_NO_RELOGIO] + matrizDaSimulacao[i][TEMPO_DESDE_ULTIMA_CHEGADA];
						}
							
						if(j == TEMPO_DE_SERVICO)
						matrizDaSimulacao[i][TEMPO_DE_SERVICO] = testeMatriz.tempoDeServico();
						
						if(j == TEMPO_DE_INICIO_DE_SERVICO)
						{
							if(i == 0)
							{
								matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO] = matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO];
							}
							else
								if(matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO] >=   matrizDaSimulacao[i-1][TEMPO_CHEGADA_NO_RELOGIO] + matrizDaSimulacao[i-1][TEMPO_DE_SERVICO] + matrizDaSimulacao[i-1][TEMPO_DO_CLIENTE_NA_FILA])
									matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO] = matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO];
								else
									matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO] = matrizDaSimulacao[i-1][TEMPO_CHEGADA_NO_RELOGIO] + matrizDaSimulacao[i-1][TEMPO_DE_SERVICO] + matrizDaSimulacao[i-1][TEMPO_DO_CLIENTE_NA_FILA];
							
						}
						
						if(j == TEMPO_DO_CLIENTE_NA_FILA)
						{
							matrizDaSimulacao[i][TEMPO_DO_CLIENTE_NA_FILA] = matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO] - matrizDaSimulacao[i][TEMPO_CHEGADA_NO_RELOGIO]; 
						}
						
						if(j == TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO)
						{
							matrizDaSimulacao[i][TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO] = matrizDaSimulacao[i][TEMPO_DE_INICIO_DE_SERVICO] + matrizDaSimulacao[i][TEMPO_DE_SERVICO];
		
						}
						
						if(j == TEMPO_DO_CLIENTE_NO_BANCO)
						{
							matrizDaSimulacao[i][TEMPO_DO_CLIENTE_NO_BANCO] = matrizDaSimulacao[i][TEMPO_DE_SERVICO] + matrizDaSimulacao[i][TEMPO_DO_CLIENTE_NA_FILA];
						}
					}
				}
				
				
				testeMatriz.imprimeMatriz(matrizDaSimulacao);
			}

	// inicializando a matriz
	public double[][] inicializaMatriz(double[][] matrizAuxiliar) {
		for (int i = 0; i < TOTAL_DE_CLIENTES; i++) {
			for (int j = 0; j < TOTAL_DE_OPERACOES; j++) {
				matrizAuxiliar[i][j] = 0;
			}
		}

		return matrizAuxiliar;
	}
	
	public void imprimeMatriz(double[][] matrizImpressa)
	{
		for(int i = 0; i <TOTAL_DE_CLIENTES; i++)
		{
			System.out.println("< -------------------- CLIENTE " + i + "-------------------->" + i + "\n" );
			for(int j = 0; j< TOTAL_DE_OPERACOES; j++)
			{
				if(j == NUMERO_CLIENTE)
					System.out.println("NUMERO_CLIENTE: " + matrizImpressa[i][NUMERO_CLIENTE] + "\n");
				if(j == TEMPO_DESDE_ULTIMA_CHEGADA)
					System.out.println("TEMPO_DESDE_ULTIMA_CHEGADA: " + matrizImpressa[i][TEMPO_DESDE_ULTIMA_CHEGADA] + "\n");
				
				if(j == TEMPO_CHEGADA_NO_RELOGIO)
					System.out.println("TEMPO_CHEGADA_NO_RELOGIO: " + matrizImpressa[i][TEMPO_CHEGADA_NO_RELOGIO] + "\n");
				
				if(j == TEMPO_DE_SERVICO)
					System.out.println("TEMPO_DE_SERVICO: " + matrizImpressa[i][TEMPO_DE_SERVICO] + "\n");
				
				if(j == TEMPO_DE_INICIO_DE_SERVICO)
					System.out.println("TEMPO_DE_INICIO_DE_SERVICO: " + matrizImpressa[i][TEMPO_DE_INICIO_DE_SERVICO] + "\n");
				
				if(j == TEMPO_DO_CLIENTE_NA_FILA)
					System.out.println("TEMPO_DO_CLIENTE_NA_FILA: " + matrizImpressa[i][TEMPO_DO_CLIENTE_NA_FILA] + "\n");
				
				if(j == TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO)
					System.out.println("TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO: " + matrizImpressa[i][TEMPO_FINAL_DO_ATENDIMENTO_NO_RELOGIO] + "\n");
				
				if(j == TEMPO_DO_CLIENTE_NO_BANCO)
					System.out.println("TEMPO_DO_CLIENTE_NO_BANCO: " + matrizImpressa[i][TEMPO_DO_CLIENTE_NO_BANCO] + "\n");
			}
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
	
	public double tempoDesdeUltimaChegadaMonteCarlo()
	{
		double numeroAleatorioentreZeroEum = Math.random();
		if(numeroAleatorioentreZeroEum >= 0.01 && numeroAleatorioentreZeroEum <= 0.35)
			return 2.5;
		
		else if(numeroAleatorioentreZeroEum >= 0.36 && numeroAleatorioentreZeroEum <= 0.54)
			return 7.5;
		
		else if(numeroAleatorioentreZeroEum >= 0.55 && numeroAleatorioentreZeroEum <= 0.73)
			return 12.5;
		
		else if(numeroAleatorioentreZeroEum >= 0.74 && numeroAleatorioentreZeroEum <= 0.86)
			return 17.5;
		
		else if(numeroAleatorioentreZeroEum >= 0.87 && numeroAleatorioentreZeroEum <= 0.89)
			return 22.5;
		
		else if(numeroAleatorioentreZeroEum >=0.90 && numeroAleatorioentreZeroEum <= 0.96)
			return 27.5;
		
		else if(numeroAleatorioentreZeroEum >= 0.97 && numeroAleatorioentreZeroEum < 0.98)
			return 32.5;
		
		else if(numeroAleatorioentreZeroEum >=0.98 && numeroAleatorioentreZeroEum <=0.99)
			return 37.5;
		
		else return 42.5;
		
	}
	
	public double tempoDeServico()
	{
		Random myRandom = new Random();
		final int tempoServico = myRandom.nextInt(100);

		if (tempoServico > 50) 
		{
			return 10;
		}

		else if (tempoServico > 20)
		{
			return 9;
		} 
		
		else 
		{
			return 11;
		}
		
	}

}
