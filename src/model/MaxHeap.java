package model;

import java.util.ArrayList;

public class MaxHeap {
	ArrayList<Task> heap;
	int modoVisualizacao;

	public MaxHeap() {
		this.heap = new ArrayList<>();
		this.modoVisualizacao = 1;
	}

	public int getModoVisualizacao() {
		return modoVisualizacao;
	}

	public void setModoVisualizacao(int modoVisualizacao) {
		if (modoVisualizacao > 0 && modoVisualizacao < 4) {
			this.modoVisualizacao = modoVisualizacao;
		} else {
			System.out.println("\nValor inválido!");
		}
	}

	public Task peek() {
		if (heap.isEmpty())
			return null;
		return heap.get(0);
	}

	public void insert(Task task) {
		heap.add(task);
		if (heap.size() > 1) {
			heapfiUp(heap.size() - 1);
		}
	}

	private void heapfiUp(int index) {
		while (index > 0) {
			int indicePai = (index - 1) / 2; 

			Task elementoAtual = heap.get(index); 
			Task paiAtual = heap.get(indicePai); 

			if (elementoAtual.getPrioridade() > paiAtual.getPrioridade()) {
				swap(index, indicePai); // invertendo posições
				index = indicePai;
			} else {
				break;
			}
		}
	}

	private void swap(int indexFilho, int indexPai) {
		Task temp = heap.get(indexFilho);
		heap.set(indexFilho, heap.get(indexPai));
		heap.set(indexPai, temp);
	}

	public Task extractMax() {
		if (heap.isEmpty()) {
			return null;
		}

		Task max = heap.get(0);
		Task last = heap.remove(heap.size() - 1);

		if (!heap.isEmpty()) {
			heap.set(0, last);
			heapifyDown(0);
		}

		return max;
	}

	private void heapifyDown(int index) {
		int size = heap.size();
		while (index < size) {
			int leftChild = 2 * index + 1;
			int rightChild = 2 * index + 2;
			int largest = index;

			if (leftChild < size && heap.get(leftChild).getPrioridade() > heap.get(largest).getPrioridade()) {
				largest = leftChild;
			}

			if (rightChild < size && heap.get(rightChild).getPrioridade() > heap.get(largest).getPrioridade()) {
				largest = rightChild;
			}

			if (largest != index) {
				swap(index, largest);
				index = largest;
			} else {
				break;
			}
		}
	}

	public void showHeap() {
		if (heap.isEmpty()) {
			System.out.println("\nHeap vazia!");
			return;
		}

		int tamanho = (int) (Math.log(heap.size()) / Math.log(2)) + 1; // tamamho da arvore 7-2^3
		int maxLevel = tamanho - 1; // altura
		int currentSize = heap.size(); 

		for (int level = 0; level < tamanho; level++) {
			int itensNoNivelAtual = (int) Math.pow(2, level); //2-4-8..
            // inicio dos elementos nesse nivel
			int start = (int) Math.pow(2, level) - 1; // 3-2^2-1
            // fim dos elementos nesse nivel
			int end = Math.min(start + itensNoNivelAtual, currentSize);
			// Espaço entre os itens
			int centralizandoArvore = (int) Math.pow(2, maxLevel - level) - 1; 
			printSpaces(centralizandoArvore * 3);

			for (int i = start; i < end; i++) {
				if (this.modoVisualizacao == 1) { // visualizacao por prioridade
					System.out.print(heap.get(i).getPrioridade());

				} else if (this.modoVisualizacao == 2) { // visualizacao por descricao
					System.out.print(heap.get(i).getDescricao());

				} else if (this.modoVisualizacao == 3) { // visualizacao por prioridade+descricao
					System.out.print(heap.get(i).getDescricao() + " - " + heap.get(i).getPrioridade());
				}

				// Espaço horizontal entre os itens desse nivel
				int spacing_horizontal = (int) Math.pow(2, maxLevel - level + 1) - 1; // calculando a potencia
				printSpaces(spacing_horizontal * 3);
			}
			System.out.println();

			if (level < tamanho - 1) { // verificando se é o ultimo nivel
				printSpaces((centralizandoArvore - 1) * 3); // espaços

				for (int i = start; i < end; i++) {
					if (2 * i + 1 < heap.size()) // verificando se o filho esquerdo existe no heap
						System.out.print("  /"); 
					if (2 * i + 2 < heap.size()) // verificando se o filho direito existe no heap
						System.out.print(" \\ "); 
					else
						System.out.print("   ");
					printSpaces((centralizandoArvore - 1) * 3);
				}
				System.out.println();
			}
		}
	}

	private void printSpaces(int count) { // recebe um numero de espaços para mostrar na tela
		for (int i = 0; i < count; i++) {
			System.out.print(" ");
		}
	}
}
