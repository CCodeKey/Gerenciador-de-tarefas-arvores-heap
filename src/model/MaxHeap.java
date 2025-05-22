package model;

import java.util.ArrayList;

public class MaxHeap {
	ArrayList<Task> heap;

	public MaxHeap() {
		this.heap = new ArrayList<>();
	}

	public Task peek() {
		return heap.getFirst();
	}

	public void insert(Task task) {
		heap.add(task);
		if (heap.size() > 1) {
			heapfiUp(heap.size() - 1);
		}
	}

	public void heapfiUp(int index) {
		while (index > 0) {
			int indicePai = (index - 1) / 2;

			Task elementoAtual = heap.get(index);
			Task paiAtual = heap.get(indicePai); 
			
			if (elementoAtual.getPrioridade() > paiAtual.getPrioridade()) {
				swap(index, indicePai);
				index = indicePai;
			} else {
				break;
			}
		}
	}

	public void swap(int indexFilho, int indexPai) {
		Task temp = heap.get(indexFilho);
		heap.set(indexFilho, heap.get(indexPai));
		heap.set(indexPai, temp);
	}

	// extractMax

	// heapifyDown

	public void visualizarHeap() {
		for (int i = 0; i < heap.size(); i++) {
			System.out.println(heap.get(i).toString());
		}
	}
}
