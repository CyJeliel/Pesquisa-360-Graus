package br.com.idecaph.client.utils;

import java.util.ArrayList;
import java.util.List;

public class SelectionModel<T> {
	List<T> selectedItems = new ArrayList<T>();
	List<T> todosItens;
	
	public SelectionModel(List<T> todosItens) {
		this.todosItens = todosItens;
	}

	public List<T> getSelectedItems() {
		return selectedItems;
	}

	public void addSelection(T item) {
		if (!selectedItems.contains(item)){
			selectedItems.add(item);
		}
	}

	public void removeSelection(T item) {
		selectedItems.remove(item);
	}

	public boolean isSelected(T item) {
		return selectedItems.contains(item);
	}

	public void removeTodos() {
		selectedItems.clear();
	}

	public void addTodos(List<T> itens) {
		selectedItems.addAll(itens);
	}

	public boolean isEmpty() {
		return selectedItems.isEmpty();
	}

	public int size() {
		return selectedItems.size();
	}
	
	public List<T> todosItens() {
		return todosItens;
	}
}
