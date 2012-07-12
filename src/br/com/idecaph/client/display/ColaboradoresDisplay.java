package br.com.idecaph.client.display;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.Widget;

public interface ColaboradoresDisplay extends Display{
    Widget asWidget();
    HasClickHandlers getBotaoEnviarArquivo();
    FileUpload getFileUpload();
}
