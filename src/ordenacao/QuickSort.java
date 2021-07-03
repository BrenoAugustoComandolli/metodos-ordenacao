package ordenacao;

import java.util.ArrayList;
import java.util.List;

public class QuickSort extends Ordenacao{

	public QuickSort(int id, String nome) {
		super(id, nome);
	}

	@Override
	public List<String> ordenar(List<String> listaOrdenacao) {
		
		List<Integer> listaInteira = new ArrayList<>();
		for (String umItem : listaOrdenacao) {
			listaInteira.add(Integer.parseInt(umItem));
		}
		
		Integer fim = listaInteira.size()-1;
		Integer inicio = 0;
		
		List<Integer> listaResul = quick(listaInteira, inicio, fim);
		
		listaOrdenacao.clear();
        for (int i = 0; i < listaResul.size(); i++) {
            listaOrdenacao.add(String.valueOf(listaResul.get(i)));
        }
        
		return listaOrdenacao;
	}
	
	private static List<Integer> quick(List<Integer> listaInteira, Integer inicio, Integer fim) {
		if (inicio < fim) {
			Integer posPivo = rodadaQuick(listaInteira, inicio, fim);
			quick(listaInteira, inicio, posPivo-1);
			quick(listaInteira, posPivo+1, fim);
		}
		return listaInteira;
	}
	
	private static Integer rodadaQuick(List<Integer> listaInteira, Integer inicio, Integer fim){
		
		Integer pivo = listaInteira.get(inicio);
		Integer ini = inicio + 1;
		Integer f = fim;
		
		while(ini <= f) {
			
			if(listaInteira.get(ini) <= pivo) {
				ini++;
			}else if(pivo < listaInteira.get(f)) {
				f--;
			}else {
				Integer temp = listaInteira.get(ini);
				listaInteira.set(ini, listaInteira.get(f));
				listaInteira.set(f, temp);
				ini++;
				f--;
			}
		}
		
		listaInteira.set(inicio, listaInteira.get(f));
		listaInteira.set(f, pivo);
		return f;
	}
}
