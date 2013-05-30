package br.com.idecaph.utils;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.TaskOptions.Method;

public class FilasUtil {
	public static void adicionaNaFila(String url) {
		Queue queue = QueueFactory.getDefaultQueue();
		TaskOptions withUrl = TaskOptions.Builder.withUrl(url).method(
				Method.GET);
		queue.add(withUrl);
	}
}
